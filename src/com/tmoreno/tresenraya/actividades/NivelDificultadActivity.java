package com.tmoreno.tresenraya.actividades;

import com.tmoreno.tresenraya.cpu.AvanzadaInteligenciaCpu;
import com.tmoreno.tresenraya.cpu.BasicaInteligenciaCpu;
import com.tmoreno.tresenraya.cpu.InteligenciaCpu;
import com.tmoreno.tresenraya.cpu.MediaInteligenciaCpu;

import com.tmoreno.tresenraya.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NivelDificultadActivity extends Activity{

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.niveldificultad);

        Button dificilButton = (Button) findViewById(R.id.dificilButton);
        dificilButton.setOnClickListener(new OnClickListener() {
	        @Override
        	public void onClick(View view) {
	        	iniciarActividad(new AvanzadaInteligenciaCpu());
	        }
        });
        
        Button medioButton = (Button) findViewById(R.id.medioButton);
        medioButton.setOnClickListener(new OnClickListener() {
	        @Override
        	public void onClick(View view) {
	        	iniciarActividad(new MediaInteligenciaCpu());
	        }
        });
        
        Button facilButton = (Button) findViewById(R.id.facilButton);
        facilButton.setOnClickListener(new OnClickListener() {
	        @Override
        	public void onClick(View view) {
	        	iniciarActividad(new BasicaInteligenciaCpu());
	        }
        });
    }
	
	/**
	 * Método que inicia la actividad de un juegador según la inteligencia que la CPU
	 * @param inteligenciaCpu
	 */
	private void iniciarActividad(InteligenciaCpu inteligenciaCpu){
		Intent intent = new Intent(getApplicationContext(), UnJugadorTableroActivity.class);
        intent.putExtra("INTELIGENCIA_CPU", inteligenciaCpu);
        startActivity(intent);
	}
}
