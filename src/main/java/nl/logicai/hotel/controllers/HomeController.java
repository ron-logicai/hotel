package nl.logicai.hotel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String home(Model model)
//    {
//        model.addAttribute("titel","Home");
//
//        return "home";
//    }

    @GetMapping("/home") // you can open this with 8080/fiets
    public String home(Model model)
    {
        model.addAttribute("titel",""); // this will be the title


        return "home"; // go to home.html
    }


    @GetMapping("/players")
    public String players (Model model) {

        model.addAttribute("titel", "Players");

        return "players";



    }

    @GetMapping("/rules")
    public String rules (Model model) {

        model.addAttribute("titel", "Rules of the Game");

        return "rules";
    }

    @GetMapping ("/game")
    public String game (Model model) {

        model.addAttribute("titel", "2k");

        return "game";

    }

    @GetMapping("/journey")
    public String journey(Model model) {

        model.addAttribute("titel", "Make it to the NBA");

        return "journey";

    }

}



