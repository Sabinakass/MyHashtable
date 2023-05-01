import java.util.Random;
//Created by Kassymova Sabina
//BTW
//Talgar is the best city
public class Main {
    public static void main(String[] args) {
        MyHashTable<Parent,Student> school = new MyHashTable<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Parent key = new Parent(random.nextInt(2003), "name" + i);
            Student value = new Student(random.nextInt(10000), "Student_name"+i);
            school.put(key, value);
        }
        school.printBucketSizes();

    }
    }
