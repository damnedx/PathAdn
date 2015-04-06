/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Terrain.java
 * \brief Generation du terrain, obstacles
 */

package Univers;

import java.util.*;
import Univers.Points;

public class Terrain {
		
	private int tailleX;
	private int tailleY;
	
	// L'univers est representé sous un tableau 2D
	private int[][] MapPos;
	
	// on stocke les coordonnées d'arrivé et de départ
	public static Points[] posInfos;
	
	//Constructeur de terrain vide
	public Terrain(int x, int y){
		this.tailleX = x / Constantes.TAILLE_SPRITE;
		this.tailleY = y / Constantes.TAILLE_SPRITE;
		
		posInfos = new Points[2]; // on stockera le point de départ et d'arrivé
		
		// On initialise notre terrain avec uniquement du sol
		MapPos = new int[this.tailleX][this.tailleY];
		for(int i = 0; i < this.tailleX ; i++){
			for(int j = 0; j < this.tailleY ; j++){
				MapPos[i][j] = Constantes.Sol;
			}
		}
	}
	//Generation d'obstacle
	public void genObstacle(int nbr){
		// on génère X obstacle aléatoirement
		int posX, posY;
		Random rd = new Random();
		for(int i = 0; i < nbr ; i++){
			posX = rd.nextInt(this.tailleX);
			posY = rd.nextInt(this.tailleY);
			MapPos[posX][posY] = Constantes.Obstacle;
		}
	}	
	//Generation du point de depart
	public void genDepart()
	{
		int posX, posY;
		Random rd = new Random();
		posX = rd.nextInt(this.tailleX);
		posY = rd.nextInt(this.tailleY);
		
		while(MapPos[posX][posY] == Constantes.Obstacle)
		{
			// Si jamais le point de départ est généré sur un obstacle...
			posX = rd.nextInt(this.tailleX);
			posY = rd.nextInt(this.tailleY);
		}
		MapPos[posX][posY] = Constantes.Adn;
		// on stocke les coordonnées du point de départ
		posInfos[0] = new Points(posX, posY);
	}
	//Generation du point d'arrivé
	public void genArrive()
	{
		int posX, posY;
		Random rd = new Random();
		posX = rd.nextInt(this.tailleX);
		posY = rd.nextInt(this.tailleY);
		
		while(MapPos[posX][posY] == Constantes.Obstacle || MapPos[posX][posY] == Constantes.Adn)
		{
			// Si jamais le point de départ est généré sur un obstacle ou sur le point de départ
			posX = rd.nextInt(this.tailleX);
			posY = rd.nextInt(this.tailleY);
		}
		MapPos[posX][posY] = Constantes.Arrive;
		// on stocke les coordonnées du point de départ
		posInfos[1] = new Points(posX, posY);
	}
	//SETTERS
	public void setPos(int i, int j, int val){
		this.MapPos[i][j] = val;
	}
	
	//GETTERS
	public int getTailleX(){
		return this.tailleX;
	}
	
	public int getTailleY(){
		return this.tailleY;
	}
	public int getPos(int i, int j){
		return this.MapPos[i][j];
	}

}
