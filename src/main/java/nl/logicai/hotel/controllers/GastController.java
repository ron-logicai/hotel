package nl.logicai.hotel.controllers;

import nl.logicai.hotel.models.Gast;
import nl.logicai.hotel.repositories.GastRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gasten")
public class GastController {

    private final GastRepository gastRepository;

    public GastController(GastRepository gastRepository) {
        this.gastRepository = gastRepository;




//        Auto auto = new Auto();
//
//        auto.Gaan();
//
//        Fiets fiets = new Fiets();
//
//        fiets.Gaan();

    }

    @GetMapping
    public String lijst(Model model) {
        model.addAttribute("gasten", gastRepository.findAll());
        return "gasten";
    }

    @GetMapping("/nieuw")
    public String nieuw(Model model) {
        model.addAttribute("gast", new Gast());
        return "gast-formulier";
    }

    @PostMapping
    public String opslaan(@ModelAttribute Gast gast) {
        gastRepository.save(gast);

        return "redirect:/gasten";
    }

    @PostMapping("/{id}/verwijderen")
    public String verwijderen(@PathVariable Long id) {
        gastRepository.deleteById(id);
//        gastRepository.deleteById(3L);
        return "redirect:/gasten";
    }
}


