package com.app.tester;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;

public class FruitBasket {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter basket size: ");
            int n = sc.nextInt();
            Fruit[] basket = new Fruit[n];
            int counter = 0;
            boolean exit = false;

            while (!exit) {
                System.out.println("\n0. Exit");
                System.out.println("1. Add Mango");
                System.out.println("2. Add Orange");
                System.out.println("3. Add Apple");
                System.out.println("4. Display names of all fruits in the basket");
                System.out.println("5. Display name, color, weight, taste of all fresh fruits");
                System.out.println("6. Display tastes of all stale fruits");
                System.out.println("7. Mark a fruit as stale");
                System.out.println("8. Mark all sour fruits stale");
                System.out.print("Choose an option: ");

                try {
                    int option = sc.nextInt();
                    switch (option) {
                        case 0:
                            exit = true;
                            System.out.println("Bye!");
                            break;

                        case 1:
                        case 2:
                        case 3:
                            // boundary checking
                            if (counter >= basket.length) {
                                System.out.println("Basket is full!");
                                break;
                            }
                            System.out.print("Enter name, weight, color: ");
                            String nm = sc.next();
                            double weight = sc.nextDouble();
                            String color = sc.next();
                            // a newly added fruit is always fresh (set in Fruit constructor)
                            if (option == 1)
                                basket[counter++] = new Mango(nm, weight, color);
                            else if (option == 2)
                                basket[counter++] = new Orange(nm, weight, color);
                            else
                                basket[counter++] = new Apple(nm, weight, color);
                            System.out.println("Fruit added at index " + (counter - 1));
                            break;

                        case 4:
                            for (Fruit f : basket)
                                if (f != null)
                                    System.out.println(f.getName());
                            break;

                        case 5:
                            for (Fruit f : basket)
                                if (f != null && f.isFresh())
                                    System.out.println(f + ", taste=" + f.taste());
                            break;

                        case 6:
                            for (Fruit f : basket)
                                if (f != null && !f.isFresh())
                                    System.out.println(f.getName() + " : " + f.taste());
                            break;

                        case 7:
                            System.out.print("Enter index: ");
                            int idx = sc.nextInt();
                            if (idx < 0 || idx >= counter)
                                System.out.println("Error: invalid index!");
                            else {
                                basket[idx].setFresh(false);
                                System.out.println(basket[idx].getName() + " marked as stale");
                            }
                            break;

                        case 8:
                            for (Fruit f : basket)
                                if (f != null && f.taste().equals("sour"))
                                    f.setFresh(false);
                            System.out.println("All sour fruits marked stale");
                            break;

                        default:
                            System.out.println("Invalid option!");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input: " + e);
                    sc.nextLine(); // discard bad input and continue
                }
            }
        }
    }
}