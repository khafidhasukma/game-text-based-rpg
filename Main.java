import character.Character;
import enemy.Enemy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            // Initialize player and enemy
            Character player = new Character("Character", 100, 20, 10);
            Enemy monster = new Enemy("Enemy", 150, 15, 5);

            // Display welcome message and initial HP
            System.out.println("Selamat datang di Text RPG!");
            System.out.println("HP " + player.getName() + ": " + player.getHp() + " | HP " + monster.getName() + ": " + monster.getHp());

            // Main battle loop
            while (player.getHp() > 0 && monster.getHp() > 0) {
                // Display action menu
                System.out.println("\nPilih aksi:");
                System.out.println("1. Serang");
                System.out.println("2. Bertahan");
                System.out.println("3. Minum Ramuan (sisa: " + player.getPotions() + ")");
                System.out.println("4. Keluar");

                System.out.print("> ");
                int choice = input.nextInt();

                // Handle player actions
                switch (choice) {
                    case 1:
                        // Player attacks enemy
                        player.attack(monster);
                        if (monster.getHp() > 0) {
                            // Enemy counterattacks if still alive
                            monster.attack(player);
                        }
                        break;
                    case 2:
                        // Player defends against enemy attack
                        int enemyDamage = monster.getAttackPower();
                        player.defend(enemyDamage, monster.getName());
                        break;
                    case 3:
                        // Player drinks a potion to restore HP
                        player.drinkPotion();
                        break;
                    case 4:
                        // Exit the game
                        System.out.println("Keluar dari permainan.");
                        System.exit(0);
                        break;
                    default:
                        // Handle invalid input
                        System.out.println("Pilihan tidak valid.");
                }

                // Display current HP status
                System.out.println("\nStatus HP:");
                System.out.println(player.getName() + ": " + player.getHp() + " | " + monster.getName() + ": " + monster.getHp());
            }

            // Check if player is defeated
            if (player.getHp() <= 0) {
                String again;
                while (true) {
                    // Prompt to restart or quit the game
                    System.out.println("Game Over, mulai lagi? (y/n)");
                    again = input.next().trim().toLowerCase();
                    if (again.equals("y")) {
                        // Restart the game
                        System.out.println("Memulai permainan baru...");
                        break;
                    } else if (again.equals("n")) {
                        // Quit the game
                        System.out.println("Terima kasih telah bermain!");
                        playing = false;
                        break;
                    } else {
                        // Handle invalid input
                        System.out.println("Input tidak valid. Masukkan 'y' untuk ya atau 'n' untuk tidak.");
                    }
                }
            } else {
                // Player wins the game
                System.out.println("Selamat! Kamu mengalahkan musuh!");
                playing = false;
            }
        }
        // Close the scanner
        input.close();
    }
}