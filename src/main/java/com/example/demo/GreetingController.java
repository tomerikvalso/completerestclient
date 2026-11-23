package com.example.demo;

import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path=("/api"), produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting2 greeting(@RequestParam(defaultValue = "tom-erik") String name) {
    Greeting2 gretting = Greeting2.builder().build();
    gretting.setName(name);
    System.out.println(gretting);
    return gretting;
  }

  @PostMapping(path = "/postgreeting" ,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
  public Greeting2 greetingpost( @RequestBody  Greeting2 greeting) {
    System.out.println("postgreeting " + greeting);
    return greeting;
  }

  @PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createUser(@RequestBody Greeting2 greeting) { // Missing @RequestBody
    System.out.println("create " + greeting.getName());
    return ResponseEntity.ok("User created: " + greeting.getName());

  }


}

