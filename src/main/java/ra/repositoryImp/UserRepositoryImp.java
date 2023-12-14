package ra.repositoryImp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.model.User;
import ra.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("select u from User as u", User.class).getResultList();
    }

    @Override
    public User findById(int userId) {
        User user = null;
        try {
            user = entityManager.createQuery("select u from User as u where u.id = :userId", User.class)
                    .setParameter("userId", userId).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByName(String fullName) {
        return entityManager.createQuery("select u from User as u where u.fullName like :name", User.class)
                .setParameter("name", fullName).getResultList();
    }

    @Override
    public Optional<User> login(User userEntity) {
        User user = null;
        try {
            user = entityManager.createQuery("select u from User as u where u.userName = :uName and u.password = :uPass and u.status = true", User.class)
                    .setParameter("uName", userEntity.getUserName())
                    .setParameter("uPass", userEntity.getPassword()).getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (user==null){
            return Optional.ofNullable(user);
        }
        return Optional.of(user);
    }

    @Override
    @Transactional
    public boolean register(User user) {
        try {
            entityManager.persist(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(User user) {
        try {
            entityManager.merge(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int userId) {
        try {
            User user = findById(userId);
            entityManager.remove(user);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
