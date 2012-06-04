package com.tmoreno.tresenraya.cpu;

import java.util.List;
import java.util.Random;

import com.tmoreno.tresenraya.modelo.Tablero;
import com.tmoreno.tresenraya.modelo.Casilla.Estado;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class InteligenciaCpu implements Parcelable {
	
	private Tablero tablero;
	private Random random = new Random();

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
	}
	
	public void setTablero(Tablero tablero){
		this.tablero = tablero;
	}
	
	/**
	 * Método que recupera la casilla que la CPU va a pulsar
	 * @return
	 */
	public abstract int getIdCasilla();
	
	/**
	 * Método que devuelve una casilla vacía de manera aleatoria
	 * @return
	 */
	public int getCasillaAleatoria(){
		List<Integer> casillasVacias = tablero.getCasillasVacias();
		
		int index = random.nextInt(casillasVacias.size());
		
		return casillasVacias.get(index);
	}
	
	/**
	 * Método que devuelve la casilla que falta para completar las tres en raya
	 * según si es para los círculos o para las cruces
	 * @return
	 */
	public int getMejorCasilla(Estado estado){
		if(tablero.isCasillaVacia(0)){
			if ((tablero.isCasillaEstado(1, estado) && tablero.isCasillaEstado(2, estado)) ||
				(tablero.isCasillaEstado(3, estado) && tablero.isCasillaEstado(6, estado)) ||
				(tablero.isCasillaEstado(4, estado) && tablero.isCasillaEstado(8, estado))) {
				return tablero.getCasilla(0).getId();
			}
		}
		
		if(tablero.isCasillaVacia(1)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(2, estado)) ||
				(tablero.isCasillaEstado(4, estado) && tablero.isCasillaEstado(7, estado))) {
				return tablero.getCasilla(1).getId();
			}
		}
		
		if(tablero.isCasillaVacia(2)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(1, estado)) ||
				(tablero.isCasillaEstado(4, estado) && tablero.isCasillaEstado(6, estado)) ||
				(tablero.isCasillaEstado(5, estado) && tablero.isCasillaEstado(8, estado))) {
				return tablero.getCasilla(2).getId();
			}
		}
		
		if(tablero.isCasillaVacia(3)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(6, estado)) ||
				(tablero.isCasillaEstado(4, estado) && tablero.isCasillaEstado(5, estado))) {
				return tablero.getCasilla(3).getId();
			}
		}
		
		if(tablero.isCasillaVacia(4)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(8, estado)) ||
				(tablero.isCasillaEstado(1, estado) && tablero.isCasillaEstado(7, estado)) ||
				(tablero.isCasillaEstado(2, estado) && tablero.isCasillaEstado(6, estado)) ||
				(tablero.isCasillaEstado(3, estado) && tablero.isCasillaEstado(5, estado))) {
				return tablero.getCasilla(4).getId();
			}
		}
		
		if(tablero.isCasillaVacia(5)){
			if ((tablero.isCasillaEstado(3, estado) && tablero.isCasillaEstado(4, estado)) ||
				(tablero.isCasillaEstado(2, estado) && tablero.isCasillaEstado(8, estado))) {
				return tablero.getCasilla(5).getId();
			}
		}
		
		if(tablero.isCasillaVacia(6)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(3, estado)) ||
				(tablero.isCasillaEstado(2, estado) && tablero.isCasillaEstado(4, estado)) ||
				(tablero.isCasillaEstado(7, estado) && tablero.isCasillaEstado(8, estado))) {
				return tablero.getCasilla(6).getId();
			}
		}
		
		if(tablero.isCasillaVacia(7)){
			if ((tablero.isCasillaEstado(1, estado) && tablero.isCasillaEstado(4, estado)) ||
				(tablero.isCasillaEstado(6, estado) && tablero.isCasillaEstado(8, estado))) {
				return tablero.getCasilla(7).getId();
			}
		}
		
		if(tablero.isCasillaVacia(8)){
			if ((tablero.isCasillaEstado(0, estado) && tablero.isCasillaEstado(4, estado)) ||
				(tablero.isCasillaEstado(2, estado) && tablero.isCasillaEstado(5, estado)) ||
				(tablero.isCasillaEstado(6, estado) && tablero.isCasillaEstado(7, estado))) {
				return tablero.getCasilla(8).getId();
			}
		}
		
		return -1;
	}
}
