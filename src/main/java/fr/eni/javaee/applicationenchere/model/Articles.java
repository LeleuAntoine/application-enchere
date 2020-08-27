package fr.eni.javaee.applicationenchere.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Classe pour gérer getter et setter de l'objet Articles
 *
 * @author Adalrik
 * @date 26/08/2020
 */

public class Articles implements Serializable {
    private int articleID;
    private String nomArticle;
    private String description;
    private Timestamp dateDebutEnchere;
    private Timestamp dateFinEnchere;
    private int prixInitial;
    private int prixVente;

    public Articles() {
    }

    public Articles(int articleID, String nomArticle, String description, Timestamp dateDebutEnchere, Timestamp dateFinEnchere, int prixInitial, int prixVente) {
        this.articleID = articleID;
        this.nomArticle = nomArticle;
        this.description = description;
        this.dateDebutEnchere = dateDebutEnchere;
        this.dateFinEnchere = dateFinEnchere;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateDebutEnchere() {
        return dateDebutEnchere;
    }

    public void setDateDebutEnchere(Timestamp dateDebutEnchere) {
        this.dateDebutEnchere = dateDebutEnchere;
    }

    public Timestamp getDateFinEnchere() {
        return dateFinEnchere;
    }

    public void setDateFinEnchere(Timestamp dateFinEnchere) {
        this.dateFinEnchere = dateFinEnchere;
    }

    public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "articleID=" + articleID +
                ", nomArticle='" + nomArticle + '\'' +
                ", description='" + description + '\'' +
                ", dateDebutEnchere=" + dateDebutEnchere +
                ", dateFinEnchere=" + dateFinEnchere +
                ", prixInitial=" + prixInitial +
                ", prixVente=" + prixVente +
                '}';
    }
}