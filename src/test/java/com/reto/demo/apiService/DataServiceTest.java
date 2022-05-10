package com.reto.demo.apiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.reto.demo.apiModel.DataModel;
import com.reto.demo.apiModel.UserModel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DataServiceTest {
    
    @Mock
    private RestTemplate template;
    

    @InjectMocks
    private DataService dataService = new DataService(template, "https://reqres.in/api/users");

    @Test
    public void listarDataTest() throws Exception{
        DataModel dato = new DataModel();
        UserModel users[] = new UserModel[6];
        users[0] = new UserModel(1,"george.bluth@reqres.in","Bluth");
        users[1] = new UserModel(2,"janet.weaver@reqres.in","Weaver");
        users[2] = new UserModel(3,"emma.wong@reqres.in","Wong");
        users[3] = new UserModel(4,"eve.holt@reqres.in","Holt");
        users[4] = new UserModel(5,"charles.morris@reqres.in","Morris");
        users[5] = new UserModel(6,"tracey.ramos@reqres.in","Ramos");

        dato.setData(users);

       Mockito.when(template.getForEntity("https://reqres.in/api/users",DataModel.class)).thenReturn(new ResponseEntity<DataModel>(dato, HttpStatus.OK));

        DataModel dato2 = dataService.listarDatos();
        Assert.assertEquals(dato, dato2);
    }
}
