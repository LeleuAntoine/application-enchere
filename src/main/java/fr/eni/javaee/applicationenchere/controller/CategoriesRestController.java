package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dto.CategorieDTO;
import fr.eni.javaee.applicationenchere.model.Categories;
import fr.eni.javaee.applicationenchere.services.categories.CategoriesServicesImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categories/api")
public class CategoriesRestController {

    @Autowired
    CategoriesServicesImpl categoriesServices;

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

    private CategorieDTO mapCategoriesToCategoriesDTO(Categories categories) {
        ModelMapper mapper = new ModelMapper();
        CategorieDTO categorieDTO = mapper.map(categories, CategorieDTO.class);
        return categorieDTO;
    }

}
