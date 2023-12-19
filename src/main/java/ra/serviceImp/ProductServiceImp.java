package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.Product;
import ra.repository.ProductRepository;
import ra.service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean create(Product product) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNow = new Date();
        Date now = null;
        try {
            now = sdf.parse(sdf.format(dateNow));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        product.setCreated(now);
        return productRepository.create(product);
    }
}
