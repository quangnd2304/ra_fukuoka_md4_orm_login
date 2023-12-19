package ra.repository;

import ra.model.Categories;

import java.util.List;

public interface CategoriesRepository {
    List<Categories> findAll();
}
