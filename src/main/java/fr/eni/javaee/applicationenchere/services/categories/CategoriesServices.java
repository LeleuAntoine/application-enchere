package fr.eni.javaee.applicationenchere.services.categories;

import fr.eni.javaee.applicationenchere.model.Categories;

import java.util.List;

public interface CategoriesServices{

    Categories saveCategorie(Categories categorie);

    Categories updateCategorie(Categories categorie);

    void deleteCategorie(Integer categorieId);

    List<Categories> getAllCategories();

}
