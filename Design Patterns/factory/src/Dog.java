public class Dog implements Pet {
    public Dog(){}

    @Override
    public String showLove() {
        return "Flash puppy eyes!";
    }

    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
