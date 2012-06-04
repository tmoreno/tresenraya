package com.tmoreno.tresenraya.cpu;

import com.tmoreno.tresenraya.modelo.Casilla.Estado;

import android.os.Parcel;

/**
 * Inteligencia de CPU media que intenta que los círculos no hagan tres en raya
 */
public class MediaInteligenciaCpu extends InteligenciaCpu {
	
	/**
	 * @see InteligenciaCpu#getIdCasilla()
	 */
	@Override
	public int getIdCasilla() {
		
		int idCasilla = getMejorCasilla(Estado.CIRCULO);
		
		if(idCasilla == -1){
			idCasilla = getCasillaAleatoria();
		}

		return idCasilla;
	}
	
	public static final Creator<MediaInteligenciaCpu> CREATOR = new Creator<MediaInteligenciaCpu>() {

		public MediaInteligenciaCpu createFromParcel(Parcel source) {
			return new MediaInteligenciaCpu();
		}
	
		public MediaInteligenciaCpu[] newArray(int size) {
			return new MediaInteligenciaCpu[size];
		}
	};
}
