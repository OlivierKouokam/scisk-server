package com.scisk.sciskbackend.util;

public interface PasswordEncodingManager {
    /**
     * Crypte la chaine envoyée en paramètre
     * @param password Le mot de passe à encoder
     */
    public String encode(String password);

    /**
     * Vérifie si la chaine rawPassword correspond au mot de passe encodedPassword
     * @param rawPassword Le mot de passe à vérifier
     * @param encodedPawword Le mot de passe encodé
     */
    public boolean matches(String rawPassword, String encodedPawword);
}
