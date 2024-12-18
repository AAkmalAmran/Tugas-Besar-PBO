package Main;

// KELOMPOK 13 
// KELAS: SI4708
// STUDI KASUS: Game RPG
// Anggota Kelompok:
// AHMAD AKMAL AMRAN		- 102022300010 
// ADINAR TRI PANUNTUN		- 102022300174 
// MUHAMMAD RAYHAN RAMADHAN	- 102022330145 

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
                    } else {
                        player.setPlayerName(playerName);
                        player.insertPlayer(playerName);
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
