package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Page extends AppCompatActivity {
    EditText email, password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_l);
        password = findViewById(R.id.password_l);
    }
    public void loginProcess(View view) {
        try{
            String email_s = email.getText().toString();
            String password_s = password.getText().toString();
            if(TextUtils.isEmpty(email_s)&&TextUtils.isEmpty(password_s)){
                Toast.makeText(getApplicationContext(), "Please fill Correct Info.", Toast.LENGTH_SHORT).show();
                email.setText("");
                password.setText("");
                return;
            }
            auth.signInWithEmailAndPassword(email_s,password_s).addOnSuccessListener(Login_Page.this,new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(Login_Page.this, "login successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
            });
            auth.signInWithEmailAndPassword(email_s,password_s).addOnFailureListener(Login_Page.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Login_Page.this, "Incorrect Email/Password", Toast.LENGTH_SHORT).show();
                    email.setText("");
                    password.setText("");
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "Please fill all info", Toast.LENGTH_SHORT).show();
        }

    }
    public void goToRegitrationPage(View view) {
        startActivity(new Intent(this,Registration_Page.class));
        finish();
    }
}