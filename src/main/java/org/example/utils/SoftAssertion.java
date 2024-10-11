package org.example.utils;

import com.google.common.base.Joiner;
import lombok.SneakyThrows;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SoftAssertion {

    public static List<AssertionError> errorList = new ArrayList<>();

    @SneakyThrows
    public static <T> void assertThat(String reason, Supplier<T> supplierForGettingActualValue, Matcher<? super T> matcher) {
        for (int i = 0; i < 5; i++) {
            try {
                MatcherAssert.assertThat(reason, supplierForGettingActualValue.get(), matcher);
                return;
            } catch (AssertionError e) {
                Wait.forMillis(1000);
                if (i == 4) {
                    MyLogger.takeScreenshot(e.getMessage());
                    errorList.add(e);
                }
            }
        }
    }


    public static void assertAll() {
        if (!errorList.isEmpty()) {
            String resultMessage = Joiner.on("\n")
                    .join(errorList
                            .stream()
                            .map(a -> a.getMessage())
                            .collect(Collectors.toList()));
            errorList.clear();
            throw new AssertionError(resultMessage);
        }
    }

}
