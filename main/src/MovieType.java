public enum MovieType {
    CHILDREN(2),
    REGULAR(0),
    NEW_RELEASE(1);

    final int ordinal;

    MovieType(int type) {
        ordinal = type;
    }
}
