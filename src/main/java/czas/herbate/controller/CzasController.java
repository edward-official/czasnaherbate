package czas.herbate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CzasController {
    @GetMapping("czas")
    public String czas(Model model) {
        model.addAttribute("name", "edward lee");
        return "czas"; // viewResolver: viewName mapping (find czas.html)
    }
}
