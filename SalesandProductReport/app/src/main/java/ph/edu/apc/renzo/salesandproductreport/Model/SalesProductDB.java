package ph.edu.apc.renzo.salesandproductreport.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Renzo on 06/11/2016.
 */
/*
public class SalesProductDB extends SQLiteOpenHelper {

    SQLiteDatabase db;

    public SalesProductDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String query = "CREATE TABLE signup (id integer primary key not null autoincrement, name text not null" +
        //        "username text not null, password text not null, email text not null);";
        db.execSQL(SalesProductDBAdapter.TABLE_CREATE);
        db.execSQL(SalesProductDBAdapter.TABLE_CREATE_SALES);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String query = "DROP TABLE IF EXIST " + TABLE_NAME;
        db.execSQL("DROP TABLE IF EXIST " + SalesProductDBAdapter.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXIST " + SalesProductDBAdapter.TABLE_NAME_SALES);
        this.onCreate(db);
    }
}*/
