package lesson3;

public class Cat extends Animal {

    private static final int RUNNING_RESTRICTION = 200;
    private String catName;

    public Cat(String catName) {
        super(catName);
    }

    @Override
    protected void run(int obstacleLength) {
        if (obstacleLength <= RUNNING_RESTRICTION)
            super.run(obstacleLength);
        else
            System.out.println("Кіт не може бігти більш ніж " + RUNNING_RESTRICTION + " м.");
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
