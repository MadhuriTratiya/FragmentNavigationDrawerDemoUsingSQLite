package madhuri.com.craftzone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String databasename = "login.db";
    public DatabaseHelper(@Nullable Context context) {

        super(context, "login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table userscradentials(email TEXT primary key,password TEXT )");
        db.execSQL("Create table SofaItem(sofaimg VARCHAR, sofatitle TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists usercradentials");
        db.execSQL("drop table if exists SofaItem");
    }

    public Boolean insertdata(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Email",email);
        contentValues.put("Password",password);

        long result = db.insert("userscradentials", null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Boolean checkEmail(String email){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userscradentials where email = ? ",new String[]{email});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkPassword(String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userscradentials where password = ?",new String[]{password});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
}
