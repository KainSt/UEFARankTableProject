package JavaCollectionsFramework2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cat {
    String name;
    int age, weight, tail;

    Cat(String name, int age, int weight,int tail) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.tail = tail;

    }

    public String toString(){
        System.out.println("Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tail);
        return "Cat name is " + name + ", age is " + age + ", weight is " + weight + ", tail = " + tail;
    }

    public static void main (String[] args) throws IOException {
        List<Cat> catArray = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String catName;
        int catAge, catWeight, catTail;
        do{
            System.out.println("Write cat's name:");
            catName = reader.readLine();
            if (catName.equals(" ")) {
                break;
            } else {
                System.out.println("Write cat's age:");
                catAge = Integer.parseInt(reader.readLine());
                System.out.println("Write cat's weight:");
                catWeight = Integer.parseInt(reader.readLine());
                System.out.println("Write cat's tail length:");
                catTail = Integer.parseInt(reader.readLine());
                catArray.add(new Cat(catName, catAge, catWeight, catTail));
            }
        } while (true);
        Iterator<Cat> catIterator = catArray.iterator();
        while(catIterator.hasNext()) {
            Cat nowPet = catIterator.next();
            nowPet.toString();
        }

    }

}
