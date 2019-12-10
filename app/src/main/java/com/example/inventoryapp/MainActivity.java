package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_add, btn_list, btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = (ImageButton)findViewById(R.id.btn_add);
        btn_list = (ImageButton)findViewById(R.id.btn_list);
        btn_search = (ImageButton)findViewById(R.id.btn_search);
    }

    public void addProduct(View view){
        Intent intent = new Intent(getApplicationContext(), Main2Activity_Add.class);
        startActivity(intent);
    }

    public void listProduct(View view){
        Intent intent = new Intent(getApplicationContext(), ListActivity.class);
        startActivity(intent);
    }

    public void searchProduct(View view){
        Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
        startActivity(intent);
    }
}
