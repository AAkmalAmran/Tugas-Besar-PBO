package Main;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userInterface) {
        ui = userInterface;

    }

    public void showTitleScreen() {
        // Show title Screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide Game Screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtoPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

    }

    public void titleToTown() {
        // Hide title Screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show Game Screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtoPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

    }

    public void showCreateCharacterScreen() {
        // Show Create Character Screen
        ui.createCharacterPanel.setVisible(true);

        // Hide other screens
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtoPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

}
