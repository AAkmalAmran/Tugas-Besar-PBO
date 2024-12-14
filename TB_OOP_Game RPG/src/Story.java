public class Story {
    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup(){
        player.setHp(20);
        int hp = player.getHp();

        ui.hpNumberLabel.setText("" + hp);

        player.setWeaponName(hp);
        String weapon = player.getWeaponName();
        ui.weaponNameLabel.setText(weapon);
    }
}
