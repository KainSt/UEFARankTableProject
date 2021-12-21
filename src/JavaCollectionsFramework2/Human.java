package JavaCollectionsFramework2;

import java.util.ArrayList;

import java.util.List;

public class Human {
    String name;
    String sex;
    int age;
    ArrayList<Human> kids;

    Human(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.kids = new ArrayList<>();
    }

    Human(String name) {
        this.name = name;
        }

   private String kidsPrint(Human human){
        String kidsList ="";

       for (Human kid : kids) {
           kidsList = kidsList + " " + kid.name;
       }
        return kidsList;
   }

    public String toString(Human human){
        return "Имя: " + human.name+ ", пол: " + human.sex + ", возраст: " + human.age+ ", дети: " + human.kidsPrint(human);
    }

   public static void main(String [] args){

       Human ivan = new Human("ded Ivan", "male", 70);
       Human masha = new Human("babka Masha", "female", 65);
       Human fedya = new Human("papa Fedya", "male", 40);
       Human lesha = new Human("son Lesha");
       Human misha = new Human("son Misha");
       Human mashaJr = new Human("daughter Masha ");
       ivan.kids.add(fedya);
       masha.kids.add(fedya);
       fedya.kids.add(lesha);
       fedya.kids.add(misha);
       fedya.kids.add(mashaJr);

      System.out.println(ivan.toString(ivan));
      System.out.println(masha.toString(masha));
      System.out.println(fedya.toString(fedya));

    }
}



