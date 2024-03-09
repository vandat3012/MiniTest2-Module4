package com.example.minitest2.repository;

import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IRepositoryTask extends CrudRepository<Task,Long> {
    Iterable<Task> findAllByCategory(Category category);
    Page<Task> findAll(Pageable pageable);
    Page<Task> findByName(Pageable pageable,String name);
}
