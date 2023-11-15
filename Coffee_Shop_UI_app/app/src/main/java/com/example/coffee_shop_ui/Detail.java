package com.example.coffee_shop_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {
    ImageView imageView;
    int count=1;

    String[] name = {"Capuchino", "Cold-Coffee", "Espresso", "Cafe-Latte", "Americano", "Hot-Coffee"};
    String[] c_price = {"$20", "$30", "$40", "$50", "$60", "$70"};
    int[] resource={R.drawable.capuchino, R.drawable.cold_coffee, R.drawable.expresso, R.drawable.cafe_latte, R.drawable.americano, R.drawable.hot_coffee};
    TextView coffee_name,price,count_t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.imageView);
        coffee_name = findViewById(R.id.coffee_name);
        price = findViewById(R.id.price);
        count_t = findViewById(R.id.count);

        Intent i = getIntent();
        int id = i.getIntExtra("id",0);
        imageView.setImageResource(resource[id]);
        coffee_name.setText(name[id]);
        price.setText(c_price[id]);
    }

    public void increase_Quantity(View view) {

            count=count+1;
            count_t.setText(""+count);
    }

    public void decrease_Quantity(View view) {
        if(count==1){
            count_t.setText("1");
        }else{
            count=count-1;
            count_t.setText(""+count);
        }
    }

    public void order_Now(View view) {
        Toast.makeText(this, count+" Order placed.", Toast.LENGTH_SHORT).show();
    }
}