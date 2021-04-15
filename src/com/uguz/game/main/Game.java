package com.uguz.game.main;

import com.uguz.game.model.PlayerCharacter;
import com.uguz.game.service.LocationService;
import com.uguz.game.service.PlayerService;

import java.util.Scanner;

public class Game {
    PlayerService playerService;
    LocationService locationService =new LocationService();

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome The Adventure Game !!!");
        System.out.print("Please Enter Name : ");
        String playerName = input.nextLine();                    // Gamer entered own name
        playerService = new PlayerService(playerName);

    }
    public void selectedCharacter() {
        playerService.selectedCharacter();
    }

    public void start() {
        showCharacter(playerService.getPlayer().getPlayerCharacter());
    }

    public void showCharacter(PlayerCharacter character){
        if(character == null)
            throw new IllegalArgumentException("Wrong choice!!");
        System.out.println(character);
    }
    public void selectedLocation(){
        locationService.locationSelected(playerService);
    }

}
