package Orcs;

public class OrcDirector {
    private final OrkBuilderFactory builderFactory;
    
    public OrcDirector(OrkBuilderFactory builderFactory) {
        this.builderFactory = builderFactory;
    }
    
    public Ork createBasicOrk() {
        return builderFactory.createOrkBuilder()
            .build();
    }
    
    public Ork createLeaderOrk() {
        return builderFactory.createOrkBuilder()
            .withBanner("Знамя командира")
            .build();
    }
    
    public Ork createScoutOrk() {
        OrkBuilder builder = builderFactory.createOrkBuilder();
        String originalWeapon = builder.weapon;
        return builder
            .withWeapon("Лук")
            .build();
    }
} 