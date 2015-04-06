/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Fenetre.java
 * \brief Gestion de la fenetre
 */

package Graphics;

import java.awt.*;
import javax.swing.*;
import Univers.*;
import Adn.Adn;

public class Fenetre extends JFrame 
{
	private Display disp = new Display();
	private Adn adn = new Adn();
	
	public Fenetre(Terrain t)
	{
		this.setTitle(Constantes.title);
		this.setSize(Constantes.TAILLE_TERRAIN_X, Constantes.TAILLE_TERRAIN_Y);
		this.setLocationRelativeTo(null); // centre la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // permet de quitter l'application       
		this.setResizable(false); // ne pas redimensionner la fenetre en cours d'execution
		this.setIconImage(new ImageIcon(Constantes.icone).getImage()); // icone
		this.setContentPane(disp); // Affiche le terrain
		this.setVisible(true); // affiche notre fenetre
	
		disp.setUnivers(t); // on définie notre univers dans notre classe
		
		adn.generationAdn(); // créer un adn aléatoire
		int len = adn.evalAdn(t, this.adn ,t.posInfos[0], t.posInfos[1]);
		System.out.println("Chemin de taille : " + len);
		//Affichage du terrain toutes les 20 ms
		dispTerrain();
		
	}  
	
	public void dispTerrain()
	{
		while(true)
		{
			try{
				Thread.sleep(20);
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
			disp.repaint();
		}
	}
}
