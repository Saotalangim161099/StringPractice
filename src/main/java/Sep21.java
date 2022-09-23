import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Sep21 {
    // Given a valid (IPv4) IP address, return a defanged version of that IP address.
    //A defanged IP address replaces every period "." with "[.]".
    public static String defangIPaddr(String address) {
        String res = "";
        for (char c : address.toCharArray()) {
            if (c == '.') {
                res += "[.]";
            } else {
                res += c;
            }
        }
        return res;
    }

    /*Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:
    If version1 < version2, return -1.
    If version1 > version2, return 1.
    Otherwise, return 0.*/
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[j]);
            i++;
            j++;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }

        if (len1 > len2) {
            while (i < len1) {
                if (Integer.parseInt(arr1[i]) > 0) {
                    return 1;
                }
                i++;
            }
        }

        if (len2 > len1) {
            while (j < len1) {
                if (Integer.parseInt(arr2[j]) > 0) {
                    return -1;
                }
                j++;
            }
        }
        return 0;
    }

    // Integer to Roman
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

    // Remove the outer parentheses
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // exclude the case the opening parentheses at the beginning of the string
                if (stack.size() > 0) {
                    res.append(ch);
                }
                stack.push(ch);
            } else {
                // exclude the case the closing parentheses at the end of the string, it needs to be corresponding to one inner parentheses
                if (stack.size() > 1) {
                    res.append(ch);
                }
                stack.pop();

            }
        }
        return res.toString();
    }

    // Number of strings that appear as substrings in word
    public int numOfStrings(String[] patterns, String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= word.length(); i++) {
            for (int j = i; j <= word.length(); j++) {
                set.add(word.substring(i, j));
            }
        }
        int res = 0;
        for (String p : patterns) {
            if (set.contains(p)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
