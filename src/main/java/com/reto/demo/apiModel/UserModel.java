package com.reto.demo.apiModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    
    
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserModel(Integer id, String email, String lastName) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  id +"|" +email +"|" + lastName ;
    }

    
    
}
