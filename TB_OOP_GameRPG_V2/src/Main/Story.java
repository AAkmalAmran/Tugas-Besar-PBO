package Main;

import Support.Weapon;
import Support.Monster;

public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    String nameNPC;
    Player player = new Player();
    Npc npc = new Npc();
    public int longsword;

    int cincinBerlian;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.hp = 20;
        ui.hpNumberLabel.setText("" + player.hp);

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
                playerAttack();
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
            case "ngobrolPenjaga2":
                ngobrolPenjaga2();
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

    public void ngobrolPenjaga() {
        npc.setNpcName(1);
        String nameNPC = npc.getNpcName();

        // Ngambil nama player
        player.setPlayerName("Link");
        String playerName = player.getPlayerName();

        if (player.hp >= 20) {
            ui.mainTextArea.setText(nameNPC + ": Berhenti! Siapa kamu? Ada keperluan apa di kerajaan Jawa?");
            ui.choice1.setText("Hai, namaku " + playerName + ". Saya ingin menemui pujaan hati saya.");
            ui.choice2.setText("Hah!? Kau tidak kenal siapa aku?");
            ui.choice3.setText("(Menonjok Penjaga)");
            ui.choice4.setText("");

            game.nextPosition1 = "ngobrolPenjaga2";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "attackPenjaga";
            game.nextPosition4 = "";
        } else if (player.hp == 5) {
            ui.mainTextArea.setText(
                    nameNPC + ": Oh, Punya nyali juga kamu buat kembali\n\n(Penjaga memasukkanmu ke penjara)");

            ui.choice1.setText(">");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "ending1";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (cincinBerlian == 1) {
            ui.mainTextArea.setText(nameNPC + ": Apa kamu berhasil?");
            ui.choice1.setText("Memperlihatkan cincin berlian");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "ngobrolPenjaga2";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

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
        ui.mainTextArea.setText("Kamu masuk ke dalam kerajaan\n\n<TAMAT>");
        ui.choice1.setText("To title screen");
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

        game.nextPosition1 = "toTitle";
    }

    public void ngobrolPenjaga2() {

        if (cincinBerlian == 0) {
            npc.setNpcName(1);
            String nameNPC = npc.getNpcName();
            ui.mainTextArea.setText(nameNPC
                    + ": Jika ingin masuk ke dalam kerajaan. Kamu harus membunuh Goblin yang ada di hutan bagian utara");
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
                    + ": Terima kasih telah membalaskan dendam ku kepada goblin sialan itu. Kamu bisa menyimpan cincin itu.");
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
                    penjaga + ": Apa maksudmu HAH!?\n(Penjaga Membunuhmu)\n\n<GAME OVER>");

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
        Monster nama_Monster = new Monster(3);
        String monster = nama_Monster.getMonsterName();

        ui.mainTextArea.setText(
                "Kamu pergi ke arah utara. \n\nSesampainya disana, kamu melihat ada " + monster
                        + " yang sedang menikmati makanannya");

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
                "");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void timur() {

        if (player.currentWeapon.id != 3) {
            ui.mainTextArea.setText(
                    "Kamu berjalan ke dalam hutan. Di depan, kamu melihat sebuah Long Sword tertancap di tanah.\n\n(Kamu mendapatkan Long Sword)");

            // Ganti Senjata
            Weapon weapon_name = new Weapon(3);
            player.currentWeapon = weapon_name;
            ui.weaponNameLabel.setText(player.currentWeapon.name);

            ui.choice1.setText("Pergi ke arah Utara");
            ui.choice2.setText("kembali");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "utara";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if ((player.currentWeapon.id == 3 || player.currentWeapon.id == 4 || player.currentWeapon.id == 5
                || player.currentWeapon.id == 6) && player.currentWeapon.id != 1) {
            ui.mainTextArea.setText(
                    "Kamu memutuskan untuk beristirahat sejenak di bawah pohon beringin.\n\n(Mendapatkan 3 HP)");

            // Tambah HP
            player.hp = player.hp + 10;
            ui.hpNumberLabel.setText("" + player.hp);

            ui.choice1.setText("Pergi ke arah Utara");
            ui.choice2.setText("kembali");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "utara";
            game.nextPosition2 = "crossRoad";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    // ===========================================================================HP
    // Monster e bermasalah===============================================
    public void fight() {
        Monster Monster = new Monster(3);
        String nama_monster = Monster.getMonsterName();
        int monster_hp = Monster.getMonsterHP();

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

    // HP Monster e bermasalah
    public void playerAttack() {
        Monster Monster = new Monster(3);
        String nama_monster = Monster.getMonsterName();
        int monster_hp = Monster.getMonsterHP();

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        monster_hp = monster_hp - playerDamage;

        ui.mainTextArea.setText(
                "Kamu menyerang " + nama_monster + ", kerusakan serangan mu sebesar " + playerDamage + "\n\n"
                        + nama_monster + " HP:" + monster_hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        //monster_hp ne
        if (monster_hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster_hp < 1) {
            game.nextPosition1 = "Win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void monsterAttack() {
        Monster Monster = new Monster(3);
        String nama_monster = Monster.getMonsterName();
        int monster_attack = Monster.getMonsterDMG();

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
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (player.hp < 1) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }

    }

    public void win() {
        Monster Monster = new Monster(3);
        String nama_monster = Monster.getMonsterName();
        ui.mainTextArea.setText("Kamu mengalahkan " + nama_monster + "!\n\n(Kamu mendapatkan cincin berlian!)");

        cincinBerlian = 1;
        ui.choice1.setText("Pergi ke Timur");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void lose() {
        ui.mainTextArea.setText("Kamu telah mati!\n\n<GAME OVER>");

        cincinBerlian = 1;
        ui.choice1.setText("To the title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void ending() {

    }

    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }
}
