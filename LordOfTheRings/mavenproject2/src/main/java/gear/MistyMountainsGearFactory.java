/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gear;

/**
 *
 * @author vika
 */
public class MistyMountainsGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Axe";
    }

    @Override
    public String createArmor() {
        return "Leather Armor";
    }

    @Override
    public String createBanner() {
        return "Moon Banner";
    }
} 
