import com.example.restservice.Greeting2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
public class GreetingControllerTests {
  RestTestClient client;

  public GreetingControllerTests() {
    client =
            RestTestClient.bindToController(new GreetingsController()).build();
  }

  @Test
  public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

    this.client.get().uri("/greeting")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("tom-erik");
  }

  /*
  @Test
  public void paramGreetingShouldReturnTailoredMessage() throws Exception {

    this.restTestClient.get()
        .uri(uri -> uri.path("/greeting").queryParam("name", "Spring Community").build())
        .exchange()
        .expectStatus().isOk()
        .expectBody()
          .jsonPath("$.content").isEqualTo("Hello, Spring Community!");
  }
*/

  @Test
  public void sendGreetingMessage() throws Exception {

    this.client.post()
            .uri(uri -> uri.path("/post-greeting").build())
            .accept(MediaType.APPLICATION_JSON)
            //.contentType(MediaType.APPLICATION_JSON)
            .body(Greeting2.builder().build())
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.name").isEqualTo("tom-erik");
  }
}

