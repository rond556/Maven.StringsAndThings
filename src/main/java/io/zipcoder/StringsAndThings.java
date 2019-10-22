package io.zipcoder;

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
        boolean happy = false;
        for (int i = 0; i <= input.length() - 2; i++) {
            //it's a little broken, but you can easily see the number of times
            //g and g appear in the following method
            if (input.charAt(i) == 'g' && input.charAt(i + 1) == 'g') {
                happy = true;
                break;
                //however, even one occurrence of g appearing alone returns false
            } else if (input.charAt(i) == 'g' && input.charAt(i) != 'g'){
                happy = false;
                break;
            }
        }
        return happy;
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
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)){
            tripleCounter++;
            }
        }
        return tripleCounter;
    }
}
