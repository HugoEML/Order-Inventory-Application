package com.example.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pedidos(code text, client text, phone text, address text, description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

    //Metodo registrar
    public String Insert(String code, String client, String phone, String address, String description){
        String msg = "";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("code", code);
        registro.put("client", client);
        registro.put("phone", phone);
        registro.put("address", address);
        registro.put("description", description);
        try {
            db.insertOrThrow("pedidos", null, registro);
            msg = "Registro exitoso";
        } catch (SQLException e){
            msg = "No registrado";
        }
        db.close();
        return msg;
    }

    //Metodo llenar lista
    public ArrayList fillListView(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "select * from pedidos";
        Cursor reg = db.rawQuery(q, null);
        if(reg.moveToFirst()){
            do{
                list.add(reg.getString(1));
            }while (reg.moveToNext());
        }
        return list;
    }

    //Metodo que muestra la informacion
    public String Information(int position){
        String msg = "";
        //ArrayList<String> info = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String q = "select * from pedidos where code = " + position;
        Cursor reg = db.rawQuery(q,null);

        if(reg.moveToFirst()){
            do{
                msg += "Código: " + reg.getString(0);
                msg += "\nTeléfono Cliente: " + reg.getString(2);
                msg += "\nDirección Cliente: " + reg.getString(3);
                msg += "\nDescripción Cliente: \n" + reg.getString(4);
            }while (reg.moveToNext());
        }
        db.close();
        return msg;
    }

    //Metodo Buscar
    public String[] Search(String client){ //String code
        String datas [] = new String[6];
        SQLiteDatabase db = this.getWritableDatabase();
        //String q = "select * from pedidos where code = '" + code + "'" ;
        String q = "select * from pedidos where client = '" + client + "'" ;
        Cursor reg = db.rawQuery(q, null);
        if (reg.moveToFirst()){
            datas[0] = reg.getString(0);
            datas[1] = reg.getString(1);
            datas[2] = reg.getString(2);
            datas[3] = reg.getString(3);
            datas[4] = reg.getString(4);
            datas[5] = "Encontrado";
        } else {
            datas[5] = "No se ha encontrado el pedido";
        }
        db.close();
        return datas;
    }

    public String Update(String code, String client, String phone, String address, String description){
        String msg = "";
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("code", code);
        contentValues.put("client", client);
        contentValues.put("phone", phone);
        contentValues.put("address", address);
        contentValues.put("description", description);

        int cant = db.update("pedidos", contentValues, "code = '"+code+"'",null);

        if (cant != 0) {
            msg = "Editado Satisfactoriamente";
        } else{
            msg = "No se ha podido editar";
        }
        db.close();
        return msg;
    }

    public String Delete(String client){ //String code
        String msg = "";
        SQLiteDatabase db = this.getWritableDatabase();
        //int cant = db.delete("pedidos", "code = '"+code+"'", null);
        int cant = db.delete("pedidos", "client = '"+client+"'", null);

        if (cant != 0){
            msg = "Eliminado Correctamente";
        } else{
            msg = "No se ha encontrado pedido";
        }
        db.close();
        return msg;
    }

}
