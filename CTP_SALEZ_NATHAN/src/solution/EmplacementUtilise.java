/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import instance.Commercant;
import instance.EmplacementLivraison;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class EmplacementUtilise extends EmplacementLivraison {
    
    
    private int nbColisTotal;
    
    private int distanceCumulee;
    
    private LinkedList<Commercant> commercantsLivres;

    
    /**
     * essaye d’ajouter un commerçant à l’emplacement. Si l’ajout a bien lieu, on renvoie true, et on met à jour les attributs.
     * Sinon, on renvoie false.
     * @param comm
     * @return un booléan indiquant si l'ajout a eu lieu 
     */
    public boolean ajouterCommercant(Commercant comm)
    {
        if( ajoutPossible(comm) )  
        {
            commercantsLivres.add(comm);
            majAjoutCommercant();
            comm.affecterEmplacement(this); // cf Q9
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    /**
     * Ajoute le plus de commercants possibles dans l'emplacement this.
     * @param listeComm 
     */
    public void ajouterCommercants(Collection<Commercant> listeComm)
    {
        if( listeComm == null)
            return;
        
        for( Commercant c : listeComm )
        {
            if( ajouterCommercant(c) )
            {
                System.out.println("Commercant ajouté");
            }
        }
    }
    
    
    /**
     * Un commerçant est ajoutable <=> il ne vaut pas null + il n'est pas trop loin + il n'ajoute pas trop de colis + il n'est pas déjà dans la liste.
     * @param comm
     * @return true si le commerçant est ajoutable, false sinon.
     */
    public boolean ajoutPossible(Commercant comm)
    {
        if( comm == null)
            return false;
        
        //System.out.println("Ajout : capacité correcte ?");
        if( comm.getNbColis() + nbColisTotal > this.getCapaciteLivraison() )
            return false;
        
        //System.out.println("Ajout : distance correcte ?");
        if( this.distance(comm) > this.getDistanceMax() )
            return false;
        
        // est déjà contenu ?
        if( this.commercantsLivres.contains(comm) )
            return false;
        
        // contient-il déjà un autre emplacement ?
        if( comm.estAffecte() )
            return false;
        
        return true;
    }
    
    
    /**
     * Constructeur par copie de la classe.
     * Utilise le constructeur par copie de la classe EmplacementLivraison, qui utilise le constructeur par copie de la Localisation.
     * @param empl 
     */
    public EmplacementUtilise(EmplacementLivraison empl) {
        super(empl);
        
        commercantsLivres = new LinkedList<>();
        
        nbColisTotal = 0;
        
        distanceCumulee = 0;
    }

    public int getNbColisTotal() {
        return nbColisTotal;
    }

    public int getDistanceCumulee() {
        return distanceCumulee;
    }

    
    /**
     * Met a jour les attributs nbColisTotal et distanceCumulee avec l'ajout du dernier commercnat
     */
    private void majAjoutCommercant()
    {
        if( this.commercantsLivres.isEmpty() )
        {
            System.err.println("Problème : on veut màj les attributs alors que la liste de commercants est vide !");
            return;
        }
        
        Commercant c  = this.commercantsLivres.getLast();
        
        this.distanceCumulee += c.distance(this);
        this.nbColisTotal += c.getNbColis();
    }
    
    
    public static void testQ7to9()
    {
        EmplacementLivraison emplLivraison = new EmplacementLivraison(10, 10, 100, 20);
        EmplacementUtilise empl = new EmplacementUtilise(emplLivraison);
        boolean ajout = empl.ajouterCommercant(null); // return false
        System.out.println(ajout);
        Commercant comm1 = new Commercant(12, 5, 20);
        ajout = empl.ajouterCommercant(comm1); // return true
        System.out.println(ajout);
        Commercant comm2 = new Commercant(2, 2, 40);
        ajout = empl.ajouterCommercant(comm2); // return true
        System.out.println(ajout);
        Commercant comm3 = new Commercant(1, 24, 10);
        ajout = empl.ajouterCommercant(comm3); // return false --> trop loin
        System.out.println(ajout);
        Commercant comm4 = new Commercant(12, 7, 70);
        ajout = empl.ajouterCommercant(comm4); // return false --> trop de colis
        System.out.println(ajout);
        // Q9
        Commercant comm5 = new Commercant(12, 7, 44);
        ajout = empl.ajouterCommercant(comm5); // return false --> commerçant déjà présent.
        System.out.println(ajout);
    }
    
    
    @Override
    public String toString() {
        String sReturn = "EmplacementUtilise{" + super.toString() + "nbColisTotal=" + nbColisTotal + ", distanceCumulee=" + distanceCumulee + ", commercantsLivres{";
        
        //return "EmplacementUtilise{" + super.toString() + "nbColisTotal=" + nbColisTotal + ", distanceCumulee=" + distanceCumulee + '}';
        for(Commercant c : this.commercantsLivres)
        {
            sReturn += "\n" + c.toString();
        }
       
        return sReturn + "}\n}";
    }
    
    public String toStringFichier()
    {
        String sReturn =" Emplacement : (" + this.getAbscisse() + "," + this.getOrdonnee() +") -- nb colis total = " + this.nbColisTotal;
        for(Commercant c : this.commercantsLivres)
        {
            sReturn += c.toStringFichier() + "\n";
        }
        return sReturn;
    }
    
    public static void main(String[] args) {
        testQ7to9();
    }

    
    
}
