package fr.eni.javaee.applicationenchere.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Classe pour gérer getter et setter de l'objet Categories
 *
 * @author Adalrik
 * @date 26/08/2020
 */
@Entity
@Table(name = "CATEGORIES")
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_categorie")
    private int categorieId;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
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
