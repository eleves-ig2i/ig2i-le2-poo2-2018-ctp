/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import instance.Commercant;
import instance.EmplacementLivraison;
import instance.Instance;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Solution {
    
    private double coutTotal;
    
    private Instance instance;
    
    private ArrayList<EmplacementUtilise> listeEmplacementsUtilises;

    
    /**
     * 
     * tant qu’il reste des commerçants non affectés, on prend un nouvel emplacement de livraison,
     * et on affecte des commerçants (pas déjà affectés) à cet emplacement.
     * Pour affecter les commerçants à un emplacement de livraison, 
     *      on parcoure les commerçants, 
     *      et on y ajoute les commerçants non affectés si possible. 
     * 
     * À la fin, on calcule le coût total de la solution.
     * @param listeEmpl la liste des emplacements de livraison disponibles.
     * @param listeComm la liste des commercants à livrer dans la rue.
     */
    public void algorithmeSolutionSimple( Collection<EmplacementLivraison> listeEmpl, Collection<Commercant> listeComm)
    {
        if( listeEmpl == null || listeComm == null)
        {
            System.err.println("Problème : une des listes vaut null");
            return;
        }
        
        Iterator<EmplacementLivraison> itEmplLivr = listeEmpl.iterator();
        
        while( resteCommercantsNonAffectes(listeComm) )
        {
            EmplacementUtilise emplUtilise;
            if( itEmplLivr.hasNext() )
            {
                emplUtilise = new EmplacementUtilise( itEmplLivr.next());
                emplUtilise.ajouterCommercants(listeComm);
                this.listeEmplacementsUtilises.add(emplUtilise);
            }
            else
            {
                System.err.println("Problème : on a utilisé tous les emplacements possibles !");
                return;
            }
        }
        
        this.calculerCout();
    }
    
    /**
     * fait le calcul du coût total de la solution, et met à jour l’attribut correspondant.
     */
    public void calculerCout()
    {        
        // la distance totale est la somme des distances entre chaque commerçant et son emplacement. <==> getDistanceTotale()
        double distanceTotale = this.getDistanceTotale();
        
        // le coût de la distance totale de livraison est la distance totale multipliée par le coût unitaire (coutDistance) ;
        double coutDistanceTotale = distanceTotale * this.instance.getCoutDistance();
        
        // le coût des emplacements est le nombre d’emplacements utilisés multiplié par le coût d’un emplacement (coutEmplacement) ;
        double coutEmplacements = getNbEmplacementsUtilises() * this.instance.getCoutEmplacement();
        
        // le cout de la solution est le coût des emplacements plus le coût de la distance totale de livraison ;
        coutTotal = coutEmplacements + coutDistanceTotale;
    }
    
    
    /**
     * écrit la solution dans le format proposé
     * @param nomFichier 
     */
    public void ecrireSolution(String nomFichier)
    {
        if( nomFichier == null)
            nomFichier = "solution.txt";
        
        PrintWriter p = null;
        try
        {
            p = new PrintWriter(nomFichier);
            p.print( this.toStringFichier() );
            p.close();
        }
        catch( Exception e)
        {
            e.getMessage();
        }
    }
    
    
    public double getCoutTotal() {
        return coutTotal;
    }
  
    
    public double getDistanceTotale()
    {
        double dTotale = 0;
        
        for( EmplacementUtilise empl : listeEmplacementsUtilises)
        {
            dTotale += empl.getDistanceCumulee();
        }
        
        // System.out.println("distance totale : " + dTotale); // OK
        return dTotale;
    }
    
    
    public double getNbEmplacementsUtilises()
    {
        return this.listeEmplacementsUtilises.size();
    }
    
    
    /**
     * Renvoie true s'il reste des commercants à affecter dans listeComm, false sinon.
     * @param listeComm
     * @return true s'il reste des commercants à affecter dans listeComm, false sinon.
     */
    public boolean resteCommercantsNonAffectes(Collection<Commercant> listeComm)
    {
        if( listeComm == null )
            return false;
        
        for( Commercant c : listeComm)
        {
            if( !c.estAffecte() )   // c n'est pas affecté, il faut le faire !
                return true;
        }
        
        return false;
    }
    
    
    
    /**
     * Constructeur par défaut, utilisé par le constructeur par données.
     */
    public Solution() {
        coutTotal = 0;
        instance = new Instance();
        listeEmplacementsUtilises = new ArrayList<>();
    }

    
    
    /**
     * Constructeur par données
     * @param instance 
     */
    public Solution(Instance instance) {
        this();
        if( instance != null )
        {
            this.instance = instance;
            listeEmplacementsUtilises = new ArrayList<>( instance.getNbEmplacements() );    // pn sait qu'on utilisera pas plus que le nombre d'emplacements total.
        }
    }
    
    
    /**
     * Charge les données de l'instance puis applique l'algorithme de la solution simple.
     */
    public void solutionSimple()
    {
        // avant de commencer l'algorithme, on doit récupérer les données importantes de l'instance.
        Collection<EmplacementLivraison> listeEmpl = this.instance.getTousEmplacements();
        Collection<Commercant> listeComm = this.instance.getTousCommercants();
        
        System.out.println("Nombre de commerçants à ajouter : " + listeComm.size());
        
        algorithmeSolutionSimple(listeEmpl, listeComm);
        
    }
    
    

    public static void testQ13()
    {
        Instance i = new Instance();
        i.chargerData1();
        Solution s = new Solution(i);
        s.solutionSimple();
        System.out.println(s.toString());
        s.ecrireSolution("solution.txt");
    }
    
    @Override
    public String toString() {
        String sReturn = "Solution{" + "coutTotal=" + coutTotal + ", instance=" + instance.toString() + ", listeEmplacements {";
        
        for(EmplacementUtilise e : listeEmplacementsUtilises)
        {
            sReturn += "\n" + e.toString();
        }
        
        return sReturn + "}\n}";
    }
    
    
    public String toStringFichier()
    {
        String sReturn = "Cout total = " + this.coutTotal 
                + "\nNombre d'emplacements utilisés : " + this.getNbEmplacementsUtilises() + "\n";
        
        for(EmplacementUtilise empl : listeEmplacementsUtilises)
        {
            sReturn += empl.toStringFichier();
        }
        
        return sReturn;
    }
    
    public static void main(String[] args) {
        testQ13();
    }
    
    
    
    
    
    
    
    
}
