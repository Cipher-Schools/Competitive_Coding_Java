package recursion;


import java.util.ArrayList;
import java.util.List;

public class PrintKeyPadCombinations {

public static String getValue(char c) {
    if(c == '2') {
        return "abc";
    }

    if(c == '3') {
        return "def";
    }

    return "";
}

public static List<String> letterCombinations(String digits) {

    if(digits.length() == 0) {

        ArrayList<String> emptyList = new ArrayList<>();
        emptyList.add("");
        return emptyList;
    }
    String firstCharacterValue = getValue(digits.charAt(0));

    List<String> smallerProblemCombinations =
            letterCombinations(digits.substring(1));

    ArrayList<String> ans = new ArrayList<>();

    for(int i= 0; i < firstCharacterValue.length(); i++) {
        for(int j = 0; j < smallerProblemCombinations.size(); j++) {
            String combination = firstCharacterValue.charAt(i)
                    + smallerProblemCombinations.get(j);
            ans.add(combination);
        }
    }

    return ans;
}


    public static void main(String[] args) {

        List<String> list =
                letterCombinations("23");

        for(String str : list) {
            System.out.println(str);
        }

    }
}
