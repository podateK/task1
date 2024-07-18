package pl.podatek;

import java.util.Comparator;
import java.util.List;

public class PlayerManager {
    private List<Player> players;

    public PlayerManager(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    public void updatePlayerScore(String name, int newScore) {
        for(Player player : players) {
            if(player.getName().equals(name)) {
                player.setScore(newScore);
            }
        }
    }
    public void removePlayersWithNegativeScore() {
        players.removeIf(player -> player.getScore() < -1);
    }
    public void displayPlayers() {
        sortPlayersByScore();
        for(Player player : players) {
            System.out.println("Imie/Nazwa gracza: " + player.getName() + " Wynik: " + player.getScore());
        }
    }

    public void sortPlayersByScore() {
        players.sort(Comparator.comparingInt(Player::getScore).reversed());
    }
    public boolean playerExists(String name) {
    return players.stream().anyMatch(player -> player.getName().equals(name));
}

    public boolean removePlayerByName(String name) {
        return players.removeIf(player -> player.getName().equals(name));
    }
}
