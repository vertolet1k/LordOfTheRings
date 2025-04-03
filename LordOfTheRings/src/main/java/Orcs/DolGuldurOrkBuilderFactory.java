package Orcs;

public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    private final OrcGearFactory gearFactory;
    
    public DolGuldurOrkBuilderFactory() {
        this.gearFactory = new DolGuldurGearFactory();
    }
    
    @Override
    public OrkBuilder createOrkBuilder() {
        return new OrkBuilder()
            .withTribe(Ork.Tribe.DOL_GULDUR)
            .withWeapon(gearFactory.createWeapon())
            .withArmor(gearFactory.createArmor())
            .withBanner(gearFactory.createBanner());
    }
} 