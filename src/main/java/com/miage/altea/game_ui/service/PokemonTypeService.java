package com.miage.altea.game_ui.service;

import com.miage.altea.game_ui.bo.PokemonType;
import com.miage.altea.game_ui.repository.TranslationRepository;

import java.util.List;

public interface PokemonTypeService {

    List<PokemonType> listPokemonsTypes();

    PokemonType getPokemonType(int i);
}