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

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0";
        System.out.println(compareVersion(version1, version2));
    }
}
