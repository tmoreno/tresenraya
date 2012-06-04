package com.tmoreno.tresenraya.cpu;

import com.tmoreno.tresenraya.modelo.Casilla.Estado;

import android.os.Parcel;

/**
 * Inteligencia de CPU avanzada o dificil que intenta que ganen las cruces, 
 * sino intenta que no gananen los círculos
 */
public class AvanzadaInteligenciaCpu extends InteligenciaCpu {

	/**
	 * @see InteligenciaCpu#getIdCasilla()
	 */
	@Override
	public int getIdCasilla() {

		int idCasilla = getMejorCasilla(Estado.CRUZ);
		
		if(idCasilla == -1){
			idCasilla = getMejorCasilla(Estado.CIRCULO);
			
			if(idCasilla == -1){
				idCasilla = getCasillaAleatoria();
			}
		}

		return idCasilla;
	}

	public static final Creator<AvanzadaInteligenciaCpu> CREATOR = new Creator<AvanzadaInteligenciaCpu>() {

		public AvanzadaInteligenciaCpu createFromParcel(Parcel source) {
			return new AvanzadaInteligenciaCpu();
		}

		public AvanzadaInteligenciaCpu[] newArray(int size) {
			return new AvanzadaInteligenciaCpu[size];
		}
	};
}
