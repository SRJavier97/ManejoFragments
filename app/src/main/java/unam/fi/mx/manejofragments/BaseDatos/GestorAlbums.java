package unam.fi.mx.manejofragments.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;

import unam.fi.mx.manejofragments.Album;
import unam.fi.mx.manejofragments.R;

public class GestorAlbums {

    private Context context;

    public GestorAlbums(Context context){
        this.context = context;
    }

    public ArrayList<Album> AsignarAlbum(){
        MotorBaseDatos db = new MotorBaseDatos(context);
        InsertarDosAlbums(db);
        return db.extraerAlbumsDataBase();
    }

    private void InsertarDosAlbums(MotorBaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, "BABA YAGA");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, "JW");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.jwb_dps);
        db.InsertarAlbums(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, "REVELATION");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, "Jeff Williams");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.rvb_revelation);

        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, "BROTHERS IN ARMS - SINGLE");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, "DaGames");
        contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_FOTO, R.drawable.bia_dag);
    }
}
