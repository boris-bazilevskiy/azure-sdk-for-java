// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.test.aad.filter.stateless;

import com.azure.spring.test.aad.AADWebApiITHelper;
import com.azure.spring.autoconfigure.aad.AADAppRoleStatelessAuthenticationFilter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.azure.spring.test.aad.EnvironmentVariables.AAD_SINGLE_TENANT_CLIENT_ID_WITH_ROLE;
import static com.azure.spring.test.aad.EnvironmentVariables.AAD_SINGLE_TENANT_CLIENT_SECRET_WITH_ROLE;
import static org.junit.Assert.assertEquals;

public class AADAppRoleStatelessAuthenticationFilterIT {

    private AADWebApiITHelper aadWebApiITHelper;

    @Before
    public void init() {
        String clientId = AAD_SINGLE_TENANT_CLIENT_ID_WITH_ROLE;
        String clientSecret = AAD_SINGLE_TENANT_CLIENT_SECRET_WITH_ROLE;
        Map<String, String> properties = new HashMap<>();
        properties.put("azure.activedirectory.client-id", clientId);
        properties.put("azure.activedirectory.client-secret", clientSecret);
        properties.put("azure.activedirectory.session-stateless", "true");
        aadWebApiITHelper = new AADWebApiITHelper(
            DumbApp.class,
            properties,
            clientId,
            clientSecret,
            Arrays.asList("user.read", "openid", "profile", "offline_access"));
    }

    @Test
    public void testAllowedEndpoints() {
        assertEquals("public", aadWebApiITHelper.httpGetStringByIdToken("public"));
        assertEquals("userRole", aadWebApiITHelper.httpGetStringByIdToken("userRole"));
    }

    @Test(expected = HttpClientErrorException.class)
    public void testNotAllowedEndpoints() {
        aadWebApiITHelper.httpGetStringByIdToken("adminRole");
    }

    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @SpringBootApplication
    @RestController
    public static class DumbApp extends WebSecurityConfigurerAdapter {

        @Autowired
        private AADAppRoleStatelessAuthenticationFilter aadAuthFilter;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();

            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);

            http.authorizeRequests()
                .antMatchers("/adminRole").hasRole("Admin")
                .antMatchers("/", "/index.html", "/public").permitAll()
                .anyRequest().authenticated();

            http.addFilterBefore(aadAuthFilter, UsernamePasswordAuthenticationFilter.class);
        }

        @GetMapping("/public")
        public String publicMethod() {
            return "public";
        }

        @GetMapping("/userRole")
        @PreAuthorize("hasRole('ROLE_User')")
        public String onlyAuthorizedUsers() {
            return "userRole";
        }

        @GetMapping("/adminRole")
        public String onlyForAdmins() {
            return "adminRole";
        }
    }

}
