package ru.training.at.hw3_steps.data;

import java.util.List;

public class TestData {

    public static final String WEB_DRIVER_NAME = "webdriver.chrome.driver";

    public static final String PATH_TO_THE_CHROME_DRIVER = "C:/WebDrivers/chromedriver.exe";

    public static final String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public static final String HOME_PAGE_TITLE = "Home Page";

    public static final String THE_MAIN_TITLE_OF_THE_PAGE = "EPAM framework Wishes…";

    public static final String THE_SECOND_TITLE_OF_THE_PAGE = "Lorem ipsum dolor sit amet, "
            + "consectetur adipisicing elit, " +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " +
            "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
            "consequat Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore " +
            "eu fugiat nulla pariatur.";

    public static final String FRAME_CARD_TITLE = "Frame card Title";

    public static final List<String> HEADER_ITEMS_TEXT = List.of(
        "HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"
    );

    public static final String LOGIN = "Roman";

    public static final String PASSWORD = "Jdi1234";

    public static final String USERNAME = "ROMAN IOVLEV";

    public static final int NUMBER_OF_IMAGES = 4;

    public static final List<String> TEXT_UNDER_ICONS = List.of(
        "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project",

        "To be flexible and\n"
            + "customizable",

        "To be multiplatform",

        "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…"
    );

    public static List<String> LEFT_SECTION_ITEMS_TEXTS = List.of(
        "Home", "Contact form", "Service", "Metals & Colors", "Elements packs"
    );

    public static String TITLE_OF_PAGE_DIFFERENT_ELEMENTS = "Different Elements";

    public static final String COLOR = "Yellow";

    public static final List<String> TEXTS_OF_LOGS = List.of(
        "value changed to Yellow",
        "value changed to Selen",
        "condition changed to true",
        "condition changed to true"
    );

    public static final int WATER_LIST_NUMBER = 0;

    public static final int WIND_LIST_NUMBER = 2;

    public static final int SELEN_LIST_NUMBER = 3;
}
