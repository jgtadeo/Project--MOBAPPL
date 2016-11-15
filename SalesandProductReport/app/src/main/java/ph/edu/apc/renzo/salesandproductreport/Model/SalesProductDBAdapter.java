package ph.edu.apc.renzo.salesandproductreport.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Renzo on 09/11/2016.
 */

public class SalesProductDBAdapter {

    private SalesProductDB salesproductDB;
    private SQLiteDatabase sqliteDB;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "salesandproduct.db";
    protected static final String TABLE_NAME = "signup";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    public static final String TABLE_CREATE = "create table " + TABLE_NAME + "(" + COLUMN_ID + " integer primary key not null, "
            + COLUMN_NAME + " text not null, " + COLUMN_USERNAME + " text not null, " + COLUMN_PASSWORD + " text not null, " + COLUMN_EMAIL + " text not null);";

    public SalesProductDBAdapter(Context context) {
        salesproductDB = new SalesProductDB(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertInformation(Information information) {
        ContentValues cv = new ContentValues();
        sqliteDB = salesproductDB.getWritableDatabase();

        cv.put(COLUMN_NAME, information.getName());
        cv.put(COLUMN_USERNAME, information.getUsername());
        cv.put(COLUMN_PASSWORD, information.getPassword());
        cv.put(COLUMN_EMAIL, information.getEmail());
        sqliteDB.insert(TABLE_NAME, null, cv);
    }

    public String searchPass(String usernamestr) {
        sqliteDB = salesproductDB.getReadableDatabase();
        Cursor cursor = sqliteDB.query(TABLE_NAME, null, COLUMN_USERNAME + "=?", new String[]{usernamestr}, null, null, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                b = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                if (a.equals(usernamestr)) {
                    b = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

        public String displayName(String usernamestr) {
            sqliteDB = salesproductDB.getReadableDatabase();
            Cursor cursor = sqliteDB.query(TABLE_NAME, null, COLUMN_USERNAME + "=?", new String[]{usernamestr}, null, null, null);
            String a, b;
            b = "note found";
            if (cursor.moveToFirst()) {
                do {
                    a = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
                    b = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                    if (a.equals(usernamestr)) {
                        b = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                        break;
                    }
                }
                while (cursor.moveToNext());
            }
            return b;
        }

    }

