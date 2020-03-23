package com.miage.altea.game_ui.bo;

public class Stats {
    private Integer speed;
    private Integer defense;
    private Integer attack;
    private Integer hp;

    public Stats() {
        super();
    }

    public Stats(Integer speed, Integer defense, Integer attack, Integer hp) {
        this.speed = speed;
        this.defense = defense;
        this.attack = attack;
        this.hp = hp;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }
}