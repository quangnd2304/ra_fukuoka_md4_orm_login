package ra.repositoryImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.model.Product;
import ra.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    @Transactional
    public boolean create(Product product) {
        try {
            entityManager.persist(product);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
