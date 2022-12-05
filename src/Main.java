
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //task1
        Double[] array1 = {5.0, 7.0, 25.0, 14.0, 10.0, 23.0};
        double average = Arrays.stream(array1).filter(p -> p % 5 == 0).mapToDouble(digit -> digit)
                .average().getAsDouble();
        System.out.println(average);
        //task2
        String[] array2 =
                {"Hello World!",
                "Goodbye Universe!",
                "Hello World!",
                "Welcome to the club!",
                "Nice to meet you!",
                "Welcome to the club!"};
        int uniqueNumber = (int)Arrays.stream(array2).distinct().filter(p -> p.length() > 8).count();
        System.out.println(uniqueNumber);
        //task3
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("keyphrase", 1);
        map1.put("abc", 2);
        map1.put("java", 3);
        map1.put("computers", 4);
        map1.put("coding", 5);
        map1.put("key", 6);
        int sum = map1.keySet().stream().filter(p -> p.length() < 7).map(p -> map1.get(p))
                .mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        //task4
        int[] array3 = {5, 7, 2, 4, 1, 3};
        String result = Arrays
                .stream(Arrays.stream(array3)
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new))
                .collect(Collectors.joining());
        System.out.println(result);
        //task5
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Mark", "Black", 25));
        people.add(new Person("Mark", "Black", 25));
        people.add(new Person("Jack", "Wolf", 41));
        people.add(new Person("Sebastian", "Courtney", 17));
        people.add(new Person("William", "Defo", 30));
        people.add(new Person("Birmintelington", "Orlonto", 68));
        String oldestName = people.stream().filter(p -> p.getFirstName().length() < 15)
                .sorted(Comparator.comparing(Person::getAge).reversed()).findFirst().get().getFirstName();
        System.out.println(oldestName);
    }
}