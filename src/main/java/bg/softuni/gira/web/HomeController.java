package bg.softuni.gira.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "home";
        }

        return "redirect:/";
    }
}
