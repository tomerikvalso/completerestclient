package com.example.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.bind.annotation.RequestBody;
import tools.jackson.databind.json.JsonMapper;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

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
    Greeting2 g = Greeting2.builder().id("1").name("TomErik2").build();
    String s = JsonMapper.builderWithJackson2Defaults().build().writeValueAsString(g);
    this.client.post()
            .uri(uri -> uri.path("/api/postgreeting").build())
            .contentType(MediaType.APPLICATION_JSON)
            .body(s )
            .exchange()
            .expectStatus().isOk()
            .expectBody()//equals("TomErik22")
            .jsonPath("$.name").isEqualTo("TomErik2");
  }

}

