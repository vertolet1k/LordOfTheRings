/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.github.javafaker.Faker;
/**
 *
 * @author vika
 */
public class NameGenerator {
    private static final Faker faker = new Faker();

    public static String generateOrcName() {
        String adjective = faker.lordOfTheRings().location().replaceAll("\\s+.*", "");
        String name = faker.lordOfTheRings().character().replaceAll("\\s+.*", "");
        return adjective + " " + name;
    }
} 
