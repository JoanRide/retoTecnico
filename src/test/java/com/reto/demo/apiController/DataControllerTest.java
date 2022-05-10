package com.reto.demo.apiController;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class DataControllerTest {
    @Autowired
    private DataController dataController;

    @LocalServerPort 
  private int port;

  @Autowired 
  private TestRestTemplate template;
  
  @Test 
  public void index() { 
    Assertions.assertThat(dataController); 
  }

  @Test 
  public void indexResultTest() { 

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    Assertions.assertThat(template.postForObject("http://localhost:" +port,headers, String.class));
  } 

}
