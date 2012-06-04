package com.tmoreno.tresenraya.actividades;

import com.tmoreno.tresenraya.modelo.Casilla;
import com.tmoreno.tresenraya.modelo.Tablero;

import com.tmoreno.tresenraya.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Clase que modela la actividad del tablero tanto para un jugador como para dos
 */
public abstract class TableroActivity extends Activity {

	protected Tablero tablero;
	protected boolean esTurnoJugador1;
	
	protected int numVictoriasJugador1;
	protected int numVictoriasJugador2;

	protected AlertDialog alertDialog;
	protected MediaPlayer mp;
	protected TextView numVictoriasJugador1textView;
	protected TextView numVictoriasJugador2textView;
	
	private TextView victoriasJugador1textView;
	private TextView victoriasJugador2textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablero);

		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				clickAlertDialogButton(dialog);
			}
		});
		
		esTurnoJugador1 = true;

		numVictoriasJugador1 = 0;
		numVictoriasJugador1textView = (TextView) findViewById(R.id.numVictoriasJugador1textView);
		numVictoriasJugador1textView.setText(numVictoriasJugador1 + "");
		victoriasJugador1textView = (TextView) findViewById(R.id.victoriasJugador1textView);

		numVictoriasJugador2 = 0;
		numVictoriasJugador2textView = (TextView) findViewById(R.id.numVictoriasJugador2textView);
		numVictoriasJugador2textView.setText(numVictoriasJugador2 + "");
		victoriasJugador2textView = (TextView) findViewById(R.id.victoriasJugador2textView);

		OnClickListener casillaOnClickListener = createCasillaOnClickListener();

		tablero = new Tablero();
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla1ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla2ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla3ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla4ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla5ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla6ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla7ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla8ImageButton), casillaOnClickListener));
		tablero.addCasilla(new Casilla((ImageButton) findViewById(R.id.casilla9ImageButton), casillaOnClickListener));
	}
	
	@Override
	public void onResume() {
		if(mp == null){
			mp = MediaPlayer.create(getBaseContext(), R.raw.click_casilla);
		}
		
		super.onResume();
	}
	
	@Override
	public void onStop() {
		mp.release();
		mp = null;
		
		super.onStop();
	}
	
	/**
	 * Método que cambia el turno de jugador
	 */
	protected void cambiarTurno(){
		esTurnoJugador1 = !esTurnoJugador1;
		
		if(esTurnoJugador1){
			victoriasJugador1textView.setTextAppearance(this, R.style.textoNegrita);
			numVictoriasJugador1textView.setTextAppearance(this, R.style.textoNegrita);
			
			victoriasJugador2textView.setTextAppearance(this, R.style.textoNormal);
			numVictoriasJugador2textView.setTextAppearance(this, R.style.textoNormal);
		}
		else{
			victoriasJugador1textView.setTextAppearance(this, R.style.textoNormal);
			numVictoriasJugador1textView.setTextAppearance(this, R.style.textoNormal);
			
			victoriasJugador2textView.setTextAppearance(this, R.style.textoNegrita);
			numVictoriasJugador2textView.setTextAppearance(this, R.style.textoNegrita);
		}
	}
	
	protected void clickAlertDialogButton(DialogInterface dialog){
		tablero.reiniciar();
		dialog.cancel();
		cambiarTurno();
	}

	/**
	 * Método que crea la clase que modela el listener cuando se pulsa una casilla
	 * @return
	 */
	protected abstract OnClickListener createCasillaOnClickListener();
}
