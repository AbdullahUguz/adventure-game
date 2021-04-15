package com.uguz.game.model;

import com.uguz.game.service.PlayerService;

public class River extends BattleLocation {
    public River(PlayerService playerService) {
        super(playerService, "River", new Bear(), "Water");
    }
}
