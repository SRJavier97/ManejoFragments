package unam.fi.mx.manejofragments.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import unam.fi.mx.manejofragments.Album;
import unam.fi.mx.manejofragments.AlbumAdaptador;
import unam.fi.mx.manejofragments.BaseDatos.GestorAlbums;
import unam.fi.mx.manejofragments.R;

public class Fragment2 extends Fragment {

    ArrayList<Album> albums;
    private RecyclerView listaAlbums;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2_layout,container,false);

        listaAlbums = v.findViewById(R.id.rcvListaAlbums);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaAlbums.setLayoutManager(llm);
        InicializarListaAlbums();
        IniciarAdaptador();

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
