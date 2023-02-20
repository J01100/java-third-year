public class Cat implements Pet{
    public Cat(){}
    private String petName;
    private Double runSpeed;
    private Integer lifeCounter;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Double getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(Double runSpeed) {
        this.runSpeed = runSpeed;
    }

    public Integer getLifeCounter() {
        return lifeCounter;
    }

    public void setLifeCounter(Integer lifeCounter) {
        this.lifeCounter = lifeCounter;
    }

    @Override
    public String showLove() {
        return "Keeps purring!";
    }
}
