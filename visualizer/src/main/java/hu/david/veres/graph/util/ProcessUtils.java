package hu.david.veres.graph.util;

import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ProcessUtils {

    private static final String DATE_AND_TIME_FORMAT = "yyyyMMddHHmmssSSSS";

    private ProcessUtils() {
    }

    public static String generateProcessIdentifier() {

        String timeStamp = DateTimeFormatter.ofPattern(DATE_AND_TIME_FORMAT).format(LocalDateTime.now());
        String randomString = RandomStringUtils.randomAlphanumeric(20);

        return timeStamp + "_" + randomString;

    }

    public static String generateStateSpaceFileName() {

        // TODO

        String timeStamp = DateTimeFormatter.ofPattern(DATE_AND_TIME_FORMAT).format(LocalDateTime.now());
        String randomString = RandomStringUtils.randomAlphanumeric(20);

        return timeStamp + "_" + randomString;

    }

}
