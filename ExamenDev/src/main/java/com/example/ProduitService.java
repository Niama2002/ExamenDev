package com.example;

import java.util.ArrayList;
import java.util.List;

	//CREATE

public class ProduitService {

    private List<Produit> produits;

    public ProduitService() {
        this.produits = new ArrayList<>();
    }

    // Opération CREATE
    public void ajouterProduit(Produit nouveauProduit) {
        // Vérification de l'unicité du produit
        if (!produitExiste(nouveauProduit.getId()) && !produitExiste(nouveauProduit.getNom())) {
            // Validation des données
            if (nouveauProduit.getPrix() >= 0 && nouveauProduit.getQuantite() >= 0) {
                produits.add(nouveauProduit);
                System.out.println("Produit ajouté avec succès.");
            } else {
                System.out.println("Le prix et la quantité du produit doivent être positifs.");
            }
        } else {
            System.out.println("Un produit avec le même ID ou nom existe déjà.");
        }
    }
    
    //READ
    public Produit trouverProduitParId(Long id) {
        for (Produit produit : produits) {
            if (produit.getId().equals(id)) {
                return produit;
            }
        }
        return null; // Produit non trouvé
    }
    
 // Opération UPDATE
    public void mettreAJourProduit(Produit produitMaj) {
        // Vérification de l'existence du produit
        if (produitExiste(produitMaj.getId())) {
            // Validation des données
            if (produitMaj.getPrix() >= 0 && produitMaj.getQuantite() >= 0) {
                // Mise à jour des attributs du produit existant
                Produit produitExist = trouverProduitParId(produitMaj.getId());
                produitExist.setNom(produitMaj.getNom());
                produitExist.setPrix(produitMaj.getPrix());
                produitExist.setQuantite(produitMaj.getQuantite());
                System.out.println("Produit mis à jour avec succès.");
            } else {
                System.out.println("Le prix et la quantité du produit doivent être positifs.");
            }
        } else {
            System.out.println("Le produit à mettre à jour n'existe pas.");
        }
    }
    
 // Opération DELETE
    public void supprimerProduit(Long id) {
        // Vérification de l'existence du produit
        Produit produitASupprimer = trouverProduitParId(id);
        if (produitASupprimer != null) {
            produits.remove(produitASupprimer);
            System.out.println("Produit supprimé avec succès.");
        } else {
            System.out.println("Le produit à supprimer n'existe pas.");
        }
    }
    
    
    private boolean produitExiste(Long id) {
        return produits.stream().anyMatch(produit -> produit.getId().equals(id));
    }

    private boolean produitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }

    public List<Produit> getProduits() {
        return produits;
    }
}