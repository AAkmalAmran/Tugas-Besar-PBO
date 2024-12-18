import java.util.Scanner;

public class GameRpg {
    private String[] enemies = { "Goblin", "Skeleton", "Orc", "Dragon" };
    private Player player;
    private Scanner scanner;

    public GameRpg() {
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("==================");
        System.out.println("GAME RPG SEDERHANA");
        System.out.println("==================");
        System.out.print("\nMasukkan Nama Player: ");
        String Name = scanner.nextLine();

        System.out.print("Masukkan Level Awal Player: ");
        int level = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Masukkan Job Player (Mage/Warrior)");
        String job = scanner.nextLine();
        System.out.println(" ");

        player = new Player(Name, level, job);
        player.showCharacterStatus();

        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println("\nApa yang ingin kamu lakukan?");
            System.out.println("1. Serang musuh");
            System.out.println("2. Naik level");
            System.out.println("3. Gunakan kemampuan khusus");
            System.out.println("4. Tampilkan Status Player");
            System.out.println("Keluar dari game");
            System.out.println("");
            System.out.print("Pilih aksu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Pilih musuh yang ingin diserang");

                    for (int i = 0; i < enemies.length; i++) {
                        System.out.println((i + 1) + ". " + enemies[i]);
                    }

                    System.out.print("Pilihan: ");
                    int enemyChoice = scanner.nextInt();

                    try {
                        String enemyName = enemies[enemyChoice - 1];
                        Karakter enemy = new Enemy(enemyName, player.level, enemyChoice);
                        player.attackEnemy(enemyName);
                        enemy.attackEnemy(player.nama);
                        if (enemyChoice == 1) {
                            player.gainExperience(25);
                        } else if (enemyChoice == 2) {
                            player.gainExperience(50);
                        } else if (enemyChoice == 3) {
                            player.gainExperience(75);
                        } else if (enemyChoice == 4) {
                            player.gainExperience(100);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Pilihan musuh tidak valid.");
                    }

                    break;
                case 2:
                    player.levelUp();
                    player.showCharacterStatus();
                    break;
                case 3:
                    player.specialAbility();
                    break;
                case 4:
                    player.showCharacterStatus();
                case 5:
                    System.out.println("Terima kasih telah bermain!");
                    isPlaying = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}
