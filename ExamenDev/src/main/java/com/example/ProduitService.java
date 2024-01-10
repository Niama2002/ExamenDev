package com.example;

import java.util.ArrayList;
import java.util.List;

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
    // Méthode utilitaire pour vérifier l'existence d'un produit par ID
    private boolean produitExiste(Long id) {
        return produits.stream().anyMatch(produit -> produit.getId().equals(id));
    }

    // Méthode utilitaire pour vérifier l'existence d'un produit par nom
    private boolean produitExiste(String nom) {
        return produits.stream().anyMatch(produit -> produit.getNom().equals(nom));
    }
}