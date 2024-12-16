public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    String nameNPC;
    Player player = new Player();
    Npc npc = new Npc();

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.setHp(20);
        int hpPlayer = player.getHp();

        ui.hpNumberLabel.setText("" + hpPlayer);

        player.setWeaponName(20);
        String weaponPlayer = player.getWeaponName();
        ui.weaponNameLabel.setText(weaponPlayer);

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
            case "guildPetualang":
                guildPetualang();
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
            case "helpVillager":
                helpVillager();
                break;
            case "goblinHunt":
                goblinHunt();
                break;
            case "playerAttack":
                playerAttack();
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

        player.setPlayerName(20);
        String namePlayer = player.getPlayerName();
        ui.mainTextArea.setText(nameNPC + ": Berhenti! Siapa kamu? Ada keperluan apa di kerajaan Jawa?");
        ui.choice1.setText("Hai, namaku " + namePlayer + ". Saya datang untuk mengambil misi.");
        ui.choice2.setText("Hah!? Kau tidak kenal siapa aku?");
        ui.choice3.setText("(Menonjok Penjaga)");
        ui.choice4.setText("");

        game.nextPosition1 = "guildPetualang";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "attackPenjaga";
        game.nextPosition4 = "";

    }

    public void attackPenjaga() {
        npc.setNpcName(1);
        String penjaga = npc.getNpcName();

        ui.mainTextArea.setText(
                penjaga + ": Apa kau sudah gila? \n(Kamu mendapat 7 damage)");

        player.setHp(20, 7);
        int hpPlayer = player.getHp();

        ui.hpNumberLabel.setText("" + hpPlayer);

        ui.choice1.setText("Pergi");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "crossRoad";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
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

    public void guildPetualang() {
        ui.mainTextArea.setText(
                "Saat ini kamu berada di dalam guild petualang. Kamu melihat papan misi. Di sana terdapat 3 misi\n1. Berburu Goblin(50 Silver)\n2. Menolong Warga Desa(25 Silver)\n3. Memetik 'bunga' di hutan bagian utara(5 Gold)\n\n Apa yang akan anda ambil?");
        ui.choice1.setText("Berburu Goblin");
        ui.choice2.setText("Menolong warga desa");
        ui.choice3.setText("Memetik bunga");
        ui.choice4.setText("");

        game.nextPosition1 = "utara";
        game.nextPosition2 = "helpVillager";
        game.nextPosition3 = "barat";
        game.nextPosition4 = "";
    }

    public void utara() {
        npc.setNpcName(7);
        String goblin = npc.getNpcName();

        ui.mainTextArea.setText(
                "Kamu pergi ke arah utara. \n\nSesampainya disana, kamu melihat ada " + goblin
                        + " yang sedang menikmati makanannya\n\nApa yang akan kamu lakukan?");
        ui.choice1.setText("Bertarung melawan " + goblin);
        ui.choice2.setText("Lari");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "goblinHunt";
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
        ui.mainTextArea.setText(
                "Kamu berjalan ke dalam hutan. Di depan, kamu melihat sebuah Long Sword tertancap di tanah.\n\n(Kamu mendapatkan Long Sword)");

        player.updateWeapon(20, 2);
        String weaponPlayer = player.getWeaponName();
        ui.weaponNameLabel.setText(weaponPlayer);

        ui.choice1.setText("Pergi ke arah Utara");
        ui.choice2.setText("kembali");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "utara";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void helpVillager() {

    }

    public void goblinHunt() {
        npc.setNpcHp(7);
        int npc_hp = npc.getNpcHp();

        npc.setNpcName(7);
        String npc_name = npc.getNpcName();

        ui.mainTextArea.setText(
                npc_name + " mengeluarkan senjatanya\n\n" + npc_name + ": " + npc_hp + "\n\nApa tindakan mu?");
        ui.choice1.setText("Serang");
        ui.choice2.setText("Lari");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void playerAttack() {
        npc.setNpcName(7);
        String npc_name = npc.getNpcName();
        int playerDamage = new java.util.Random().nextInt(player.getWeaponDamage());

        ui.mainTextArea.setText(
                "Kamu menyerang " + npc_name + ", kerusakan serangan mu sebesar " + playerDamage);
        npc.setNpcHp(7, playerDamage);
        ui.choice1.setText("Serang");
        ui.choice2.setText("Lari");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }
}
