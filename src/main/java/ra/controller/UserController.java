package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.dto.request.LoginRequest;
import ra.dto.request.UserRequest;
import ra.dto.response.LoginResponse;
import ra.dto.response.UserResponse;
import ra.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ModelAndView getAllUser() {
        ModelAndView mav = new ModelAndView("admin/userManagement");
        List<UserResponse> listUser = userService.findAll();
        mav.addObject("listUser", listUser);
        return mav;
    }
    @GetMapping("/wellcome")
    public String wellcomeUser(ModelMap modelMap, HttpServletRequest request){
        //Lấy thông tin từ Cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")){
                modelMap.addAttribute("userName",cookie.getValue());
                break;
            }
        }
        return "user/userPage";
    }

    @PostMapping("/login")
    public String login(LoginRequest loginRequest, ModelMap modelMap, HttpServletResponse response, HttpServletRequest request) {
        //Gọi sang service để login
        LoginResponse loginResponse = userService.login(loginRequest);
        if (loginResponse == null) {
            //Đăng nhập thất bại --> login
            modelMap.addAttribute("error", "Username or password incorrect");
            return "login";
        }
        //Đăng nhập thành công
        //1.Lưu thông tin user vào cookie
        Cookie cookieUserId = new Cookie("userId", loginResponse.getId() + "");
        Cookie cookieUserName = new Cookie("userName", loginResponse.getUserName());
        Cookie cookiePermission = new Cookie("permission", String.valueOf(loginResponse.isPermission()));
        response.addCookie(cookieUserId);
        response.addCookie(cookieUserName);
        response.addCookie(cookiePermission);
        //2. Kiểm tra quyền và điều hướng về trang admin hoặc user
        if (loginResponse.isPermission()) {
            //Trang admin
            return "redirect:findAll";
        }
        //Trang user
        return "redirect:wellcome";

    }
}
