package com.ifi.trainer_ui.controller;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PokemonTypeController {

    @Autowired
    private PokemonTypeService pokemonTypeService;



    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        // TODO
        var modelAndView = new ModelAndView("pokedex");
        modelAndView.addObject("pokedex",pokemonTypeService.listPokemonTypes());
        return modelAndView;
    }

    public PokemonTypeService getPokemonTypeService() {
        return pokemonTypeService;
    }

    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }
}
