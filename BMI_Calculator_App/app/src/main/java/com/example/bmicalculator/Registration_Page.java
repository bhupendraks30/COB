package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;

public class Registration_Page extends AppCompatActivity {
    EditText email, password,cpassword;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email_r);
        password = findViewById(R.id.password_r);
        cpassword = findViewById(R.id.cpassword_r);
    }

    public void registrationProcess(View view) {
        try {
            String email_s = email.getText().toString();
            String pass_s = password.getText().toString();
            String cpass_s = cpassword.getText().toString();
            if(TextUtils.isEmpty(pass_s)&&TextUtils.isEmpty(pass_s)&&TextUtils.isEmpty(cpass_s)){
                Toast.makeText(this, "Please fill Correct Info.", Toast.LENGTH_SHORT).show();
                email.setText("");
                password.setText("");
                cpassword.setText("");
                return;
            }else if(pass_s.equals(cpass_s) && pass_s.length()>=6){
                auth.createUserWithEmailAndPassword(email_s,cpass_s).addOnCompleteListener(Registration_Page.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Toast.makeText(Registration_Page.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login_Page.class));
                            finish();
                        }else{
                            Toast.makeText(Registration_Page.this, "Registration Failed try again letter", Toast.LENGTH_SHORT).show();
                            email.setText("");
                            password.setText("");
                            cpassword.setText("");
                            return;
                        }
                    }
                });
            }else {
                Toast.makeText(this, "Please fill Correct Info.", Toast.LENGTH_SHORT).show();
                email.setText("");
                password.setText("");
                cpassword.setText("");
                return;
            }
        }catch (Exception e){
            Toast.makeText(this, "Please fill all info", Toast.LENGTH_SHORT).show();
        }
        

    }
}