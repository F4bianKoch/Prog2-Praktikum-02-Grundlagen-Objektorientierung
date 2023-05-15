/**
 * Enum for different Pet Types.
 * 
 * <pre>
 * Every PetType has multiple porperties that manage further identificaton.
 * </pre>
 * 
 * @version 1.0
 */
public enum PetType {
    // initialize Pet Types
    DOG(2, 2, 2),
    CAT(1, 3, 2),
    BIRD(0.75, 1, 0.75),
    RABBIT(0.5, 0.5, 1);

    // declare enum attributes
    private final double happinessMultiplier;
    private final double hungrinessMultiplier;
    private final double sleepinessMultiplier;

    /**
     * Constructor for PetType.
     * 
     * <pre>
     * initializes the following Attributes without any further logic.
     * </pre>
     * 
     * @param happinessMultiplier
     * @param hungrinessMultiplier
     * @param sleepinessMultiplier
     * 
     * @see PetType
     */
    private PetType(double happinessMultiplier, double hungrinessMultiplier, double sleepinessMultiplier) {
        // default constructor
        this.happinessMultiplier = happinessMultiplier;
        this.hungrinessMultiplier = hungrinessMultiplier;
        this.sleepinessMultiplier = sleepinessMultiplier;
    }

    // getter Methods
    /**
     * @return happinessMultiplier
     */
    public double getHappinessMultiplier() {
        return happinessMultiplier;
    }
    
    /**
     * @return hungrinessMultiplier
     */
    public double getHungrinessMultiplier() {
        return hungrinessMultiplier;
    }

    /**
     * @return sleepinessMultiplier
     */
    public double getSleepinessMultiplier() {
        return sleepinessMultiplier;
    }
}
