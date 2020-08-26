package fr.eni.javaee.applicationenchere.services.categories;

import fr.eni.javaee.applicationenchere.bo.Categories;

public interface CategoriesServices {

    Categories saveCategorie(Categories categorie);

    Categories updateCategorie(Categories categorie);

    void deleteCategorie(Integer categorieId);

}
