package com.example.ex2evikergorostiaga.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ex2evikergorostiaga.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mapa1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mapa1Fragment extends Fragment {

    //OBLIGATORIO el permiso de internet en el manifest para que el mapa se cargue
    MapView mapa;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mapa1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mapa1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Mapa1Fragment newInstance(String param1, String param2) {
        Mapa1Fragment fragment = new Mapa1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mapa1, container, false);


        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        mapa = view.findViewById(R.id.Mapa1GPS);



        //mapa jarri
        mapa.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK);

        //Que parte del mundo cargara el mapa
        org.osmdroid.views.MapController controlMapa = (org.osmdroid.views.MapController) mapa.getController(); //añadimos los controles
        controlMapa.setZoom(17.5); //el zoom inicial al mapa
        GeoPoint startPoint = new GeoPoint(43.24777, -2.92020); //latitud y longitud donde se centra el principio de mapa (https://www.openstreetmap.org/search?whereami=1&query=43.24777%2C-2.92020#map=17/43.24777/-2.92020)
        controlMapa.setCenter(startPoint);

        //Zooma jarri mapan
        mapa.setBuiltInZoomControls(true);
        mapa.setMultiTouchControls(true);


        //marker1
        Marker startMarker1 = new Marker(mapa);
        GeoPoint marker1 = new GeoPoint(43.24777, -2.92020);
        startMarker1.setPosition(marker1);
        startMarker1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);


        //marker1 onclick
        startMarker1.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker, MapView mapView) {

                // Crear un Bundle y agregar el String que quieres pasar al segundo fragment
                Bundle bundle_titulo = new Bundle();
                String titulo_fragment = "Bilbao La Peña";
                bundle_titulo.putString("titulo_fragment", titulo_fragment);



                //instancia del fragmento de destino
                Mapas_1_infoFragment fragment = new Mapas_1_infoFragment();
                fragment.setArguments(bundle_titulo);
                FragmentManager fragmentManager = getParentFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Reemplazar el mapa con mapainfo
                transaction.replace(R.id.fragmentContainerView, fragment).addToBackStack("mapa1");
                // Confirmar la transacción
                transaction.commit();

                return false;
            }
        });


        //add marker to map
        mapa.getOverlays().add(startMarker1);


        return view;
    }
}