import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavamitForEach {
    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("asdf");
        liste.add("run");
        for (String arg : liste) {
            System.out.println(arg);
        }
        liste.forEach(System.out::println);
        liste.forEach((String s) -> System.out.println(s));
    }
}


