package fr.eni.javaee.applicationenchere.model;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Classe pour gérer getter et setter de l'objet Users
 *
 * @author Adalrik
 * @date 26/08/2020
 */

@Entity
@Table(name = "UTILISATEURS",
        uniqueConstraints = {
                @UniqueConstraint(name = "pseudo_email", columnNames = {"pseudo", "email"})
        })
public class SecurityUsers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_utilisateur")
    private int userId;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String pseudo;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String nom;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String prenom;

    @NotNull
    @Column(unique = true)
    @Email(message = "Email invalide")
    @Size(max = 20, message = "Taille maximum 20 caractères")
    private String email;

    @Size(max = 15, message = "Taille maximum 15 caractères")
    private String telephone;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String rue;

    @NotNull
    @Column(name = "code_postal")
    @Size(max = 10, message = "Taille maximum 10 caractères")
    private String codePostal;

    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String ville;

    @Column(name = "mot_de_passe")
    @NotNull
    @Size(max = 30, message = "Taille maximum 30 caractères")
    private String motDePasse;

    @Value(value = "0")
    private int credit;

    @NotNull
    @Value(value = "0")
    private byte administrateur;

    public SecurityUsers() {
    }

    public SecurityUsers(@Size(max = 30, message = "Taille maximum 30 caractères") String pseudo, @Size(max = 30, message = "Taille maximum 30 caractères") String nom, @Size(max = 30, message = "Taille maximum 30 caractères") String prenom, @Email(message = "Email invalide") @Size(max = 20, message = "Taille maximum 20 caractères") String email, @Size(max = 15, message = "Taille maximum 15 caractères") String telephone, @Size(max = 30, message = "Taille maximum 30 caractères") String rue, @Size(max = 10, message = "Taille maximum 10 caractères") String codePostal, @Size(max = 30, message = "Taille maximum 30 caractères") String ville, @Size(max = 30, message = "Taille maximum 30 caractères") String motDePasse, int credit, byte administrateur) {
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    public SecurityUsers(int userId, @Size(max = 30, message = "Taille maximum 30 caractères") String pseudo, @Size(max = 30, message = "Taille maximum 30 caractères") String nom, @Size(max = 30, message = "Taille maximum 30 caractères") String prenom, @Email(message = "Email invalide") @Size(max = 20, message = "Taille maximum 20 caractères") String email, @Size(max = 15, message = "Taille maximum 15 caractères") String telephone, @Size(max = 30, message = "Taille maximum 30 caractères") String rue, @Size(max = 10, message = "Taille maximum 10 caractères") String codePostal, @Size(max = 30, message = "Taille maximum 30 caractères") String ville, @Size(max = 30, message = "Taille maximum 30 caractères") String motDePasse, int credit, byte administrateur) {
        this.userId = userId;
        this.pseudo = pseudo;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.motDePasse = motDePasse;
        this.credit = credit;
        this.administrateur = administrateur;
    }

    public int getUserId() {
        return userId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public byte getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(byte administrateur) {
        this.administrateur = administrateur;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", pseudo='" + pseudo + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", rue='" + rue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", credit=" + credit +
                ", administrateur=" + administrateur +
                '}';
    }
}
