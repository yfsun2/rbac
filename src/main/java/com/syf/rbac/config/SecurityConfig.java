package com.syf.rbac.config;

import com.syf.rbac.service.impl.MyAuthenticationProvider;
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

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("管理员")
                .antMatchers("/level2/**").hasRole("普通用户")
                .antMatchers("/level3/**").hasRole("高级会员");

        http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/toLogin");

        http.csrf().disable();

        http.logout().logoutSuccessUrl("/");

        http.rememberMe().rememberMeParameter("remember-me");
    }

    @Bean
    MyAuthenticationProvider myAuthenticationProvider(){
        return new MyAuthenticationProvider();
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("zs").password(new BCryptPasswordEncoder().encode("123")).roles("vip2","vip3")
//                .and().withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3")
//                .and().withUser("guest").password(new BCryptPasswordEncoder().encode("123")).roles("vip1");

        auth.authenticationProvider(myAuthenticationProvider());

    }

}