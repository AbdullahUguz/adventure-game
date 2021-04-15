package com.uguz.game.model;

import com.uguz.game.service.MonsterService;
import com.uguz.game.service.PlayerService;

public abstract class BattleLocation extends Location {

    protected MonsterService monsterService = new MonsterService();
    protected Battle battle = new Battle(monsterService, playerService);
    protected String gift;

    public BattleLocation(PlayerService playerService, String name, Monster monster, String award) {
        super(playerService);
        this.name = name;
        this.monsterService.setMonster(monster);
        this.gift = award;
    }

    @Override
    public boolean getLocation() {
        int monsterCount = monsterService.count();
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\nYou are at " + name);
        System.out.println("Be Careful!!! " + monsterCount + " " + monsterService.getMonster().getName() + " live here");
        battle.setLocationName(name);
        battle.setGift(gift);
        battle.setMonsterCount(monsterCount);
        battle.selectPlayerBehavior();
        return battle.isControl();
    }

}
