import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MyStream stream = new MyStream();
        List<String> names = new ArrayList<>();
        names.add("Misha");
        names.add("Max");
        names.add("Yura");
        names.add("Nazar");
        names.add("Anna");
        names.add("Victoria");
        names.add("Nina");
        names.add("Lera");
//        stream.newNames(names);
//        stream.namesToUpperCase(names);
//        String[] string = {"1, 2, 0", "4, 5"};
//        stream.searchFigure(string);


//        var endlessStream = stream.streamIterator(25214903917L,11, 2^48L, 1);
//        endlessStream.forEach(System.out::println);
        Stream<Integer> s1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream();
        Stream<Integer> s2 = Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9).stream();
            stream.zip(s1,s2)
                    .forEach(System.out::println);
    }
}