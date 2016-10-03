# MascotasRecyclerView
Catálogo de Mascotas

Actionbar xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.Toolbar
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_height="?attr/actionBarSize"
    android:layout_width="match_parent"
    android:background="@color/colorPrimary"
    android:elevation="@dimen/elevacion_actionbar"
    app:theme="@style/ThemeOverlay.AppCompat.ActionBar"
    android:popupTheme="@style/ThemeOverlay.AppCompat.Light"
    >
    <TextView
        android:id="@+id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/app_name"
        android:gravity="center"
        android:textAppearance="?android:attr/textAppearanceMedium"
         />
</android.support.v7.widget.Toolbar>

Cardview_mascotas xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/cv_Contacto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="@dimen/marginTop_cardview"
    android:layout_marginLeft="@dimen/marginLeft_cardview"
    android:layout_marginRight="@dimen/marginRight_cardview"
    android:layout_marginBottom="@dimen/activity_vertical_margin"
    app:cardCornerRadius="@dimen/corner_radius_cardview">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >
        <ImageView
            android:id="@+id/imgFoto"
            android:layout_width="match_parent"
            android:layout_height="@dimen/heightFoto_cardview"
            android:src="@drawable/imgperro1"
            android:scaleType="centerCrop"
            android:layout_gravity="center_horizontal"
            />
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            >
            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                >

            <ImageView
                android:id="@+id/btnRank_MarcarCV"
                android:layout_width="@dimen/widthIconoRank_cardview"
                android:layout_height="@dimen/heightIconoRank_cardview"
                android:src="@drawable/dogbonerank1"
                />
            <TextView
                android:id="@+id/tvNombreCV"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/nombre"
                android:textSize="@dimen/nombre_cardview"
                android:textStyle="bold"
                />
            </LinearLayout>
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:layout_gravity="right"
                android:gravity="right"
                >
            <TextView
                android:id="@+id/tvRankCV"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/rank"
                android:textSize="@dimen/nombre_cardview"
                android:textStyle="bold"
                />
             <ImageView
                android:id="@+id/imgRank_LecturaCV"
                android:layout_width="@dimen/widthIconoRankLectura_cardview"
                android:layout_height="@dimen/heightIconoRankLectura_cardview"
                android:src="@drawable/dogbonerank2"
                android:layout_gravity="right"

                />
            </LinearLayout>
        </LinearLayout>
    </LinearLayout>
</android.support.v7.widget.CardView>

activity_main xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context="com.henrymeza.mascotasrecyclerview.MainActivity">
    <include
        android:id="@+id/miactionbar"
        layout="@layout/actionbar"
        >

    </include>

    <android.support.v7.widget.RecyclerView
        android:id="@+id/rvMascotas"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerHorizontal="true"
        android:layout_below="@id/miactionbar"
        >
    </android.support.v7.widget.RecyclerView>
    <android.support.design.widget.FloatingActionButton
        android:id="@+id/fabImagenCamara"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/marginTop_Camara"
        android:layout_marginLeft="@dimen/marginLeft_Camara"
        android:src="@drawable/camera_50"
        />
</RelativeLayout>

activity_mascotas_favoritas xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    tools:context="com.henrymeza.mascotasrecyclerview.MascotasFavoritas">
    <include
        android:id="@+id/miactionbar"
        layout="@layout/actionbar">
    </include>
    <android.support.v7.widget.RecyclerView
        android:id="@+id/rvMascotas"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_centerHorizontal="true"
        android:layout_below="@id/miactionbar"
        >

    </android.support.v7.widget.RecyclerView>
</RelativeLayout>

Clase Mascota
public class Mascota implements Parcelable {
    private String nombre;
    private int foto;
    private int rank;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Mascota(String nombre, int foto, int rank){
        this.nombre=nombre;
        this.foto=foto;
        this.rank=rank;
    }
   
    public Mascota(Parcel in){
        this.nombre=in.readString();
        this.foto=in.readInt();
        this.rank=in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(foto);
        dest.writeInt(rank);
    }
    public static final Parcelable.Creator<Mascota> CREATOR = new Parcelable.Creator<Mascota>() {
        public Mascota createFromParcel(Parcel source) {
            return new Mascota(source);
        }

        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };
}


Clase MainActivity

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;
    private Toolbar mnuToolBar;

    //private ClipData.Item mnuEstrella;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnuToolBar=(Toolbar)findViewById(R.id.miactionbar);
        mnuToolBar.setTitle("");
        mnuToolBar.setLogo(R.drawable.cat_footprint_48);
        setSupportActionBar(mnuToolBar);
        //
        rvListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.mnuAbout:
                Intent i= new Intent(this,MascotasFavoritas.class);
                startActivity(i);
                break;
            case R.id.mnuRanking:

                Collections.sort(lstObjMascota, new Comparator<Mascota>() {
                    @Override
                    public int compare(Mascota m1, Mascota m2) {
                        return new Integer(m2.getRank()).compareTo(new Integer(m1.getRank()));
                    }
                });

                Intent i2= new Intent(this, MascotasFavoritas.class);

                for(int x=0;x<5;x=x+1) {
                    i2.putExtra(getResources().getString(R.string.OBJETO_MASCOTA) + String.valueOf(x), lstObjMascota.get(x));
                }

                i2.putExtra(getResources().getString(R.string.LONGITUD_LISTA), 5);

                startActivity(i2);

                break;
        }
        return true;

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(lstObjMascota,this);

        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();
        Bundle b = getIntent().getExtras();
        if(b!=null) {
            Mascota obMascota;
            int vlongitud=b.getInt(getResources().getString(R.string.LONGITUD_LISTA));
            for(int x=0;x<vlongitud;x++) {
                obMascota = b.getParcelable(getResources().getString(R.string.OBJETO_MASCOTA) +String.valueOf(x));
                lstObjMascota.add(obMascota);
            }
        }
        else {
            lstObjMascota.add(new Mascota("Catty", R.drawable.imgperro1, 1));
            lstObjMascota.add(new Mascota("Ronny", R.drawable.imgperro2, 2));
            lstObjMascota.add(new Mascota("Dumy", R.drawable.imgperro3, 3));
            lstObjMascota.add(new Mascota("Donko", R.drawable.imgperro4, 4));
            lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 5));
            lstObjMascota.add(new Mascota("Bobby", R.drawable.imgperro6, 6));
            lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 7));
        }
    }
}

Clase MascotaAdaptador
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> lstObjMascota;
    int nuevoRank;
    //ArrayList<Mascota> lstObjMascota;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> lstObjMascota,Activity activity) {
        this.lstObjMascota=lstObjMascota;
        this.activity=activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewholder, final int position) {
        final Mascota objMascota=lstObjMascota.get(position);
        mascotaViewholder.tvNombreCV.setText(objMascota.getNombre());
        mascotaViewholder.tvRankCV.setText(String.valueOf(objMascota.getRank()));
        mascotaViewholder.imgFoto.setImageResource(objMascota.getFoto());

        mascotaViewholder.btnRank_MarcarCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objMascota.setRank(objMascota.getRank()+1);
                lstObjMascota.set(position,objMascota);

                mascotaViewholder.tvRankCV.setText(String.valueOf(objMascota.getRank()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return lstObjMascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private ImageView btnRank_MarcarCV;
        private TextView tvNombreCV;
        private TextView tvRankCV;
        private ImageView imgRank_LecturaCV;
        public MascotaViewHolder(View itemView){
            super(itemView);
            imgFoto=(ImageView)itemView.findViewById(R.id.imgFoto);
            btnRank_MarcarCV=(ImageView)itemView.findViewById(R.id.btnRank_MarcarCV);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            tvRankCV=(TextView)itemView.findViewById(R.id.tvRankCV);
            imgRank_LecturaCV=(ImageView)itemView.findViewById(R.id.imgRank_LecturaCV);
        }

    }
}

Clase MascotasFavoritas
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



