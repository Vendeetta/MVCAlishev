package mmm.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodBye() {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b, @RequestParam(value = "act") String act, Model model) {
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        if (act.equalsIgnoreCase("mul")) {
            model.addAttribute("result", String.valueOf(a * b));
            model.addAttribute("act", "*");
        }
        if (act.equalsIgnoreCase("add")) {
            model.addAttribute("result", String.valueOf(a + b));
            model.addAttribute("act", "+");
        }
        if (act.equalsIgnoreCase("sub")) {
            model.addAttribute("result", String.valueOf(a - b));
            model.addAttribute("act", "-");
        }
        if (act.equalsIgnoreCase("div")) {
            model.addAttribute("result", String.valueOf(a / b));
            model.addAttribute("act", "/");
        }
        return "calc";
    }
}
