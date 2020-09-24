package com.example.app07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    //ATRIBUTOS
    private static final String DATABASE_NAME = "catalogo";
    private static final int DATABASE_VERSION = 3;
    private final String CREATE_TABLE_CATALOGO =
            "CREATE TABLE catalogo ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "titulo TEXT, autor TEXT, "
                    + "ano INTEGER);";

    public DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CATALOGO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS catalogo");
        onCreate(db);
    }

    public long inserir(ContentValues cv){
        SQLiteDatabase db = this.getWritableDatabase();
        long id = db.insert("catalogo", null, cv);
        return id;
    }

    public List<ContentValues> pesquisarPorTitulo(String titulo){
        String sql = "SELECT * FROM catalogo WHERE titulo LIKE ?";
        String where[] = new String[]{"%" + titulo + "%"};
        return pesquisar(sql, where);
    }

    public List<ContentValues> pesquisarPorAno (int ano){
        String sql = "SELECT * FROM catalogo WHERE ano = ?";
        String where[] = new String[]{String.valueOf(ano)};
        return pesquisar(sql, where);
    }

    public List<ContentValues> pesquisarPorTodos(){
        String sql = "SELECT * FROM catalogo ORDER BY id";
        String where[] = null;
        return pesquisar(sql, where);
    }

    public List<ContentValues> pesquisar(String sql, String where[]){
        List<ContentValues> lista = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(sql, where);

        if (c.moveToFirst()){
            do{
                ContentValues cv = new ContentValues();
                cv.put("id", c.getString(c.getColumnIndex("id")));
                cv.put("titulo", c.getString(c.getColumnIndex("titulo")));
                cv.put("autor", c.getString(c.getColumnIndex("autor")));
                cv.put("ano", c.getString(c.getColumnIndex("ano")));
                lista.add(cv);
            } while(c.moveToNext());
        }
        return lista;
    }
}
