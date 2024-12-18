package Main;

import Support.Weapon;
import Support.Monster;
import Support.Npc;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    String nameNPC;
    Player player = new Player();
    Npc npc = new Npc();
    Monster currentMonster;

    int cincinBerlian;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.hp = 20;
        ui.hpNumberLabel.setText("" + player.hp);

        // Ngambil nama berdasarkan yg udah diinput
        String playerName = ui.characterNameField.getText();

        player.setIdWeapon(playerName);

        Weapon weapon_name = new Weapon(1);

        player.currentWeapon = weapon_name;
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        cincinBerlian = 0;
    }

    public void pilihPosisi(String nextPosition) {
        switch (nextPosition) {
            case "cityGate":
                cityGate();
                break;
            case "ngobrolPenjaga":
                ngobrolPenjaga();
                break;
            case "attackPenjaga":
                attackPenjaga();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "utara":
                utara();
                break;
            case "barat":
                barat();
                break;
            case "timur":
                timur();
                break;
            case "playerAttack":
                playerAttack(currentMonster);
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "ending1":
                ending1();
                break;
            case "ending2":
                ending2();
                break;
            case "toTitle":
                toTitle();
                break;
            case "win":
                win();
                break;
            case "lose":
                lose();
                break;
            case "fight":
                fight();
                break;
            case "ending2v2":
                ending2v2();
                break;
            case "backAgain":
                backAgain();
                break;

        }
    }

    public void cityGate() {
        ui.mainTextArea.setText(
                "Saat ini kamu berada di depan sebuah kota. \nTerdapat seorang penjaga yang menatapmu dengan tatapan curiga. \n\nApa yang akan kamu lakukan? ");
        ui.choice1.setText("Berbicara dengan penjaga");
        ui.choice2.setText("Menyerang penjaga");
        ui.choice3.setText("Pergi");
        ui.choice4.setText(" ");

        game.nextPosition1 = "ngobrolPenjaga";
        game.nextPosition2 = "attackPenjaga";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = " ";
    }

    public void ending1() {
        ui.mainTextArea.setText("Kamu menghabiskan masa hidupmu di penjara kumuh\n\n<TAMAT>");
        ui.choice1.setText("To title screen");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "toTitle";
    }

    public void ending2() {
        npc.setNpcName(1);
        String nameNPC = npc.getNpcName();
        // Ngambil nama berdasarkan yg udah diinput
        String playerName = ui.characterNameField.getText();

        ui.mainTextArea.setText(nameNPC + ": Tunggu! Siapa nama mu wahai sang pahlawan?");
        ui.choice1.setText("Namaku " + playerName);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "ending2v2";
    }

    public void ending2v2() {
        npc.setNpcName(1);
        String nameNPC = npc.getNpcName();

        ui.mainTextArea.setText("Anda berpose keren membelakangi " + nameNPC + "\n\n<TAMAT>");
        ui.choice1.setText("Back To Title Screen");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "toTitle";
    }

    public void ngobrolPenjaga() {
        npc.setNpcName(1);
        String nameNPC = npc.getNpcName();
        if (cincinBerlian == 0) {

            ui.mainTextArea.setText(nameNPC
                    + ": Jika ingin masuk ke dalam kerajaan. Kamu harus membunuh sebuah monster yang ada di hutan bagian utara");
            ui.choice1.setText("Baiklah");
            ui.choice2.setText("Menyerang Penjaga");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "crossRoad";
            game.nextPosition2 = "attackPenjaga";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (cincinBerlian == 1) {
            ui.mainTextArea.setText(nameNPC + ": Oh... Cincin ini adalah milik putri ku...\n" + nameNPC
                    + ": Jadi dia telah tiada ya...\n" + nameNPC
                    + ": Terima kasih telah membalaskan dendam ku kepada monster sialan itu. Kamu bisa menyimpan cincin itu.");
            ui.choice1.setText("Turut berduka. Terimakasih");
            ui.choice2.setText("Mampus");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "ending2";
            game.nextPosition2 = "attackPenjaga";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void attackPenjaga() {
        npc.setNpcName(1);
        String penjaga = npc.getNpcName();

        if (cincinBerlian == 0) {
            ui.mainTextArea.setText(
                    penjaga + ": Apa kau sudah gila?\n\n(Kamu mendapat 15 damage)");

            player.hp = player.hp - 15;
            ui.hpNumberLabel.setText("" + player.hp);

            ui.choice1.setText("Pergi");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            if (player.hp > 0) {
                game.nextPosition1 = "crossRoad";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            } else if (player.hp < 1) {
                game.nextPosition1 = "lose";
                game.nextPosition2 = "";
                game.nextPosition3 = "";
                game.nextPosition4 = "";
            }
        } else if (cincinBerlian == 1) {
            ui.mainTextArea.setText(
                    penjaga + ": Apa maksudmu HAH!?\n\n(Penjaga Membunuhmu)");

            player.hp = player.hp - 1000;
            ui.hpNumberLabel.setText("" + player.hp);

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void crossRoad() {
        ui.mainTextArea.setText(
                "Saat ini kamu berada di persimpangan jalan.");
        ui.choice1.setText("Pergi ke arah Utara");
        ui.choice2.setText("Pergi ke arah Barat");
        ui.choice3.setText("Pergi ke arah Timur");
        ui.choice4.setText("Kembali");

        game.nextPosition1 = "utara";
        game.nextPosition2 = "barat";
        game.nextPosition3 = "timur";
        game.nextPosition4 = "cityGate";
    }

    public void utara() {

        int monsterRandom = new java.util.Random().nextInt(1, 7);
        currentMonster = new Monster(monsterRandom);

        String monster = currentMonster.getMonsterName();
        int monster_hp = currentMonster.getHp();

        ui.mainTextArea.setText(
                "Kamu pergi ke arah utara. \n\nSesampainya disana, kamu melihat ada " + monster
                        + " yang sedang menikmati makanannya\n\n"
                        + monster + " HP: " + monster_hp + "\nApa yang akan kamu lakukan?");

        ui.choice1.setText("Bertarung melawan " + monster);
        ui.choice2.setText("Lari");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void barat() {
        ui.mainTextArea.setText(
                "Tidak ada apa-apa disini");
        ui.choice1.setText("Kembali");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void timur() {
        int weaponRandom = new java.util.Random().nextInt(2, 7); // ID senjata acak (2-7)
        String playerName = ui.characterNameField.getText();

        // Jika senjata saat ini bukan senjata khusus (id != 3)
        if (player.currentWeapon.id != weaponRandom) {
            // Ganti senjata dengan yang baru
            Weapon newWeapon = new Weapon(weaponRandom);
            player.currentWeapon = newWeapon;
            player.updatePlayerWeapon(playerName, weaponRandom);

            // Update tampilan UI
            ui.weaponNameLabel.setText(player.currentWeapon.name);
            ui.mainTextArea.setText(
                    "Kamu berjalan ke dalam hutan. Di depan, kamu melihat sebuah " + newWeapon.name
                            + " tertancap di tanah.\n\n(Kamu mendapatkan " + newWeapon.name + ")");
        }
        // Jika senjata saat ini ID-nya 3, 4, 5, atau 6, tetapi bukan ID 1
        else if (player.currentWeapon.id != 1) {
            int newHp = new java.util.Random().nextInt(1, 50);
            // Pemain mendapatkan tambahan HP
            player.hp += newHp;
            ui.hpNumberLabel.setText(String.valueOf(player.hp));

            // Update tampilan UI
            ui.mainTextArea.setText(
                    "Kamu memutuskan untuk beristirahat sejenak di bawah pohon beringin.\n\n(Mendapatkan " + newHp
                            + " HP)");
        }

        // Set pilihan dan posisi berikutnya untuk UI
        ui.choice1.setText("Pergi ke arah Utara");
        ui.choice2.setText("Kembali");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "utara";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void fight() {
        String nama_monster = currentMonster.getMonsterName();
        int monster_hp = currentMonster.getHp();

        ui.mainTextArea.setText(nama_monster + ": " + monster_hp + "\n\nApa yang akan kamu lakukan?");

        ui.choice1.setText("Menyerang " + nama_monster);
        ui.choice2.setText("Lari");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack(Monster currentMonster) {
        String namaMonster = currentMonster.getMonsterName();
        int monsterHp = currentMonster.getHp();

        // Hitung damage player secara acak
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage) + 1;

        // Kurangi HP monster
        monsterHp -= playerDamage;
        currentMonster.setHp(monsterHp);

        // Update tampilan UI
        ui.mainTextArea.setText(
                "Kamu menyerang " + namaMonster + ", kerusakan seranganmu sebesar " + playerDamage + "\n\n"
                        + namaMonster + " HP: " + Math.max(monsterHp, 0)); // Tampilkan HP monster minimum 0

        // Atur pilihan di UI
        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        // Tentukan posisi permainan berikutnya
        if (monsterHp > 0) {
            game.nextPosition1 = "monsterAttack"; // Monster menyerang balik
        } else {
            game.nextPosition1 = "win"; // Player menang
        }
    }

    public void monsterAttack() {
        String nama_monster = currentMonster.getMonsterName();
        int monster_attack = currentMonster.getMonsterDMG();

        int monsterDamage = new java.util.Random().nextInt(monster_attack);
        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        ui.mainTextArea.setText(
                nama_monster + " menyerang.\n(HP mu berkurang " + monsterDamage + " HP)");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "playerAttack";
        } else {
            game.nextPosition1 = "lose";
        }
    }

    public void win() {
        String nama_monster = currentMonster.getMonsterName();
        ui.mainTextArea.setText("Kamu mengalahkan " + nama_monster + "!\n\n(Kamu mendapatkan cincin berlian!)");

        cincinBerlian = 1;
        currentMonster = null; // Reset monster untuk pertempuran berikutnya

        ui.choice1.setText("Pergi ke Timur");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
    }

    public void lose() {
        ui.mainTextArea.setText("Kamu telah mati!\n\n<GAME OVER>");

        cincinBerlian = 1;
        ui.choice1.setText("Start Over");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "backAgain";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void backAgain() {
        defaultSetup();
        cityGate();
    }

    public void toTitle() {
        // Ngambil nama berdasarkan yg udah diinput
        String playerName = ui.characterNameField.getText();
        // Mengembalikan setup player dari awal
        defaultSetup();
        // Delete player dalam database
        player.deletePlayerByName(playerName);
        // balik ke title screen
        vm.showTitleScreen();
    }
}
