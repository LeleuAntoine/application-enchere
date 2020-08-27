package fr.eni.javaee.applicationenchere.dao;

import fr.eni.javaee.applicationenchere.model.Articles;
import fr.eni.javaee.applicationenchere.model.SecurityUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesDAO  extends JpaRepository <Articles, Integer>{
}
