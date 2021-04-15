package com.uguz.game.service;

import com.uguz.game.model.Player;
import com.uguz.game.model.PlayerCharacter;

public class PlayerService {
    Player player;
    CharacterService characterService = new CharacterService();

    public PlayerService(String name) {
        this.player = new Player(name);
    }

    public Player getPlayer() {
        return player;
    }

    public void selectedCharacter() {
        PlayerCharacter playerCharacter = characterService.selectCharacter();
        if (playerCharacter == null) {
            throw new IllegalArgumentException("Wrong choice !!");
        }
        player.setPlayerCharacter(playerCharacter);
    }

    public void playerFeatures() {
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("-------- Player Features --------");
        System.out.println("Player Health : " + player.getPlayerCharacter().getHealth());
        System.out.println("Player Damage : " + player.getPlayerCharacter().getDamage());
        System.out.println("Player Money :  " + player.getPlayerCharacter().getMoney());

        if (player.getInventory().getDamage() > 0)
            System.out.println("Weapon : " + player.getInventory().getWeaponName());

        if (player.getInventory().getArmor() > 0)
            System.out.println("Armor : " + player.getInventory().getArmor());
    }


}
