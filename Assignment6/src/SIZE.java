public enum SIZE {
    SMALL, MEDIUM, LARGE;
    public static int getSizeMultiplier(SIZE size) {
        return switch (size) {
            case MEDIUM -> 1;
            case LARGE -> 2;
            default -> 0;
        };
    }
}
