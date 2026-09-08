package nl.logicai.hotel.controllers;

import nl.logicai.hotel.models.Gast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    // Voorlopig in het geheugen, zolang er nog geen repository is.
    private final List<Gast> gasten = new ArrayList<>(List.of(
            new Gast("Jan Jansen", "jan@example.com", 612345678),
            new Gast("Marie de Vries", "marie@example.com", 687654321)
    ));

    // Controller -> template: de gegevens gaan mee in het Model.
    @GetMapping("/test")
    public String test(Model model) {

        model.addAttribute("titel", "Test pagina :)");
        model.addAttribute("gasten", gasten);
        model.addAttribute("nieuweGast");

        return "test";
    }

    // Template -> controller: het formulier wordt gebonden aan een Gast.
    @PostMapping("/test")
    public String voegGastToe(@ModelAttribute("nieuweGast") Gast gast) {

        gasten.add(gast);

        return "redirect:/test";
    }
}
