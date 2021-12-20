package com.salesianostriana.dam.TrianaTourist.services;

import com.salesianostriana.dam.TrianaTourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.category.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.category.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.ListEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.errores.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.repos.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;


    public ResponseEntity<List<GetCategoryDto>> findAll() {

        List<Category> data = categoryRepository.findAll();

        if (data.isEmpty()) {
            throw new ListEntityNotFoundException(Category.class);
        } else {

            List<GetCategoryDto> result = data.stream().map(categoryDtoConverter::categoryToGetCategoryDto)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(result);
        }

    }

    public Optional<Category> findById(Long id){
        if (categoryRepository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(),Category.class);
        }
        return categoryRepository.findById(id);
    }

    public ResponseEntity<Category> save(CreateCategoryDto category) {

        Category newCategory = categoryDtoConverter.createCategoryDtoToCategory(category);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryRepository.save(newCategory));
    }

    public ResponseEntity<Category> edit(Long id, CreateCategoryDto c) {

        Optional<Category> data = categoryRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            return ResponseEntity.of(categoryRepository.findById(id).map(
                    m -> {
                        m.setName(c.getName());
                        categoryRepository.save(m);
                        return m;
                    }
            ));
        }


    }

    public ResponseEntity<?> delete(Long id) {

        Optional<Category> data = categoryRepository.findById(id);

        if (data.isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Category.class);
        } else {
            categoryRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }

    }

}
