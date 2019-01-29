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
public class Localisation {
    
    private int abscisse;
    
    private int ordonnee;

    
    
    /**
     * Calcule la distance entre 2 localisations.
     * @param dest
     * @return la distance de Manhattan entre les localisations this et dest. Si dest vaut null, renvoie 0.
     */
    public int distance(Localisation dest)
    {
        if( dest == null )
            return 0;
        
        return ( Math.abs(this.abscisse - dest.abscisse) + Math.abs(this.ordonnee - dest.ordonnee) );
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Localisation other = (Localisation) obj;
        if (this.abscisse != other.abscisse) {
            return false;
        }
        if (this.ordonnee != other.ordonnee) {
            return false;
        }
        return true;
    }
    

    
    public int getAbscisse() {
        return abscisse;
    }

    public int getOrdonnee() {
        return ordonnee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.abscisse;
        hash = 97 * hash + this.ordonnee;
        return hash;
    }
    
    
    
    public Localisation() {
        abscisse = 0;
        ordonnee = 0;
    }

    
    /**
     * Constructeur par copie utilisée pour la Q6
     * @param empl 
     */
    public Localisation( EmplacementLivraison empl)
    {
        this();
        if( empl != null)
        {
            this.abscisse = empl.getAbscisse();
            this.ordonnee = empl.getOrdonnee();
        }
    }
    
    /**
     * Constructeur par données de la classe.
     * Si un paramètre ne respecte pas les conditions données, l'attribut associé vaudra 0
     * @param abscisse doit être supérieure ou égale à 0.
     * @param ordonnee doit être supérieure ou égale à 0.
     */
    public Localisation(int abscisse, int ordonnee) {
        this();
        
        if( abscisse > 0)
            this.abscisse = abscisse;
        
        if( ordonnee > 0)
            this.ordonnee = ordonnee;
    }
    
    
    
    public static void testQ1to2()
    {
        Localisation l1 = new Localisation(2,1);
        Localisation l2 = new Localisation(0,-1);
        Localisation l3 = new Localisation(7,4);
        
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        
        System.out.println(l1.equals(l2)); // false
        System.out.println(l2.equals(null)); // false
        
        System.out.println(l1.distance(l3)); // affiche 8
        System.out.println(l3.distance(l1)); // idem
        
        System.out.println(l2.distance(null)); // 0
        
    }
    
    
    public static void testQ3()
    {
        Commercant c1 = new Commercant(5, 2, -5);
        Commercant c2 = new Commercant(7, 3, 20);
        Commercant c3 = new Commercant(7, 3, -10);
        EmplacementLivraison empl1 = new EmplacementLivraison(4, 0, 0, -3);
        EmplacementLivraison empl2 = new EmplacementLivraison(7, 3, 30, 20);
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(empl1.toString());
        System.out.println(empl2.toString());
        
        System.out.println(c2.equals(empl2));   // false car type différent
        System.out.println(c2.equals(c3));     // true car meme type + meme coordonnées
    }
    
    
    @Override
    public String toString() {
        return "Localisation{" + "abscisse=" + abscisse + ", ordonnee=" + ordonnee + '}';
    }
    
    
    
    
    public static void main(String[] args) {
        
        //testQ1to2();
        //testQ3();
    }
    
}
