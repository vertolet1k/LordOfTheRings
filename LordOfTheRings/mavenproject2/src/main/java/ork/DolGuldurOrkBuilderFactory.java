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
public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    private final OrcGearFactory gearFactory;

    public DolGuldurOrkBuilderFactory() {
        this.gearFactory = new DolGuldurGearFactory();
    }

    @Override
    public Ork.OrkBuilder createOrkBuilder() {
        return new Ork.OrkBuilder().strength(70).agility(70).intelligence(35).health(120)
                .weapon(gearFactory.createWeapon()).armor(gearFactory.createArmor()).banner(gearFactory.createBanner());
    }
} 
