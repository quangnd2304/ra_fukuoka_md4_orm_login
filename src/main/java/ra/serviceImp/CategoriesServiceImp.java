package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.Categories;
import ra.repository.CategoriesRepository;
import ra.service.CategoriesService;

import java.util.List;
@Service
public class CategoriesServiceImp implements CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }
}
