package com.tmoreno.tresenraya.actividades;

import com.tmoreno.tresenraya.cpu.InteligenciaCpu;
import com.tmoreno.tresenraya.modelo.Casilla.Estado;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tmoreno.tresenraya.R;

public class UnJugadorTableroActivity extends TableroActivity{
	
	private InteligenciaCpu inteligenciaCpu;
	
	@Override
	protected void clickAlertDialogButton(DialogInterface dialog){
		tablero.reiniciar();
		dialog.cancel();

		if(esTurnoJugador1){
			new CpuTask().execute(new Void[0]);
		}
		else{
			cambiarTurno();
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Bundle extra = getIntent().getExtras();
		inteligenciaCpu = extra.getParcelable("INTELIGENCIA_CPU");
		inteligenciaCpu.setTablero(tablero);
	} 

	@Override
	protected OnClickListener createCasillaOnClickListener() {
		return new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// Al hacer click en una casilla se reproduce un sonido
				mp.start();
				
				tablero.setCirculo(v.getId());

				if(tablero.comprobarJuegoTerminado(Estado.CIRCULO)){
					numVictoriasJugador1++;
					numVictoriasJugador1textView.setText(numVictoriasJugador1+"");
					alertDialog.setMessage(getString(R.string.ganaJugador1));
					alertDialog.show();
				}
				else{
					if(tablero.isCompleto()){
						alertDialog.setMessage(getString(R.string.empate));
						alertDialog.show();
					}
					else{
						new CpuTask().execute(new Void[0]);
					}
				}
			}
	    };  
	}
	
	/**
	 * Clase que ejecuta los movimientos de la CPU en segundo plano
	 */
	private class CpuTask extends AsyncTask<Void, Void, Void> {
		int idCasilla;
		
		@Override
		protected void onPreExecute() {
			cambiarTurno();
	    }
		
		@Override
		protected Void doInBackground(Void... params) {
			// Al hacer click en una casilla se reproduce un sonido
			mp.start();
			
			idCasilla = inteligenciaCpu.getIdCasilla();
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void nulo) {
			tablero.setCruz(idCasilla);
			
			if(tablero.comprobarJuegoTerminado(Estado.CRUZ)){
				numVictoriasJugador2++;
				numVictoriasJugador2textView.setText(numVictoriasJugador2+"");
				alertDialog.setMessage(getString(R.string.ganaJugador2));
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
	}
}
