package nl.logicai.hotel.controllers;

import nl.logicai.hotel.repositories.GastRepository;
import nl.logicai.hotel.repositories.KamerRepository;
import nl.logicai.hotel.repositories.ReseveringRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // this decide what is gonna happen
public class WebController {

    private final GastRepository gastRepository; //final is you can not change it
    private final KamerRepository kamerRepository;
    private final ReseveringRepository reseveringRepository;

    public WebController(GastRepository gastRepository, KamerRepository kamerRepository, ReseveringRepository reseveringRepository) {
        this.gastRepository = gastRepository;
        this.kamerRepository = kamerRepository;
        this.reseveringRepository = reseveringRepository;
    }

    @GetMapping("/") //home
    public String home(Model model) {    //aantalGasten moet hetzelfde zijn in index.html
        model.addAttribute("aantalGasten", gastRepository.count()); //gastRepository will go to database
        model.addAttribute("aantalKamers", kamerRepository.count());// he is counting here how many room we have
        model.addAttribute("aantalReseveringen", reseveringRepository.count());
        return "index";// naar index.html
    }
}
