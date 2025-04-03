/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orcs;

import Gear.*;

/**
 *
 * @author vika
 */
public class MordorOrkBuilderFactory implements OrkBuilderFactory {
    private final OrcGearFactory gearFactory;
    
    public MordorOrkBuilderFactory() {
        this.gearFactory = new MordorGearFactory();
    }
    
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
            .withTribe(Ork.Tribe.MORDOR)
            .withWeapon(gearFactory.createWeapon())
            .withArmor(gearFactory.createArmor())
            .withBanner(gearFactory.createBanner());
    }
}
