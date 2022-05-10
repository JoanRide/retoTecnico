package com.reto.demo.apiModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataModel {
    
    private UserModel data[];

    public DataModel() {
    }

    public UserModel[] getData() {
        return data;
    }

    public void setData(UserModel[] data) {
        this.data = data;
    }

}
