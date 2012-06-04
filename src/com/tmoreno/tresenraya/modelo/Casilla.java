package com.tmoreno.tresenraya.modelo;

import com.tmoreno.tresenraya.R;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/**
 * Clase que modela una casilla del tablero
 */
public class Casilla {
	
	/**
	 * Estados en los que puede estar una casilla
	 */
	public enum Estado{
		VACIO, CIRCULO, CRUZ
	}
	
	/** Estado de la casilla */
	private Estado estado;
	
	/** Imagen que muestra la casilla */
	private ImageButton imageButton;
	
	public Casilla (ImageButton imageButton, OnClickListener onClickListener){
		this.estado = Estado.VACIO;
		this.imageButton = imageButton;
		this.imageButton.setOnClickListener(onClickListener);
		this.imageButton.setEnabled(true);
		this.imageButton.setImageResource(R.drawable.casilla_vacia);
	}
	
	/**
	 * Método que recupera el identificador de la imagen asociada a la casilla
	 * @return
	 */
	public int getId(){
		return imageButton.getId();
	}
	
	/**
	 * Método que recupera el estado de la casilla
	 * @return
	 */
	public Estado getEstado(){
		return estado;
	}
	
	/**
	 * Método que pone un círculo en la casilla y la deshabilita para que no
	 * se pueda pulsar otra vez
	 */
	public void setCirculo(){
		estado = Estado.CIRCULO;
		imageButton.setEnabled(false);
		imageButton.setImageResource(R.drawable.circulo);
	}
	
	/**
	 * Método que pone una cruz en la casilla y la deshabilita para que no
	 * se pueda pulsar otra vez
	 */
	public void setCruz(){
		estado = Estado.CRUZ;
		imageButton.setEnabled(false);
		imageButton.setImageResource(R.drawable.cruz);
	}

	/**
	 * Método que vuelve a habilitar la casilla para que se pueda pulsar
	 */
	public void reiniciar() {
		estado = Estado.VACIO;
		imageButton.setEnabled(true);
		imageButton.setImageResource(R.drawable.casilla_vacia);
	}
}
