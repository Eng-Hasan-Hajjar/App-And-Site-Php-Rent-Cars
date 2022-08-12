package com.example.sql.carRental;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CarageDetailAct extends Activity {
int id;
    String id1;
    String na,reg;
    double lat,longt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_carage_detail);
         Bundle b=   getIntent().getExtras();
        ImageView im=(ImageView)  findViewById(R.id.imageView);
         na= b.getString("name");
         reg= b.getString("region");
       id1= b.getString("id");
        Toast.makeText(this,id1+"",Toast.LENGTH_LONG).show();
        ((TextView) findViewById(R.id.textView2)).setText("ID:     "+b.getString("id"));
        ((TextView) findViewById(R.id.textView3)).setText("NAME:   "+b.getString("name"));
        ((TextView) findViewById(R.id.textView4)).setText("REGION: "+b.getString("region"));

        int resID = getResources().getIdentifier("carage"+id,
                "drawable", getPackageName());
        im.setImageResource(resID);
        setupLocationListening();

    }

    public void   onclick(View v)
    {
        Intent intent =new Intent(this,CarAct.class);
        intent.putExtra("id",id1);

        startActivity(intent);
    }
    public void   onclick1(View v)
    {
        Intent intent =new Intent(this,MapsActivity.class);

        intent.putExtra("lat",lat);
        intent.putExtra("lon",longt);
        startActivity(intent);
    }

    void setupLocationListening() {
        Toast.makeText(this,"Get Best Location",Toast.LENGTH_LONG).show();;
        LocationManager locationManager;
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
               // TextView longitude = (TextView) findViewById(R.id.textView_lon);
               /// TextView latitude = (TextView) findViewById(R.id.textView_lat);

              //  longitude.setText("Longitude:" + location.getLongitude());
              //  latitude.setText("Latitude:" + location.getLatitude());
                lat=location.getLatitude();
                longt=location.getLongitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        String mprovider;

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        mprovider = locationManager.getBestProvider(criteria, false);

        Location location = locationManager.getLastKnownLocation(mprovider);
        locationManager.requestLocationUpdates(mprovider, 15000, 1, locationListener);

        if (location != null)
            locationListener.onLocationChanged(location);
        else
            Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();

    }


}
