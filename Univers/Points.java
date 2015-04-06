/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Terrain.java
 * \brief Gestion du point de départ et d'arrivé
 */

package Univers;

public class Points {

	private int posX;
	private int posY;
	
	
	public Points(int x, int y)
	{
		this.posX = x;
		this.posY = y;
	}
	
	//GETTERS
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	//SETTERS
	public void setPos(int x, int y){
		this.posX = x;
		this.posY = y;
	}
	public void setPosX(int x){
		this.posX = x;
	}
	public void setPosY(int y){
		this.posY = y;
	}

}
