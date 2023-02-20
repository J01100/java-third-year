
public class Main {
    public static void main(String[] args){

        PetOwner petOwner = new PetOwner();
        petOwner.setId("123");
        petOwner.setName("Jimmy");
        petOwner.setPet("dog");
        petOwner.getDog().setPetName("Goddard");
        petOwner.getDog().setBreed("German Shepherd");

        printDetails(petOwner);

        PetOwner petOwner1 = new PetOwner();

        petOwner1.setId("456");
        petOwner1.setName("Mammy");
        petOwner1.setPet("cat");
        petOwner1.getCat().setPetName("Thomas");
        petOwner1.getCat().setLifeCounter(3);
        petOwner1.getCat().setRunSpeed(16.7);

        printDetails(petOwner1);

    }

    public static void printDetails(PetOwner petOwner){
        System.out.printf("Pet Owner Name: %s\nID: %s\nPet: %s\n",
                petOwner.getName(), petOwner.getId(), petOwner.getPet());
        if (petOwner.getPet().equals("Dog")){
            System.out.printf("Dog Name: %s\nDog Breed: %s\nShow love: %s\n",
            petOwner.getDog().getPetName(), petOwner.getDog().getBreed(), petOwner.getDog().showLove());
        } else if (petOwner.getPet().equals("Cat")){
            System.out.printf("Cat Name: %s\nCat Life Counter: %s\nCat Run Speed: %s\nShow love: %s\n",
                    petOwner.getCat().getPetName(), petOwner.getCat().getLifeCounter(),
                    petOwner.getCat().getRunSpeed(), petOwner.getCat().showLove());
        }

        System.out.println("-----------------------");
    }
}
