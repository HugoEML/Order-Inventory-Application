package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lv_datos;
    TextView tv_consulta;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv_datos = (ListView)findViewById(R.id.lv_datos);
        tv_consulta = (TextView)findViewById(R.id.tv_consulta);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);
        arrayList = admin.fillListView();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lv_datos.setAdapter(adapter);

        lv_datos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);
                String msg = admin.Information(position+1);
                tv_consulta.setText(msg);
            }
        });
    }

    //Metodo del boton volver
    public void Volver(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
