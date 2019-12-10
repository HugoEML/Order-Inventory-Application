package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity_Add extends AppCompatActivity {

    EditText et_code, et_client, et_phone, et_address;
    Button btn_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__add);

        et_code = (EditText)findViewById(R.id.et_code);
        et_client = (EditText)findViewById(R.id.et_client);
        et_phone = (EditText)findViewById(R.id.et_phone);
        et_address = (EditText)findViewById(R.id.et_address);
        btn_product = (Button)findViewById(R.id.btn_product);
    }

    public void addProductCant(View view){
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);

        String code = et_code.getText().toString();
        String client = et_client.getText().toString();
        String phone = et_phone.getText().toString();
        String address = et_address.getText().toString();

        if (!code.isEmpty() && !client.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            intent.putExtra("code", code);
            intent.putExtra("client", client);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);

            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
