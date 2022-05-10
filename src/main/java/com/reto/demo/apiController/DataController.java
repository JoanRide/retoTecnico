package com.reto.demo.apiController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.reto.demo.apiModel.DataModel;
import com.reto.demo.apiModel.UserModel;
import com.reto.demo.apiService.DataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    @Autowired
    DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/data")
    public Map<String, ArrayList<String>> getData() throws Exception{
        ArrayList<String> format = new ArrayList<String>();
        DataModel dataModel = dataService.listarDatos();

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put("data",format);
        if (dataModel.getData().length<=0){
            return map;
        }

        for( UserModel dato : dataModel.getData()){
            format.add(dato.toString());
        }



        return map ;
    }

}
