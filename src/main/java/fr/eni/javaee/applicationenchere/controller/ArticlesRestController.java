package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dto.ArticleDTO;
import fr.eni.javaee.applicationenchere.model.Articles;
import fr.eni.javaee.applicationenchere.services.articles.ArticlesServicesImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enchere")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArticlesRestController {

    @Autowired
    private ArticlesServicesImpl articlesServices;

    /**
     * Pagination des Articles
     */
    @GetMapping("/pages")
    public ResponseEntity<List<ArticleDTO>> getAllArticles() {
        List<Articles> articles = articlesServices.getAllArticles();
        if (!CollectionUtils.isEmpty(articles)) {
            System.out.println("article " + articles);
            List<ArticleDTO> articleDTOs = articles.stream().map(article -> {
                return mapArticleToArticleDTO(article);
            }).collect(Collectors.toList());
            return new ResponseEntity<List<ArticleDTO>>(articleDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<List<ArticleDTO>>(HttpStatus.NO_CONTENT);
    }


    /**
     * Affiche un article
     * */
    @GetMapping("/article/{articleID}")
    public ResponseEntity<ArticleDTO> afficheArticle(@RequestBody ArticleDTO ArticleDTORequest) {
        Articles  articleRequest = mapArticleDTOToArticle(ArticleDTORequest);
        Articles articleResponse = articlesServices.afficheArticle(ArticleDTORequest.getArticleID());
        if (articleResponse != null) {
            ArticleDTO articleDTO = mapArticleToArticleDTO(articleResponse);
            return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ArticleDTO>(HttpStatus.NO_CONTENT);
    }

    /**
     * Ajoute un nouvel article
     *
     * @param ArticleDTORequest
     * @return
     */
    @PostMapping("/addArticles")
    public ResponseEntity<ArticleDTO> createNewArticle(@RequestBody ArticleDTO ArticleDTORequest) {
        Articles articleRequest = mapArticleDTOToArticle(ArticleDTORequest);
        Articles articleResponse = articlesServices.saveArticle(articleRequest);
        if (articleResponse != null) {
            ArticleDTO articleDTO = mapArticleToArticleDTO(articleResponse);
            return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<ArticleDTO>(HttpStatus.NOT_MODIFIED);
    }


    /**
     * Transforme une entitée article en un articleDTO
     *
     * @param article
     * @return
     */
    private ArticleDTO mapArticleToArticleDTO(Articles article) {
        ModelMapper mapper = new ModelMapper();
        ArticleDTO articleDTO = mapper.map(article, ArticleDTO.class);
        return articleDTO;
    }

    /**
     * Transforme un articleDTO en une entité article
     *
     * @param articleDTO
     * @return
     */
    private Articles mapArticleDTOToArticle(ArticleDTO articleDTO) {
        ModelMapper mapper = new ModelMapper();
        Articles articles = mapper.map(articleDTO, Articles.class);
        return articles;
    }
}
