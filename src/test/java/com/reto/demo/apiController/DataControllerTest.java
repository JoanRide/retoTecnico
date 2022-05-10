package com.reto.demo.apiController;


import com.reto.demo.apiModel.DataModel;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 
public class DataControllerTest {
    @Autowired
    private DataController dataController;

    @LocalServerPort 
  private int port;

  private TestRestTemplate template=new TestRestTemplate();
  
  @Test 
  public void index() { 
    Assertions.assertThat(dataController); 
  }

  @Test 
  public void indexResultTest()  {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("user-agent", "Application");
    HttpEntity<String> request =
            new HttpEntity<String>("", headers);

    Assertions.assertThat(template.postForObject("http://localhost:8080/data", request, String.class)).isNotNull();
  }
}
