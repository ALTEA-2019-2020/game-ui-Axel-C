package com.miage.altea.game_ui.trainers;


public interface TrainerService {
    Trainer[] getAllTrainers();
    Trainer getTrainerByName(String name);
}