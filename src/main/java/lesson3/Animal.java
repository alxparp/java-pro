package lesson3;

public abstract class Animal {

    private String animalName;
    private static int countAnimal;

    protected Animal(String animalName) {
        this.animalName = animalName;
        ++countAnimal;
    }

    protected void run(int obstacleLength) {
        System.out.println(animalName + " пробіг " + obstacleLength + " м");
    }

    public static int getCountAnimal() {
        return countAnimal;
    }

}
