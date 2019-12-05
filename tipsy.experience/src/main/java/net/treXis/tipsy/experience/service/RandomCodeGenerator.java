package net.treXis.tipsy.experience.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class RandomCodeGenerator implements CommandLineRunner {

    private String code;
    private UUID uuid = UUID.randomUUID();

    public String newCode(){

        StringBuilder codeBuilder = new StringBuilder(String.valueOf(uuid));
        codeBuilder.insert(4, "-");
        codeBuilder.setLength(9);
        code = codeBuilder.toString();

        return code;
    }

    @Override
    public void run(String... args){
        System.out.println(newCode().toUpperCase());
    }



}
