/**
 * Projet POO
 * \author ABDESSELAM Gaia
 * \author BERTRAND Lucas
 * \file Population.java
 * \brief Traite les ADN d'une population
 */
package Adn;
import Univers.*;
import java.util.*;

public class Population{
	
	private List<Adn> adns = new ArrayList<Adn>(); // créer une liste d'adn
	
	/* constructeur pour construire une population */
	public Population(int taille){
		for(int i = 0; i < taille ; i++){
			Adn newAdn = new Adn();
			newAdn.generationAdn(); // on créer un adn avec des genes aléatoire
			this.adns.add(newAdn);
		}
	}
	
	//Getters
	public Adn getAdn(int index){
		return this.adns.get(index);
	}
	
	
}
