package com.example.minitest2.repository;

import com.example.minitest2.dto.TotalAmountOfCategory;
import com.example.minitest2.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
@Repository
public interface IRepositoryCategory extends CrudRepository<Category,Long> {
    @Query(nativeQuery = true, value = "select c.name, sum(t.amount) as total_amount\n" +
            "from category c left join task t on c.id = t.category_id\n" +
            "group by c.name;")
    Iterable<TotalAmountOfCategory> countByName();
}
