package com.uguz.game.model;

import com.uguz.game.service.PlayerService;
import com.uguz.game.service.ToolStoreService;

public class ToolStore extends NormalLocation {

    public ToolStore(PlayerService playerService) {
        super(playerService, "Store");
    }

    ToolStoreService storeService = new ToolStoreService(playerService);

    @Override
    public boolean getLocation() {
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\nYou Are At Tool Store ");
        storeService.storeMenu();
        return true;
    }
}
