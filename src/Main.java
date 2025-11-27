// ============= MÉTHODE MAIN POUR LES TESTS =============
public class Main { 
    public static void main(String[] args) {
        System.out.println("=== TEST DE LA DEQUE (DOUBLE ENDED QUEUE) ===\n");
        
        Deque deque = new Deque();
        
        // Test 1: Vérification deque vide
        System.out.println("1. TEST DEQUE VIDE:");
        System.out.println("Est vide? " + deque.estVide());
        System.out.println("Taille: " + deque.getTaille());
        deque.afficherDebutVersFin();
        System.out.println();
        
        // Test 2: Insertion au début
        System.out.println("2. INSERTION AU DÉBUT:");
        deque.insererDebut(10);
        deque.insererDebut(20);
        deque.insererDebut(30);
        deque.afficherDebutVersFin();
        System.out.println("Taille: " + deque.getTaille());
        System.out.println();
        
        // Test 3: Insertion à la fin
        System.out.println("3. INSERTION À LA FIN:");
        deque.insererFin(5);
        deque.insererFin(15);
        deque.afficherDebutVersFin();
        System.out.println("Taille: " + deque.getTaille());
        System.out.println();
        
        // Test 4: Affichage bidirectionnel
        System.out.println("4. AFFICHAGE BIDIRECTIONNEL:");
        deque.afficherDebutVersFin();
        deque.afficherFinVersDebut();
        System.out.println();
        
        // Test 5: Consultation sans suppression
        System.out.println("5. CONSULTATION SANS SUPPRESSION:");
        System.out.println("Premier élément (début): " + deque.voirDebut());
        System.out.println("Dernier élément (fin): " + deque.voirFin());
        System.out.println();
        
        // Test 6: Suppression au début
        System.out.println("6. SUPPRESSION AU DÉBUT:");
        System.out.println("Élément supprimé: " + deque.supprimerDebut());
        deque.afficherDebutVersFin();
        System.out.println("Taille: " + deque.getTaille());
        System.out.println();
        
        // Test 7: Suppression à la fin
        System.out.println("7. SUPPRESSION À LA FIN:");
        System.out.println("Élément supprimé: " + deque.supprimerFin());
        deque.afficherDebutVersFin();
        System.out.println("Taille: " + deque.getTaille());
        System.out.println();
        
        // Test 8: Recherche
        System.out.println("8. RECHERCHE D'ÉLÉMENTS:");
        System.out.println("Recherche 10: " + deque.rechercher(10));
        System.out.println("Recherche 100: " + deque.rechercher(100));
        System.out.println();
        
        // Test 9: Accès par index
        System.out.println("9. ACCÈS PAR INDEX:");
        for (int i = 0; i < deque.getTaille(); i++) {
            System.out.println("Élément à l'index " + i + ": " + deque.getElement(i));
        }
        System.out.println();
        
        // Test 10: Inversion
        System.out.println("10. INVERSION DE LA DEQUE:");
        System.out.println("Avant inversion:");
        deque.afficherDebutVersFin();
        deque.inverser();
        System.out.println("Après inversion:");
        deque.afficherDebutVersFin();
        System.out.println();
        
        // Test 11: Cas limites
        System.out.println("11. TESTS DES CAS LIMITES:");
        Deque deque2 = new Deque();
        deque2.insererDebut(100);
        System.out.println("Deque avec un seul élément:");
        deque2.afficherDebutVersFin();
        System.out.println("Suppression du seul élément: " + deque2.supprimerFin());
        System.out.println("Est vide? " + deque2.estVide());
        System.out.println();
        
        // Test 12: Gestion d'erreurs
        System.out.println("12. TEST GESTION D'ERREURS:");
        try {
            deque2.supprimerDebut(); // Deque vide
        } catch (RuntimeException e) {
            System.out.println("Exception capturée: " + e.getMessage());
        }
        
        try {
            deque2.voirDebut(); // Deque vide
        } catch (RuntimeException e) {
            System.out.println("Exception capturée: " + e.getMessage());
        }
        
        // Test 13: Vider la deque
        System.out.println("\n13. VIDER LA DEQUE:");
        System.out.println("Taille avant: " + deque.getTaille());
        deque.vider();
        System.out.println("Taille après: " + deque.getTaille());
        System.out.println("Est vide? " + deque.estVide());
    }
}
