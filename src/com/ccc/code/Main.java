package com.ccc.code;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter password:");
        Scanner sc = new Scanner(System.in);
        String pwd = sc.next();

        // define the characters to use in the password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789,.-#+";

        // define the length of the password
        int passwordLength = pwd.length();

        // generate all possible passwords of the given length
        for(int length = 0; length < 30; length++){
            boolean passwordFound = generatePassword(characters, length, "", pwd);
            if(passwordFound) return;
        }

        System.out.println("Password not found.");
    }

    public static boolean generatePassword(String characters, int passwordLength, String password, String pwd) {
        // if the password has the desired length, check if it matches the target password
        if (password.length() == passwordLength) {
            if (password.equals(pwd)) {
                System.out.println("Password found: " + password);
                return true;
            } else {
                return false;
            }
        }

        // generate all possible passwords by appending each character to the current password
        boolean passwordFound = false;
        for (int i = 0; i < characters.length(); i++) {
            String newPassword = password + characters.charAt(i);
            passwordFound = generatePassword(characters, passwordLength, newPassword, pwd);
            if (passwordFound) {
                break;
            }
        }
        return passwordFound;
    }
}