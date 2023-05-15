import java.util.Objects;

/**
 * Simulates a virutal Pet.
 * 
 * <pre>
 * Contatins all the Methods and Attributes to interact with the virtualPet.
 * </pre>
 * 
 * @version 1.0
 */
public class Pet {
    private final String name;
    private final PetType type;
    private int happiness;
    private int hungriness;
    private int sleepiness;

    /**
     * Constructor for a Pet.
     * 
     * <pre>
     * Sets Pet Attributes to defualt values.
     * happiness == 5
     * hungriness == 3
     * sleepiness == 1
     * </pre>
     * 
     * @param name cannot be null.
     * @param type cannot be null.
     */
    public Pet(String name, PetType type) {
        // default constructor
        if (type == null) throw new IllegalArgumentException("PetType cannot be null!");
        this.type = type;

        if (name == null || name.equals("")) throw new IllegalArgumentException("Name cannot be null or empty!");
        this.name = name;

        // set property defaults
        this.happiness = 5;
        this.hungriness = 3;
        this.sleepiness = 1;
    }

    /**
     * Generates flat copy of a Pet {other}.
     * 
     * @param other
     */
    public Pet(Pet other) {
        // copy constructor
        if (other == null) throw new IllegalArgumentException("Pet to copy cannot be null!");
        this.name = other.getName();
        this.type = other.getType();
        this.happiness = other.getHappiness();
        this.hungriness = other.getHungriness();
        this.sleepiness = other.getSleepiness();
    }

    // getter methods
    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return name
     */
    public PetType getType() {
        return this.type;
    }

    /**
     * @return happiness
     */
    public int getHappiness() {
        return this.happiness;
    }

    /**
     * @return hungriness
     */
    public int getHungriness() {
        return this.hungriness;
    }

    /**
     * @return sleepiness
     */
    public int getSleepiness() {
        return this.sleepiness;
    }

    /**
     * True if happiness >= 8 else false.
     * 
     * @return boolean
     */
    public boolean isHappy() {
        if (this.happiness >= 8) return true;
        return false;
    }

    /**
     * True if happiness greater or equal 2 else false.
     * 
     * @return boolean
     */
    public boolean isSad() {
        if (this.happiness <= 2) return true;
        return false;
    }

    /**
     * Sadness corresponds to 10 - happiness.
     * 
     * @return sadness
     */
    public int getSadness() {
        return (10 - this.happiness);
    }

    // setter methods
    /**
     * Changes Happiness attribute.
     * 
     * <pre>
     * If the new calculated happiness is lower 10 and greater 0 the new value gets accepted.
     * In the other cases the new value is going to be 0 or 10.
     * </pre>
     * 
     * @param change increasing/decreasing value
     * @return new value for happiness
     */
    public int changeHappiness(int change) {
        if (this.happiness + change > 10) 
            this.happiness = 10;

        if (this.happiness + change < 0) 
            this.happiness = 0;

        if (this.happiness + change <= 10 && this.happiness + change >= 0) 
            this.happiness = this.happiness + change;

        return this.happiness;
    }

    /**
     * Changes Hungriness attribute.
     * 
     * <pre>
     * If the new calculated hungriness is lower 10 and greater 0 the new value gets accepted.
     * In the other cases the new value is going to be 0 or 10.
     * </pre>
     * 
     * @param change increasing/decreasing value
     * @return new value for hungriness
     */
    public int changeHungriness(int change) {
        if (this.hungriness + change > 10) 
            this.hungriness = 10;

        if (this.hungriness + change < 0) 
            this.hungriness = 0;

        if (this.hungriness + change <= 10 && this.hungriness + change >= 0) 
            this.hungriness = this.hungriness + change;

        return this.hungriness;
    }

    /**
     * Changes Sleepiness attribute.
     * 
     * <pre>
     * If the new calculated sleepiness is lower 10 and greater 0 the new value gets accepted.
     * In the other cases the new value is going to be 0 or 10.
     * </pre>
     * 
     * @param change increasing/decreasing value
     * @return new value for sleepiness
     */
    public int changeSleepiness(int change) {
        if (this.sleepiness + change > 10) 
            this.sleepiness = 10;

        if (this.sleepiness + change < 0) 
            this.sleepiness = 0;

        if (this.sleepiness + change <= 10 && this.sleepiness + change >= 0) 
            this.sleepiness = this.sleepiness + change;

        return this.sleepiness;
    }

    /**
     * Method to compare this Pet deeply with a given {other} Pet.
     * 
     * <pre>
     * True if Pets are equal. False if Pets are not equal.
     * </pre>
     * 
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        // standard comparisons
        if (this == other)
            return true;
        if(other == null)
            return false;
        if (getClass() != other.getClass())
            return false;
        
        // special comparisons for the Pet class
        Pet otherPet = (Pet) other;

        if (!this.name.equals(otherPet.getName()))
            return false;
        if (!Objects.equals(this.type, otherPet.getType()))
            return false;
        if (this.happiness != otherPet.getHappiness())
            return false;
        if (this.hungriness != otherPet.getHungriness())
            return false;
        if (this.sleepiness != otherPet.getSleepiness())
            return false;

        return true;
    }

    /**
     * String representation of Pet.
     * 
     * <pre>
     * Emoji represents happiness of pet.
     * :-| == Normal
     * :-) == isHappy() == true
     * :-( == isSad() == true
     * </pre>
     * 
     * @return String representation
     */
    public String toString() {
        // find out emojy
        String emojy = ":-|";
        if (isHappy()) emojy = ":-)"; 
        if (isSad()) emojy = ":-("; 

        return this.name + " " + emojy + " " + this.type + ": Ha:" + this.happiness + ", Hu:" + this.hungriness + ", Sl: " + this.sleepiness;
    }

    /**
     * Plays with Pet.
     * 
     * <pre>
     * Changes all attributes of Pet following the rules of the specific PetType.
     * </pre>
     * 
     * @see PetType
     */
    public void play() {
        changeHappiness(calcAttributeChange(this.happiness, this.type.getHappinessMultiplier(), +2));
        changeHungriness(calcAttributeChange(this.hungriness, this.type.getHungrinessMultiplier(), +2));
        changeSleepiness(calcAttributeChange(this.sleepiness, this.type.getSleepinessMultiplier(), +2));
    }

    /**
     * Feeds the Pet.
     * 
     * <pre>
     * Changes all attributes of Pet following the rules of the specific PetType.
     * </pre>
     * 
     * @see PetType
     */
    public void eat() {
        changeHappiness(calcAttributeChange(this.happiness, this.type.getHappinessMultiplier(), +1));
        changeHungriness(calcAttributeChange(this.hungriness, this.type.getHungrinessMultiplier(), -2));
        changeSleepiness(calcAttributeChange(this.sleepiness, this.type.getSleepinessMultiplier(), +1));
    }

    /**
     * Lets Pet sleep.
     * 
     * <pre>
     * Changes all attributes of Pet following the rules of the specific PetType.
     * </pre>
     * 
     * @see PetType
     */
    public void sleep() {
        changeHappiness(calcAttributeChange(this.happiness, this.type.getHappinessMultiplier(), -2));
        changeHungriness(calcAttributeChange(this.hungriness, this.type.getHungrinessMultiplier(), +2));
        changeSleepiness(calcAttributeChange(this.sleepiness, this.type.getSleepinessMultiplier(), -2));
    }

    private int calcAttributeChange(int startValue, double multiplier, int change) {
        // calculate amout to rise or lower attribute
        return (int) Math.round((startValue + multiplier * change) - startValue);
    }
}
