package com.example.turkishsite;

import com.example.turkishsite.objects.Oceanarium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TurkishSiteApplicationTests {

    @Autowired
    private Oceanarium oceanarium;

    @DisplayName("Проверка на наличие рыбы в океанариуме")
    @ParameterizedTest(name = "{0} есть в океанариуме")
    @ValueSource(strings = {"Кит", "Касатка", "Немо"})
    void checkIfFishExist(String fishName) {
        Assertions.assertTrue(oceanarium.exists(fishName));
    }

    @DisplayName("Проверка на отсутствие рыбы в океанариуме")
    @ParameterizedTest(name = "{0} нет в океанариуме")
    @ValueSource(strings = {"Мегалодон", "Щука", "Ботинок"})
    void checkIfFishNotExist(String fishName) {
        Assertions.assertTrue(!oceanarium.exists(fishName));
    }

}
