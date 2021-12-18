package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.category.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<GetCategoryDto>> all(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GetCategoryDto>> findOne(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }
    @PostMapping("/")
    public ResponseEntity<Category> create(@Valid @RequestBody CreateCategoryDto createCategoryDto){
        return categoryService.save(createCategoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> edit(@Valid @RequestBody CreateCategoryDto categoryDto, @PathVariable("id") Long id){
        return categoryService.edit(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        return categoryService.delete(id);
    }

}
