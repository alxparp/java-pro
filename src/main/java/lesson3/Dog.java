package lesson3;

public class Dog extends Animal {

    private static final int RUNNING_RESTRICTION = 500;
    private static final int SWIMMING_RESTRICTION = 10;
    private String dogName;

    public Dog(String dogName) {
        super(dogName);
    }

    @Override
    protected void run(int obstacleLength) {
        if (obstacleLength <= RUNNING_RESTRICTION)
            super.run(obstacleLength);
        else
            System.out.println("Собака не може бігти більш ніж " + RUNNING_RESTRICTION + " м.");
    }

    protected void swim(int obstacleLength) {
        if (obstacleLength <= SWIMMING_RESTRICTION)
            System.out.println(dogName + " пройманув " + obstacleLength + " м");
        else
            System.out.println("Собака не може бігти більш ніж " + SWIMMING_RESTRICTION + " м.");
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
