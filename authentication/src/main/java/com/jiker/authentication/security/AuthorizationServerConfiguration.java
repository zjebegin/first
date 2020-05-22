package com.jiker.authentication.security;

import com.jiker.authentication.dao.domain.OauthClientDetails;
import com.jiker.authentication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import java.util.List;

@Configuration
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private MainService mainService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*clients.inMemory()
                .withClient("infoclient")
                .secret("thisissecret")
                .authorizedGrantTypes("authorization_code","refresh_token", "password", "client_credentials")
                .scopes("webclient", "mobileclient").redirectUris("http://localhost:8081");*/
        List<OauthClientDetails> ls=mainService.getOauthClientDetails();
        for (OauthClientDetails o:ls) {
            clients.inMemory().withClient(o.getClientId())
                    .secret(o.getClientSecret())
                    .authorizedGrantTypes("authorization_code","refresh_token", "password", "client_credentials")
                    .scopes(o.getScope())
                    .redirectUris(o.getWebServerRedirectUri());
        }

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsService)
        .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
    //AuthorizationServer和ResourceServer分离需要重写的方法
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 配置前来验证token的client需要拥有的角色
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("permitAll()");

    }
}
