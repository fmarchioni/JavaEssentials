package java12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeeingCollector
{
    public static void main(String[] args)
    {
        List<Person> list = Arrays.asList(
                new Person(1, "John", 23),
                new Person(2, "Laura", 44),
                new Person(3, "Paul", 18),
                new Person(4, "Elena", 55));

        HashMap<String, Person> result = list.stream().collect(
                Collectors.teeing(
                        Collectors.maxBy(Comparator.comparing(Person::getAge)),
                        Collectors.minBy(Comparator.comparing(Person::getAge)),
                        (e1, e2) -> {
                            HashMap<String, Person> map = new HashMap();
                            map.put("eldest", e1.get());
                            map.put("youngest", e2.get());
                            return map;
                        }
                ));

        System.out.println(result);
    }
    static class Person {
        int i;
        String name;
        int age;
        public Person(int i, String name, int age) {
            this.i = i;
            this.name = name;
            this.age = age;
        }
        public int getAge() { return age;}
        public String getName() { return name;}

        @Override
        public String toString() {
            return "Person{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
