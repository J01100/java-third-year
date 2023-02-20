public class Dog implements Pet {
    public Dog(){ }
    private String petName;
    private String breed;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String showLove() {
        return "Flash puppy eyes!";
    }
}
