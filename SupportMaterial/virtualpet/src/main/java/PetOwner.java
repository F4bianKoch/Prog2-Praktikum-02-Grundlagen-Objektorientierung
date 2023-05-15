/**
 * Simulates Owner of one or two virtual Pets.
 * 
 * <pre>
 * Contains all the Methods and Attributes to interact with the Owner.
 * </pre>
 * 
 * @see Pet
 * @version 1.0
 */
public class PetOwner {
    // declaring class Attributes
    private final String name;
    private final Pet firstPet;
    private final Pet secondPet;

    /**
     * Constructor for Owner with 2 Pets.
     * 
     * @param name cannot be null
     * @param firstPet cannot be null
     * @param secondPet
     */
    public PetOwner(String name, Pet firstPet, Pet secondPet) {
        // default constructor - 2 Pets
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be null or empty!");
        if (firstPet == null)
            throw new IllegalArgumentException("fistPet cannot be null!");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }

    /**
     * Constructor for Owner with 1 Pets.
     * 
     * <pre>
     * Sets secondPet to null.
     * </pre>
     * 
     * @param name cannot be null
     * @param firstPet cannot be null
     */
    public PetOwner(String name, Pet firstPet) {
        // default constructor - 1 Pet
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be null or empty!");
        if (firstPet == null)
            throw new IllegalArgumentException("fistPet cannot be null!");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = null;  // set second Pet to null
    }

    /**
     * Generates deep copy of Owner {other}
     * 
     * <pre>
     * Pets are copied too.
     * </pre>
     * 
     * @param other
     */
    public PetOwner(PetOwner other) {
        // copy constructor
        // copy Owner
        if (other == null)
            throw new IllegalArgumentException("Owner to copy cannot be null!");
        this.name = other.name;

        // copy Pets
        this.firstPet = new Pet(other.firstPet);
        if (other.secondPet != null) {
            this.secondPet = new Pet(other.secondPet);
        } else {
            this.secondPet = null;
        }
    }

    // getter Methods
    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return firstPet
     */
    public Pet getFirstPet() {
        return this.firstPet;
    }

    /**
     * @return secondPet
     */
    public Pet getSecondPet() {
        return this.secondPet;
    }

    /**
     * Method to compare this Owner deeply with given {other} Owner.
     * 
     * <pre>
     * True if Owners and thier Pets are equal. False if Owner and their Pets are not equal.
     * </pre>
     * 
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        // standard comparisons
        if (this == other) 
            return true;
        if (other == null)
            return false;
        if (getClass() != other.getClass())
            return false;

        // special comparisons for the PetOwner class
        PetOwner otherPetOwner = (PetOwner) other;

        if (!this.name.equals(otherPetOwner.getName()))
            return false;
        if (!this.firstPet.equals(otherPetOwner.firstPet))
            return false; 
        if (!this.secondPet.equals(otherPetOwner.secondPet))
            return false;
        
        return true;
    }

    /**
     * String representation of Owner.
     * 
     * <pre>
     * Formates states of Owners Pet/s into a string.
     * </pre>
     * 
     * @return String representation
     */
    public String toString() {
        // Displays state of owners pets
        if (secondPet == null)
            return this.name + "\n- First pet: " + firstPet.toString() + "\n- Second pet: none";

        return this.name + "\n- First pet: " + firstPet.toString() + "\n- Second pet: " + secondPet.toString();
    }

    /**
     * Takes care of Pet so that no values drop to 0.
     */
    public void takeCareOfPets() {
        // algorithm to take care of pet/s
        if (firstPet.getHungriness() >= firstPet.getSleepiness() && firstPet.getHungriness() >= firstPet.getSadness()) {
            firstPet.eat();
        } else if (firstPet.getSleepiness() >= firstPet.getHungriness() && firstPet.getSleepiness() >= firstPet.getSadness()) {
            firstPet.sleep();
        } else {
            firstPet.play();
        }

        if (secondPet != null) {
            if (secondPet.getHungriness() >= secondPet.getSleepiness() && secondPet.getHungriness() >= secondPet.getSadness()) {
                secondPet.eat();
            } else if (secondPet.getSleepiness() >= secondPet.getHungriness() && secondPet.getSleepiness() >= secondPet.getSadness()) {
                secondPet.sleep();
            } else {
                secondPet.play();
            }
        }
    }

}
