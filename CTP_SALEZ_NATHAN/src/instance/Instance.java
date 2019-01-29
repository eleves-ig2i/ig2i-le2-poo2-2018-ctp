/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instance;

import java.util.Collection;

/**
 *
 * @author user
 */
public class Instance {
    
    private double coutEmplacement;
    
    private double coutDistance;
    
    /**
     * Route sur laquelle on teste l'instance
     */
    private Route route;

    
    /**
     * Problème Q13 : L'instance donnée sur moodle est impossible à résoudre ?
     */
    public void chargerData1() {
	this.coutEmplacement = 1000;
	this.coutDistance = 1;
	this.route = new Route("Petite rue");
        Commercant c5 = new Commercant(12, 5, 13);
	route.ajouterLocalisation(c5);
	Commercant c1 = new Commercant(5, 2, 12);
	route.ajouterLocalisation(c1);
	Commercant c2 = new Commercant(7, 3, 20);
	route.ajouterLocalisation(c2);
	//Commercant c3 = new Commercant(2, 9, 9);
	//route.ajouterLocalisation(c3);
	Commercant c4 = new Commercant(8, 5, 15);
	route.ajouterLocalisation(c4);
        EmplacementLivraison empl2 = new EmplacementLivraison(6, 0, 30, 20);
	route.ajouterLocalisation(empl2);
	EmplacementLivraison empl1 = new EmplacementLivraison(4, 0, 25, 40);
	route.ajouterLocalisation(empl1);
	EmplacementLivraison empl3 = new EmplacementLivraison(9, 0, 20, 30);
	route.ajouterLocalisation(empl3);
    }
    
    
    /**
     * Constructeur par défaut.
     * coutEmplacement et coutDistance vaudront 0
     * route est initialisé avec le contructeur par données du nom dont le paramètre vaut "ROAD TO THE L3"
     */
    public Instance() {
        coutEmplacement = 0;
        coutDistance = 0;
        
        route = new Route("ROAD TO THE L3");        
    }

    
    /**
     * @return le nombre d'emplacements de l'instance.
     */
    public int getNbEmplacements()
    {
        return this.route.getNbEmplacements();
    }

    public double getCoutEmplacement() {
        return coutEmplacement;
    }

    public double getCoutDistance() {
        return coutDistance;
    }
    
    /**
     * Remarque : on n'effectue pas une copie en profondeur pour le moment.
     * @return une copie de la liste des commercants.
     */
    public Collection<Commercant> getTousCommercants()
    {        
        return this.route.getTousCommercants();
    }
    
    /**
     * Remarque : on n'effectue pas une copie en profondeur pour le moment.
     * @return une copie de la liste des emplacements.
     */
    public Collection<EmplacementLivraison> getTousEmplacements()
    {
        return this.route.getTousEmplacements();
    }
    
    
    @Override
    public String toString() {
        return "Instance{" + "coutEmplacement=" + coutEmplacement + ", coutDistance=" + coutDistance + ", rModele=" + route.toString() + '}';
    }
    
    
    public static void main(String[] args) {
        Instance inst = new Instance();
        inst.chargerData1();
        System.out.println(inst);
    }
     
    
}
