/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orcs;

import java.util.*;

/**
 *
 * @author vika
 */
public class Ork {
    
    public enum Tribe {
        MORDOR,
        DOL_GULDUR,
        MISTY_MOUNTAINS
    }
    
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int mind;
    private int health;
    private Tribe tribe;
    
    Ork(OrkBuilder builder) {
        this.name = builder.name;
        this.weapon = builder.weapon;
        this.armor = builder.armor;
        this.banner = builder.banner;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.mind = builder.mind;
        this.health = builder.health;
        this.tribe = builder.tribe;
    }
    
    public Map<String, Integer> getAttributes() {
        Map<String, Integer> attributes = new HashMap<>();
        attributes.put("Сила", strength);
        attributes.put("Ловкость", agility);
        attributes.put("Интеллект", mind);
        attributes.put("Здоровье", health);
        return attributes;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmor() {
        return armor;
    }

    public String getBanner() {
        return banner;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getMind() {
        return mind;
    }

    public int getHealth() {
        return health;
    }
    
    public Tribe getTribe() {
        return tribe;
    }
}
