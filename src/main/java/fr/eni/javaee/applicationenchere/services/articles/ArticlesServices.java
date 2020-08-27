package fr.eni.javaee.applicationenchere.services.articles;

import fr.eni.javaee.applicationenchere.model.Articles;

public interface ArticlesServices {


    Articles saveArticle(Articles article);

    Articles updateArticle(Articles article);

    void deleteArticle(Integer articleID);

}
