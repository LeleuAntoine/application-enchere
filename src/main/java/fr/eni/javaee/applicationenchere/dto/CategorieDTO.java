package fr.eni.javaee.applicationenchere.dto;

public class CategorieDTO implements Comparable<CategorieDTO> {

    private int categorieId;
    private String libelle;

    public CategorieDTO() {
    }

    public CategorieDTO(int categorieId, String libelle) {
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
    public int compareTo(CategorieDTO o) {
        return libelle.compareToIgnoreCase(o.libelle);
    }

}
