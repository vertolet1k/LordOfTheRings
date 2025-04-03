/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ork;

import gear.*;
/**
 *
 * @author vika
 */
public class MistyMountainsOrkBuilderFactory implements OrkBuilderFactory {
    private final OrcGearFactory gearFactory;

    public MistyMountainsOrkBuilderFactory() {
        this.gearFactory = new MistyMountainsGearFactory();
    }

    @Override
    public Ork.OrkBuilder createOrkBuilder() {
        return new Ork.OrkBuilder().strength(60).agility((int)(100 * 1.3)).intelligence(20).health(100)
                .weapon(gearFactory.createWeapon()).armor(gearFactory.createArmor()).banner(gearFactory.createBanner());
    }
} 
