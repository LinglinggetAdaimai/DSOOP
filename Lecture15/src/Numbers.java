import java.util.Comparator;

public class Numbers implements Comparator<Numbers> {
    private String word;
    int number;
    public Numbers(String word, int num) {
        this.word = word;
        this.number = num;
    }
    public Numbers() {
    }
    @Override
    public int compare(Numbers o1, Numbers o2) {
        if (o1.number == o2.number) {
            return 0;
        }
        else if (o1.number > o2.number){
            return 1;
        }
        return -1;
    }

    public int getNumber() {
        return number;
    }
}
