package fr.eni.javaee.applicationenchere.controller;

import fr.eni.javaee.applicationenchere.dto.CategoriesDTO;
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

    public ResponseEntity<List<CategoriesDTO>> getAllCategories() {
        List<Categories> categories = categoriesServices.getAllCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            categories.removeAll(Collections.singleton(null));
            List<CategoriesDTO> categoriesDTOs = categories.stream().map(categorie -> {
                return mapCategoriesToCategoriesDTO(categorie);
            }).collect(Collectors.toList());
            return new ResponseEntity<List<CategoriesDTO>>(categoriesDTOs, HttpStatus.OK);
        }
        return new ResponseEntity<List<CategoriesDTO>>(HttpStatus.NO_CONTENT);
    }

    private CategoriesDTO mapCategoriesToCategoriesDTO(Categories categories) {
        ModelMapper mapper = new ModelMapper();
        CategoriesDTO categoriesDTO = mapper.map(categories, CategoriesDTO.class);
        return categoriesDTO;
    }

}
