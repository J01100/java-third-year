public class Main {
    public static void main(String[] args) {
        Bowling bowling = new Bowling();

        bowling.addPlayer("Dave", 42);
        bowling.addPlayer("Amy", 103);
        bowling.addPlayer("Rob", 64);

        System.out.println(bowling.getWinner());
    }
}

