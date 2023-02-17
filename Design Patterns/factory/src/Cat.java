public class Cat implements Pet {
    public Cat(){}
    private Double runSpeed;
    private Integer lifeCounter;

    @Override
    public String showLove() {
        return "Keeps purring!";
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
}
