package ra.mapper;

import org.springframework.stereotype.Component;
import ra.dto.request.UserRequest;
import ra.dto.response.UserResponse;
import ra.model.User;

@Component
public class UserMapper implements MapperGeneric<User, UserRequest, UserResponse> {
    @Override
    public User mapperRequestToEntity(UserRequest userRequest) {
        return User.builder().userName(userRequest.getUserName())
                .password(userRequest.getPassword())
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail()).build();
    }

    @Override
    public UserResponse mapperEntityToResponse(User user) {
        return new UserResponse(user.getId(), user.getUserName(), user.getPassword(),
                user.getFullName(), user.getEmail(), user.getCreated(), user.isStatus());
    }
}
