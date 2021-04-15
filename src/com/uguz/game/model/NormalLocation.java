package com.uguz.game.model;

import com.uguz.game.service.PlayerService;

public abstract class NormalLocation extends Location {

    public NormalLocation(PlayerService playerService, String name) {
        super(playerService);
        this.name = name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }

}
