package io.zipcoder;

import java.lang.String.*;

import org.apache.commons.lang.StringUtils;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.SQLOutput;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */



    public Integer countYZ(String input){
        String arrayStr[] = input.split(" ");
        Integer counter = 0;
        for( String s : arrayStr ){
            if( s.endsWith("y") || s.endsWith("z")){
                counter++;
            }
        }
        //System.out.println( "Salida: " + Arrays.toString(arrayStr) );

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        // System.out.println( "Base: " + base + " - " + "Remove: " + remove );
        String result = base.replaceAll(remove,"");
        return result ;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input)
    {
        System.out.println(input);
        Integer isWords = StringUtils.countMatches(input, "is");
        Integer notWords = StringUtils.countMatches(input, "not");
        Boolean result = isWords.equals(notWords);
        System.out.println("Is: " + isWords + " Not: "+ notWords + " Res: " + result);

        return result;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        System.out.println(input);
        //System.out.println(StringUtils.countMatches(input,"g"));
        String[] dummyArray = input.split("");
        System.out.println( Arrays.toString(dummyArray) );
        for( int i = 0; i < dummyArray.length; i++ ){
            if( !dummyArray[i].equals("g")){
                dummyArray[i] = "x";
            }
        }
        System.out.println( Arrays.toString(dummyArray));
        String str = StringUtils.join(dummyArray,"");
        System.out.println(str);
        str = str.replaceAll("x"," " );
        System.out.println(str);
        str = str.trim().replaceAll(" +", " ");
        System.out.println(str);
        String[] dummyArray2 = str.split(" ");
        System.out.println( Arrays.toString(dummyArray2));
        Boolean flag = false;
        for (String s : dummyArray2){
            if(s.length() > 1){
                flag = true;
            }
            System.out.println(s+"-"+flag);
        }
//        for(int i = 0; i <dummyArray.length; i++){
//            if( dummyArray[i] == "");
//        }
//        System.out.println(Arrays.toString(dummyArray));
        return flag;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        Integer lengthStr = input.length();
        System.out.println(input + "-" + lengthStr);
        String container = String.valueOf(input.charAt(0));
        System.out.println( input.charAt(0) );
        String input2 = input + "h";
        Integer counter = 1;
        Integer secondCounter = 0;
        for (int i = 1; i < input2.length()-1; i++ ){
            System.out.println( i+ "-I:"+input2.charAt(i) + "-C:" + container + "-L:" + container.length() + " C:"+counter + " -- "+secondCounter);
            if ( input2.charAt(i) != input2.charAt(i+1) ){
                container = String.valueOf(input2.charAt(i));
                counter = 0;
            }
            else {
                container = String.valueOf(input2.charAt(i));
                counter++;
                if(counter > 1){
                    secondCounter++;
                }
            }
        }
        System.out.println("End: " + secondCounter);
        return secondCounter;
    }
}
