package com.example.ex2evikergorostiaga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.ex2evikergorostiaga.Fragments.Mapa1Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //pasar al fragment del mapa directamente

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, Mapa1Fragment.class, null) //le ponemos al fragment container el fragment que queremos que se vea
                .setReorderingAllowed(true)
                .addToBackStack("mapa1")
                .commit();


    }
}