package com.uguz.game.model;

import com.uguz.game.constants.GameConstant;
import com.uguz.game.service.MonsterService;
import com.uguz.game.service.PlayerService;

import java.util.Scanner;

public class Battle {
    Scanner input = new Scanner(System.in);
    PlayerService playerService;
    MonsterService monsterService;
    private boolean control;
    private int monsterCount;
    private String gift;
    private String locationName;

    public Battle(MonsterService monsterService, PlayerService playerService) {
        this.monsterService = monsterService;
        this.playerService = playerService;
    }

    public void selectPlayerBehavior() {
        System.out.println("Fight  or   Run");
        System.out.print("Please select your choice  <F> or <R>    --> ");
        control = playerBehavior(input.nextLine());
    }

    public boolean playerBehavior(String choice) {
        if (choice.equalsIgnoreCase(GameConstant.FIGHING)) {
            return isPlayerAlive();
        } else if (choice.equalsIgnoreCase(GameConstant.RUNNING)) {
            System.out.println("You Select Run");
            return true;
        } else {
            throw new IllegalArgumentException("Wrong Choice !!!");
        }
    }

    public boolean combat(int monsterCount) {
        int defaultMonsterHealth = monsterService.getMonster().getHealth();
        for (int i = 0; i < monsterCount; i++) {
            fightersFeatures();
            while (playerService.getPlayer().getPlayerCharacter().getHealth() > 0 && monsterService.getMonster().getHealth() > 0) {
                String choice = playerBehavior();
                if (!(isFighting(choice))) return false;
            }
            if (isMonsterAlive(defaultMonsterHealth, i)) return false;
        }
        return true;
    }

    private boolean isFighting(String choice) {
        if (choice.equalsIgnoreCase(GameConstant.HIT)) {
            playerHit();
            monsterHit();
        } else if (choice.equalsIgnoreCase(GameConstant.RUNNING)) {
            System.out.println("You Select Run");
            return false;
        } else {
            throw new IllegalArgumentException("Wrong Chioce !!!");
        }
        return true;
    }

    private String playerBehavior() {
        String choice;
        System.out.println("\nHit or Run ");
        System.out.print("Please select your choice  <H> or <R>    --> ");
        choice = input.nextLine();
        return choice;
    }

    private void playerHit() {
        System.out.println("\nYou Hit Its !!!");
        /*
        The monster's new life is obtained by extracting the total damage done by the player from the monster's life
         */
        monsterService.getMonster().setHealth(monsterService.getMonster().getHealth()
                - playerService.getPlayer().getTotalDamage());
        afterHit();
    }

    private void monsterHit() {
        if (monsterService.getMonster().getHealth() > 0) {
            System.out.println("\n" + monsterService.getMonster().getName() + " Hit You !!!");
            /*
            At first, the damage to the beast decreases due to the player's armor
            the final damage to the monster is then removed from the player's life
             */
            playerService.getPlayer().getPlayerCharacter().setHealth(playerService.getPlayer().getPlayerCharacter().getHealth()
                    - (monsterService.getMonster().getDamage() - playerService.getPlayer().getInventory().getArmor()));
            afterHit();
        }
    }

    private boolean isPlayerAlive() {
        if (combat(monsterCount)) {
            System.out.println("You Cleared All Enemies In " + locationName);
            itemControl();
        }
        if (playerService.getPlayer().getPlayerCharacter().getHealth() <= 0) {
            System.out.println("You Died ");
            return false;
        }
        return true;
    }

    private boolean isMonsterAlive(int defaultMonsterHealth, int i) {
        if (monsterService.getMonster().getHealth() <= 0) {
            System.out.println("\nYou Killed The " + (i + 1) + ". " + monsterService.getMonster().getName());
            playerService.getPlayer().getPlayerCharacter().setMoney(playerService.getPlayer().getPlayerCharacter().getMoney()
                    + monsterService.getMonster().getAward());
            System.out.println("Your Current Money : " + playerService.getPlayer().getPlayerCharacter().getMoney());
            monsterService.getMonster().setHealth(defaultMonsterHealth);
        } else {
            return true;
        }
        return false;
    }

    public void afterHit() {
        if (playerService.getPlayer().getPlayerCharacter().getHealth() < 0)
            playerService.getPlayer().getPlayerCharacter().setHealth(0);
        if (monsterService.getMonster().getHealth() < 0)
            monsterService.getMonster().setHealth(0);

        System.out.println("Player's health : " + playerService.getPlayer().getPlayerCharacter().getHealth());
        System.out.println(monsterService.getMonster().getName() + "'s health : " + monsterService.getMonster().getHealth());
    }

    public void fightersFeatures() {
        monsterService.enemyFeatures();
        playerService.playerFeatures();
    }

    public void itemControl() {
        if (gift.equals("Food") && !playerService.getPlayer().getInventory().isFood()) {
            System.out.println("Win a " + gift);
            playerService.getPlayer().getInventory().setFood(true);
        } else if (gift.equals("Firewood") && !playerService.getPlayer().getInventory().isFirewood()) {
            System.out.println("Win a " + gift);
            playerService.getPlayer().getInventory().setFirewood(true);
        } else if (gift.equals("Water") && !playerService.getPlayer().getInventory().isWater()) {
            System.out.println("Win a " + gift);
            playerService.getPlayer().getInventory().setWater(true);
        }
    }

    public boolean isControl() {
        return control;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
