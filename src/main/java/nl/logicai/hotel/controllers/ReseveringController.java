package nl.logicai.hotel.controllers;

import nl.logicai.hotel.models.Gast;
import nl.logicai.hotel.models.Kamer;
import nl.logicai.hotel.models.Resevering;
import nl.logicai.hotel.repositories.GastRepository;
import nl.logicai.hotel.repositories.KamerRepository;
import nl.logicai.hotel.repositories.ReseveringRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Controller
@RequestMapping("/reseveringen")
public class ReseveringController {

    private final ReseveringRepository reseveringRepository;
    private final GastRepository gastRepository;
    private final KamerRepository kamerRepository;

    public ReseveringController(ReseveringRepository reseveringRepository,
                                GastRepository gastRepository,
                                KamerRepository kamerRepository) {
        this.reseveringRepository = reseveringRepository;
        this.gastRepository = gastRepository;
        this.kamerRepository = kamerRepository;
    }

    @GetMapping   //has also /reseveringen because of requestMapping
    public String lijst(Model model) {
        model.addAttribute("reseveringen", reseveringRepository.findAll());
        return "reseveringen";
    }

    @GetMapping("/nieuw")
    public String nieuw(@RequestParam(required = false) Integer kamerNummer, Model model) {
        model.addAttribute("gasten", gastRepository.findAll());
        model.addAttribute("kamers", kamerRepository.findAll());
        model.addAttribute("gekozenKamer", kamerNummer);
        return "resevering-formulier";
    }

    @PostMapping
    public String opslaan(@RequestParam Long gastId,
                          @RequestParam int kamerNummer,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate eind,
                          @RequestParam(defaultValue = "false") boolean betaald) {

        if (!eind.isAfter(start)) {
            return "redirect:/reseveringen/nieuw?kamerNummer=" + kamerNummer + "&fout=datum";
        }

        Gast gast = gastRepository.findById(gastId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gast niet gevonden"));
        Kamer kamer = kamerRepository.findById(kamerNummer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kamer niet gevonden"));

        Resevering resevering = new Resevering(start, eind, gast, kamer);
        resevering.setBetaald(betaald);
        reseveringRepository.save(resevering);
        return "redirect:/reseveringen";
    }

    @PostMapping("/{nummer}/verwijderen")
    public String verwijderen(@PathVariable int nummer) {
        reseveringRepository.deleteById(nummer);
        return "redirect:/reseveringen";
    }
}
