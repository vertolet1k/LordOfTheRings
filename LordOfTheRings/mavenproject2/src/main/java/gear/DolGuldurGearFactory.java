/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gear;

/**
 *
 * @author vika
 */
public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Spear";
    }

    @Override
    public String createArmor() {
        return "Chain Mail";
    }

    @Override
    public String createBanner() {
        return "Spider Banner";
    }
} 
