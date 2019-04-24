package controller;

import model.University;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

import java.util.Map;

@Controller
public class AuthController
{
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model)
    {
        return "login";
    }

    @PostMapping("/login")
    public String login(String message, Map<String, Object> model)
    {
        model.put("message", message);
        return "login";
    }

    @GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration_student(User user, University university, Map<String, Object> model, RedirectAttributes attr)
    {
        if(user != null)
        {
            if(university.getTitle() != null)
                user.setUniversity(university);
            if(userService.getUserRepository().findByName(user.getName()) != null)
            {
                model.put("message", "Пользователь с таким логином уже зарегистрированн!");
                return "registration";
            }
            else if(user.getPassword().isEmpty())
            {
                model.put("message", "Пароль не может быть пустым!");
                return "registration";
            }
            else if(user.getName().isEmpty())
            {
                model.put("message", "Имя не может быть пустым!");
                return "registration";
            }
            else
            {
                user.setActive(true);
                user.setAuthority(0);
                try
                {
                    userService.setCurrentUser(user);
                    userService.saveAndFlush();
                }
                catch (Exception ex)
                {
                    model.put("message", "Произошла ошибка при создании пользователя!");
                    return "registration";
                }
                attr.addFlashAttribute("message", "Пользователь успешно зарегистрирован!");
                return "redirect:/login";
            }
        }
        return "registration";
    }

    @GetMapping("/user_cabinet")
    public String user_cabinet(Map<String, Object> model, RedirectAttributes attr)
    {
        model.putIfAbsent("user", userService.getCurrentUser());
        return "user_cabinet";
    }

    @PostMapping("/user_cabinet")
    public String user_cabinet(String message, Map<String, Object> model)
    {
        return "user_cabinet";
    }

    @PostMapping("/pass_change")
    public String pass_change(String newpassword, String againpassword, Map<String, Object> model, RedirectAttributes attr)
    {
        if(!newpassword.equals(againpassword))
        {
            attr.addFlashAttribute("message","Новый пароль и его подтверждение не совпадают!");
            return "redirect:/user_cabinet";
        }
        else
        {
            if (newpassword.isEmpty())
            {
                attr.addFlashAttribute("message", "Новый пароль не может быть пустым!");
                return "redirect:/user_cabinet";
            }
            userService.getCurrentUser().setPassword(newpassword);
            userService.saveAndFlush();
            attr.addFlashAttribute("message", "Пароль успешно изменен!");
            return "redirect:/user_cabinet";
        }
    }

}