package com.example.minitest2.service.category;

import com.example.minitest2.dto.TotalAmountOfCategory;
import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import com.example.minitest2.repository.IRepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private IRepositoryCategory iRepositoryCategory;
    @Override
    public Iterable<Category> findAll() {
        return iRepositoryCategory.findAll();
    }

    @Override
    public void save(Category category) {
        iRepositoryCategory.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iRepositoryCategory.findById(id);
    }

    @Override
    public void remove(Long id) {
        iRepositoryCategory.deleteById(id);
    }

    @Override
    public Iterable<TotalAmountOfCategory> count1() {
        return iRepositoryCategory.countByName();
    }
}
