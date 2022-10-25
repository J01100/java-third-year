import java.util.HashMap;
import java.util.Map;

public class Bowling {
    HashMap<String, Integer> players = new HashMap<>();

    public Bowling(){ }

    public void addPlayer(String name, Integer score){
        players.put(name, score);
    }

    public String getWinner(){
        int highest = 0;
        String winner = "";

        for (Map.Entry<String, Integer> player: players.entrySet()){
            if (player.getValue() > highest) {
                highest = player.getValue();
                winner = player.getKey();
            }
        }

        return winner;
    }
}

