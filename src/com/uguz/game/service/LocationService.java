package com.uguz.game.service;

import com.uguz.game.model.*;

import java.util.Scanner;

public class LocationService {
    Scanner input = new Scanner(System.in);
    Location location;

    public void locationSelected(PlayerService playerService) {

        while (true) {
            locationSelect(playerService);
            location.setPlayerService(playerService);
            if (isWinTheGame(playerService)) break;
            if (!location.getLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }

    private boolean isWinTheGame(PlayerService playerService) {
        if (location.getName().equals("Safe House")) {
            if (playerService.getPlayer().getInventory().isItemCompleted()) {
                System.out.println("!!! Congratulations You Won The Game !!!");
                return true;
            }
        }
        return false;
    }

    public void locationSelect(PlayerService playerService) {
        switch (locationMenu()) {
            case 1 -> location = new SafeHouse(playerService);
            case 2 -> location = new Cave(playerService);
            case 3 -> location = new Forest(playerService);
            case 4 -> location = new River(playerService);
            case 5 -> location = new ToolStore(playerService);
            default -> throw new IllegalArgumentException("Is not valid");
        }
    }

    public int locationMenu() {
        displayLocation();
        System.out.print("Please Enter Where You Want To Go : ");
        return input.nextInt();
    }

    public void displayLocation() {
        System.out.println("\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("\nPlease Select  Location !!!");
        System.out.println("1-Safe House");
        System.out.println("2-Cave");
        System.out.println("3-Forest");
        System.out.println("4-River");
        System.out.println("5-Store");
    }
}
