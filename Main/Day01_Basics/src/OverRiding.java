import java.util.Scanner;

class Animal {
    void makeSound() {
        System.out.println("The animal makes a sound");
    }
}

class Dog extends Animal {
    // Overriding the parent method
    @Override
    void makeSound() {
        System.out.println("The dog barks: Woof, Woof!");
    }
}

class Cow extends Animal {
    // Overriding the parent method
    @Override
    void makeSound() {
        System.out.println("The cow moos: Moo!");
    }
}

class Cat extends Animal {
    // Overriding the parent method
    @Override
    void makeSound() {
        System.out.println("The cat meows: Meow!");
    }
}

public class OverRiding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the base Animal
        Animal myAnimal = new Animal();
        myAnimal.makeSound();

        // Ask for user input to trigger Overriding
        System.out.print("Choose 1 for Dog, 2 for Cat, or 3 for Cow: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            Animal myDog = new Dog();
            myDog.makeSound(); // Prints: The dog barks: Woof, Woof!
        }
        else if (choice == 2) {
            Animal myCat = new Cat();
            myCat.makeSound(); // Prints: The cat meows: Meow!
        }
        else if (choice == 3) {
            Animal myCow = new Cow();
            myCow.makeSound(); // Prints: The cow moos: Moo!
        }
        sc.close();
    }
}