package com.uguz.game.service;

import com.uguz.game.model.PlayerCharacter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterService {
    Scanner input = new Scanner(System.in);
    List<PlayerCharacter> playerCharacters = new ArrayList<>();

    public void initializingCharacters() {
        playerCharacters.add(new PlayerCharacter(CharacterType.SAMURAY, 5, 21, 15));
        playerCharacters.add(new PlayerCharacter(CharacterType.ARCHER, 7, 18, 20));
        playerCharacters.add(new PlayerCharacter(CharacterType.KNIGHT, 8, 24, 5));
    }

    public int characterMenu() {
        initializingCharacters();
        displaySelection();
        System.out.print("Please Enter The ID Of Your Choice : ");
        return input.nextInt();
    }

    public PlayerCharacter selectCharacter() {
        int cha = characterMenu();
        for (PlayerCharacter character : playerCharacters) {
            if (character.getCharacterType().id == cha) {
                return character;
            }
        }
        return null;
    }

    public void displaySelection() {
        System.out.println("Please Select a Character ");
        for (PlayerCharacter playerCharacter : playerCharacters) {
            System.out.println(" ID: " + playerCharacter.getCharacterType().id
                    + "\tName Of Character: " + playerCharacter.getCharacterType().name
                    + "\tDamage:  " + playerCharacter.getDamage()
                    + "\tHealthy: " + playerCharacter.getHealth()
                    + "\tMoney:   " + playerCharacter.getMoney());
        }
    }


}
