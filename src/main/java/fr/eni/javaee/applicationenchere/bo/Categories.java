package fr.eni.javaee.applicationenchere.bo;

import java.io.Serializable;

/**
 * Classe pour gérer getter et setter de l'objet Categories
 *
 * @author Adalrik
 * @date 26/08/2020
 */

public class Categories implements Serializable {

    private int categorieId;
    private String libelle;

    public Categories() {
    }

    public Categories(int categorieId, String libelle) {
        this.categorieId = categorieId;
        this.libelle = libelle;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categorieId=" + categorieId +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
