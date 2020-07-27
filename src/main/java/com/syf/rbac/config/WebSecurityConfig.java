package com.syf.rbac.config;

import com.syf.rbac.service.impl.MyAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author syf
 * @Date 2020/7/27 17:20
 */
//@EnableWebSecurity
public class WebSecurityConfig {
//    @Autowired
//    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(MyAuthenticationProvider myAuthenticationProvider) {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/").permitAll()
                        .antMatchers("/level1/**").hasRole("管理员")
                        .antMatchers("/level2/**").hasRole("普通用户")
                        .antMatchers("/level3/**").hasRole("高级会员").anyRequest().authenticated();

                http.formLogin().loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/toLogin");

                http.csrf().disable();

                http.logout().logoutSuccessUrl("/");

                http.rememberMe().rememberMeParameter("remember-me");

            }

            /**
             * 配置自定义校验规则，密码编码，使用我们自定义的校验器
             * @param auth
             * @throws Exception
             */
            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(myAuthenticationProvider);
            }

        };
    }

}
