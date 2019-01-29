/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instance;

import solution.EmplacementUtilise;

/**
 *
 * @author user
 */
public class Commercant extends Localisation {
    
    /**
     * le nombre de colis qu’il faut lui livrer depuis un emplacement
     */
    private int nbColis;

    
    private EmplacementUtilise emplUtilise;
    
    
    
    /**
     * essaye d’affecter l’emplacement au commerçant;
     * @param empl
     * @return cette méthode renvoie true si l’affectation a eu lieu, false sinon (par exemple si le commerçant était déjà affecté à un emplacement).
     * Remarque : on ne vérifiera pas que l’emplacement contient bien le commerçant.
     */
    public boolean affecterEmplacement(EmplacementUtilise empl)
    {
        if( estAffecte() || empl == null)
            return false;
        
        emplUtilise = empl;
        return true;
    }
    
    
    /**
     * Constructeur par données de la classe.
     * Si un paramètre ne respecte pas les conditions données, l'attribut associé vaudra 0.
     * @param abscisse doit être supérieure ou égale à 0.
     * @param ordonnee doit être supérieure ou égale à 0.
     * @param nbColis doit être supérieur ou égal à 0.
     */
    public Commercant(int abscisse, int ordonnee, int nbColis) {
        super(abscisse, ordonnee);
        
        if( nbColis < 0)
            nbColis = 0;
        
        this.nbColis = nbColis;
    }

    
    /**
     * 
     * @return true si le commerçant est déjà affecté à un emplacement de livraison, false sinon ;
     */
    public boolean estAffecte()
    {
        if( emplUtilise == null)
            return false;
        else
            return true;
    }
    
    public int getNbColis() {
        return nbColis;
    }

    
    @Override
    public String toString() {
        return "Commercant{" + super.toString() + "nbColis=" + nbColis + '}';
    }
    
    
    public String toStringFichier()
    {
        String sReturn = "\tCommercant (" + this.getAbscisse() + ";" + this.getOrdonnee() +")";
        
        return sReturn;
    }
    
    
    public static void testQ9()
    {
        Commercant comm1 = new Commercant(12, 5, 20);
        EmplacementLivraison emplLivraison = new EmplacementLivraison(10, 10, 100, 20);
        EmplacementUtilise empl = new EmplacementUtilise(emplLivraison);
        EmplacementUtilise emp2 = new EmplacementUtilise(emplLivraison);
        
        boolean succes = comm1.affecterEmplacement(null);
        System.out.println(succes); // false
        
        succes = comm1.affecterEmplacement(emp2);
        System.out.println(succes); // true
        
        succes = comm1.affecterEmplacement(empl);
        System.out.println(succes); // false
    }
    
    
    public static void main(String[] args) {
        testQ9();
    }
    
    
}
