package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story st = new Story(this, ui, vm);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {
        new Game();

    }

    public Game() {
        ui.createUI(cHandler);
        st.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            Player player = new Player();

            switch (yourChoice) {
                case "START":
                    vm.showCreateCharacterScreen();
                    break;
                case "CONFIRM":
                    String playerName = ui.characterNameField.getText();
                    if (playerName.isEmpty()) {
                        // javax.swing.JOptionPane.showMessageDialog(null, "Please enter a name!");
                    } else {
                        player.setPlayerName(playerName);
                        System.out.println("Character Name: " + playerName);
                        System.out.println();
                        vm.titleToTown();
                        st.cityGate();
                    }
                    break;
                case "c1":
                    st.pilihPosisi(nextPosition1);
                    break;
                case "c2":
                    st.pilihPosisi(nextPosition2);
                    break;
                case "c3":
                    st.pilihPosisi(nextPosition3);
                    break;
                case "c4":
                    st.pilihPosisi(nextPosition4);
                    break;
            }
        }

    }
}
