package fr.eni.javaee.applicationenchere.services.categories;

import fr.eni.javaee.applicationenchere.bo.Categories;
import fr.eni.javaee.applicationenchere.dal.CategoriesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("categoriesService")
@Transactional
public class CategoriesServicesImpl implements CategoriesServices {

    @Autowired
    private CategoriesDAO categoriesDAO;

    @Override
    public Categories saveCategorie(Categories categorie) {
        return categoriesDAO.save(categorie);
    }

    @Override
    public Categories updateCategorie(Categories categorie) {
        return categoriesDAO.save(categorie);
    }

    @Override
    public void deleteCategorie(Integer categorieId) {
        categoriesDAO.deleteById(categorieId);
    }

}
