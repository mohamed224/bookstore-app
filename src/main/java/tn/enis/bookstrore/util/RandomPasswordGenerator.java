package tn.enis.bookstrore.util;

import org.springframework.stereotype.Component;
import tn.enis.bookstrore.util.constants.ConstantsValue;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RandomPasswordGenerator {

    private static SecureRandom secureRandom = new SecureRandom();


    public static String generatePassword() {
        StringBuilder returnedPassword = new StringBuilder(ConstantsValue.PASSWORD_LENGTH);
        String passwordBase = makeItMoreRandom();
        for (int i = 0; i < ConstantsValue.PASSWORD_LENGTH; i++) {
            int randomValue = secureRandom.nextInt(passwordBase.length());
            char randomChar = passwordBase.charAt(randomValue);
            returnedPassword.append(randomChar);
        }
        return returnedPassword.toString();
    }

    public static String makeItMoreRandom() {
        List<String> letterList = Arrays.asList(ConstantsValue.PASSWORD_BASE.split(""));
        Collections.shuffle(letterList);
        return letterList.stream().collect(Collectors.joining());
    }
}
