package ra.service;

import ra.dto.request.LoginRequest;
import ra.dto.response.LoginResponse;
import ra.dto.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    List<UserResponse> findAll();
}
