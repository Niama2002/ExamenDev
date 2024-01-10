package com.example;

public class Produit {
    private Long id;
    private String nom;
    private double prix;
    private int quantite;

    // Constructeur
    public Produit(Long id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    // Getters et setters pour chaque attribut
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Méthode toString pour afficher les détails du produit
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }

    // Méthode main pour tester la classe Produit
    public static void main(String[] args) {
        Produit produit = new Produit(1L, "Ordinateur portable", 999.99, 5);
        System.out.println(produit.toString());
    }
}

