package pairmatching.domain;

public enum Mission {
    RACING_CAR(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL2, "로또"),
    NUMBER_BASEBALL_GAME(Level.LEVEL3, "숫자야구게임"),
    IMPROVEMENT(Level.LEVEL4, "성능개선"),
    DISTRIBUTION(Level.LEVEL4, "배포");

    private Level level;
    private String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }
}
