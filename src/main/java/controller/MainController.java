package controller;

import model.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.*;

import java.util.List;
import java.util.Map;

@Controller
public class MainController
{
    private final UserService userService;

    private final UniversityService universityService;

    private final SubjectService subjectService;

    private final SpecializationService specializationService;

    private final ConditionService conditionService;

    @Autowired
    public MainController(UserService userService, UniversityService universityService, SubjectService subjectService, SpecializationService specializationService, ConditionService conditionService)
    {
        this.userService = userService;
        this.universityService = universityService;
        this.subjectService = subjectService;
        this.specializationService = specializationService;
        this.conditionService = conditionService;
    }

    @GetMapping("/")
    public String main(Map<String, Object> model, RedirectAttributes attr)
    {
        model.put("user", userService.getCurrentUser());
        model.put("universities", universityService.getUniversityRepository().findAll());
        return "main";
    }

    @PostMapping("/university_info")
    public String university_info(String title, Map<String, Object> model, RedirectAttributes attr)
    {
        University university = universityService.getUniversityRepository().findByTitle(title);
        if(university != null)
        {
            model.put("university", university);
            return "university_info";
        }
        else
        {
            attr.addFlashAttribute("message", "Не удалось найти ВУЗ с данным названием: '" + title + "'!");
            return "redirect:/";
        }
    }
}
