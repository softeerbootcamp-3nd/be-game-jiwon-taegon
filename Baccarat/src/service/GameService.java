package service;

import domain.Person;

public class GameService {
    private final int GP = 9;

    private Person player;
    private Person banker;

    private final String[] cards = new String[14];

    public GameService(String name) {
        //player, banker 생성
        player = new Person(name);
        banker = new Person("banker");
    }

    public void Game() {
        init();
        if(splitCard()){
            printCard(true);
            System.out.println(player.getName() + "님이 자연승했습니다.");
            return;
        }

        printCard(false);
        if (compare()) {
            System.out.println(player.getName() + "님이 승리하였습니다.");
        } else {
            System.out.println(player.getName() + "님이 패배하였습니다.");
        }
    }

    private void init() {
        for (int i = 2; i <= 10; i++) {
            cards[i] = Integer.toString(i);
        }
        cards[1] = "A";
        cards[11] = "J";
        cards[12] = "Q";
        cards[13] = "K";
    }

    //Card 나눠주기
    public boolean splitCard() {
        for (int turn = 1; turn <= 2; turn++) {
            int valueP = pickCard();
            if (player.setCard(turn, cards[valueP])) {
                return true;
            }
            int valueB = pickCard();
            banker.setCard(turn, cards[valueB]);
        }
        return false;
    }

    public boolean compare() {
        int totalP = Math.abs(GP - player.getTotal());
        int totalB = Math.abs(GP - banker.getTotal());
        return totalP <= totalB;
    }

    private static int pickCard() {
        double rand = Math.random();
        int value = (int) (rand * 13) + 1;
        return value;
    }

    void printCard(boolean flag) {
        if (flag) {
            System.out.println(player.getName()+ " 카드: " + player.getFirst() + ", " + player.getSecond());
            System.out.println("banker 카드: " + banker.getFirst());
        }
        else {
            System.out.println(player.getName()+ " 카드: " + player.getFirst() + ", " + player.getSecond());
            System.out.println("banker 카드: " + banker.getFirst() + ", " + banker.getSecond());
        }
    }
}
