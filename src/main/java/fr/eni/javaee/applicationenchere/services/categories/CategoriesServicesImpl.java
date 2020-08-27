package fr.eni.javaee.applicationenchere.services.categories;

import fr.eni.javaee.applicationenchere.model.Categories;
import fr.eni.javaee.applicationenchere.dao.CategoriesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("categoriesService")
@Transactional
public class CategoriesServicesImpl implements CategoriesServices {

    @Autowired
    private CategoriesDAO categorieDAO;

    @Override
    public Categories saveCategorie(Categories categorie) {
        return categorieDAO.save(categorie);
    }

    @Override
    public Categories updateCategorie(Categories categorie) {
        return categorieDAO.save(categorie);
    }

    @Override
    public void deleteCategorie(Integer categorieId) {
        categorieDAO.deleteById(categorieId);
    }

    @Override
    public List<Categories> getAllCategories(){
        return categorieDAO.findAll();
    }

}
