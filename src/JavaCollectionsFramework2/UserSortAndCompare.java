package JavaCollectionsFramework2;

import java.util.*;

public class UserSortAndCompare {

    public static void main(String [] args){

        Map<User,String> hashMap = new HashMap<>();


        hashMap.put(new User(25,56000,"Eva"),"worker");
        hashMap.put(new User(39,156000,"Kain"),"boss");
        hashMap.put(new User(39,175000,"Stuart"),"boss");
        hashMap.put(new User(22,32000,"Adel"),"worker");
        hashMap.put(new User(23,45000,"Brine"),"courier");
        hashMap.put(new User(30,40000,"Don"),"driver");
        hashMap.put(new User(32,40000,"Cave"),"postman");

        Map<User,String> bossMap = new TreeMap<>(new salaryComparator());
        Map<User,String> workerMap = new TreeMap<>(new ageComparator());
        Map<User,String> otherMap = new TreeMap<>(new nameComparator());

        Iterator<Map.Entry<User,String>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<User,String> currentIterator = iterator.next();
            System.out.println(currentIterator.toString());
            if(currentIterator.getValue().equals("boss")){
                bossMap.put(currentIterator.getKey(),currentIterator.getValue());
            } else if(currentIterator.getValue().equals("worker")){
                workerMap.put(currentIterator.getKey(),currentIterator.getValue());
            } else{
                otherMap.put(currentIterator.getKey(),currentIterator.getValue());
            }
        }
        System.out.println();
        iterator = bossMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }

        System.out.println();
        iterator = workerMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }

        System.out.println();
        iterator = otherMap.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }


    }
}

class salaryComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

class ageComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getAge() - o2.getAge();
    }
}

class nameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}

class User{
    private int age, salary;
    private String name;

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age= " + age +
                ", salary= " + salary +
                ", name='" + name + '\'' +
                '}';
    }

    public User(int age, int salary, String name) {
        this. age =  age;
        this.salary = salary;
        this.name = name;
    }

}

