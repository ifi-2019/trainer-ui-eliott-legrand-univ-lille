package com.ifi.trainer_ui.trainers.service;

import com.ifi.trainer_ui.pokemonTypes.service.PokemonTypeService;
import com.ifi.trainer_ui.trainers.bo.Pokemon;
import com.ifi.trainer_ui.trainers.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    private PokemonTypeService pokemonService;

    private RestTemplate restTemplate;

    private String trainerServiceUrl;

    @Autowired
    @Qualifier("trainerApiRestTemplate")
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        var url = trainerServiceUrl + "/trainers/";
        var trainers = restTemplate.getForObject(url, Trainer[].class);
        System.out.println(".................................");

        System.out.println(trainers);
        Arrays.sort(trainers);
        return Arrays.asList(trainers);
    }


    @Override
    public Trainer getTrainer(String name) {
        var url = trainerServiceUrl + "/trainers/{name}";
        Trainer  t = restTemplate.getForObject(url, Trainer.class, name);
        return t;
    }


    @Value("${trainer.service.url}")
    void setTrainerServiceUrl(String pokemonServiceUrl) {
        this.trainerServiceUrl = pokemonServiceUrl;
    }

    @Autowired
    void setPokemonService(PokemonTypeService pokemonService) {
        this.pokemonService = pokemonService;
    }

}
