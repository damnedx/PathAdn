/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 */

import Univers.*;
import Adn.*;
import Graphics.Fenetre;

public class main 
{	
	public static void main(String[] args)
	{	
		//Creation du terrain
		Terrain t = new Terrain(Constantes.TAILLE_TERRAIN_X,Constantes.TAILLE_TERRAIN_Y);
		// On creer nos obstacles
		t.genObstacle(50); // génération de 50 obstacles
		// On créer le point de départ
		t.genDepart();
		// On créer le point d'arrivé
		t.genArrive();
		
		//Affichage
		Fenetre window = new Fenetre(t);

	}
}
