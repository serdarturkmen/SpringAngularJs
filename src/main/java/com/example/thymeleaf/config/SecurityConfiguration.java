package com.example.thymeleaf.config;

import com.example.thymeleaf.model.User;
import com.example.thymeleaf.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private SerdarAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

    @Autowired
    private SerdarAuthenticationFailureHandler ajaxAuthenticationFailureHandler;

    @Autowired
    private SerdarLogoutSuccessHandler ajaxLogoutSuccessHandler;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setSaltSource(new SaltSource() {
            @Override
            public Object getSalt(UserDetails userDetails) {
                User user = (User) userDetails;
                return user.getSalt();
            }
        });

        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers(HttpMethod.OPTIONS, "/**")
            .antMatchers("/app/**/*.{js,html,template}")
            .antMatchers("/bower_components/**")
            .antMatchers("/i18n/**")
            .antMatchers("/content/**")
            .antMatchers("/swagger-ui/index.html")
            .antMatchers("/test/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .successHandler(ajaxAuthenticationSuccessHandler)
                .failureHandler(ajaxAuthenticationFailureHandler)
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessHandler(ajaxLogoutSuccessHandler)
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/activate").permitAll()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/account/reset_password/init").permitAll()
                .antMatchers("/account/reset_password/finish").permitAll()
                .antMatchers("/profile-info").permitAll()
                .antMatchers("/**").authenticated()
                .antMatchers("/admin/**").hasAuthority(AuthoritiesConstants.ADMIN);
        http.rememberMe().rememberMeServices(rememberMeServices()).key(applicationProperties.getSecurity().getRememberMe().getKey());
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices(applicationProperties.getSecurity().getRememberMe().getKey(), userDetailsService);
        rememberMeServices.setCookieName("remember-me");
        rememberMeServices.setParameter("remember-me");
        return rememberMeServices;
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}
