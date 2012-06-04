package com.tmoreno.tresenraya.modelo;

import java.util.ArrayList;
import java.util.List;

import com.tmoreno.tresenraya.modelo.Casilla.Estado;


/**
 * Método que modela un tablero
 */
public class Tablero {
	
	/** Casillas que tiene el tablero */
	private List<Casilla> casillas;
	
	public Tablero(){
		casillas = new ArrayList<Casilla>();
	}
	
	/**
	 * Método que añade una casilla al tablero
	 * @param casilla
	 */
	public void addCasilla(Casilla casilla){
		casillas.add(casilla);
	}
	
	/**
	 * Método que reinicia el tablero
	 */
	public void reiniciar(){
		for(Casilla c : casillas){
			c.reiniciar();
		}
	}
	
	/**
	 * Método que pone un círculo en la casilla que coincide el identificador 
	 * @param idCasilla
	 */
	public void setCirculo(int idCasilla){
		for(Casilla c : casillas){
			if(c.getId() == idCasilla){
				c.setCirculo();
			}
		}
	}
	
	/**
	 * Método que pone una cruz en la casilla que coincide el identificador 
	 * @param idCasilla
	 */
	public void setCruz(int idCasilla){
		for(Casilla c : casillas){
			if(c.getId() == idCasilla){
				c.setCruz();
			}
		}
	}
	
	/**
	 * Método que devuelve la casilla que está en la posición i
	 * @param i
	 * @return
	 */
	public Casilla getCasilla(int i){
		return casillas.get(i);
	}
	
	/**
	 * Método que pregunta si hay un círculo, o una cruz, en la casilla i
	 * @param i
	 * @return
	 */
	public boolean isCasillaEstado(int i, Estado estado){
		return casillas.get(i).getEstado() == estado;
	}
	
	/**
	 * Método que pregunta si está vacía la casilla i
	 * @param i
	 * @return
	 */
	public boolean isCasillaVacia(int i){
		return casillas.get(i).getEstado() == Estado.VACIO;
	}
	
	/**
	 * Método que comprueba si se ha terminado el juego teniendo como referencia
	 * un estado
	 * @param estado
	 * @return
	 */
	public boolean comprobarJuegoTerminado(Estado estado) {		
		if(isCasillaEstado(4, estado)){
			if(isCasillaEstado(0, estado) && isCasillaEstado(8, estado)){
				return true;
			}
			
			if(isCasillaEstado(2, estado) && isCasillaEstado(6, estado)){
				return true;
			}
			
			if(isCasillaEstado(1, estado) && isCasillaEstado(7, estado)){
				return true;
			}
			
			if(isCasillaEstado(3, estado) && isCasillaEstado(5, estado)){
				return true;
			}
		}
		
		if(isCasillaEstado(0, estado)){
			if(isCasillaEstado(1, estado) && isCasillaEstado(2, estado)){
				return true;
			}
			
			if(isCasillaEstado(3, estado) && isCasillaEstado(6, estado)){
				return true;
			}
		}
		
		if(isCasillaEstado(8, estado)){
			if(isCasillaEstado(6, estado) && isCasillaEstado(7, estado)){
				return true;
			}
			
			if(isCasillaEstado(2, estado) && isCasillaEstado(5, estado)){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * Método que pregunta si quedan casillas vacías en el tablero
	 * @return
	 */
	public boolean isCompleto() {
		for(Casilla c : casillas){
			if(c.getEstado() == Estado.VACIO){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Método que devuelve una lista con las casillas vacias
	 * @return
	 */
	public List<Integer> getCasillasVacias(){
		List<Integer> casillasVacias = new ArrayList<Integer>();
		
		for(Casilla c : casillas){
			if(c.getEstado() == Estado.VACIO){
				casillasVacias.add(c.getId());
			}
		}
		
		return casillasVacias;
	}
}
