package com.example.appmapiagi26;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appmapiagi26.databinding.ActivityMapsBinding;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback  {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    private final LatLng TANGER     = new LatLng(35.7595, -5.8340);
    private final LatLng RABAT      = new LatLng(34.0209, -6.8416);
    private final LatLng CASABLANCA = new LatLng(33.5731, -7.5898);
    private final LatLng AGADIR     = new LatLng(30.4278, -9.5981);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        ajouterMarqueurs();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(RABAT, 6));
    }

    private void ajouterMarqueurs() {

        mMap.addMarker(new MarkerOptions()
                .position(TANGER)
                .title("Tanger")
                .snippet("Porte de l'Afrique")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_tanger)));

        // Rabat
        mMap.addMarker(new MarkerOptions()
                .position(RABAT)
                .title("Rabat")
                .snippet("Capitale du Maroc - Tour Hassan")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_rabat)));

        // Casablanca
        mMap.addMarker(new MarkerOptions()
                .position(CASABLANCA)
                .title("Casablanca")
                .snippet("Mosquée Hassan II")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_casablanca)));
        // Agadir
        mMap.addMarker(new MarkerOptions()
                .position(AGADIR)
                .title("Agadir")
                .snippet("Perle du Souss")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_agadir)));
    }

    //  Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_default) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        } else if (id == R.id.menu_satellite) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
