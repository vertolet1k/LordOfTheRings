/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ork;

/**
 *
 * @author vika
 */
public class Ork {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private int strength;    
    private int agility;     
    private int intelligence; 
    private int health;       
    
    private Ork() {}
    
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
    
    public int getIntelligence() { 
        return intelligence; 
    }
    
    public int getHealth() { 
        return health; 
    }
    
    public static class OrkBuilder {
        private Ork ork;
        
        public OrkBuilder() {
            ork = new Ork();
        }
        
        public OrkBuilder name(String name) {
            ork.name = name;
            return this;
        }
        
        public OrkBuilder weapon(String weapon) {
            ork.weapon = weapon;
            return this;
        }
        
        public OrkBuilder armor(String armor) {
            ork.armor = armor;
            return this;
        }
        
        public OrkBuilder banner(String banner) {
            ork.banner = banner;
            return this;
        }
        
        public OrkBuilder strength(int strength) {
            ork.strength = Math.min(100, Math.max(1, strength));
            return this;
        }
        
        public OrkBuilder agility(int agility) {
            ork.agility = Math.min(100, Math.max(1, agility));
            return this;
        }
        
        public OrkBuilder intelligence(int intelligence) {
            ork.intelligence = Math.min(50, Math.max(1, intelligence));
            return this;
        }
        
        public OrkBuilder health(int health) {
            ork.health = Math.min(200, Math.max(50, health));
            return this;
        }
        
        public Ork build() {
            return ork;
        }
    }
    
    @Override
    public String toString() {
        return "Ork{" + "name='" + name + '\'' + ", weapon='" + weapon + '\'' + ", armor='" + armor + '\'' +
                ", banner='" + banner + '\'' + ", strength=" + strength + ", agility=" + agility +
                ", intelligence=" + intelligence + ", health=" + health + '}';
    }
} 
