
/**
 * Implémentation d'une Deque (Double Ended Queue) par liste doublement chaînée
 * Une Deque permet l'insertion et la suppression aux deux extrémités
 */
public class Deque {
    private NoeudDeque tete;      // Premier élément (front)
    private NoeudDeque queue;     // Dernier élément (rear)
    private int taille;           // Nombre d'éléments dans la deque
    
    /**
     * Constructeur - Crée une deque vide
     * Complexité: O(1)
     */
    public Deque() {
        this.tete = null;
        this.queue = null;
        this.taille = 0;
    }
    
    /**
     * Vérifie si la deque est vide
     * Complexité: O(1)
     * 
     * @return true si la deque est vide, false sinon
     */
    public boolean estVide() {
        return tete == null;
    }
    
    /**
     * Retourne la taille de la deque
     * Complexité: O(1)
     * 
     * @return le nombre d'éléments dans la deque
     */
    public int getTaille() {
        return taille;
    }
    
    /**
     * Insère un élément au début de la deque (front)
     * Complexité: O(1)
     * 
     * @param donnee la valeur à insérer
     */
    public void insererDebut(int donnee) {
        NoeudDeque nouveau = new NoeudDeque(donnee);
        
        // Cas 1: Deque vide
        if (estVide()) {
            tete = nouveau;
            queue = nouveau;
        } 
        // Cas 2: Deque non vide
        else {
            nouveau.suivant = tete;
            tete.precedent = nouveau;
            tete = nouveau;
        }
        
        taille++;
    }
    
    /**
     * Insère un élément à la fin de la deque (rear)
     * Complexité: O(1)
     * 
     * @param donnee la valeur à insérer
     */
    public void insererFin(int donnee) {
        NoeudDeque nouveau = new NoeudDeque(donnee);
        
        // Cas 1: Deque vide
        if (estVide()) {
            tete = nouveau;
            queue = nouveau;
        } 
        // Cas 2: Deque non vide
        else {
            nouveau.precedent = queue;
            queue.suivant = nouveau;
            queue = nouveau;
        }
        
        taille++;
    }
    
    /**
     * Supprime et retourne l'élément au début de la deque (front)
     * Complexité: O(1)
     * 
     * @return la valeur supprimée
     * @throws RuntimeException si la deque est vide
     */
    public int supprimerDebut() {
        if (estVide()) {
            throw new RuntimeException("Erreur: Deque vide - impossible de supprimer au début");
        }
        
        int valeur = tete.donnee;
        
        // Cas 1: Un seul élément
        if (tete == queue) {
            tete = null;
            queue = null;
        } 
        // Cas 2: Plusieurs éléments
        else {
            tete = tete.suivant;
            tete.precedent = null;
        }
        
        taille--;
        return valeur;
    }
    
    /**
     * Supprime et retourne l'élément à la fin de la deque (rear)
     * Complexité: O(1)
     * 
     * @return la valeur supprimée
     * @throws RuntimeException si la deque est vide
     */
    public int supprimerFin() {
        if (estVide()) {
            throw new RuntimeException("Erreur: Deque vide - impossible de supprimer à la fin");
        }
        
        int valeur = queue.donnee;
        
        // Cas 1: Un seul élément
        if (tete == queue) {
            tete = null;
            queue = null;
        } 
        // Cas 2: Plusieurs éléments
        else {
            queue = queue.precedent;
            queue.suivant = null;
        }
        
        taille--;
        return valeur;
    }
    
    /**
     * Retourne l'élément au début sans le supprimer
     * Complexité: O(1)
     * 
     * @return la valeur au début de la deque
     * @throws RuntimeException si la deque est vide
     */
    public int voirDebut() {
        if (estVide()) {
            throw new RuntimeException("Erreur: Deque vide - aucun élément au début");
        }
        return tete.donnee;
    }
    
    /**
     * Retourne l'élément à la fin sans le supprimer
     * Complexité: O(1)
     * 
     * @return la valeur à la fin de la deque
     * @throws RuntimeException si la deque est vide
     */
    public int voirFin() {
        if (estVide()) {
            throw new RuntimeException("Erreur: Deque vide - aucun élément à la fin");
        }
        return queue.donnee;
    }
    
    /**
     * Recherche un élément dans la deque
     * Complexité: O(n) où n est le nombre d'éléments
     * 
     * @param valeur la valeur à rechercher
     * @return true si l'élément existe, false sinon
     */
    public boolean rechercher(int valeur) {
        NoeudDeque courant = tete;
        
        while (courant != null) {
            if (courant.donnee == valeur) {
                return true;
            }
            courant = courant.suivant;
        }
        
        return false;
    }
    
    /**
     * Affiche la deque du début vers la fin
     * Complexité: O(n)
     */
    public void afficherDebutVersFin() {
        if (estVide()) {
            System.out.println("Deque vide: []");
            return;
        }
        
        System.out.print("Deque (début -> fin): [");
        NoeudDeque courant = tete;
        
        while (courant != null) {
            System.out.print(courant.donnee);
            if (courant.suivant != null) {
                System.out.print(" <-> ");
            }
            courant = courant.suivant;
        }
        
        System.out.println("]");
    }
    
    /**
     * Affiche la deque de la fin vers le début
     * Complexité: O(n)
     */
    public void afficherFinVersDebut() {
        if (estVide()) {
            System.out.println("Deque vide: []");
            return;
        }
        
        System.out.print("Deque (fin -> début): [");
        NoeudDeque courant = queue;
        
        while (courant != null) {
            System.out.print(courant.donnee);
            if (courant.precedent != null) {
                System.out.print(" <-> ");
            }
            courant = courant.precedent;
        }
        
        System.out.println("]");
    }
    
    /**
     * Vide complètement la deque
     * Complexité: O(1)
     */
    public void vider() {
        tete = null;
        queue = null;
        taille = 0;
    }
    
    /**
     * Inverse l'ordre des éléments dans la deque
     * Complexité: O(n)
     */
    public void inverser() {
        if (estVide() || taille == 1) {
            return; // Rien à inverser
        }
        
        NoeudDeque courant = tete;
        NoeudDeque temp = null;
        
        // Échanger les pointeurs suivant et précédent pour chaque nœud
        while (courant != null) {
            temp = courant.precedent;
            courant.precedent = courant.suivant;
            courant.suivant = temp;
            courant = courant.precedent; // Avancer (dans l'ancien sens suivant)
        }
        
        // Échanger tête et queue
        temp = tete;
        tete = queue;
        queue = temp;
    }
    
    /**
     * Retourne le élément à l'index spécifié (0-based)
     * Complexité: O(n) dans le pire cas, O(n/2) en moyenne avec optimisation
     * 
     * @param index l'index de l'élément (0 = premier élément)
     * @return la valeur à l'index spécifié
     * @throws IndexOutOfBoundsException si l'index est invalide
     */
    public int getElement(int index) {
        if (index < 0 || index >= taille) {
            throw new IndexOutOfBoundsException("Index invalide: " + index + " (taille: " + taille + ")");
        }
        
        NoeudDeque courant;
        
        // Optimisation: commencer du côté le plus proche
        if (index < taille / 2) {
            // Parcourir depuis le début
            courant = tete;
            for (int i = 0; i < index; i++) {
                courant = courant.suivant;
            }
        } else {
            // Parcourir depuis la fin
            courant = queue;
            for (int i = taille - 1; i > index; i--) {
                courant = courant.precedent;
            }
        }
        
        return courant.donnee;
    }
}