public enum PetType {
    // initialize Pet Types
    DOG(2, 2, 2),
    CAT(1, 3, 2),
    BIRD(0.75, 1, 0.75),
    RABBIT(0.5, 0.5, 1);

    private final double happinessMultiplier;
    private final double hungrinessMultiplier;
    private final double sleepinessMultiplier;

    private PetType(double happinessMultiplier, double hungrinessMultiplier, double sleepinessMultiplier) {
        this.happinessMultiplier = happinessMultiplier;
        this.hungrinessMultiplier = hungrinessMultiplier;
        this.sleepinessMultiplier = sleepinessMultiplier;
    }

    public double getHappinessMultiplier() {
        return happinessMultiplier;
    }
    
    public double getHungrinessMultiplier() {
        return hungrinessMultiplier;
    }

    public double getSleepinessMultiplier() {
        return sleepinessMultiplier;
    }
}
