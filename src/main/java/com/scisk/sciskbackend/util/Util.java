package com.scisk.sciskbackend.util;

import java.util.Objects;

public class Util {

    public static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    public static enum PASSWOR_STATE {INVALID, WEAK, STRONG};
    public static int OTP_LENGTH = 6;
    public static long OTP_DURATION = 10;

    /**
     * Teste l'adresse email envoyée en paramètre et retourne true si
     * elle est correcte et false dans le cas contraire
     * @param email L'adresse email à tester
     * @return true si l'adresse est correct et false dans le cas contraire
     */
    public static boolean isEmailCorrect(String email) {
        if (Objects.isNull(email)) {
            return false;
        }
        return email.matches(EMAIL_REGEX);
    }

    /**
     * Evalue et retourne l'état du mot de passe envoyé en paramètre
     * @param password le mot de passe à évaluer
     * @return L'état du mot de passe : INVALID, WEAK, STRONG
     *
     */
    public static String getPasswordState(String password) {
        if (Objects.isNull(password)) {
            return PASSWOR_STATE.INVALID.name();
        }

        int passwordLength=8, upChars=0, lowChars=0;
        int special=0, digits=0;
        char ch;

        int total = password.length();
        if(total < passwordLength) {
            return PASSWOR_STATE.INVALID.name();
        } else {
            for(int i=0; i<total; i++) {
                ch = password.charAt(i);
                if(Character.isUpperCase(ch))
                    upChars = 1;
                else if(Character.isLowerCase(ch))
                    lowChars = 1;
                else if(Character.isDigit(ch))
                    digits = 1;
                else
                    special = 1;
            }
        }
        if(upChars==1 && lowChars==1 && digits==1 && special==1)
            return PASSWOR_STATE.STRONG.name();
        else
            return PASSWOR_STATE.WEAK.name();
    }

}
