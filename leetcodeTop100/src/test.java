public class test {
    public static void main(String[] args) {
        Integer l1 = 111110;
        Integer l2 = 111110;
        Integer l3 = 20;
        System.out.println(l1 == l2);

        l1 = l1-111100;
        System.out.println(l1 == l3);
        System.out.println(l1);
        System.out.println(l1 == l2);
        String str = "kite";
        System.out.println(str);

        str=str.replace('e','0');
        str=str.replace('i','0');

        str=str.replace('u','0');

        System.out.println(str);
    }
}
