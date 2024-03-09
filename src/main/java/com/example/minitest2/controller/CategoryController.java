package com.example.minitest2.controller;

import com.example.minitest2.dto.TotalAmountOfCategory;
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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model) {
        Iterable<Category> categories = iCategoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categories", new Category());
        return "category/create";
    }

    @PostMapping("/save")
    public String save(Category category) {
        iCategoryService.save(category);
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Optional<Category> category = iCategoryService.findById(id);
        if (category.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("categories",category.get());
            return modelAndView;
        }else {
            return new ModelAndView("error");
        }
    }
    @PostMapping("/edit/{id}")
    public String edit (@ModelAttribute("categories")Category category) {
        iCategoryService.save(category);
        return "redirect:/categories";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable Long id) {
        iCategoryService.remove(id);
        return "redirect:/categories";
    }
    @GetMapping("/count")
    public ModelAndView count(){
        ModelAndView modelAndView = new ModelAndView("category/moneyofcategory");
        Iterable<TotalAmountOfCategory> categories = iCategoryService.count1();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}
