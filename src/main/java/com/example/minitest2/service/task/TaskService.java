package com.example.minitest2.service.task;

import com.example.minitest2.dto.TotalAmountOfCategory;
import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import com.example.minitest2.repository.IRepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TaskService implements ITaskService{
    @Autowired
    private IRepositoryTask iRepositoryTask;
    @Override
    public Iterable<Task> findAll() {
        return iRepositoryTask.findAll();
    }

    @Override
    public void save(Task task) {
        iRepositoryTask.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return iRepositoryTask.findById(id);
    }

    @Override
    public void remove(Long id) {
        iRepositoryTask.deleteById(id);
    }

    @Override
    public Iterable<Task> findAllByCategory(Category category) {
        return iRepositoryTask.findAllByCategory(category);
    }




}
