public class PetOwner {
    // declaring class Attributes
    private final String name;
    private final Pet firstPet;
    private final Pet secondPet;

    // default constructor - 2 Pets
    public PetOwner(String name, Pet firstPet, Pet secondPet) {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be null or empty!");
        if (firstPet == null)
            throw new IllegalArgumentException("fistPet cannot be null!");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = secondPet;
    }

    // default constructor - 1 Pet
    public PetOwner(String name, Pet firstPet) {
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("Name cannot be null or empty!");
        if (firstPet == null)
            throw new IllegalArgumentException("fistPet cannot be null!");

        this.name = name;
        this.firstPet = firstPet;
        this.secondPet = null;  // set second Pet to null
    }

    // copy constructor
    public PetOwner(PetOwner other) {
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
    public String getName() {
        return this.name;
    }

    public Pet getFirstPet() {
        return this.firstPet;
    }

    public Pet getSecondPet() {
        return this.secondPet;
    }

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

    // Displays state of owners pets
    public String toString() {
        if (secondPet == null)
            return this.name + "\n- First pet: " + firstPet.toString() + "\n- Second pet: none";

        return this.name + "\n- First pet: " + firstPet.toString() + "\n- Second pet: " + secondPet.toString();
    }

    // algorithm to take care of pet/s
    public void takeCareOfPets() {
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
