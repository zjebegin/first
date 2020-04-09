package com.jiker.info.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter
{

    private static final Logger logger = LoggerFactory.getLogger(ResourceServerConfiguration.class);
    private static final String URL = "http://localhost:8081/oauth/check_token";
    @Override
    public void configure(HttpSecurity http) throws Exception{
        logger.debug("in ResourceServerConfiguration configure");
        http
        .authorizeRequests()
          .antMatchers(HttpMethod.DELETE, "/music/**")
          .hasRole("ADMIN")
          .anyRequest()
          .authenticated();
    }
    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
            throws Exception {

        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(URL);
        tokenService.setClientId("infoclient");
        tokenService.setClientSecret("thisissecret");

        resources.tokenServices(tokenService);
    }
}
