package fr.eni.javaee.applicationenchere.services.articles;

import fr.eni.javaee.applicationenchere.model.Articles;
import fr.eni.javaee.applicationenchere.dao.ArticlesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

@Service("articlesService")
@Transactional
public class ArticlesServicesImpl implements ArticlesServices {

    @Autowired
    private ArticlesDAO articlesDAO;

    @Override
    public Articles saveArticle(Articles article) {
        return articlesDAO.save(article);
    }

    @Override
    public Articles updateArticle(Articles article) {
        return articlesDAO.save(article);
    }

    @Override
    public void deleteArticle(Integer articleID) {
        articlesDAO.deleteById(articleID);
    }

    @Override
    public Page<Articles> getPaginatedArticlesList(int begin, int end) {
        Pageable page = PageRequest.of(begin, end);
        return articlesDAO.findAll(page);
    }

}
