/**
 * Classe représentant un nœud de la Deque
 * Contient une donnée et des pointeurs vers le nœud suivant et précédent
 */
class NoeudDeque {
    int donnee;
    NoeudDeque suivant;
    NoeudDeque precedent;
    
    /**
     * Constructeur du nœud
     * Complexité: O(1)
     */
    public NoeudDeque(int donnee) {
        this.donnee = donnee;
        this.suivant = null;
        this.precedent = null;
    }
}