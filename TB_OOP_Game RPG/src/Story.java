public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    String nameNPC;
    Character chara = new Character();

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        chara.setHp(20);
        int hpPlayer = chara.getHp();

        ui.hpNumberLabel.setText("" + hpPlayer);

        chara.setWeaponName(hpPlayer);
        String weaponPlayer = chara.getWeaponName();
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
        chara.setNpcName(1);
        String nameNPC = chara.getNpcName();

        chara.setPlayerName(20);
        String namePlayer = chara.getPlayerName();

        ui.mainTextArea.setText(nameNPC + ": Berhenti! Siapa kamu? Ada keperluan apa di kerajaan Jawa?");
        ui.choice1.setText("Hai, namaku " + namePlayer + ". Saya datang untuk mengambil misi.");
        ui.choice2.setText("Hah!? Kau tidak kenal siapa aku?");
        ui.choice3.setText("Menonjok Penjaga");
        ui.choice4.setText("");

        game.nextPosition1 = "guildPetualang";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "attackPenjaga";
        game.nextPosition4 = "";
    }

    public void attackPenjaga() {
        chara.setNpcName(1);
        String nameNPC = chara.getNpcName();

        ui.mainTextArea.setText(
                nameNPC + ": Apa kau sudah gila? \n(Kamu mendapat 7 damage)");

        chara.setHp(20);
        int hpPlayer = chara.getHp();
        hpPlayer -= 7;
        chara.setHp(hpPlayer);

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
        ui.choice4.setText("Kembali ke gerbang");

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
        ui.choice4.setText("Tidak peduli");

        game.nextPosition1 = "utara";
        game.nextPosition2 = "helpVillager";
        game.nextPosition3 = "timur";
        game.nextPosition4 = "nolep";
    }

    public void utara() {
        ui.mainTextArea.setText(
                "Kamu melihat ada goblin yang sedang menikmati makanannya\n\nApa yang akan kamu lakukan?");
        ui.choice1.setText("Menyerang goblin");
        ui.choice2.setText("Kembali ke Persimpangan jalan");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "goblinHunt";
        game.nextPosition2 = "crossRoad";
        game.nextPosition3 = "timur";
        game.nextPosition4 = "nolep";
    }
}
