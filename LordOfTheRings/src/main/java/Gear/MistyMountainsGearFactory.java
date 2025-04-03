/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gear;

/**
 *
 * @author vika
 */
public class MistyMountainsGearFactory implements OrcGearFactory{
    
    public String createWeapon() {
        return "axe";
    }
    
    public String createArmor() {
        return "leather armor";
    }
    
    public String createBanner() {
        return "Moon";
    }
    
}
