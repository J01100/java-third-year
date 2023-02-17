public class Main {
    public static void main(String[] args) {
        PetOwner petOwner = new PetOwner();

        petOwner.setId("123");
        petOwner.setPet("cat");
        petOwner.setName("Jonathan");
        System.out.println(petOwner.getPet().showLove());
        petOwner.getPet()
    }
}