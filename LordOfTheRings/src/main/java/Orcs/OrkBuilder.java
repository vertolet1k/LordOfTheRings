/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Orcs;

import com.github.javafaker.Faker;
import java.util.Locale;

/**
 *
 * @author vika
 */
public class OrkBuilder {
    
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;
    private int agility;
    private int mind;
    private int health;
    Ork.Tribe tribe;
    private Faker faker = new Faker();
    
    public OrkBuilder withTribe(Ork.Tribe tribe) {
        this.tribe = tribe;
        return this;
    }
    
    public OrkBuilder withName(String name) {
        this.name = name;
        return this;
    }
    
    public OrkBuilder withRandomName() {
        this.name = faker.lordOfTheRings().character() + " " + faker.name().lastName();
        return this;
    }
    
    public OrkBuilder withWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }
    
    public OrkBuilder withArmor(String armor) {
        this.armor = armor;
        return this;
    }
    
    public OrkBuilder withBanner(String banner) {
        this.banner = banner;
        return this;
    }
    
    public OrkBuilder withAttributes() {
        if (tribe == null) {
            throw new IllegalStateException("Tribe must be set before generating attributes");
        }
        
        int baseStrength = faker.number().numberBetween(1, 100);
        int baseAgility = faker.number().numberBetween(1, 100);
        int baseMind = faker.number().numberBetween(1, 50);
        int baseHealth = faker.number().numberBetween(50, 200);
        
        switch (tribe) {
            case MORDOR:
                this.strength = (int) (baseStrength * 1.3);
                this.agility = (int) (baseAgility * 0.7);
                break;
            case MISTY_MOUNTAINS:
                this.strength = baseStrength;
                this.agility = (int) (baseAgility * 1.3);
                this.mind = (int) (baseMind * 0.7);
                break;
            case DOL_GULDUR:
                this.strength = baseStrength;
                this.agility = baseAgility;
                break;
        }
        
        this.mind = baseMind;
        this.health = baseHealth;
        
        return this;
    }
    
    public Ork build() {
        if (name == null) {
            withRandomName();
        }
        if (tribe == null) {
            throw new IllegalStateException("Tribe must be set");
        }
        if (strength == 0 || agility == 0 || mind == 0 || health == 0) {
            withAttributes();
        }
        return new Ork(this);
    }
}
