package com.uguz.game.model;

import com.uguz.game.service.CharacterService;
import com.uguz.game.service.CharacterType;

import java.util.Scanner;

public class Player {
    private String name;
    private Inventory inventory;
    private PlayerCharacter playerCharacter;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage() {
        return inventory.getDamage() + playerCharacter.getDamage();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
