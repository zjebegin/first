package com.jiker.authentication.security;

import com.jiker.authentication.dao.domain.LoginInfo;
import com.jiker.authentication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MainService mainService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

   @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<LoginInfo> ls= mainService.getLoginInfoList();
        /*auth
                .inMemoryAuthentication()
                .withUser("test1").password("123456").roles("USER")
                .and()
                .withUser("test2").password("123456").roles("USER", "ADMIN");

         */
        for (LoginInfo l:ls) {
            auth.inMemoryAuthentication().withUser(l.getUserName()).password(l.getPassword()).roles(l.getRoleCode());
        }

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                //放行POST方法请求
                .antMatchers(HttpMethod.POST).permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                //所有请求都需要通过认证
                .anyRequest().authenticated()
                .and()
                //Basic提交
                .httpBasic()
                .and()
                //关跨域保护
                .csrf().disable();
    }
    @Override
    public void configure( final WebSecurity web ) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/login","/WEB-INF/jsp/index.jsp");
        web.ignoring().mvcMatchers("/**/*.js","/**/*.html","/**/*.json");


    }

}
