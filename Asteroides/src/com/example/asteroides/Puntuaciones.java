package com.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Puntuaciones extends ListActivity{
     
	TextView seleccion;
	String[] items={"123000 Pepito Dominguez", "111000 Pedro Martinez", "511000 Dani Ferrito"};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1));
        seleccion = (TextView) findViewById(R.id.seleccion);
    }
	
	  @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
		   getMenuInflater().inflate(R.menu.main, menu);
	       return true;
	    }
	  
	  public void onListItemClick(ListView parent, View v, int position, long id){
		  seleccion.setText(items[position]);
	  }
}
