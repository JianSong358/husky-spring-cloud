package com.husky.cloud.config;

import com.husky.cloud.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private LoginSuccessHandler loginSuccessHandler ;
    @Resource
    private LoginFailHandler loginFailHandler ;

    /**
     * 权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // 配置拦截规则
        http.authorizeRequests().antMatchers("/").permitAll();
        // 配置登录功能
        http.formLogin().usernameParameter("userName")
                .passwordParameter("passWord")
                .loginProcessingUrl("/userLogin")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailHandler);
        // 注销成功跳转首页
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
    }
    /**
     * 自定义认证数据源
     */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService())
                .passwordEncoder(passwordEncoder());
    }
    @Bean
    public UserDetailServiceImpl userDetailService (){
        return new UserDetailServiceImpl() ;
    }
    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
