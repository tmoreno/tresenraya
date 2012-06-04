package com.tmoreno.tresenraya.actividades;

import com.tmoreno.tresenraya.modelo.Casilla.Estado;

import android.view.View;
import android.view.View.OnClickListener;
import com.tmoreno.tresenraya.R;

public class DosJugadoresTableroActivity extends TableroActivity{

	@Override
	protected OnClickListener createCasillaOnClickListener() {
		return new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				boolean juegoTerminado = false;
				
				// Al hacer click en una casilla se reproduce un sonido
				mp.start();

				if(esTurnoJugador1){
					tablero.setCirculo(v.getId());
					juegoTerminado = tablero.comprobarJuegoTerminado(Estado.CIRCULO);
				}
				else{
					tablero.setCruz(v.getId());
					juegoTerminado = tablero.comprobarJuegoTerminado(Estado.CRUZ);
				}
				
				if(juegoTerminado){
					if(esTurnoJugador1){
						numVictoriasJugador1++;
						numVictoriasJugador1textView.setText(numVictoriasJugador1+"");
						alertDialog.setMessage(getString(R.string.ganaJugador1));
					}
					else{
						numVictoriasJugador2++;
						numVictoriasJugador2textView.setText(numVictoriasJugador2+"");
						alertDialog.setMessage(getString(R.string.ganaJugador2));
					}
					
					alertDialog.show();
				}
				else if(tablero.isCompleto()){
					alertDialog.setMessage(getString(R.string.empate));
					alertDialog.show();
				}
				else{
					cambiarTurno();
				}
			}
	    };  
	}
}
