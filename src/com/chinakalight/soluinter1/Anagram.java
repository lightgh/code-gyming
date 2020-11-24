package com.chinakalight.soluinter1;

/**
 * @author - Chinaka .I. Light <ichinaka@byteworks.com.ng>
 * Date: 10/1/2020
 */
public class Anagram
{
    public static Boolean isAnagram(String a, String b) {
        boolean outcome = true;

        if(a == null ||  b == null){
            return a == b;
        }

        if(a.length() != b.length()){
            return false;
        }

        char[] stringAChar = a.toLowerCase().toCharArray();
        char[] stringBChar = b.toLowerCase().toCharArray();

        for(int i = 0; i < stringAChar.length; i++){
            char thisC = stringAChar[i];
            boolean foundAny = isInArray(thisC, stringBChar);
            if(foundAny == false){
                return false;
            }
        }
        return outcome;
    }

    static boolean isInArray(char a, char [] baseArray){
        boolean found = false;
        for (char thisC : baseArray
             ) {
            if(thisC == a){
                found = true;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String a = "School master";
        String b = "the classroom";
        System.out.println(isAnagram(a, b));
    }
}
