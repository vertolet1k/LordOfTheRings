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
public class MordorOrkBuilderFactory implements OrkBuilderFactory {
    private OrcGearFactory gearFactory;

    public MordorOrkBuilderFactory() {
        this.gearFactory = new MordorGearFactory();
    }

    @Override
    public Ork.OrkBuilder createOrkBuilder() {
        return new Ork.OrkBuilder().strength((int)(100 * 1.3)).agility(50).intelligence(30).health(150)
                .weapon(gearFactory.createWeapon()).armor(gearFactory.createArmor()).banner(gearFactory.createBanner());
    }
} 
