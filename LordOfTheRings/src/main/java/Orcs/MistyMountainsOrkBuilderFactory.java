package Orcs;

public class MistyMountainsOrkBuilderFactory implements OrkBuilderFactory {
    private final OrcGearFactory gearFactory;
    
    public MistyMountainsOrkBuilderFactory() {
        this.gearFactory = new MistyMountainsGearFactory();
    }
    
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
            .withTribe(Ork.Tribe.MISTY_MOUNTAINS)
            .withWeapon(gearFactory.createWeapon())
            .withArmor(gearFactory.createArmor())
            .withBanner(gearFactory.createBanner());
    }
} 