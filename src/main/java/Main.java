import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Complete the positiveMultiplier method such that it throws an IllegalArgumentException
        // if the input number is less than zero and returns the input squared (input x input) otherwise.

        System.out.println(positiveMultiplier(5));

        List<String> words = new ArrayList<>(List.of("ABCD", "12345", "Hello"));

       for (String s : wordTransformation(words, 2)) {
           System.out.println(words);
       }

       String[] letters = new String[]{"a", "b", "a", "c", "b"};

       wordMultiple(letters);

       /*
        input ["a", "b", "a", "c", "b"]
        output {"a": true, "b": true, "c": false}

        input ["c", "b", "a"]
        output {"a": false, "b": false, "c": false}

        input ["c", "c", "c", "c"]
        output {"c": true}
        */

    }

    public static int positiveMultiplier(int input) {
        if (input < 0) throw new IllegalArgumentException("Input must be higher than or equal to 0");
        return (int) Math.pow(input, 2);
    }

    private static List<String> wordTransformation(List<String> words, int n) {

        boolean removeFirst = true;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < words.size(); j++) {
                String word = words.get(j);
                if (removeFirst && word.length() >1) {
                    String newWord = word.substring(1);
                    words.set(j, newWord);

                } else if(!removeFirst && word.length() > 1) {
                    String newWord = word.substring(0, word.length()-1);
                    words.set(j, newWord);
                }

                removeFirst = !removeFirst;

            }

        }
        return words;
    }

    public static Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Boolean> result = new HashMap<>();

        //input ["a", "b", "a", "c", "b"]

        for (String s : strings) {
            if (!result.containsKey(s)) {
                result.put(s, false);
            } else if(result.get(s) == false) {
                result.put(s, true);
            }
        }

        return result;
    }

    public static String rps(String p1, String p2) {

        if (p1.equals(p2)) return "Draw!";

        boolean rs = p1.equals("rock") && p2.equals("scissors");
        boolean pr = p1.equals("paper") && p2.equals("rock");
        boolean tp = p1.equals("scissors") && p2.equals("paper");

        if(rs || pr || tp) return "Player 1 won!";

        return "Player 2 won";

    }


}
