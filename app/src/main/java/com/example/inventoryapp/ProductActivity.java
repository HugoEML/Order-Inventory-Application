package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    CheckBox cc1lt, cc2lt, cc3lt, sp1lt, sp2lt, sp3lt, ft1lt, ft2lt, ft3lt, v2lt;
    EditText cant1, cant2, cant3, cant4, cant5, cant6, cant7, cant8, cant9, cant10;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        cc1lt = (CheckBox)findViewById(R.id.cc1lt);
        cc2lt = (CheckBox)findViewById(R.id.cc2lt);
        cc3lt = (CheckBox)findViewById(R.id.cc3lt);
        sp1lt = (CheckBox)findViewById(R.id.sp1lt);
        sp2lt = (CheckBox)findViewById(R.id.sp2lt);
        sp3lt = (CheckBox)findViewById(R.id.sp3lt);
        ft1lt = (CheckBox)findViewById(R.id.ft1lt);
        ft2lt = (CheckBox)findViewById(R.id.ft2lt);
        ft3lt = (CheckBox)findViewById(R.id.ft3lt);
        v2lt = (CheckBox)findViewById(R.id.v2lt);

        cant1 = (EditText)findViewById(R.id.cant1);
        cant2 = (EditText)findViewById(R.id.cant2);
        cant3 = (EditText)findViewById(R.id.cant3);
        cant4 = (EditText)findViewById(R.id.cant4);
        cant5 = (EditText)findViewById(R.id.cant5);
        cant6 = (EditText)findViewById(R.id.cant6);
        cant7 = (EditText)findViewById(R.id.cant7);
        cant8 = (EditText)findViewById(R.id.cant8);
        cant9 = (EditText)findViewById(R.id.cant9);
        cant10 = (EditText)findViewById(R.id.cant10);

        btn_save = (Button)findViewById(R.id.btn_search);
    }

    public void SaveAll(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);

        Bundle bundle = getIntent().getExtras();
        String code = bundle.getString("code");
        String client = bundle.getString("client");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        String description = "";


        if (cc1lt.isChecked() == true){
            description += "Coca Cola 1lt. cantidad: " + cant1.getText().toString() + "\n";
        }
        if (cc2lt.isChecked() == true){
            description += "Coca Cola 2lt. cantidad: " + cant2.getText().toString() + "\n";
        }
        if (cc3lt.isChecked() == true){
            description += "Coca Cola 3lt. cantidad: " + cant3.getText().toString() + "\n";
        }
        if (sp1lt.isChecked() == true){
            description += "Sprite 1lt. cantidad: " + cant4.getText().toString() + "\n";
        }
        if (sp2lt.isChecked() == true){
            description += "Sprite 2lt. cantidad: " + cant5.getText().toString() + "\n";
        }
        if (sp3lt.isChecked() == true){
            description += "Sprite 3lt. cantidad: " + cant6.getText().toString() + "\n";
        }
        if (ft1lt.isChecked() == true){
            description += "Fanta 1lt. cantidad: " + cant7.getText().toString() + "\n";
        }
        if (ft2lt.isChecked() == true){
            description += "Fanta 2lt. cantidad: " + cant8.getText().toString() + "\n";
        }
        if (ft3lt.isChecked() == true){
            description += "Fanta 3lt. cantidad: " + cant9.getText().toString() + "\n";
        }
        if (v2lt.isChecked() == true){
            description += "Vital 2lt. cantidad: " + cant10.getText().toString() + "\n";
        }

        String msg = admin.Insert(code, client, phone, address, description);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        /*
            cc1lt.setChecked(false);
            cc2lt.setChecked(false);
            cc3lt.setChecked(false);
            sp1lt.setChecked(false);
            sp2lt.setChecked(false);
            sp3lt.setChecked(false);
            ft1lt.setChecked(false);
            ft2lt.setChecked(false);
            ft3lt.setChecked(false);
            v2lt.setChecked(false);
            cant1.setText("");
            cant2.setText("");
            cant3.setText("");
            cant4.setText("");
            cant5.setText("");
            cant6.setText("");
            cant7.setText("");
            cant8.setText("");
            cant9.setText("");
            cant10.setText("");
         */
    }
}
