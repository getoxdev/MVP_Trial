package com.example.firebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.firebase.Presenter.PresenterMethodImplementation;
import com.example.firebase.Presenter.PresenterMethodInterface;
import com.example.firebase.View.ViewMethodInterface;
import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity implements ViewMethodInterface {

    EditText Email,Password;
    ImageView imgprofile;
    Button btn;
    PresenterMethodInterface PTM;
    Uri mImageUri;
    private static final int imagepicker = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        PTM  = new PresenterMethodImplementation(this);
        imgprofile = findViewById(R.id.img);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        imgprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent,imagepicker);
            }
        });
        btn = findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PTM.Onlogin(Email.getText().toString(),Password.getText().toString(),mImageUri);
            }
        });
    }

    @Override
    public void Success(String message) {
        Toast.makeText(SecondActivity.this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == imagepicker && resultCode == RESULT_OK && data !=null && data.getData() !=null){
            mImageUri = data.getData();
            Picasso.get().load(mImageUri).into(imgprofile);
        }
    }

}


