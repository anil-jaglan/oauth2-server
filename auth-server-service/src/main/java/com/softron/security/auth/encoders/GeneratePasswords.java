package com.softron.security.auth.encoders;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePasswords {
    public static void main(String[] args) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
        System.out.println(encoder.encode("modifier"));
    }
}
