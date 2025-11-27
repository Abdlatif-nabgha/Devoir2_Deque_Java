# 📊 Analyse de Complexité - Deque (Double Ended Queue)

## Réalisé par : Abd Latif SIDI MED NABGHA - GLSID2

## Qu'est-ce qu'une Deque?

Une **Deque** (Double Ended Queue) est une structure de données linéaire qui permet l'insertion et la suppression d'éléments aux **deux extrémités** (début et fin). Elle combine les fonctionnalités d'une pile (Stack) et d'une file (Queue).

## Structure d'Implémentation

L'implémentation utilise une **liste doublement chaînée** avec:
- Un pointeur `tete` vers le premier élément (front)
- Un pointeur `queue` vers le dernier élément (rear)
- Un compteur `taille` pour le nombre d'éléments
- Des nœuds contenant: `donnee`, `suivant`, `precedent`

---

## ⚡ Complexité Temporelle des Opérations

### Opérations de Base

| Opération | Complexité | Explication |
|-----------|-----------|-------------|
| **estVide()** | **O(1)** | Vérification simple si tête == null |
| **getTaille()** | **O(1)** | Retour direct de l'attribut taille |
| **insererDebut()** | **O(1)** | Modification des pointeurs en temps constant |
| **insererFin()** | **O(1)** | Accès direct à la queue, modification en temps constant |
| **supprimerDebut()** | **O(1)** | Modification des pointeurs de la tête |
| **supprimerFin()** | **O(1)** | Accès direct à la queue grâce à la liste doublement chaînée |
| **voirDebut()** | **O(1)** | Accès direct à la donnée de la tête |
| **voirFin()** | **O(1)** | Accès direct à la donnée de la queue |

### Opérations Avancées

| Opération | Complexité | Explication |
|-----------|-----------|-------------|
| **rechercher(valeur)** | **O(n)** | Parcours linéaire de tous les éléments |
| **afficherDebutVersFin()** | **O(n)** | Parcours de tous les nœuds du début vers la fin |
| **afficherFinVersDebut()** | **O(n)** | Parcours de tous les nœuds de la fin vers le début |
| **vider()** | **O(1)** | Remise à zéro des pointeurs (le garbage collector s'occupe du reste) |
| **inverser()** | **O(n)** | Parcours de tous les nœuds pour inverser les pointeurs |
| **getElement(index)** | **O(n)** en pire cas<br>**O(n/2)** en moyenne | Parcours optimisé depuis l'extrémité la plus proche |

**Où :**
- `n` = nombre d'éléments dans la deque

---

## 🎯 Avantages de la Liste Doublement Chaînée

### ✅ Avantages

1. **Insertion/Suppression en O(1) aux deux extrémités**
   - Pas de décalage d'éléments comme avec un tableau
   - Opérations optimales pour une deque

2. **Taille dynamique**
   - Pas de limite de capacité prédéfinie
   - Croissance automatique selon les besoins

3. **Navigation bidirectionnelle**
   - Parcours possible dans les deux sens
   - Facilite l'inversion et l'affichage inversé

4. **Suppression en O(1) avec accès direct au nœud**
   - Grâce aux pointeurs `precedent` et `suivant`

### ⚠️ Inconvénients

1. **Accès par index en O(n)**
   - Pas d'accès direct comme avec un tableau
   - Nécessite un parcours séquentiel

2. **Surcharge mémoire**
   - Chaque nœud nécessite 2 pointeurs supplémentaires
   - Consommation mémoire plus élevée qu'un tableau

3. **Mauvaise localité spatiale**
   - Les nœuds peuvent être dispersés en mémoire
   - Cache CPU moins efficace qu'avec un tableau contigu

---

## 📈 Analyse Détaillée par Opération

### **insererDebut() / insererFin() - O(1)**

**Pourquoi O(1)?**
- Accès direct aux pointeurs `tete` et `queue`
- Modification simple des liens sans parcours
- Nombre d'opérations constant quel que soit la taille

**Cas traités:**
1. Deque vide: créer le premier nœud
2. Deque non vide: ajuster les pointeurs

### **supprimerDebut() / supprimerFin() - O(1)**

**Pourquoi O(1)?**
- Accès direct aux extrémités
- La liste doublement chaînée permet la suppression en fin en O(1)
- Avec une liste simplement chaînée, `supprimerFin()` serait en O(n)

**Cas traités:**
1. Deque avec un seul élément
2. Deque avec plusieurs éléments

### **rechercher() - O(n)**

**Pourquoi O(n)?**
- Aucune structure d'indexation
- Nécessite un parcours séquentiel complet dans le pire cas
- **Meilleur cas**: O(1) si l'élément est au début
- **Pire cas**: O(n) si l'élément est à la fin ou absent

### **inverser() - O(n)**

**Pourquoi O(n)?**
- Chaque nœud doit être visité une fois
- Pour chaque nœud: échanger les pointeurs `suivant` et `precedent`
- Complexité linéaire inévitable

### **getElement(index) - O(n/2) en moyenne**

**Optimisation implémentée:**
- Si `index < taille/2`: parcourir depuis le début
- Si `index >= taille/2`: parcourir depuis la fin
- Réduit le nombre de parcours de moitié en moyenne

---

## 🆚 Comparaison: Deque par Liste vs Tableau Circulaire

| Critère | Liste Doublement Chaînée | Tableau Circulaire |
|---------|-------------------------|-------------------|
| **Insertion début/fin** | O(1) | O(1) |
| **Suppression début/fin** | O(1) | O(1) |
| **Accès par index** | O(n) | O(1) |
| **Taille dynamique** | ✅ Illimitée | ❌ Capacité fixe |
| **Mémoire** | Surcharge (2 pointeurs/nœud) | Efficace (tableau contigu) |
| **Localité cache** | ❌ Faible | ✅ Excellente |

---

## 💡 Cas d'Usage de la Deque

1. **Implémentation de Pile et File**
   - Pile: utiliser `insererDebut()` et `supprimerDebut()`
   - File: utiliser `insererFin()` et `supprimerDebut()`

2. **Historique de navigation (navigateur)**
   - Pages précédentes et suivantes

3. **Algorithme de planification (Scheduling)**
   - Gestion des processus avec priorités des deux côtés

4. **Algorithme de parcours (BFS avec deux sens)**
   - Parcours bidirectionnel de graphes

5. **Fenêtre glissante (Sliding Window)**
   - Maintenir un maximum/minimum dans une fenêtre

---

## 🧪 Complexité Spatiale

- **Stockage**: O(n) - un nœud par élément
- **Chaque nœud contient**:
  - 1 donnée (int: 4 bytes)
  - 2 pointeurs (8 bytes chacun sur système 64-bit)
  - Total: ~20 bytes par élément (vs 4 bytes pour un tableau)

---

## 🔑 Points Clés de l'Implémentation

### 1. **Gestion des cas limites**
- Deque vide
- Deque avec un seul élément
- Opérations sur deque vide (exceptions)

### 2. **Maintien de l'invariant**
- Si `tete == null` alors `queue == null`
- Si un seul élément, alors `tete == queue`
- `taille` toujours synchronisée avec le nombre réel d'éléments

### 3. **Optimisations implémentées**
- Compteur de taille en O(1)
- Accès par index optimisé (parcours depuis l'extrémité la plus proche)
- Opérations aux extrémités en temps constant

### 4. **Robustesse**
- Vérifications des cas vides
- Exceptions explicites avec messages clairs
- Tests exhaustifs de tous les cas limites