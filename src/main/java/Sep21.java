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

    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println("Before: " + address);
        System.out.println("After: " + defangIPaddr(address));
    }
}
