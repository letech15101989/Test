package com.nojata.UserAuthentication.Util;

import java.security.SecureRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shamsher
 */
public class RenadomNumberGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int LENGTH = 8;

    
    public static String  generate(String startCharacter)   {
        StringBuilder idBuilder = new StringBuilder(startCharacter);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            idBuilder.append(CHARACTERS.charAt(index));
        }
        return idBuilder.toString();
    }
}
