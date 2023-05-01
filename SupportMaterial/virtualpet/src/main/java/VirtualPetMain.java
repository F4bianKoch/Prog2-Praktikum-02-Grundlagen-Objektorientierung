public class VirtualPetMain {
    public static void main(String[] args) {
        Pet rosco;
        Pet morgana;
        Pet rabbit;

        rosco = new Pet("Rosco", PetType.DOG);
        morgana = new Pet("Morgana", PetType.CAT);
        rabbit = new Pet("Rabbit of Caerbannog", PetType.RABBIT);

        System.out.println(rosco.toString()); 
        System.out.println(morgana.toString()); 
        System.out.println(rabbit.toString()); 

        Pet roscoClone;

        roscoClone = new Pet(rosco);
        System.out.println("Equals Method: " + roscoClone.equals(rosco));
        System.out.println("== Method: " + (roscoClone == rosco ? "true" : "false"));
        roscoClone = rosco;
        System.out.println("== Method: " + (roscoClone == rosco ? "true" : "false"));

        PetOwner jimmy;
        PetOwner timmy;

        jimmy = new PetOwner("Jimmy", rosco, rabbit);
        timmy = new PetOwner("Timmy", morgana);

        System.out.println(jimmy.toString());
        System.out.println(timmy.toString());

        PetOwner jimmyClone;

        jimmyClone = new PetOwner(jimmy);

        System.out.println("Equals Method: " + jimmyClone.equals(jimmy));
        System.out.println("== Method: " + (jimmyClone == jimmy ? "true" : "false"));
        System.out.println("Equals Method: " + jimmyClone.getFirstPet().equals(jimmy.getFirstPet()));
        System.out.println("== Method: " + (jimmyClone.getFirstPet() == jimmy.getFirstPet() ? "true" : "false"));

        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < 10 ; i++) {
            jimmy.takeCareOfPets();
            timmy.takeCareOfPets();

            System.out.println("Iteration " + i);

            System.out.println(jimmy.toString());
            System.out.println(timmy.toString());

            System.out.println("-----------------------------------------------------------");
        }
    }
}
