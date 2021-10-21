package com.dongryun.oauth_study.support.spring.security;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class OnlyDeveloperPreAuthenticatedProcessingFilter extends
    AbstractPreAuthenticatedProcessingFilter {

  @Override
  protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
    return "N/A";
  }

  @Override
  protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
    return Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION)).orElse("");
  }
}
