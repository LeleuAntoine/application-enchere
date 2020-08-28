package fr.eni.javaee.applicationenchere.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe pour gérer getter et setter de l'objet Articles
 *
 * @author Adalrik
 * @date 26/08/2020
 */

@Entity
@Table(name = "ARTICLES")
public class Articles implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "no_articles")
    private int articleID;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    @Column(name = "nom_article")
    private String nomArticle;

    @NotNull
    @Size(max = 300, message = "Taille maximum 300 caractères")
    private String description;

    @NotNull
    @Column(name = "date_debut_encheres")
    private LocalDate dateDebutEnchere;

    @NotNull
    @Column(name = "date_fin_encheres")
    private LocalDate dateFinEnchere;

    @Column(name = "prix_initial")
    private int prixInitial;

    @Column(name = "prix_vente")
    private int prixVente;

    @NotNull
    @Column(name = "no_utilisateur")
    private int userId;

    @NotNull
    @Column(name = "no_categorie")
    private int categorieId;

    public Articles() {
    }

    public Articles(int articleID, String nomArticle, String description, LocalDate dateDebutEnchere, LocalDate dateFinEnchere, int prixInitial, int prixVente) {
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
