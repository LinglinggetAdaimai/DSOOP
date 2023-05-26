class OffByOne implements CharacterComparator{
    // implements CharacterComparator,
    // equalChars(char x, char y) returns true if they are different by one
        // if x - y = |1| == true
        // a, b == true
        // z, a == false (maybe binary?)
        // r, q == true
    // then uncomment the TestOffByOne + write plenty of tests in it, to make sure the func is correct

    @Override
    public boolean equalChars(char x, char y) {
        int diff = (Math.abs((int) x - (int) y));
        return diff == 1;
    }

}