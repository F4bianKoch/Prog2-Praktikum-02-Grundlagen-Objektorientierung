public class VirtualPetMain {
    public static void main(String[] args) {
        // declare 3 Pets
        Pet rosco;
        Pet morgana;
        Pet rabbit;

        // initialise 3 Pets
        rosco = new Pet("Rosco", PetType.DOG);
        morgana = new Pet("Morgana", PetType.CAT);
        rabbit = new Pet("Rabbit of Caerbannog", PetType.RABBIT);

        // print out String reputation of the 3 Pets
        System.out.println(rosco.toString()); 
        System.out.println(morgana.toString()); 
        System.out.println(rabbit.toString()); 

        // clone Pet
        Pet roscoClone;
        roscoClone = new Pet(rosco);

        // check if clone worked
        System.out.println("Equals Method: " + roscoClone.equals(rosco));
        System.out.println("== Method: " + (roscoClone == rosco ? "true" : "false"));
        roscoClone = rosco;
        System.out.println("== Method: " + (roscoClone == rosco ? "true" : "false"));

        // declare Owners
        PetOwner jimmy;
        PetOwner timmy;

        // initialize Owners with Pets
        jimmy = new PetOwner("Jimmy", rosco, rabbit);
        timmy = new PetOwner("Timmy", morgana);

        // print out String reputation of the Owners
        System.out.println(jimmy.toString());
        System.out.println(timmy.toString());

        // clone Owner
        PetOwner jimmyClone;
        jimmyClone = new PetOwner(jimmy);

        // check if clone worked
        System.out.println("Equals Method: " + jimmyClone.equals(jimmy));
        System.out.println("== Method: " + (jimmyClone == jimmy ? "true" : "false"));
        System.out.println("Equals Method: " + jimmyClone.getFirstPet().equals(jimmy.getFirstPet()));
        System.out.println("== Method: " + (jimmyClone.getFirstPet() == jimmy.getFirstPet() ? "true" : "false"));

        // use teke care algorithm 
        // take care for 10 iterations
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < 10 ; i++) {
            jimmy.takeCareOfPets();
            timmy.takeCareOfPets();

            System.out.println("Iteration " + i);

            // print out Owner/Pet state after every iteration
            System.out.println(jimmy.toString());
            System.out.println(timmy.toString());

            System.out.println("-----------------------------------------------------------");
        }
    }
}
