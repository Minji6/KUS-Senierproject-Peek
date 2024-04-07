package com.peek.kusprojectpeek.Controller;

import com.peek.kusprojectpeek.dto.UserDto;
import com.peek.kusprojectpeek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ViewController {
    private final UserRepository userRepository;

    @RequestMapping("/login")
    String loginView() {
        return "login";
    }

    @RequestMapping("/fail")
    String failView() {
        return "fail";
    }

    @RequestMapping("/admin")
    ModelAndView andView() {
        List<UserDto> userDtoList = userRepository
                .findAll()
                .stream()
                .map(u -> UserDto.builder()
                .id(u.getId())
                .email(u.getEmail())
                .password(u.getPassword())
                .role(u.getRole()).build()).collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView("/admin");
        modelAndView.addObject("userList", userDtoList);

        return modelAndView;
    }

    @RequestMapping("/signup")
    String signupView() {
        return "signup";
    }
}
