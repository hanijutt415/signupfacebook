package com.enfotriz.signupfacebook;

public class ModelUser {
    String name;
    String number;
    String email;
    String password;

    public ModelUser(String name , String number , String email , String password){
        this.name = name;
        this.number = number;
        this.email = email;
        this.password = password;
    }
    public String getName(){

        return name;
    }
    public String getNumber(){
        return number;
    }
    public String getEmail(){

        return email;
    }
    public String getPassword(){

        return password;
    }
    public void setName(String name) {

        this.name = name;
    }
    public void setNumber(String number){

        this.number = number;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
