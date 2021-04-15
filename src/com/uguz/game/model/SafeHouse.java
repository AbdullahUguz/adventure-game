package com.uguz.game.model;

import com.uguz.game.service.PlayerService;

public class SafeHouse extends NormalLocation {
    public SafeHouse(PlayerService playerService) {
        super(playerService, "Safe House");
    }

    @Override
    public boolean getLocation() {
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\nYou Are At Safe House ");
        playerService.getPlayer().getPlayerCharacter().setHealth(10);
        System.out.println("Your Healthy Has Been Renewed");
        return true;
    }
}
