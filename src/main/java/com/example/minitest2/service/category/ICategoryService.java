package com.example.minitest2.service.category;

import com.example.minitest2.dto.TotalAmountOfCategory;
import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import com.example.minitest2.service.IGenerateService;

public interface ICategoryService extends IGenerateService<Category> {
    Iterable<TotalAmountOfCategory> count1();
}
