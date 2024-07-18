package pl.podatek;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerManager playerManager = new PlayerManager(new ArrayList<>());
        playerManager.addPlayer(new Player("Andrzej", 32));
        playerManager.addPlayer(new Player("Tomek", -1));
        playerManager.addPlayer(new Player("Anna", 23));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Dodaj gracza");
            System.out.println("2. Usun gracza");
            System.out.println("3. Wyświetl graczy");
            System.out.println("4. Usuń graczy z wynikiem ujemnym i wyswietl graczy");
            System.out.println("5. Usun graczy z ujemnym wynikiem");
            System.out.println("6. Aktualizuj wynik gracza");
            System.out.println("7. Zakończ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
               case 1:
    System.out.println("Podaj imię gracza:");
    String nameToAdd = scanner.nextLine().toLowerCase();
    if (playerManager.playerExists(nameToAdd)) {
        System.out.println("Gracz o imieniu " + nameToAdd + " już istnieje.");
    } else {
        System.out.println("Podaj wynik gracza:");
        if (scanner.hasNextInt()) {
            int scoreToAdd = scanner.nextInt();
            scanner.nextLine();
            playerManager.addPlayer(new Player(nameToAdd, scoreToAdd));
        } else {
            System.out.println("Wynik musi być liczbą całkowitą.");
            scanner.nextLine();
        }
    }
    break;
case 2:
    System.out.println("Podaj imię gracza, którego chcesz usunac:");
    String nameToRemove = scanner.nextLine().toLowerCase();
    if (playerManager.removePlayerByName(nameToRemove)) {
        System.out.println("Gracz " + nameToRemove + " został usunięty.");
    } else {
        System.out.println("Nie znaleziono gracza o imieniu " + nameToRemove + ".");
    }
    break;
                case 3:
                    playerManager.displayPlayers();
                    break;
                case 4:
                    playerManager.removePlayersWithNegativeScore();
                    playerManager.displayPlayers();
                    break;
                case 5:
                    playerManager.removePlayersWithNegativeScore();
                    break;
                case 6:
                    System.out.println("Podaj imię gracza, którego wynik chcesz zaktualizować:");
                    String playerNameToUpdate = scanner.nextLine().toLowerCase();
                    System.out.println("Podaj nowy wynik:");
                    if (scanner.hasNextInt()) {
                        int newScore = scanner.nextInt();
                        scanner.nextLine();
                        playerManager.updatePlayerScore(playerNameToUpdate, newScore);
                    } else {
                        System.out.println("Wynik musi być liczbą całkowitą.");
                        scanner.nextLine();
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nieznana opcja, spróbuj ponownie.");
                    break;
            }
        }
    }
}