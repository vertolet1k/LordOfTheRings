/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gear;

/**
 *
 * @author vika
 */
public class MordorGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Heavy Sword";
    }

    @Override
    public String createArmor() {
        return "Steel Armor";
    }

    @Override
    public String createBanner() {
        return "Red Eye Banner";
    }
} 
