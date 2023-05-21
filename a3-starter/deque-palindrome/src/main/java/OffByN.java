// a class that implements CharacterComparator
class OffByN implements CharacterComparator{
    // create an obj. that has equalChars() method where it returns true
    // if and only if the characters are off by N
        // x - y = |n| == true
        // OffByN offBy5 = new OffByN(5);
        // offBy5.equalChars('a', 'f'); // ==> true
        // offBy5.equalChars('f', 'a'); // ==> false
        // offBy5.equalChars('f', 'h'); // ==> false
    // this task doesn't require you to send the test cases, but it would be a good habit to do so

    private int n;
    public OffByN(int N){
        n = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        int diff = (Math.abs((int) x - (int) y));
        return diff == n;
    }

}