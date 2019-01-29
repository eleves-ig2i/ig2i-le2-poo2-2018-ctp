/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instance;

import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class Route {
    
    private String nom;
    
    private LinkedList<EmplacementLivraison> listeEmp;
    
    private LinkedList<Commercant> listeCom;
    
    
    /**
     * ajoute une localisation à l’ensemble des emplacements ou l’ensemble des commerçants de la route, en fonction du type de localisation.
     * @param loc la localisation à ajouter (Commerçant ou EmplacementLivraison)
     * @return true si l'ajout a été effectué, 
     * false si un emplacement ou un commerçant aux mêmes coordonnées a déjà été ajouté 
     * ou si la localisation n'est ni un emplacement, ni un comemrçant.
     */
    public boolean ajouterLocalisation(Localisation loc)
    {
        if( loc == null)
            return false;
        
        if( loc instanceof Commercant)
        {
            //System.out.println("On essaie d'ajouter un commerçant");
            if( !listeCom.contains((Commercant)loc) )   // on a le droit de forcer la conversion car on sait que loc est une instance de Commercant
                // une autre solution est de mettre listeCom en tant que liste de Localisation
            {
                listeCom.add((Commercant)loc);
                return true;
            }
            else
                return false;
               
        }
        else if( loc instanceof EmplacementLivraison )
        {
            //System.out.println("On essaie d'ajouter un emplacement");
            if( !listeEmp.contains((EmplacementLivraison)loc) )  
            {
                listeEmp.add((EmplacementLivraison)loc);
                return true;
            }
            else
                return false;
        }
        else
        {
            return false;
        }
    }

    /**
     * Utilisé pour la question 10
     * @return 
     */
    public int getNbEmplacements() {
        return listeEmp.size();
    }
    
    /**
     * Remarque : on n'effectue pas une copie en profondeur, car on n'a pas l'intention de modifier les instances.
     * @return une copie de la liste des emplacements.
     */
    public Collection<EmplacementLivraison> getTousEmplacements()
    {
        LinkedList<EmplacementLivraison> l = new LinkedList<>();
        l.addAll(this.listeEmp);
        
        return l;
    }
    
    /**
     * 
     * @return une copie de la liste des emplacements.
     */
    public Collection<Commercant> getTousCommercants()
    {
        LinkedList<Commercant> l = new LinkedList<>();
        l.addAll(this.listeCom);
        
        return l;
    }
    
    
    
    
    /**
     * Constructeur par données de la classe.
     * @param nom s'il vaut null ou est vide, alors l'attribut associé vaudra "TEST"
     */
    public Route(String nom) {
        listeCom = new LinkedList<>();
        listeEmp = new LinkedList<>();
        
        
        if( nom != null && !nom.isEmpty() )
            this.nom = nom;
        else
            this.nom = "TEST";
    }
    
    
    public static void testQ4()
    {
        Route r = new Route("");
        
        Commercant c1 = new Commercant(5, 2, -5);
        Commercant c2 = new Commercant(7, 3, 20);
        Commercant c3 = new Commercant(7, 3, -10);
        EmplacementLivraison empl1 = new EmplacementLivraison(4, 0, 0, -3);
        EmplacementLivraison empl2 = new EmplacementLivraison(7, 3, 30, 20);
        EmplacementLivraison empl3 = new EmplacementLivraison(7, 3, 5, -5);
        
        boolean succes = r.ajouterLocalisation(c1);
        System.out.println( succes );
        
        succes = r.ajouterLocalisation(c2);
        System.out.println(succes);
        
        succes = r.ajouterLocalisation(c3);
        System.out.println(succes); // false
        
        succes = r.ajouterLocalisation(empl1);
        System.out.println(succes);
        
        succes = r.ajouterLocalisation(empl2);
        System.out.println(succes);
        
        succes = r.ajouterLocalisation(empl3);
        System.out.println(succes);
        
        
        System.out.println(r.toString());
    }

    @Override
    public String toString() {
        String sReturn = "Route{" + "nom=" + nom + ", listeEmp={";
        
        for(EmplacementLivraison e : listeEmp)
        {
            sReturn += "\n" + e.toString();            
        }
        
        sReturn +="}\n, listeCom={";
        
        for(Commercant c : listeCom)
        {
            sReturn += "\n" + c.toString();
        }
        
        //return "Route{" + "nom=" + nom + ", listeEmp=" + listeEmp + ", listeCom=" + listeCom + '}';
        
        return sReturn;
    }
    
    
    
    
    
    public static void main(String[] args) {
        testQ4();
    }
    
  
}
