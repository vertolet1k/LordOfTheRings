package Orcs;

public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Копье";
    }

    @Override
    public String createArmor() {
        return "Кольчуга";
    }

    @Override
    public String createBanner() {
        return "Знамя с пауком";
    }
} 