import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import static java.util.stream.Collectors.groupingBy;

class Anagram{
  // 코드 45-3 스트림을 적절히 활용하면 깔끔하고 명료해진다. (271쪽)
    public static void main(String[] args) throws IOException {
      Path dictionary = Paths.get(args[0]);
      int minGroupSize = Integer.parseInt(args[1]);

      try (Stream<String> words = Files.lines(dictionary)) {
          words.collect(groupingBy(word -> alphabetize(word)))
                  .values().stream()
                  .filter(group -> group.size() >= minGroupSize)
                  .forEach(g -> System.out.println(g.size() + ": " + g));
      }
  }
  private static String alphabetize(String s) {
      char[] a = s.toCharArray();
      Arrays.sort(a);
      return new String(a);
  }

  // 코드 45-1 사전 하나를 훑어 원소 수가 많은 아나그램 그룹들을 출력한다. (269-270쪽)
    /* public static void main(String[] args) throws IOException {
      File dictionary = new File(args[0]);
      int minGroupSize = Integer.parseInt(args[1]);

      Map<String, Set<String>> groups = new HashMap<>();
      try (Scanner s = new Scanner(dictionary)) {
          while (s.hasNext()) {
              String word = s.next();
              groups.computeIfAbsent(alphabetize(word),
                      (unused) -> new TreeSet<>()).add(word);
          }
      }

      for (Set<String> group : groups.values())
          if (group.size() >= minGroupSize)
              System.out.println(group.size() + ": " + group);
  }

  private static String alphabetize(String s) {
      char[] a = s.toCharArray();
      Arrays.sort(a);
      return new String(a);
  } */

// 코드 45-2 스트림을 과하게 사용했다. - 따라 하지 말 것! (270-271쪽)
  /* public class StreamAnagrams {
    public static void main(String[] args) throws IOException {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(
                    groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    StringBuilder::append).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minGroupSize)
                    .map(group -> group.size() + ": " + group)
                    .forEach(System.out::println);
        }
    } */
}