package nl.logicai.hotel.controllers;

import nl.logicai.hotel.repositories.KamerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kamers")
public class KamerController {

    private final KamerRepository kamerRepository;

    public KamerController(KamerRepository kamerRepository) {
        this.kamerRepository = kamerRepository;
    }

    @GetMapping
    public String lijst(Model model) {
        model.addAttribute("kamers", kamerRepository.findAll());
        return "kamers";
    }


}
