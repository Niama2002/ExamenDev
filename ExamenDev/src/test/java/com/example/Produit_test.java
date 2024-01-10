package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Produit_test {

    @Test
    public void testAjouterProduit() {
        ProduitService produitService = new ProduitService();
        Produit produit = new Produit(1L, "Ordinateur", 999.99, 5);

        produitService.ajouterProduit(produit);

        assertEquals(1, produitService.getProduits().size());
        assertTrue(produitService.getProduits().contains(produit));

        // Ajouter un produit avec le même ID ou nom doit lever une exception
        assertThrows(IllegalArgumentException.class, () ->
                produitService.ajouterProduit(new Produit(1L, "Smartphone", 599.99, 3)));
    }

    @Test
    public void testTrouverProduitParId() {
        ProduitService produitService = new ProduitService();
        Produit produit = new Produit(1L, "Ordinateur", 999.99, 5);

        produitService.ajouterProduit(produit);

        Produit produitTrouve = produitService.trouverProduitParId(1L);

        assertNotNull(produitTrouve);
        assertEquals(produit, produitTrouve);

        // Trouver un produit avec un ID inexistant doit retourner null
        assertNull(produitService.trouverProduitParId(2L));
    }

    @Test
    public void testMettreAJourProduit() {
        ProduitService produitService = new ProduitService();
        Produit produit = new Produit(1L, "Ordinateur", 999.99, 5);

        produitService.ajouterProduit(produit);

        Produit produitMaj = new Produit(1L, "Nouvel Ordinateur", 1299.99, 3);
        produitService.mettreAJourProduit(produitMaj);

        assertEquals("Nouvel Ordinateur", produit.getNom());
        assertEquals(1299.99, produit.getPrix(), 0.001);
        assertEquals(3, produit.getQuantite());

        // Mettre à jour un produit qui n'existe pas doit lever une exception
        assertThrows(IllegalArgumentException.class, () ->
                produitService.mettreAJourProduit(new Produit(2L, "Smartphone", 599.99, 3)));
    }

    @Test
    public void testSupprimerProduit() {
        ProduitService produitService = new ProduitService();
        Produit produit = new Produit(1L, "Ordinateur", 999.99, 5);

        produitService.ajouterProduit(produit);
        produitService.supprimerProduit(1L);

        assertEquals(0, produitService.getProduits().size());

        // Supprimer un produit qui n'existe pas doit lever une exception
        
        assertThrows(IllegalArgumentException.class, () ->
                produitService.supprimerProduit(2L));
    }
}