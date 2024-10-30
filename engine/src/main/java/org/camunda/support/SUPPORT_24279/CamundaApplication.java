package org.camunda.support.SUPPORT_24279;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication("SUPPORT-24279")
public class CamundaApplication {

  public static void main(String... args) {
    SpringApplication.run(CamundaApplication.class, args);
  }

}
