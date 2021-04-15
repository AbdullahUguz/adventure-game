package com.uguz.game.service;

import com.uguz.game.model.Monster;

import java.util.Random;

public class MonsterService {
    Monster monster;

    public int count() {
        Random random = new Random();
        return random.nextInt(this.monster.getMaxNumber()) + 1;
    }

    public void enemyFeatures() {
        System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("-------- " + monster.getName() + " Features --------");
        System.out.println(monster.getName() + " Health : " + monster.getHealth());
        System.out.println(monster.getName() + " Damage : " + monster.getDamage());
        System.out.println(monster.getName() + " Award :  " + monster.getAward());
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

}


