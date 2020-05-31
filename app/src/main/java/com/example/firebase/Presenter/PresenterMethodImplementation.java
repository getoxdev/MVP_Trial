package com.example.firebase.Presenter;

import android.net.Uri;

import com.example.firebase.Model.ModelMethodImplement;
import com.example.firebase.SecondActivity;
import com.example.firebase.View.ViewMethodInterface;

public class PresenterMethodImplementation implements PresenterMethodInterface{

    ViewMethodInterface viewinterface;

    public PresenterMethodImplementation(SecondActivity viewinterface){
        this.viewinterface = (ViewMethodInterface) viewinterface;
    }

    @Override
    public void Onlogin(String email, String password, Uri imageurl) {
        ModelMethodImplement user = new ModelMethodImplement(email, password);
        if (imageurl!=null) {
            int x = user.isValid();
            if (x == 2) {
                viewinterface.Success("SignUp successful");
            }
            if (x == 0) {
                viewinterface.Success("Please fill the blocks");
            }
            if (x == 1) {
                viewinterface.Success("Please enter valid Email-id");
            }
            if (x == 3) {
                viewinterface.Success("Password length must be greater then 5");
            }
        }
        else{
            viewinterface.Success("please select image profile");
        }
    }
}
