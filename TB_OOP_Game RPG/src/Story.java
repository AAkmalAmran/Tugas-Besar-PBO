public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VisibilityManager vManager) {
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {
        player.setHp(20);
        int hp = player.getHp();

        ui.hpNumberLabel.setText("" + hp);

        player.setWeaponName(hp);
        String weapon = player.getWeaponName();
        ui.weaponNameLabel.setText(weapon);
    }

    public void pilihPosisi(String nextPosition) {
        switch (nextPosition) {
            case "ngobrolPenjaga": ngobrolPenjaga();
                break;
            case "nyerangPenjaga": nyerangPenjaga();
                break;
            case "hutan": hutan();
                break;
        }
    }

    public void villageGate() {
        ui.mainTextArea.setText(
                "Saat ini kamu berada di depan sebuah desa. \nTerdapat seorang penjaga yang menatapmu dengan tatapan curiga. \n\nApa yang akan kamu lakukan? ");
        ui.choice1.setText("Berbicara dengan penjaga");
        ui.choice2.setText("Menyerang penjaga");
        ui.choice3.setText("Pergi");
        ui.choice4.setText(" ");

        game.nextPosition1 = "ngobrolPenjaga";
        game.nextPosition2 = "nyerangPenjaga";
        game.nextPosition3 = "hutan";
        game.nextPosition4 = " ";
    }

    public void ngobrolPenjaga() {
        ui.mainTextArea.setText(
                "Penjaga A ");
        ui.choice1.setText("");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void nyerangPenjaga() {

    }

    public void hutan() {

    }
}
