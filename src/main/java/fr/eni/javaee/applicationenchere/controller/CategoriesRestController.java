package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dto.ArticleDTO;
import fr.eni.javaee.applicationenchere.dto.CategorieDTO;
import fr.eni.javaee.applicationenchere.model.Articles;
import fr.eni.javaee.applicationenchere.model.Categories;
import fr.eni.javaee.applicationenchere.services.categories.CategoriesServicesImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categories")
public class CategoriesRestController {

    @Autowired
    CategoriesServicesImpl categoriesServices;

    /**
     * Renvoie la liste des categories
     * */
    @GetMapping("/listCategories")
    public ResponseEntity<List<CategorieDTO>> getAllCategories() {
        List<Categories> categories = categoriesServices.getAllCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            categories.removeAll(Collections.singleton(null));
            List<CategorieDTO> categoriesDTOs = categories.stream().map(categorie -> {
                return mapCategoriesToCategoriesDTO(categorie);
            }).collect(Collectors.toList());
            return new ResponseEntity<List<CategorieDTO>>(categoriesDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategorieDTO>>(HttpStatus.NO_CONTENT);
    }

    /**
     * Ajoute une nouvelle categorie
     *
     * @param CategorieDTORequest
     * @return
     */
    @PostMapping("/addCategorie")
    public ResponseEntity<CategorieDTO> createNewCategorie(@RequestBody CategorieDTO CategorieDTORequest) {
        Categories categorieRequest = mapCategoriesDTOToCategories(CategorieDTORequest);
        Categories categorieResponse = categoriesServices.saveCategorie(categorieRequest);
        if (categorieResponse != null) {
            CategorieDTO categorieDTO = mapCategoriesToCategoriesDTO(categorieResponse);
            return new ResponseEntity<CategorieDTO>(categorieDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<CategorieDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Transforme une entitée categories en un categorieDTO
     *
     * @param categories
     * @return
     */
    private CategorieDTO mapCategoriesToCategoriesDTO(Categories categories) {
        ModelMapper mapper = new ModelMapper();
        CategorieDTO categorieDTO = mapper.map(categories, CategorieDTO.class);
        return categorieDTO;
    }

    /**
     * Transforme un categorieDTO en une entité categories
     *
     * @param categorieDTO
     * @return
     */
    private Categories mapCategoriesDTOToCategories(CategorieDTO categorieDTO) {
        ModelMapper mapper = new ModelMapper();
        Categories categorie = mapper.map(categorieDTO, Categories.class);
        return categorie;
    }
}
