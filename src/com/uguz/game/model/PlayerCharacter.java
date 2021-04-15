package com.uguz.game.model;

import com.uguz.game.service.CharacterType;

public class PlayerCharacter {
    int damage;
    int health;
    int money;
    CharacterType characterType;

    public PlayerCharacter() {
    }

    public PlayerCharacter(CharacterType characterType, int damage, int health, int money) {
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.characterType = characterType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "damage=" + damage +
                ", healthy=" + health +
                ", money=" + money +
                ", characterType=" + characterType +
                '}';
    }
}
