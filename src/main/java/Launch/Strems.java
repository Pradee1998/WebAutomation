package Launch;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strems {
    public static void main(String[] args) {


        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Amar");
        arr.add("Akash");
        arr.add("Ameer");
        arr.add("rama");
        arr.add("Krishna");

        long c = arr.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);
        arr.stream().filter(s -> s.length()>4).forEach(s -> System.out.println(s));

    }
    @Test
    public static void convertion()
    {
        Stream.of("Abhishek","ram","Ananda","Rajath","Vinay").filter(s -> s.endsWith("a")).map(s ->s.toUpperCase()).forEach(s -> System.out.println(s)
        );

        Stream.of("Axhishek","ram","Ananda","Rajath","Vinay").filter(s -> s.startsWith("A")).sorted().map(s ->s.toUpperCase()).forEach(s -> System.out.println(s)
        );

    }
    @Test
    public static void merge()
    {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("Amar");
        arr.add("Akash");
        arr.add("Ameer");
        arr.add("rama");
        arr.add("Krishna");
        List<String> names = Arrays.asList("Don", "Madhu", "Vijay", "Rajath");
        Stream<String> stream=Stream.concat(arr.stream(), names.stream());
       //stream.forEach(s -> System.out.println(s));

        boolean falag = stream.anyMatch(s -> s.equalsIgnoreCase("Don"));
        System.out.println(falag);
        Assert.assertTrue(falag);

    }

    @Test
    public static void streamCollet()
    {
        List<String> ls = Stream.of("Abhishek", "ram", "Ananda", "Rajatha", "Vinaya").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());

        System.out.println(  ls.get(0));


        List<Integer> unique = Arrays.asList(3, 5, 6, 4, 3, 4, 5, 7, 8, 9);
        unique.stream().distinct().forEach(s -> System.out.println(s));
    }
}
