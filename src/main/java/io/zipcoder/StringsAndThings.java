package io.zipcoder;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringUtils;
/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        //create a counter
        int countYZ = 0;
        //move through a for-each loop, seeking the output after you split by spaces
        for (String splitInput : input.split(" ")) {
            //seek the number of words that end in y or z
            //splitInput.charAt(splitInput.length - 1)
            if (splitInput.endsWith("y") || splitInput.endsWith("z")){
                //add to the counter if they do
                countYZ++;
            }
        }
        return countYZ;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        //find all examples of remove, and replace them with nothing
        //return
        return base.replace(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        //take out each specific occurrence of "is" and "not"
        //the \\b looks for any occurrence, meaning "is" can be taken out of "this"
        //with \\b, "this" will be ignored
        //assign the number of times this happens to an int
        int isCounter = input.split("\\bis").length;
        int notCounter = input.split("\\bnot").length;
        //return if the ints are equal
        return isCounter == notCounter;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */


    public Boolean gIsHappy(String input) {
        /*MY ORIGINAL METHOD
        boolean happy = false;
        for (int i = 0; i <= input.length() - 2; i++) {
            //it's a little broken, but you can easily see the number of times
            //g and g appear in the following method
            if (input.charAt(i) == 'g' && input.charAt(i + 1) == 'g') {
                happy = true;
                //however, even one occurrence of g appearing alone returns false
            } else if (input.charAt(i) == 'g' && input.charAt(i - 1) != 'g') {
                happy = false;
                break;
            }
        }
        return happy;*/

        /*RETHINKING WITH STRINGBUILDER INSPIRATION FROM MANNY
        //Make a String Builder
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= input.length() - 1; i++){
            //check to see if there are two consecutive g's at the current value
            if(input.charAt(i) == 'g' && input.charAt(i + 1) == 'g'){
                //if so, add to the counter to skip it
                i++;
            } else {
                //if not, put it in the string builder
                sb.append(input.charAt(i));
            }
        }
        //currently, there should be NO occurrences of double g in the string
        //run through the new String from String Builder
        for(int i = 0; i <= sb.length(); i++)
            //if there is one g remaining, return false since it is not happy
            if(sb.charAt(i) == 'g') {
                return false;
                //if there are no g's in the string, return true since you took out all the happy g's
            } else if (sb.toString().indexOf('g') == -1)
                return true;
            //all other cases should return true
        return true;*/


        //looked to replace StringBuilder with a simple replace command
        //similarly to the method above, you can use replace all gg's with nothing rather than the first for loop


        String replaceString = input.replace("gg","");
        //run the same for loop above, checking for g's or no g's
        for(int i = 0; i <= replaceString.length(); i++)
            if(input.charAt(i) == 'g') {
                return false;
            } else if (replaceString.indexOf('g') == -1)
                return true;
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int tripleCounter = 0;
        for(int i = 0; i <= input.length() - 2; i++){
            //same, it's easy to see if three characters appear in a row with a similar method
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2))
            tripleCounter++;
        }
        return tripleCounter;
    }
}

