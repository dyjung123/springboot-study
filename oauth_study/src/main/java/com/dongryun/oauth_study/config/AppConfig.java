package com.dongryun.oauth_study.config;

import java.security.SecureRandom;
import java.time.Clock;
import java.time.ZoneId;
import java.util.function.Supplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

  @Bean
  public Clock clock() {
    return Clock.system(ZoneId.of("Asia/Tokyo"));
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public Supplier<SecureRandom> secureRandomSupplier() {
    return SecureRandom::new;
  }
}
