package com.example.minitest2.service.task;

import com.example.minitest2.dto.TotalAmountOfCategory;
import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import com.example.minitest2.service.IGenerateService;

public interface ITaskService extends IGenerateService<Task> {
    Iterable<Task> findAllByCategory(Category category);
}
