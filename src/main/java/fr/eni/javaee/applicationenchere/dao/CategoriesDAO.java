package fr.eni.javaee.applicationenchere.dao;

import fr.eni.javaee.applicationenchere.model.Categories;
import fr.eni.javaee.applicationenchere.model.SecurityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO extends JpaRepository <Categories, Integer> {
}
