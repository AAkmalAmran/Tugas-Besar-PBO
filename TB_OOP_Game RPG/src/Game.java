import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story st = new Story(this, ui, vm);

    public static void main(String[] args) {
        // Player player = new Player();
        // player.getPlayerData();
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

            switch (yourChoice) {
                case "START":
                    vm.titleToTown();
                    break;
                case "c1":
                    break;
                case "c2":
                    break;
                case "c3":
                    break;
                case "c4":
                    break;

            }
        }
    }
}
