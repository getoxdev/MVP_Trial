package com.example.firebase.Model;

import android.util.Patterns;

import java.util.regex.Pattern;

public class ModelMethodImplement implements ModelMethodInterface {

    private String email,password;

   public ModelMethodImplement(String email, String password){
       this.email = email;
       this.password = password;
   }

    @Override
    public String getpassword() {
        return password;
    }

    @Override
    public String getemail() {
        return email;
    }

    @Override
    public int isValid() {
        if(email.isEmpty() || password.isEmpty()){
            return 0;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return 1;
        }
        else if(password.length()<6) {
            return 3;
        }
        else {
            return 2;

        }
   }
}
