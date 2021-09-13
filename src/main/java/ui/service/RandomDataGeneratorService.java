package ui.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class RandomDataGeneratorService {

    private static final String DOT_COM = ".com";

    public String getRandomString(int elementQuantity) {
        return RandomStringUtils.randomAlphabetic(elementQuantity);
    }

    public String getRandomNumber(int elementQuantity) {
        return RandomStringUtils.randomNumeric(elementQuantity);
    }

    public String getRandomEmail(int nameQuantity, int orgDomainQuantity) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getRandomString(nameQuantity))
                .append("@")
                .append(getRandomString(orgDomainQuantity))
                .append(DOT_COM).toString();

    }
}
