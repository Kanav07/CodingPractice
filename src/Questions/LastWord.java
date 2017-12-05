package Questions;

public class LastWord {
    public static void main(String[] args) {
        String input = " ";

        long start = System.nanoTime();
        //call function here.....
        System.out.println(lengthOfLastWord(input));
        long end = System.nanoTime();

        System.out.println("\nTime taken : " + (end - start));

    }

    public static int lengthOfLastWord(final String a) {
        int size = a.length(), length=0;
        boolean lastWordfound = false;
        if ( size ==0 ) return 0;
        else {
            int reverseCursor = size-1;

            while (reverseCursor >= 0){
                if (a.charAt(reverseCursor)!= ' '){
                    reverseCursor --;
                    length++;
                    lastWordfound = true;
                } else if (lastWordfound == false){
                    reverseCursor--;
                }else {
                    return length;
                }
            }
            return length;
        }
    }
}
