import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bowling bowling = new Bowling();

        Scanner sc = new Scanner(System.in);

        String[] first = sc.nextLine().split(" ");
        String[] second = sc.nextLine().split(" ");
        String[] third = sc.nextLine().split(" ");

        bowling.addPlayer(first[0], Integer.parseInt(first[1]));
        bowling.addPlayer(second[0], Integer.parseInt(second[1]));
        bowling.addPlayer(third[0], Integer.parseInt(third[1]));

        System.out.println(bowling.getWinner());
    }
}

