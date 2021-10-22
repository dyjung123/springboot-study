package com.dongryun.oauth_study.config;

import com.dongryun.oauth_study.support.spring.security.OnlyDeveloperPreAuthenticatedProcessingFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
public class SecurityConfig {
  private static final String ONLY_DEVELOPER = "/developer-mode/**";
  private static final RequestMatcher DEVELOPMENT_MATCHER = new AntPathRequestMatcher(ONLY_DEVELOPER);
  private static final RequestMatcher APPLICATION_MATCHER = new NegatedRequestMatcher(DEVELOPMENT_MATCHER);

  @Order(1)
  @Configuration
  @AllArgsConstructor
  public static class OnlyDeveloperSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      OnlyDeveloperPreAuthenticatedProcessingFilter filter = new OnlyDeveloperPreAuthenticatedProcessingFilter();
      filter.setAuthenticationManager(authenticationManager());

      http.requestMatcher(DEVELOPMENT_MATCHER)
          .csrf().disable()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
          .and()
          .addFilter(filter)
          .authorizeRequests()
          .mvcMatchers("/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
      provider.setPreAuthenticatedUserDetailsService();
      auth.authenticationProvider(provider);
    }
  }

  @Order(2)
  @Configuration
  public static class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.requestMatcher(APPLICATION_MATCHER)
          .csrf()
          .and()
          .authorizeRequests()
          .mvcMatchers("/**")
          .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/js/**", "/css/**");
    }
  }

}
