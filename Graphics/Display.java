/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Display.java
 * \brief Gestion de l'affichage
 */

package Graphics;

import Univers.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;


public class Display extends JPanel{
	
	private Terrain univers; // l'univers
	private Image img;
	
	public void paintComponent(Graphics g){
		try{
			// A changer car a chaque passage il lit/ferme le fichier (tte les 20ms)
			Image img_sol = ImageIO.read(new File(Constantes.spriteSol));
			Image img_obs = ImageIO.read(new File(Constantes.spriteObstacle));
			Image img_adn = ImageIO.read(new File(Constantes.spriteAdn));
			Image img_arrive = ImageIO.read(new File(Constantes.spriteArrive));
			
			for(int i = 0 ; i < univers.getTailleX(); i++){
				for(int j = 0; j < univers.getTailleY(); j++){
					switch(univers.getPos(i,j)){
						case Constantes.Sol:
							img = img_sol;
							break;
						case Constantes.Obstacle:
							img = img_obs;
							break;
						case Constantes.Adn:
							img = img_adn;
							break;
						case Constantes.Arrive:
							img = img_arrive;
							break;	
					}
					g.drawImage(img, i * Constantes.TAILLE_SPRITE, j * Constantes.TAILLE_SPRITE, this);
				}
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	//SETTERS
	public void setUnivers(Terrain t){
		this.univers = t;
	}
	
	
} 


