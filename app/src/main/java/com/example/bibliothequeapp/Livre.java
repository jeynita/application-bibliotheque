package com.example.bibliothequeapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// @Entity indique à Room que cette classe représente une table SQLite.
// tableName permet de donner un nom clair à la table.
@Entity(tableName = "livres")
public class Livre implements Serializable {

    // @PrimaryKey indique la clé primaire de la table.
    // autoGenerate = true permet à Room de générer automatiquement l'id.
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;

    public Livre(int id, String titre, String auteur, String isbn, boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
