package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.repository.CategorieRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategoryRESTController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping(value = "/", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie getCategory(@PathVariable Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie saveCategory(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @PutMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Categorie updateCategory(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }
}
