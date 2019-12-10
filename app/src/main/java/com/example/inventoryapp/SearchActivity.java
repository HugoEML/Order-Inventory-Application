package com.example.inventoryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    EditText editTextCode, editTextClient, editTextPhone, editTextAddress, editTextDescription;
    Button btn_save, btn_edit, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editTextCode = (EditText)findViewById(R.id.editTextCode);
        editTextClient = (EditText)findViewById(R.id.editTextClient);
        editTextPhone = (EditText)findViewById(R.id.editTextPhone);
        editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        editTextDescription = (EditText)findViewById(R.id.editTextDescription);
    }

    //Metodo para el boton Buscar
    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);
        //String code = editTextCode.getText().toString();
        String client= editTextClient.getText().toString();
        String[] datos;
        datos = admin.Search(client);
        editTextCode.setText(datos[0]);
        editTextClient.setText(datos[1]);
        editTextPhone.setText(datos[2]);
        editTextAddress.setText(datos[3]);
        editTextDescription.setText(datos[4]);

        Toast.makeText(getApplicationContext(), datos[5], Toast.LENGTH_SHORT).show();
    }

    //Metodo para el boton Editar
    public void Editar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);
        String code = editTextCode.getText().toString();
        String client = editTextClient.getText().toString();
        String phone = editTextPhone.getText().toString();
        String address = editTextAddress.getText().toString();
        String description = editTextDescription.getText().toString();
        String msg = admin.Update(code, client, phone, address, description);
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    //Metodo para el boton Eliminar
    public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), null, null, 1);
        //String code = editTextCode.getText().toString();
        String client = editTextClient.getText().toString();
        String msg = admin.Delete(client);
        editTextCode.setText("");
        editTextClient.setText("");
        editTextPhone.setText("");
        editTextAddress.setText("");
        editTextDescription.setText("");
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
