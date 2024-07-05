package com.qorri.common;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HexUtils {
    public String encode(String input){
        StringBuilder hex = new StringBuilder();
        for (char character : input.toCharArray()) {
            hex.append(String.format("%02x", (int) character));
        }
        return hex.toString();
    }

    public String decode(String input){
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < input.length(); i += 2) {
            String str = input.substring(i, i + 2);
            hex.append((char) Integer.parseInt(str, 16));
        }
        return hex.toString();
    }
}
