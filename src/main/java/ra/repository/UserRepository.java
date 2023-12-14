package ra.repository;

import ra.model.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    User findById(int userId);

    List<User> findByName(String fullName);

    Optional<User> login(User user);

    boolean register(User user);

    boolean update(User user);

    boolean delete(int userId);
}
