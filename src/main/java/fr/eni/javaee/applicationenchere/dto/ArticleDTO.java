package fr.eni.javaee.applicationenchere.dto;

import java.time.LocalDate;

/**
 * Classe UserDTO pour communiquer
 *
 * @author Adalrik
 * @date 28/08/2020
 */
public class ArticleDTO implements Comparable<ArticleDTO> {

    private int articleID;
    private String nomArticle;
    private String description;
    private LocalDate dateDebutEnchere;
    private LocalDate dateFinEnchere;
    private int prixInitial;
    private int prixVente;
    private int userId;
    private int categorieId;

    public int getArticleID() {
        return articleID;
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

    public LocalDate getDateDebutEnchere() {
        return dateDebutEnchere;
    }

    public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
        this.dateDebutEnchere = dateDebutEnchere;
    }

    public LocalDate getDateFinEnchere() {
        return dateFinEnchere;
    }

    public void setDateFinEnchere(LocalDate dateFinEnchere) {
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
    public int compareTo(ArticleDTO o) {
        return this.description.compareToIgnoreCase(o.getDescription());
    }
}
