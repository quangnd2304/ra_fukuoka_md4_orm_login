package ra.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.dto.response.UserResponse;
import ra.mapper.LoginMapper;
import ra.mapper.UserMapper;
import ra.model.User;
import ra.repository.UserRepository;
import ra.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        //1. Chuyển từ request sang entity - user: entity - request: loginRequest
        User user = loginMapper.mapperRequestToEntity(loginRequest);
        //2. Nhận kết quả sau khi gọi repository là: entity
        Optional<User> userLogin = userRepository.login(user);
        //entity --> response để trả về cho controller
        if (userLogin.isPresent()){
            return loginMapper.mapperEntityToResponse(userLogin.get());
        }
        return null;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> listUser = userRepository.findAll();
        return listUser.stream()
                .map(user -> userMapper.mapperEntityToResponse(user)).collect(Collectors.toList());
    }
}
