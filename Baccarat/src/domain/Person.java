package domain;

public class Person {
    private final String name;
    //카드 저장

    private String first;

    private String second;

    public int getTotal() {
        return total;
    }

    private int total;

    public Person(String name){
        this.name=name;
        this.total = 0;
    }

    public String getName() {
        return name;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public boolean setCard(int turn, String number) {
        if (turn == 1) {
            setFirstCard(number);
            return false;
        }
        else {
            return setSecondCard(number);
        }
    }

    public void setFirstCard(String number) {
        int temp = 0;
        this.first = number;

        if (number == "A") {
            temp = 1;
        }
        else if (number == "10" || number == "J" || number == "Q" || number == "K") {
            temp = 0;
        }
        else {
            temp = Integer.parseInt(number);
        }
        this.total += temp;
    }

    public boolean setSecondCard(String number) {
        int temp = 0;
        this.second = number;

        if (number == "A") {
            temp = 1;
        }
        else if (number == "10" || number == "J" || number == "Q" || number == "K") {
            temp = 0;
        }
        else {
            temp = Integer.parseInt(number);
        }
        this.total += temp;

        this.total %= 10;

        return this.total == 8 || this.total == 9;
    }
}
