/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import ork.*;

/**
 *
 * @author vika
 */
public class OrcDirector {
    private final OrkBuilderFactory builderFactory;

    public OrcDirector(OrkBuilderFactory builderFactory) {
        this.builderFactory = builderFactory;
    }

    public Ork createBasicOrk(String name) {
        return builderFactory.createOrkBuilder().name(name).build();
    }

    public Ork createLeaderOrk(String name) {
        Ork baseOrk = builderFactory.createOrkBuilder().build();
        return builderFactory.createOrkBuilder().name(name).strength((int)(baseOrk.getStrength() * 1.2))
                .health((int)(baseOrk.getHealth() * 1.5)).build();
    }

    public Ork createScoutOrk(String name) {
        Ork baseOrk = builderFactory.createOrkBuilder().build();
        return builderFactory.createOrkBuilder().name(name).weapon("Bow").agility((int)(baseOrk.getAgility() * 1.3))    
                .health((int)(baseOrk.getHealth() * 0.8)).build();
    }
} 