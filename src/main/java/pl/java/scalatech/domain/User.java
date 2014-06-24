package pl.java.scalatech.domain;

import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author przodownik
 * Module name :    springKata
 * Creating time :  26 maj 2014
 */
@RequiredArgsConstructor
public class User {
  @Getter
  private final @NonNull String login;
  @Getter
  private final @NonNull String password;
}
