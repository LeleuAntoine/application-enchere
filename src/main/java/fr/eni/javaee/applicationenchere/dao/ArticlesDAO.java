package fr.eni.javaee.applicationenchere.dao;

import fr.eni.javaee.applicationenchere.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ArticlesDAO  extends JpaRepository <Articles, Integer>{

        @Query(getAllArticles)
        List<Articles> getAllArticles(Pageable pageable);

        String getAllArticles= "pour Article ordre décroissant";
    }

