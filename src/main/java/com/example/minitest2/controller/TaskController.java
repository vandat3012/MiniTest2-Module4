package com.example.minitest2.controller;

import com.example.minitest2.model.Category;
import com.example.minitest2.model.Task;
import com.example.minitest2.service.category.ICategoryService;
import com.example.minitest2.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService iTaskService;
    @Autowired
    private ICategoryService iCategoryService;
    @ModelAttribute("categories")
    public Iterable<Category> categoryIterable() {
        return iCategoryService.findAll();
    }

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Task> tasks = iTaskService.findAll();
        model.addAttribute("tasks",tasks);
        return "task/list";
    }
    @GetMapping("/create")
    public String showCreate (Model model) {
        model.addAttribute("tasks",new Task());
        return "task/create";
    }
    @PostMapping("/save")
    public String save (Task task) {
        iTaskService.save(task);
        return "redirect:/tasks";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Optional<Task> task = iTaskService.findById(id);
        if (task.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("task/edit");
            modelAndView.addObject("tasks",task.get());
            return modelAndView;
        }else {
            return new ModelAndView("error");
        }
    }
    @PostMapping("/edit/{id}")
    public String edit (@ModelAttribute("tasks")Task task) {
        iTaskService.save(task);
        return "redirect:/tasks";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) {
        iTaskService.remove(id);
        return "redirect:/tasks";
    }
}
