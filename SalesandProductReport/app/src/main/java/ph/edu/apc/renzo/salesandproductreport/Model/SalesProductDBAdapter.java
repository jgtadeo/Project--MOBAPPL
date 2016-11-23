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

    ////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////SIGN UP TABLE//////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////

    protected static final String TABLE_NAME = "signup";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_EMAIL = "email";
    public static final String TABLE_CREATE = "create table " + TABLE_NAME + "(" + COLUMN_ID + " integer primary key not null, "
            + COLUMN_NAME + " text not null, " + COLUMN_USERNAME + " text not null, " + COLUMN_PASSWORD + " text not null, " + COLUMN_EMAIL + " text not null);";

    /////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////SALES TABLE////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////

    protected static final String TABLE_NAME_SALES = "sales";
    private static final String COLUMN_ID_SALES = "id";
    private static final String COLUMN_DATE_SALES = "date";
    private static final String COLUMN_GROSS_SALES = "gross";
    private static final String COLUMN_BREAD_SALES = "bread";
    private static final String COLUMN_GROCERY_SALES = "grocery";
    private static final String COLUMN_ELOAD_SALES = "eload";
    private static final String COLUMN_SMART_SALES = "smart";
    private static final String COLUMN_GLOBE_SALES = "globe";
    private static final String COLUMN_SUN_SALES = "sun";
    public static final String TABLE_CREATE_SALES = "create table " + TABLE_NAME_SALES + "(" + COLUMN_ID_SALES + " integer primary key not null, "
            + COLUMN_DATE_SALES + " text not null, " + COLUMN_GROSS_SALES + " integer not null, " + COLUMN_BREAD_SALES + " integer not null, " + COLUMN_GROCERY_SALES +
            " integer not null, " + COLUMN_ELOAD_SALES + " integer not null, " + COLUMN_SMART_SALES + " integer not null, " + COLUMN_GLOBE_SALES + " integer not null, "
            + COLUMN_SUN_SALES + " integer not null);";

    public SalesProductDBAdapter(Context context) {
        salesproductDB = new SalesProductDB(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////SIGN UP////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public void insertInformation(Information information) {
        ContentValues cv = new ContentValues();
        sqliteDB = salesproductDB.getWritableDatabase();

        cv.put(COLUMN_NAME, information.getName());
        cv.put(COLUMN_USERNAME, information.getUsername());
        cv.put(COLUMN_PASSWORD, information.getPassword());
        cv.put(COLUMN_EMAIL, information.getEmail());
        sqliteDB.insert(TABLE_NAME, null, cv);
    }

    /////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////LOG IN////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////

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

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////SALES///////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public void insertSalesInformation(Information salesinformation) {
        ContentValues cv = new ContentValues();
        sqliteDB = salesproductDB.getWritableDatabase();

        cv.put(COLUMN_DATE_SALES, salesinformation.getDate());
        cv.put(COLUMN_GROSS_SALES, salesinformation.getGross());
        cv.put(COLUMN_BREAD_SALES, salesinformation.getBread());
        cv.put(COLUMN_GROCERY_SALES, salesinformation.getGrocery());
        cv.put(COLUMN_ELOAD_SALES, salesinformation.getEload());
        cv.put(COLUMN_SMART_SALES, salesinformation.getSmart());
        cv.put(COLUMN_GLOBE_SALES, salesinformation.getGlobe());
        cv.put(COLUMN_SUN_SALES, salesinformation.getSun());
        sqliteDB.insert(TABLE_NAME_SALES, null, cv);

    }

}

