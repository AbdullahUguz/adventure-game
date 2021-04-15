package com.uguz.game.model;

import com.uguz.game.service.PlayerService;

public class Forest extends BattleLocation {
    public Forest(PlayerService playerService) {
        super(playerService, "Forest", new Vampire(), "Firewood");
    }
}
