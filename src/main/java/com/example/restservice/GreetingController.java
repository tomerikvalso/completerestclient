package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting2 greeting(@RequestParam(defaultValue = "World") String name) {
    Greeting2.builder().build();
    System.out.println(build);
    return build;
  }

  @PostMapping(path = "/post-greeting" )
  public Greeting greetingpost(  Greeting greeting) {
    System.out.println(greeting);
    return greeting;
  }

}

