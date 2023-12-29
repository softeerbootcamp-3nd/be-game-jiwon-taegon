import service.GameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("★★★★★★★★★★★★★★★★★★★★Welcome to Baccarat★★★★★★★★★★★★★★★★★★★★");
        while(true){
            System.out.print("🥸게임을 진행하시겠습니까? (Y/N) ");
            String ans = br.readLine();
            if(ans.equals("N") || ans.equals("n")){
                System.out.println("👋다음에 또 만나요^^");
                return;
            }
            System.out.print("🤔이름을 입력하세요: ");
            String name = br.readLine();

            GameService gameService = new GameService(name);

            gameService.Game();
            System.out.println();
        }
    }
}