package searching_and_sorting;


public class TwoPeopleMeet {

    /**
     *
     * @param s1
     * @param s2
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isMeet(int s1,
                             int s2, int v1, int v2) {

    if(s1 > s2 && v1 >= v2) {
        System.out.println("They will never meet");
        return false;
    }

    if(s2 > s1 && v2 >= v1) {
        System.out.println("They will never meet");
        return false;
    }

    while(s1 >= s2)
    {
        if(s1 == s2) {
            System.out.println("Yes, they met");
            return true;
        }
        s1 = s1 + v1;
        s2 = s2 + v2;
    }
    return  false;
}


    /**
     * T.C - O(1)
     * S.C - O(1)
     * @param s1
     * @param s2
     * @param v1
     * @param v2
     * @return
     */
    public static boolean isMeetEq(int s1,
                            int s2, int v1, int v2) {


    if(s1 > s2 && v1 >= v2) {
        System.out.println("They will never meet");
        return false;
    }

    if(s2 > s1 && v2 >= v1) {
        System.out.println("They will never meet");
        return false;
    }


    int relativeDistance = Math.abs(s1 - s2);
    int relativeSpeed = Math.abs(v1 - v2);

    if(relativeDistance % relativeSpeed == 0) {
        System.out.println("They met");
        return true;
    }

    return false;



}

    public static void main(String[] args) {

    int s1 = 6;
    int s2 = 4;

    int v1 = 6;
    int v2 = 9;



        System.out.println(isMeetEq(s1, s2, v1, v2));
    }
}
