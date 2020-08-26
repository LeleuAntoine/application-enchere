package fr.eni.javaee.applicationenchere.services.articles;

import fr.eni.javaee.applicationenchere.bo.Articles;

public interface ArticlesServices {

    Object saveArticle(Articles article);

    Articles updateArticle(Articles article);

    void deleteArticle(Integer articleID);

}
