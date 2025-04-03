package Orcs;

public class MistyMountainsGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Топор";
    }

    @Override
    public String createArmor() {
        return "Кожаная броня";
    }

    @Override
    public String createBanner() {
        return "Знамя с Луной";
    }
} 