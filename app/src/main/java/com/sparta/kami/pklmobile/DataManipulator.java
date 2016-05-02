package com.sparta.kami.pklmobile;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yod on 5/1/2016.
 */
public class DataManipulator  {
    private static final String DATABASE_NAME = "pklmobile.db";
    private static final int DATABASE_VERSION = 1;
    private static String TABLE_NAME;
    private static Context context;
    static SQLiteDatabase db;

    private SQLiteStatement insertStmt;

    private static String INSERT;

    public DataManipulator(Context context,String tableName)
    {
        DataManipulator.context = context;
        this.TABLE_NAME = tableName;
        OpenHelper openHelper = new OpenHelper(DataManipulator.context);
        DataManipulator.db = openHelper.getWritableDatabase();
        this.insertStmt = DataManipulator.db.compileStatement(INSERT);
    }

    public long insertRegisUser(String email, String name, String address, String number, String birthday, String product)
    {
        INSERT = "insert into "+TABLE_NAME+" (email,name,address,nohp,birthday,product) values (?,?,?,?,?,?)";
        this.insertStmt.bindString(1, email);
        this.insertStmt.bindString(2, name);
        this.insertStmt.bindString(3, address);
        this.insertStmt.bindString(4, number);
        this.insertStmt.bindString(5, birthday);
        this.insertStmt.bindString(6, product);
        return this.insertStmt.executeInsert();
    }

    public long insertProduk(String nama, String hargaPokok, String hargaJual)
    {
        INSERT = "insert into "+TABLE_NAME+" (nama,hargaPokok,hargaJual) values (?,?,?)";
        this.insertStmt.bindString(1, nama);
        this.insertStmt.bindString(2, hargaPokok);
        this.insertStmt.bindString(3, hargaJual);
        return this.insertStmt.executeInsert();
    }

    public long insertTransaksi(String nama, String hargaJual, String kuantitas)
    {
        INSERT = "insert into "+TABLE_NAME+" (nama,hargaJual, kuantitas) values (?,?,?)";
        this.insertStmt.bindString(1, nama);
        this.insertStmt.bindString(2, hargaJual);
        this.insertStmt.bindString(3, kuantitas);
        return this.insertStmt.executeInsert();
    }

    public void deleteAll()
    {
        db.delete(TABLE_NAME,null,null);
    }

    public List<String[]> selectAllUser(){
        List<String[]> list = new ArrayList<String[]>();
        Cursor cursor = db.query(TABLE_NAME,new String[] {"email","name","address","nohp","birthday","product"},null,null,null,null,"email asc");

        int x = 0;
        if(cursor.moveToFirst())
        {
            do{
                String[] b1 = new String[]{cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)};
                list.add(b1);

                x=x+1;
            }while (cursor.moveToNext());
        }
        if(cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
        cursor.close();
        return list;
    }

    public void delete(int rowId)
    {
        db.delete(TABLE_NAME, null, null);
    }

    private static class OpenHelper extends SQLiteOpenHelper{
        OpenHelper(Context context)
        {
            super(context, DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            if(TABLE_NAME.equals("iUser")){
                db.execSQL("CREATE TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, name TEXT, address TEXT, nohp TEXT, birthday TEXT, product TEXT)");
            }

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
            onCreate(db);
        }
    }
}