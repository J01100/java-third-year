public class PetOwner {
    private String id;
    private String name;
    private Dog dog;
    private Cat cat;
    private String pet;
    private boolean hasPet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        if (this.dog == null){
            System.out.println("You don't have a dog.");
        }
        return dog;
    }

    private void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        if (this.cat == null) {
            System.out.println("You don't have a cat.");
        }
        return cat;
    }

    private void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String petType){
        if (this.hasPet){
            System.out.println("You already have a pet!");
            return;
        }
        if (petType.equals("dog")) {
            this.setDog(new Dog());
            this.pet = "Dog";
            this.hasPet = true;
        }
        else if (petType.equals("cat")){
            this.setCat(new Cat());
            this.pet = "Cat";
            this.hasPet = true;
        }
    }
}
