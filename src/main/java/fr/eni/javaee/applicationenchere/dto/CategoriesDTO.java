package fr.eni.javaee.applicationenchere.dto;

public class CategoriesDTO implements Comparable<CategoriesDTO> {

    public CategoriesDTO() {
    }

    public CategoriesDTO(int categorieId, String libelle) {
        this.categorieId = categorieId;
        this.libelle = libelle;
    }

    private int categorieId;

    private String libelle;

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

//    @Override
//    public int compareTo(CategoriesDTO o) {
//        return libelle.compareToIgnoreCase(o.libelle);
//    }
}
