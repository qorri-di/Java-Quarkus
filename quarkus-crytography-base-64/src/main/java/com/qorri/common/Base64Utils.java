package com.qorri.common;

import javax.enterprise.context.ApplicationScoped;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@ApplicationScoped
public class Base64Utils {
    public String encode(String input){
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    public String decode(String input){
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }
}
