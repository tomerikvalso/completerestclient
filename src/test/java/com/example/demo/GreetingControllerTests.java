package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
  class GreetingControllerTests {
  RestTestClient client;


  public GreetingControllerTests() {
    client =
            RestTestClient.bindToController(new GreetingController()).build();
  }

  @Test
  void contextLoads() {
  }

  @Test
  public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

    this.client.get().uri("/greeting")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("tom-erik");
  }


  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {

    this.client.get()
        .uri(uri -> uri.path("/greeting").queryParam("name", "Spring Community").build())
        .exchange()
        .expectStatus().isOk()
        .expectBody()
          .jsonPath("$.content").isEqualTo("Hello, Spring Community!");
  }


  // dette er caset jeg raskt kom borti. behold dette
  @Test
  public void createTestWithHTTPEntity() throws Exception {
    Greeting2 tomerik = Greeting2.builder().name("tomerik").build();
    System.out.println(tomerik.getName());
    this.client.post()
            .uri(uri -> uri.path("/create").build())
            .contentType(MediaType.APPLICATION_JSON)
            .body("tomerik")
            .exchange()
            .expectStatus().isOk()
            .expectBody().equals("tomeri2k");
    //        .jsonPath("$.name").isEqualTo("tomerik");
  }

  @Test
  public void kpostgreetingTestWithString() throws Exception {
  //  Greeting2 tomerik = Greeting2.builder().name("tomerik").build();
//    System.out.println(tomerik.getName());
    this.client.post()
            .uri(uri -> uri.path("/postgreeting").build())
           // .contentType(MediaType.APPLICATION_JSON)
            .body("tomerik")
            .exchange()
            .expectStatus().isOk()
            .expectBody().equals("tomeri2k");
    //        .jsonPath("$.name").isEqualTo("tomerik");
  }

}

