package com.crudjpaHeranca;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class GeradorSenha {

    public static void main(String[] args) {
        String password = "abc";
        //solicitando o encode para 123
        System.out.println(new BCryptPasswordEncoder().encode(password));
    }

}
