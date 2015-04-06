/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Adn.java
 * \brief Gestion d'un ADN
 */
package Adn;

import Univers.*;
import java.util.*;

public class Adn {
	
	private int genes = Constantes.nbrGenes; // nombre de gene de l'ADN
	private List<Integer> listDeplacement = new ArrayList<Integer>(); //stocke les déplacements de l'ADN
	private int Orientation = 8; // 0 à 7 directions
	
	
	/* Génération aléatoire d'un ADN 
	 * Ses genes representent les déplacements aléatoires
	 * */
	public void generationAdn(){
		Random rd = new Random();
		int dir; // direction de l'adn
		for(int i = 0; i < genes ; i++){
			dir = rd.nextInt(this.Orientation);
			this.listDeplacement.add(dir);
		}
	}
	
	/* Evalue la distance entre l'adn et l'arrivée
	 * renvoie la taille de son chemin
	 */
	public int evalAdn(Terrain univers, Adn adn, Points pDepart, Points pArrive){
		
		Points pActuel = pDepart;
		Points ptmp = pDepart; //au cas ou l'adn franchit un mur
		int len = 0;
		while( (pActuel.getPosX() != pArrive.getPosX() || pActuel.getPosY() != pArrive.getPosY()) && len < adn.getNbrGenes() ){
			
			switch(adn.getValAdn(len)){
				case 0: // HAUT
					pActuel.setPosY(pActuel.getPosY() - 1);
					break;
				case 1: // HAUT DROIT
					pActuel.setPos(pActuel.getPosX() + 1 , pActuel.getPosY() - 1);
					break;
				case 2: // DROIT
					pActuel.setPosX(pActuel.getPosX() + 1);
					break;
				case 3: // BAS DROIT
					pActuel.setPos(pActuel.getPosX() + 1 , pActuel.getPosY() + 1);
					break;
				case 4: // BAS
					pActuel.setPosY(pActuel.getPosY() + 1);
					break;
				case 5: // BAS GAUCHE
					pActuel.setPos(pActuel.getPosX() - 1 , pActuel.getPosY() + 1);
					break;
				case 6: // GAUCHE
					pActuel.setPosX(pActuel.getPosX() - 1);
					break;
				case 7: // HAUT GAUCHE
					pActuel.setPos(pActuel.getPosX() - 1 , pActuel.getPosY() - 1);
					break;
			}
			
			if(pActuel.getPosX() > (univers.getTailleX()-1) || pActuel.getPosY() > (univers.getTailleY() -1)
			   || pActuel.getPosX() < 0 || pActuel.getPosY() < 0 || univers.getPos(pActuel.getPosX(),pActuel.getPosY()) == Constantes.Obstacle ) {
				
				pActuel = ptmp; // retour a l'ancienne position
			}
			else{
				ptmp = pActuel;
				univers.setPos(pActuel.getPosX(), pActuel.getPosY(), Constantes.Adn);
			}
			len++;
			
			if(len == adn.getNbrGenes()){
				/* a l'instant T l'adn n'a pas trouvé le chemin
				 * Il faut faire une estimation de la longueur
				 */
			}
		}
		return len;
	}
	
	
	//affiche infos ADN	
	public void dispAdn(){
		for(int gene : this.listDeplacement){
			System.out.println(gene);
		}
	}
	//GETTERS
	public int getNbrGenes(){
		return this.genes;
	}
	public int getValAdn(int index){
		return this.listDeplacement.get(index);
	}
}
