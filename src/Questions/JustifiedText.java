//package Questions;

import java.util.ArrayList;
import java.util.Scanner; 

/* QUESTION
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]
 Note: Each word is guaranteed not to exceed L in length.
*/

//Input : 4 I am an object 7
// Expected : I am an ## object ##
// My Code : 

//Input :
/* 7 This is an example of text justification.
16
*/
/*A : [ 5 What must be shall be. ]
B : 12
5 What must be shall be.
12

A : 49  glu muskzjyen ahxkp t djmgzzyh jzudvh raji vmipiz sg rv mekoexzfmq fsrihvdnt yvnppem gidia fxjlzekp uvdaj ua pzagn bjffryz nkdd osrownxj fvluvpdj kkrpr khp eef aogrl gqfwfnaen qhujt vabjsmj ji f opihimudj awi jyjlyfavbg tqxupaaknt dvqxay ny ezxsvmqk ncsckq nzlce cxzdirg dnmaxql bhrgyuyc qtqt yka wkjriv xyfoxfcqzb fttsfs m
144

A : 65 zsrs daqn loajxsl hhqkt slxiziyf rdzfyhgle v fbsmjxhcn pxscg hpxndkqjh cihpirm fhixozfh mgeysxb icvezcc ogcsqhfmbq iwmoiwp hbksjto c xn w otie errlpglazq jj vrtuwlmkh yulxfcuypy oojvw almcvzu exchiodmg cvx gxojn ilzrq pgtnfg mdqtuadbaz whfbvtkip hggcpal lfpbjut lrpi mgaj ttbwvzuhea mwdcehyt sli cdsrkxyou jmd lgsndxffa b tbkibeu crstuepwvv lyday pfnwdqir mlb afgdywx ily snbehhg scndl b etbrae qcrcmqjapf ruwsb jzpfw d nj fiyugwkj dyg hnnhx wlrrui
61

A : 29 lkgyyrqh qrdqusnh zyu w ukzxyykeh zmfqafqle e ajq kagjss mihiqla qekf ipxbpz opsndtyu x ec cbd zz yzgx qbzaffgf i atstkrdph jgx qiy jeythmm qgqvyz dfagnfpwat sigxajhjt zx hwmcgss
178

*/
// Expected : I am an ## object ##
// My Code :

public class JustifiedText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputListSize = sc.nextInt();
        ArrayList<String> inputList = new ArrayList<String>();
        for (int i = 0; i < inputListSize; i++) {
            String x = sc.next();
            inputList.add(x);
        }
        int lineSize = sc.nextInt();


        long start = System.nanoTime();
        //call function here.....
        ArrayList<String> outputList = fullJustify(inputList, lineSize);
        long end = System.nanoTime();
        for (String x : outputList) System.out.println(x);
        System.out.println("\nTime taken : " + (end - start));


    }

    public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {

        ArrayList<String> justifiedText = new ArrayList<String>();
        int spaceRemaining = b, wordsCursorStart = 0, wordsCursorEnd = 0, paddingCursor = 0;
        boolean perfectfit = false;
        String temp, line;
        while (wordsCursorEnd < a.size()) {
            wordsCursorStart = wordsCursorEnd;
            spaceRemaining = b;
            line = "";
            while (spaceRemaining >= 0 && wordsCursorEnd < a.size()) {

                if (spaceRemaining == a.get(wordsCursorEnd).length()) {
                    spaceRemaining -= a.get(wordsCursorEnd++).length();
                    perfectfit = true;
                } else spaceRemaining -= a.get(wordsCursorEnd++).length() + 1;

            }
            if (spaceRemaining < 0) {
                spaceRemaining += a.get((--wordsCursorEnd)).length() + 1;
                if (!perfectfit) {
                    // if not perfect fit then remove the extra space added in the last word
                    spaceRemaining++;
                }
                perfectfit = false;

            } else {
                //last line
                int i;
                for (i = wordsCursorStart; i < wordsCursorEnd-1; i++) {
                    temp = a.get(i);
                    temp = temp.concat(" ");
                    line = line.concat(temp);
                }
                if ( perfectfit == true) line = line.concat(a.get(i));
                else line = line.concat(a.get(i) + " ");
                for (int j = 0; j < spaceRemaining; j++) line = line.concat(" ");
                justifiedText.add(line);
                break;

            }
            wordsCursorEnd--;
            //this space has to be added among the words from wordCursorStart to wordCursorEnd


            if (wordsCursorEnd == wordsCursorStart) {

                line = line.concat(a.get(wordsCursorEnd));
                for (int j = 0; j < spaceRemaining; j++) line = line.concat(" ");
                justifiedText.add(line);


            } else if (spaceRemaining % (wordsCursorEnd - wordsCursorStart) == 0) {
                int blankSpaces = spaceRemaining / (wordsCursorEnd - wordsCursorStart) + 1;
                // this much blank space has to be added after the firsts and the second last word
                for (int i = wordsCursorStart; i < wordsCursorEnd; i++) {
                    temp = a.get(i);
                    for (int j = 0; j < blankSpaces; j++) temp = temp.concat(" ");
                    line = line.concat(temp);
                }
                line = line.concat(a.get(wordsCursorEnd));
                justifiedText.add(line);

            } else {

                int blankSpaces = spaceRemaining / (wordsCursorEnd - wordsCursorStart) + 1;
                int extraBlankSpaces = spaceRemaining % (wordsCursorEnd - wordsCursorStart);
                // this much blank space has to be added after the firsts and the second last word
                for (int i = wordsCursorStart; i < wordsCursorEnd; i++) {
                    temp = a.get(i);
                    for (int j = 0; j < blankSpaces; j++) temp = temp.concat(" ");
                    if (extraBlankSpaces-- > 0) temp = temp.concat(" ");
                    line = line.concat(temp);
                }
                line = line.concat(a.get(wordsCursorEnd));
                justifiedText.add(line);

            }
            wordsCursorEnd++;

        }
        return justifiedText;

    }

}

/* SOLUTION APPROACH

*/