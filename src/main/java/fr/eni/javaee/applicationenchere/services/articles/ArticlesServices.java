package fr.eni.javaee.applicationenchere.services.articles;

import fr.eni.javaee.applicationenchere.model.Articles;
import org.springframework.data.domain.Page;

public interface ArticlesServices {


    Articles saveArticle(Articles article);

    Articles updateArticle(Articles article);

    void deleteArticle(Integer articleID);

    Page<Articles> getPaginatedArticlesList(int begin, int end);

}
