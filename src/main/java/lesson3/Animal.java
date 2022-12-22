package lesson3;

public abstract class Animal {

    private String animalName;

    protected Animal(String animalName) {
        this.animalName = animalName;
    }

    protected void run(int obstacleLength) {
        System.out.println(animalName + " пробіг " + obstacleLength + " м");
    }

}
