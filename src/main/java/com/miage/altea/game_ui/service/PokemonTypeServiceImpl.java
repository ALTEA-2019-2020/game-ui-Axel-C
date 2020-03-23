package com.miage.altea.game_ui.service;

import com.miage.altea.game_ui.bo.PokemonType;
import com.miage.altea.game_ui.repository.PokemonTypeRepository;
import com.miage.altea.game_ui.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{
    RestTemplate restTemplate;
    String pokemonServiceUrl;
    String pokemonTypeUrl = "/pokemon-types/";
    PokemonTypeRepository pokemonTypeRepository ;
    TranslationRepository translationRepository ;

    public List<PokemonType> listPokemonsTypes() {
        var list = Arrays.asList(restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/", PokemonType[].class));
        return list != null ? list : new ArrayList<PokemonType>();
    }

    @Override
    public PokemonType getPokemonType(int i) {
        return null;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }

    public void setPokemonTypeRepository(PokemonTypeRepository pokemonTypeRepository) {
        this.pokemonTypeRepository = pokemonTypeRepository;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }

    public void setTranslationRepository(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public TranslationRepository getTranslationRepository() {
        return translationRepository;
    }
}