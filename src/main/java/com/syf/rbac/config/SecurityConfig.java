package com.syf.rbac.config;

import com.syf.rbac.service.impl.MyAuthenticationProvider;
import com.syf.rbac.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author syf
 * @Date 2020/7/27 9:41
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailService;
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("ADMIN","USER","VIP")
                .antMatchers("/level2/**").hasAnyRole("ADMIN","VIP")
                .antMatchers("/level3/**").hasAnyRole("ADMIN");

        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login").permitAll();

        http.csrf().disable();

        http.cors();

        http.logout().logoutSuccessUrl("/");

        http.rememberMe().userDetailsService(userDetailService).rememberMeParameter("remember-me");
    }

    @Bean
    MyAuthenticationProvider myAuthenticationProvider(){
        return new MyAuthenticationProvider();
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(myAuthenticationProvider());
    }
}