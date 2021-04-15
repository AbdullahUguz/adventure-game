package com.uguz.game.service;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum CharacterType {
    SAMURAY(1, "SAMURAY"),
    ARCHER(2, "ARCHER"),
    KNIGHT(3, "KNIGHT");

    int id;
    String name;

    CharacterType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CharacterType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
