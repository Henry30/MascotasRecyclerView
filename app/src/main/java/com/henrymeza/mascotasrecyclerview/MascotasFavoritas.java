package com.henrymeza.mascotasrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<Mascota> lstObjMascotaTop5;
    ArrayList<Mascota> lstObjMascotaTemp;
    ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;
    private Toolbar mnuToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        mnuToolBar=(Toolbar)findViewById(R.id.miactionbar);
        mnuToolBar.setTitle("");

        mnuToolBar.setLogo(R.drawable.cat_footprint_48);
        setSupportActionBar(mnuToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(false);

//Recycler View
        rvListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        MenuItem mnuRank=menu.findItem(R.id.mnuRanking);
        mnuRank.setVisible(false);
        return true;
    }

    public void inicializarAdaptador(){

        MascotaAdaptador adaptador= new MascotaAdaptador(lstObjMascota,this);
        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();
        Bundle b = getIntent().getExtras();
        Mascota obMascota;
        int vlongitud=b.getInt(getResources().getString(R.string.LONGITUD_LISTA));
        for(int x=0;x<vlongitud;x++) {
            obMascota = b.getParcelable(getResources().getString(R.string.OBJETO_MASCOTA) +String.valueOf(x));
            lstObjMascota.add(obMascota);
        }

    }
}
