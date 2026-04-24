package czas.herbate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CzasController {
    @GetMapping("czas")
    public String czas(Model model) {
        // Model: data interface designed to transport processed data from the Controller to the View (template engine)
        model.addAttribute("name", "edward lee");
        return "czas"; // viewResolver: viewName mapping (find czas.html)
    }

    @GetMapping("response-body")
    @ResponseBody()
    public Player responseBody() {
        Player player = new Player();
        return player;
    }

    static class Player {
        private int backNumber;
        private String name;

        public int getBackNumber() {
            return backNumber;
        }

        public void setBackNumber(int backNumber) {
            this.backNumber = backNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
