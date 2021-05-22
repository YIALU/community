package com.liuxuhuang.community.util;

import java.util.Random;

/**
 * @ClassName CreateName
 * @Description TODO
 * @Auther liuxuhuang
 * @Date 2021/5/20 10:29
 * @Version 1.0
 */
public class CreateName {

    public String getUserName(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 64 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
