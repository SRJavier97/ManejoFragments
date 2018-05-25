package unam.fi.mx.manejofragments.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import unam.fi.mx.manejofragments.Album;
import unam.fi.mx.manejofragments.AlbumAdaptador;
import unam.fi.mx.manejofragments.BaseDatos.ConstantesBaseDatos;
import unam.fi.mx.manejofragments.BaseDatos.GestorAlbums;
import unam.fi.mx.manejofragments.BaseDatos.MotorBaseDatos;
import unam.fi.mx.manejofragments.R;

public class FragmentAdd extends Fragment {

    ArrayList<Album> albums;
    private RecyclerView listaAlbums;

    EditText edtAlbum;
    EditText edtCancion;
    EditText edtArtista;
    Button btnSave;
    Context cont;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_add,container,false);

        listaAlbums = v.findViewById(R.id.rcvListaAlbums);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAlbums.setLayoutManager(llm);
        InicializarListaAlbums();
        IniciarAdaptador();

        btnSave = v.findViewById(R.id.btnGuardar);

        cont = container.getContext();
        btnSave= v.findViewById(R.id.btnGuardar);
        edtArtista = v.findViewById(R.id.edtAddArtista);
        edtAlbum = v.findViewById(R.id.edtAddAlbum);
        edtCancion = v.findViewById(R.id.edtAddCancion);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotorBaseDatos db = new MotorBaseDatos(cont);
                ContentValues contentValues = new ContentValues();
                contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NOMBRE_ALBUM, edtAlbum.getText().toString());
                contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_ARTISTA, edtArtista.getText().toString());
                contentValues.put(ConstantesBaseDatos.TABLE_ALBUMS_NAME, edtCancion.getText().toString());
                db.SubirDB(contentValues);
            }
        });

        return v;
    }

    private void InicializarListaAlbums() {
        /*albums = new ArrayList<>();
        albums.add(new Album("Brothers In Arms - Single", "Jeff Williams", R.drawable.bia_dag));*/

        GestorAlbums gestorAlbums = new GestorAlbums(this.getActivity());
        albums = gestorAlbums.AsignarAlbum();
    }

    private void IniciarAdaptador() {
        AlbumAdaptador miAdaptador = new AlbumAdaptador(albums);
        listaAlbums.setAdapter(miAdaptador);
    }
}
