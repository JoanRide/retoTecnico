package com.reto.demo.apiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.reto.demo.apiModel.DataModel;
import com.reto.demo.apiModel.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {
    
    @Autowired
    private RestTemplate template;
    private String baseUrl;
    
    @Autowired
    public DataService(RestTemplate template, @Value("${service.url}") String baseUrl) {
        this.template = template;
        this.baseUrl = baseUrl;
    }

    public Map<String, ArrayList<String>> listarData() throws Exception{
        
        ArrayList<String> format = new ArrayList<String>();
        ResponseEntity<DataModel> response =template.getForEntity(baseUrl,DataModel.class);

        DataModel dataModel = response.getBody();

        for( UserModel dato : dataModel.getData()){
            format.add(dato.toString());
        }
    
       Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put("data",format);

        return map;
    }

    public DataModel listarDatos() throws Exception{

        ResponseEntity<DataModel> response =template.getForEntity(baseUrl,DataModel.class);

        DataModel dataModel = response.getBody();

        return dataModel;
    }

}
