package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;
    private String pokeServiceUrl;

    public List<PokemonType> listPokemonTypes() {
        // TODO
        PokemonType[] pokeList = restTemplate.getForObject(pokeServiceUrl+"/pokemon-types/", PokemonType[].class);

        return Arrays.asList(pokeList);
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokeServiceUrl = pokemonServiceUrl;
    }
}
