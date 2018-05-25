package unam.fi.mx.manejofragments.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

import unam.fi.mx.manejofragments.Album;

public class MotorBaseDatos extends SQLiteOpenHelper {

    private Context context;

    public MotorBaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTableAlbum = "CREATE TABLE " + ConstantesBaseDatos.TABLE_ALBUMS_NAME + "(" +
                                       ConstantesBaseDatos.TABLE_ALBUMS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                       ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM + " TEXT, " +
                                       ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA + " TEXT, " +
                                       ConstantesBaseDatos.TABLE_ALBUMS_FOTO + " INTEGER" +
                                       ")";
        db.execSQL(queryCrearTableAlbum);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF " + " EXISTS " + ConstantesBaseDatos.TABLE_ALBUMS_NAME);
        onCreate(db);

    }

    public ArrayList<Album> extraerAlbumsDataBase(){
        ArrayList<Album> albums = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_ALBUMS_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);
        while (registros.moveToNext()){
            Album albumactual = new Album(registros.getString(1),registros.getString(2),registros.getInt(3));
            albums.add(albumactual);
        }

        db.close();
        return albums;
    }

    public void InsertarAlbums(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_ALBUMS_NAME, null, contentValues);
        db.close();
    }

    public void SubirDB(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_ALBUMS_NAME, null,contentValues);
        db.close();
    }

}
