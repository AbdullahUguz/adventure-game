package com.uguz.game.model;

import com.uguz.game.service.PlayerService;

public class Cave extends BattleLocation {
    public Cave(PlayerService playerService) {
        super(playerService, "Cave", new Zombie(), "Food");
    }
}
