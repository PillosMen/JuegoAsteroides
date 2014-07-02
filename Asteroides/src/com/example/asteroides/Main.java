package com.example.asteroides;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class Main extends Activity {

	Button b5, b1, b2, b3, b4;
	
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b5 = (Button) findViewById(R.id.button5);
        b5.setTextColor(Color.WHITE);
        b4 = (Button) findViewById(R.id.button4);
        b4.setTextColor(Color.WHITE);
        b3 = (Button) findViewById(R.id.button3);
        b3.setTextColor(Color.WHITE);
        b2 = (Button) findViewById(R.id.button2);
        b2.setTextColor(Color.WHITE);
        b1 = (Button) findViewById(R.id.button1);
        b1.setTextColor(Color.WHITE);
        b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
        
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mostrarPreferencias();
			}
		});
    }

    public void lanzarPuntuaciones(View view){
    	Intent i = new Intent(this, Puntuaciones.class);
    	startActivity(i);
    }
    
    public void lanzarAcercaDe(View view){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }
    
    public void lanzarPreferencias(View view){
    	Intent i = new Intent(this, Preferencias.class);
    	startActivity(i);
    }
    
    public void mostrarPreferencias(){
    	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
    	String s = "musica: " + pref.getBoolean("musica", true) + ", graficos: " + pref.getString("graficos", "?");
    	Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()){
        case R.id.acercaDe:
        	lanzarAcercaDe(null);
        	break;
        	
        case R.id.config:
        	lanzarPreferencias(null);
        	break;
        }
        
        return true;
    }
    
}
