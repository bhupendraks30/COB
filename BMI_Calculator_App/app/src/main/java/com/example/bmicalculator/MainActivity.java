package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    EditText age,feet,inch,weight;
    TextView result,health;

    private String healthReport="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        health = findViewById(R.id.health);

        if(user==null){
            startActivity(new Intent(this,Login_Page.class));
            finish();
        }
    }
    public void logoutProcess(View view) {
        auth.signOut();
        startActivity(new Intent(this,Login_Page.class));
        finish();
    }
    public void resultProcess(View view) {
        try {
            double weight_u = Double.parseDouble(weight.getText().toString());
            int feet_u = Integer.parseInt(feet.getText().toString());
            int inch_u = Integer.parseInt(inch.getText().toString());
            double height = (feet_u * 0.3048) + (inch_u * 0.0254);
            double bmi_value = weight_u / (height * height);
            result.setText("" + bmi_value);


            if (bmi_value < 18.5) {
                healthReport = "Underweight";
            } else if (bmi_value >= 18.5 && bmi_value <= 24.9) {
                healthReport = "Normal weight";
            } else if (bmi_value >= 25 && bmi_value <= 29.9) {
                healthReport = "Overweight";
            } else if (bmi_value >= 30) {
                healthReport = "Obese";
            }


            // Provide additional information based on the health report
            if (healthReport.equals("Underweight")) {
                health.setText("you are underweight. It is important to eat a healthy diet and gain weight in a healthy way.");
            } else if (healthReport.equals("Normal weight")) {
                health.setText("Maintaining a normal weight is important for your overall health and well-being.");
            } else if (healthReport.equals("Overweight")) {
                health.setText("Being overweight can increase your risk of developing chronic diseases such as heart disease, stroke, and type 2 diabetes.");
            } else if (healthReport.equals("Obese")) {
                health.setText("Obese. It is important to talk to your doctor about how to lose weight safely and effectively.");
            }
        }catch (Exception e){
            Toast.makeText(this, "Please fill the info", Toast.LENGTH_SHORT).show();
        }
        
    }
}