package com.peek.kusprojectpeek.Controller;

import com.peek.kusprojectpeek.dto.UserDto;
import com.peek.kusprojectpeek.dto.UserFormDto;
import com.peek.kusprojectpeek.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String createUser(UserFormDto userFormDto) {
        UserDto userDto = userService.createUser(userFormDto);
        if (userDto == null) {
            return "failsignup";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public void logoutPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        response.sendRedirect("/logout");
    }
}
