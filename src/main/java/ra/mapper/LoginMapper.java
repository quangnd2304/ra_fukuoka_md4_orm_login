package ra.mapper;

import org.springframework.stereotype.Component;
import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.model.User;
@Component
public class LoginMapper implements MapperGeneric<User, LoginRequest, LoginResponse>{
    @Override
    public User mapperRequestToEntity(LoginRequest loginRequest) {
        //Xây dựng constructor của User gồm 2 tham số userName và password
        //Gọi constructor và khởi tạo đối tượng user với 2 đối số truyền vào là loginRequest.getUserName() và loginRequest.getPassword()
        return User.builder().userName(loginRequest.getUserName())
                .password(loginRequest.getPassword()).build();
    }

    @Override
    public LoginResponse mapperEntityToResponse(User user) {
        return new LoginResponse(user.getId(), user.getUserName(),user.isPermission());
    }
}
