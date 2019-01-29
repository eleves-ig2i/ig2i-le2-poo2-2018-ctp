/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instance;

/**
 *
 * @author user
 */
public class EmplacementLivraison extends Localisation {
    
    
    /**
     * Le nombre maximum de colis que l’on peut livrer depuis l’emplacement
     */
    private int capaciteLivraison;
       
    /**
     * La distance maximale que l’on peut parcourir pour livrer un commerçant
     */
    private int distanceMax;

    
    /**
     * Constructeur par copie utilisée pour la Q6.
     * si empl vaut null, l'ensemble des attributs vaudront 0.
     * @param empl l'emplacement à copier
     */
    public EmplacementLivraison( EmplacementLivraison empl)
    {
        super(empl);
        if( empl != null )
        {
            capaciteLivraison = empl.capaciteLivraison;
            distanceMax = empl.distanceMax;
        }
        else
        {
            capaciteLivraison = 0;
            distanceMax = 0;
        }
    }
    
    
    /**
     * Constructeur par données de la classe.
     * Si un paramètre ne respecte pas les conditions données, l'attribut associé vaudra 0
     * @param capaciteLivraison doit être supérieure ou égale à 0.
     * @param distanceMax doit être supérieure ou égale à 0.
     * @param abscisse doit être supérieure ou égale à 0.
     * @param ordonnee doit être supérieure ou égale à 0.
     */
    public EmplacementLivraison(int abscisse, int ordonnee, int capaciteLivraison, int distanceMax) {
        super(abscisse, ordonnee);
        
        if( capaciteLivraison < 0)
            capaciteLivraison = 0;
        
        if( distanceMax < 0)
            distanceMax = 0;
        
        this.capaciteLivraison = capaciteLivraison;
        this.distanceMax = distanceMax;
    }

    
    public int getCapaciteLivraison() {
        return capaciteLivraison;
    }

    public int getDistanceMax() {
        return distanceMax;
    }

    @Override
    public String toString() {
        return "EmplacementLivraison{" + super.toString() + "capaciteLivraison=" + capaciteLivraison + ", distanceMax=" + distanceMax + '}';
    }
    
    
}
