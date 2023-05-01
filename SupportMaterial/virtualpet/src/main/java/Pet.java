import java.util.Objects;

public class Pet {
    private final String name;
    private final PetType type;
    private int happiness;
    private int hungriness;
    private int sleepiness;

    // default constructor
    public Pet(String name, PetType type) {
        if (type == null) throw new IllegalArgumentException("PetType cannot be null!");
        this.type = type;

        if (name == null || name.equals("")) throw new IllegalArgumentException("Name cannot be null or empty!");
        this.name = name;

        this.happiness = 5;
        this.hungriness = 3;
        this.sleepiness = 1;
    }

    // copy constructor
    public Pet(Pet other) {
        if (other == null) throw new IllegalArgumentException("Pet to copy cannot be null!");
        this.name = other.getName();
        this.type = other.getType();
        this.happiness = other.getHappiness();
        this.hungriness = other.getHungriness();
        this.sleepiness = other.getSleepiness();
    }

    // getter methods
    public String getName() {
        return this.name;
    }

    public PetType getType() {
        return this.type;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public int getHungriness() {
        return this.hungriness;
    }

    public int getSleepiness() {
        return this.sleepiness;
    }

    public boolean isHappy() {
        if (this.happiness >= 8) return true;
        return false;
    }

    public boolean isSad() {
        if (this.happiness <= 2) return true;
        return false;
    }

    public int getSadness() {
        return (10 - this.happiness);
    }

    // setter methods
    public int changeHappiness(int change) {
        if (this.happiness + change > 10) 
            this.happiness = 10;

        if (this.happiness + change < 0) 
            this.happiness = 0;

        if (this.happiness + change <= 10 && this.happiness + change >= 0) 
            this.happiness = this.happiness + change;

        return this.happiness;
    }

    public int changeHungriness(int change) {
        if (this.hungriness + change > 10) 
            this.hungriness = 10;

        if (this.hungriness + change < 0) 
            this.hungriness = 0;

        if (this.hungriness + change <= 10 && this.hungriness + change >= 0) 
            this.hungriness = this.hungriness + change;

        return this.hungriness;
    }

    public int changeSleepiness(int change) {
        if (this.sleepiness + change > 10) 
            this.sleepiness = 10;

        if (this.sleepiness + change < 0) 
            this.sleepiness = 0;

        if (this.sleepiness + change <= 10 && this.sleepiness + change >= 0) 
            this.sleepiness = this.sleepiness + change;

        return this.sleepiness;
    }

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

    public String toString() {
        // find out emojy
        String emojy = ":-|";
        if (isHappy()) emojy = ":-)"; 
        if (isSad()) emojy = ":-("; 

        return this.name + " " + emojy + " " + this.type + ": Ha:" + this.happiness + ", Hu:" + this.hungriness + ", Sl: " + this.sleepiness;
    }

    public void play() {
        changeHappiness(calcAttributeChange(this.happiness, this.type.getHappinessMultiplier(), +2));
        changeHungriness(calcAttributeChange(this.hungriness, this.type.getHungrinessMultiplier(), +2));
        changeSleepiness(calcAttributeChange(this.sleepiness, this.type.getSleepinessMultiplier(), +2));
    }

    public void eat() {
        changeHappiness(calcAttributeChange(this.happiness, this.type.getHappinessMultiplier(), +1));
        changeHungriness(calcAttributeChange(this.hungriness, this.type.getHungrinessMultiplier(), -2));
        changeSleepiness(calcAttributeChange(this.sleepiness, this.type.getSleepinessMultiplier(), +1));
    }

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
