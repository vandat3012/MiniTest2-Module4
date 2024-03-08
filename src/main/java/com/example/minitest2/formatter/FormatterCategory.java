package com.example.minitest2.formatter;

import com.example.minitest2.model.Category;
import com.example.minitest2.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class FormatterCategory implements Formatter<Category> {
    private final ICategoryService iCategoryService;
    @Autowired
    public FormatterCategory(ICategoryService iCategoryService) {
        this.iCategoryService = iCategoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        Optional<Category> category = iCategoryService.findById(Long.valueOf(text));
        return category.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
