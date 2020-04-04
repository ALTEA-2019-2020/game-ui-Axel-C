package com.miage.altea.game_ui.controller;

import com.miage.altea.game_ui.service.PokemonTypeService;
import com.miage.altea.game_ui.trainers.Pokemon;
import com.miage.altea.game_ui.trainers.Trainer;
import com.miage.altea.game_ui.trainers.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class IndexController {
    private TrainerService trainerService;

    @Autowired
    private PokemonTypeService pokemonTypeService;

    @Autowired
    IndexController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }

    @PostMapping(value = "/registerTrainer")
    ModelAndView registerNewTrainer(String trainerName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        modelAndView.addObject("name" , trainerName);
        return modelAndView ;
    }

    @GetMapping("/trainers")
    public ModelAndView allTrainers() {
        List<Trainer> trainers = Arrays.asList(trainerService.getAllTrainers());
        trainers.forEach(trainer ->
                trainer.setTeamType(trainer.getTeam().stream()
                        .map((Pokemon p) -> pokemonTypeService.getPokemonType(p.getPokemonTypeId()))
                        .collect(Collectors.toList()))
        );
        Map<String, Object> map = new HashMap<>();
        map.put("trainers", trainers);
        return new ModelAndView("trainers", map);
    }

}
