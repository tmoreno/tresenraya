package com.tmoreno.tresenraya.cpu;

import android.os.Parcel;

/**
 * Inteligencia de CPU básica o fácil, sólo busca casillas vacías de forma aleatoria
 */
public class BasicaInteligenciaCpu extends InteligenciaCpu{
	
	/**
	 * @see InteligenciaCpu#getIdCasilla()
	 */
	@Override
	public int getIdCasilla() {
		return getCasillaAleatoria();
	}
	
	public static final Creator<BasicaInteligenciaCpu> CREATOR = new Creator<BasicaInteligenciaCpu>() {

		public BasicaInteligenciaCpu createFromParcel(Parcel source) {
			return new BasicaInteligenciaCpu();
		}
	
		public BasicaInteligenciaCpu[] newArray(int size) {
			return new BasicaInteligenciaCpu[size];
		}
	};
}
