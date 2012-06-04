package com.tmoreno.tresenraya.actividades;

import com.tmoreno.tresenraya.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private static final String URL_GPL = "http://www.gnu.org/licenses/gpl.txt";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button unJugadorButton = (Button) findViewById(R.id.unJugadorButton);
        unJugadorButton.setOnClickListener(new OnClickListener() {
	        @Override
        	public void onClick(View view) {
		        Intent intent = new Intent(getApplicationContext(), NivelDificultadActivity.class);
		        startActivity(intent);
	        }
        });
        
        Button dosJugadoresButton = (Button) findViewById(R.id.dosJugadoresButton);
        dosJugadoresButton.setOnClickListener(new OnClickListener() {
	        @Override
        	public void onClick(View view) {
		        Intent intent = new Intent(getApplicationContext(), DosJugadoresTableroActivity.class);
		        startActivity(intent);
	        }
        });
    }
    
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.addSubMenu(Menu.NONE, 1, Menu.NONE, getString(R.string.licencia)).setIcon(android.R.drawable.ic_menu_info_details);
        
        return true;
	}
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent i = new Intent(Intent.ACTION_VIEW);
    	i.setData(Uri.parse(URL_GPL));
    	startActivity(i);
    	
    	return true;
    }
}