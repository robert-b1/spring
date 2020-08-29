package comapp.spring.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Coursecontroller {

    @GetMapping("/")
    public String init(Model model){
        final String homeTitle = "Witaj na stronie testowej";
        model.addAttribute("homeTitle", homeTitle);

        return "home";
    }

    @GetMapping
    public String redirectToPage2(Model model){
        final String homeTitle = "Witaj na stronie nr 2";
        model.addAttribute("page2Title", homeTitle);
        return "page2";
    }

    /* @GetMapping(value = "/getAll")
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<String> listOfCourses = asList("Python",
                "Java",
                "kotlin",
                "C#",
                "GOSU",
                "VUE.js",
                "DART");
        modelAndView.setViewName("home");
        modelAndView.addObject("courseName", listOfCourses);

        return modelAndView;
    }*/
    /*@PatchMapping("/addCourse")
    public String addCourse(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "type", required = false) String type,
            Model model) {
        System.out.println(name);
        System.out.println(type);
        return "home";
    }*/
}
