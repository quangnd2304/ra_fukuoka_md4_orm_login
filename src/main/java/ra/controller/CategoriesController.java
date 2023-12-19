package ra.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Categories;
import ra.service.CategoriesService;

import java.util.List;

@Controller
@RequestMapping("/categoriesController")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping("/findAll")
    public ModelAndView getAllCategories(){
        ModelAndView mav = new ModelAndView("admin/categoriesManagement");
        List<Categories> listCategories = categoriesService.findAll();
        mav.addObject("listCategories",listCategories);
        return mav;
    }
}
