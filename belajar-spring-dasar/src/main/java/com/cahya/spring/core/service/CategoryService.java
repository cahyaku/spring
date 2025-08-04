package com.cahya.spring.core.service;

import com.cahya.spring.core.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
    /**
     * Misalkan disini tidak ada constructor, maka Spring akan meng-inject
     * dengan menggunakan setter method.
     * Tapi harus menggunakan @Autowired pada setter method tersebut.
     * Karena jika tidak ada constructor, maka Spring tidak tahu.
     */
    @Getter
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
