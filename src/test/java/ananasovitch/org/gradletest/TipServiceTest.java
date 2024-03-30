package ananasovitch.org.gradletest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipServiceTest {

    @ParameterizedTest
    @CsvSource({
            "500, 550",
            "1500, 1575",
            "1000, 1050"
    })
    public void testRoundTips(BigDecimal amount, BigDecimal expected) {
        if (amount.compareTo(BigDecimal.ZERO) >= 0) {
            TipService tipService = new TipService();
            BigDecimal result = tipService.roundTips(amount);
            assertEquals(expected.setScale(2, RoundingMode.HALF_UP), result.setScale(2, RoundingMode.HALF_UP));
        }
    }
}
