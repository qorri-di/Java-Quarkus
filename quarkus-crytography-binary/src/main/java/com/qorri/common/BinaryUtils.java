package com.qorri.common;

import javax.enterprise.context.ApplicationScoped;
import java.nio.charset.StandardCharsets;

@ApplicationScoped
public class BinaryUtils {
    public String encode(String input){
        StringBuilder binary = new StringBuilder();
        for (char character : input.toCharArray()) {
            binary.append(
                    String.format("%8s", Integer.toBinaryString(character))
                            .replaceAll(" ", "0")
            );
        }
        return binary.toString();
    }

    public String decode(String input){
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < input.length(); i += 8) {
            String byteString = input.substring(i, i + 8);
            int charCode = Integer.parseInt(byteString, 2);
            text.append(new String(new byte[]{(byte) charCode}, StandardCharsets.UTF_8));
        }
        return text.toString();
    }
}
