package com.uguz.game.model;


import com.uguz.game.service.PlayerService;

public abstract class Location {

    protected String name;
    protected PlayerService playerService;

    public Location(PlayerService playerService) {
        this.playerService = playerService;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public abstract boolean getLocation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
