package com.example.ex2evikergorostiaga.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ex2evikergorostiaga.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mapas_1_infoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mapas_1_infoFragment extends Fragment {


    String texto_titulo_desde_el_main ="Si ves esto es que no pasa el titulo desde el main"; //texto conseguido del fragment mapa1

    TextView titulo_fragment;
    TextView descripcion_fragment;


    Button boton_fragment;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Mapas_1_infoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mapas_1_infoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Mapas_1_infoFragment newInstance(String param1, String param2) {
        Mapas_1_infoFragment fragment = new Mapas_1_infoFragment();
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
        View view = inflater.inflate(R.layout.fragment_mapas_1_info, container, false);


        titulo_fragment = view.findViewById(R.id.txtvw_titulo);
        descripcion_fragment = view.findViewById(R.id.txtvw_descripcion);
        boton_fragment = view.findViewById(R.id.btn_atras);


        //conseguir el texto del Mapa1
        Bundle bundle_titulo = getArguments();
        if (bundle_titulo != null) {
            // Recuperar el String
            texto_titulo_desde_el_main = bundle_titulo.getString("titulo_fragment");
        }


        titulo_fragment.setText(texto_titulo_desde_el_main);



        //Boton atras
        boton_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pasar al fragment del mapa1

                //instancia del fragmento de destino
                Mapa1Fragment fragment = new Mapa1Fragment();
                FragmentManager fragmentManager = getParentFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();

                // Reemplazar el mapainfo con mapa
                transaction.replace(R.id.fragmentContainerView, fragment).addToBackStack("mapainfo");
                // Confirmar la transacción
                transaction.commit();
            }
        });

        return view;
    }
}