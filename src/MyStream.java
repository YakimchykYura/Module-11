import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.Arrays.stream;


public class MyStream {
    public String newNames(List<String> oldNames) {

         String result = (oldNames).stream()
                .filter(string -> oldNames.indexOf(string) % 2 != 0)
                 .map(string -> oldNames.indexOf(string) + ". " + string + ", ")
                 .collect(Collectors.joining());

        return result.substring(0, result.lastIndexOf(","));

    }
    public List<String> namesToUpperCase(List<String> oldNames) {

        List<String> namesToUpperCase = oldNames.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        return namesToUpperCase;
    }
    public void searchFigure(String[] string) {

          String result = Arrays.asList(string).stream()
                 .flatMap(f -> stream(f.split(", ")))
                 .sorted(Comparator.comparingInt(Integer::parseInt))
                  .collect(Collectors.joining(", ", "\"", "\""));

        System.out.println(result);
    }

    public Stream<Long> streamIterator(long a, long c, long m, long seed) {

        Stream<Long> result = Stream.iterate(seed, x -> (a * x + c) % m);
        return result;
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        var initialValue = getNext(firstIterator, secondIterator);

        Stream stream = Stream.iterate(initialValue, item -> getNext(firstIterator, secondIterator))
                .takeWhile(item -> item != null);
        return stream;
    }
    private static boolean next = false;
    private static <T> T getNext(Iterator<T> firstIterator, Iterator<T> secondIterator) {
        next = !next;
        if (firstIterator.hasNext() && secondIterator.hasNext()) {
            if (next) {
                return firstIterator.next();
            }
            return secondIterator.next();
        }
        return null;
    }
}