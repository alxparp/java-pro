package lesson3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal cat1 = new Cat("Кіт1");
        Animal cat2 = new Cat("Кіт2");
        Animal cat3 = new Cat("Кіт3");
        Animal cat4 = new Cat("Кіт4");

        Animal dog1 = new Dog("Собака1");
        Animal dog2 = new Dog("Собака2");
        Animal dog3 = new Dog("Собака3");
        Animal dog4 = new Dog("Собака4");
        Animal dog5 = new Dog("Собака5");
        Animal dog6 = new Dog("Собака6");

        List<Animal> listCats = new ArrayList<>();
        listCats.add(cat1);
        listCats.add(cat2);
        listCats.add(cat3);
        listCats.add(cat4);

        List<Animal> listDogs = new ArrayList<>();
        listDogs.add(dog1);
        listDogs.add(dog2);
        listDogs.add(dog3);
        listDogs.add(dog4);
        listDogs.add(dog5);
        listDogs.add(dog6);

        List<Animal> listAnimals = new ArrayList<>();
        listAnimals.addAll(listCats);
        listAnimals.addAll(listDogs);

        System.out.println("Створено " + listCats.size() + " котів");
        System.out.println("Створено " + listDogs.size() + " собак");
        System.out.println("Всього створено " + listAnimals.size() + " тварин");

    }

}
