package com.uguz.game.service;

import com.uguz.game.model.Player;

import java.util.Scanner;

public class ToolStoreService {
    private PlayerService playerService;
    Scanner input = new Scanner(System.in);
    private String toolName = null;
    private int damage = 0;
    private int price = 0;
    private int armor = 0;

    public ToolStoreService(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void storeDisplay() {
        System.out.println("Money :" + playerService.getPlayer().getPlayerCharacter().getMoney());
        System.out.println("1.Weapons");
        System.out.println("2.Armors");
        System.out.println("3.Exit");
    }

    public void storeMenu() {
        storeDisplay();
        System.out.print("Please Enter Select : ");
        switch (input.nextInt()) {
            case 1:
                buyWeapon();
                break;
            case 2:
                buyArmor();
                break;
            case 3:
                break;
            default:
                throw new IllegalArgumentException("Wrong Choice");
        }
    }

    public void weaponsMenu() {
        System.out.println("\n<-- Weapons Menu -->");
        System.out.println("1. Gun    -->  Money: 25 , Damage: 2");
        System.out.println("2. Sword  -->  Money: 35 , Damage: 3");
        System.out.println("3. Rifle  -->  Money: 45 , Damage: 7");
        System.out.println("4. EXİT ");
    }

    // BUYING WEAPONS
    public void buyWeapon() {
        weaponsMenu();
        System.out.print("Please Select Weapon : ");
        int weaponNumber = input.nextInt();
        initializeWeapon(weaponNumber);
        if (price > 0) {
            buyingWeapon();
        }
    }

    private void buyingWeapon() {
        if (playerService.getPlayer().getPlayerCharacter().getMoney() >= price) {
            playerService.getPlayer().getInventory().setDamage(damage);
            playerService.getPlayer().getInventory().setWeaponName(toolName);
            playerService.getPlayer().getPlayerCharacter().setMoney(playerService.getPlayer().getPlayerCharacter().getMoney() - price);

            System.out.println("You Bought a : " + toolName
                    + "  Previous Damage : "
                    + playerService.getPlayer().getPlayerCharacter().getDamage()
                    + "  New Damage : "
                    + (playerService.getPlayer().getTotalDamage()));

            System.out.println("Remaining Money : " + playerService.getPlayer().getPlayerCharacter().getMoney());
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void initializeWeapon(int weaponNumber) {
        switch (weaponNumber) {
            case 1:
                this.toolName = "Gun";
                this.price = 25;
                this.damage = 2;
                break;
            case 2:
                this.toolName = "Sword";
                this.price = 35;
                this.damage = 3;
                break;
            case 3:
                this.toolName = "Rifle";
                this.price = 45;
                this.damage = 7;
                break;
            case 4:
                System.out.println("Signing Out");
                break;
            default:
                throw new IllegalArgumentException("Incorrect Operation");

        }
    }

    // BUYING ARMORS
    public void armorsMenu() {
        System.out.println("\n<-- Armors Menu -->");
        System.out.println("1. Light    -->  Money: 15 , Damage: 1");
        System.out.println("2. Medium  -->  Money: 25 , Damage: 3");
        System.out.println("3. Heavy  -->  Money: 40 , Damage: 5");
        System.out.println("4. EXİT ");
    }

    public void buyArmor() {
        armorsMenu();
        System.out.print("Please Select Armor : ");
        int armorNumber = input.nextInt();
        initializeArmor(armorNumber);
        if (price > 0) {
            buyingArmor();
        }
    }

    private void buyingArmor() {
        if (playerService.getPlayer().getPlayerCharacter().getMoney() >= price) {
            playerService.getPlayer().getInventory().setArmor(armor);
            playerService.getPlayer().getInventory().setArmorName(toolName);
            playerService.getPlayer().getPlayerCharacter().setMoney(playerService.getPlayer().getPlayerCharacter().getMoney() - price);

            System.out.println("You Bought a : " + toolName
                    + "  Blocked Damage : "
                    + playerService.getPlayer().getInventory().getArmor());

            System.out.println("Remaining Money : " + playerService.getPlayer().getPlayerCharacter().getMoney());
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void initializeArmor(int armorNumber) {
        switch (armorNumber) {
            case 1:
                this.toolName = "Light Armor";
                this.price = 15;
                this.armor = 1;
                break;
            case 2:
                this.toolName = "Medium Armor";
                this.price = 25;
                this.armor = 3;
                break;
            case 3:
                this.toolName = "Heavy Armor";
                this.price = 40;
                this.armor = 5;
                break;
            case 4:
                System.out.println("Signing Out");
                break;
            default:
                throw new IllegalArgumentException("Incorrect Operation");

        }
    }
}
