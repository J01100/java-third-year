public class PetOwner {
    private String id;
    private String name;
    private Pet pet;

    public PetOwner(){}

    public void setPet(String petType){
        if (petType.equals("dog"))
            this.pet = new Dog();
        else if (petType.equals("cat"))
            this.pet = new Cat();
    }

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

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


}
