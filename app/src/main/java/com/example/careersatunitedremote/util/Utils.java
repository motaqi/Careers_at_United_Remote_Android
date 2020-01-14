package com.example.careersatunitedremote.util;


public class Utils {

    public static String formattingNumber(int number){
        String numberString = "";
        if (Math.abs(number / 1000000) > 1) {
            numberString = (number / 1000000) + "m";

        } else if (Math.abs(number / 1000) > 1) {
            numberString = (number / 1000) + "k";

        } else {
            numberString = number+"";

        }
        return numberString;
    }


}
