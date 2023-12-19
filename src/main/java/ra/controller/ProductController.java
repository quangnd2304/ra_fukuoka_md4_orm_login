package ra.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.Categories;
import ra.model.Product;
import ra.service.CategoriesService;
import ra.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesService categoriesService;
    @GetMapping("/findAll")
    public ModelAndView getAllProduct(){
        ModelAndView mav = new ModelAndView("admin/productManagement");
        List<Product> listProduct = productService.findAll();
        mav.addObject("listProduct",listProduct);
        return mav;
    }
    @GetMapping("/initCreate")
    public ModelAndView initCreate(){
        ModelAndView mav = new ModelAndView("admin/newProduct");
        Product proNew = new Product();
        List<Categories> listCategories = categoriesService.findAll();
        mav.addObject("proNew",proNew);
        mav.addObject("listCategories",listCategories);
        return mav;
    }
    @PostMapping("/create")
    public String createProduct(Product proNew){
        boolean result = productService.create(proNew);
        if (result){
            return "redirect:findAll";
        }else{
            return "admin/error";
        }
    }
}
