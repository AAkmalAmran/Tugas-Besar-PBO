import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class UI {
    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtoPanel, playerPanel, createCharacterPanel, createButtonPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, createCharacterLabel, selectWeaponLabel;
    JButton starButton, choice1, choice2, choice3, choice4, createButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    JTextField characterNameField;
    JComboBox<String> weaponComboBox;

    public void createUI(ActionListener cHandler) {

        // WINDOW
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);

        // TITLE SCREEN
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 500);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("GAME RPG");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        JButton startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(cHandler);
        startButton.setActionCommand("START");
        startButtonPanel.add(startButton);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        // //CREATE CHARACTER
        // createCharacterPanel = new JPanel();
        // createCharacterPanel.setBounds(100, 100, 600, 500);
        // createCharacterPanel.setBackground(Color.black);
        // createCharacterLabel = new JLabel("CREATE CHARACTER");
        // createCharacterLabel.setForeground(Color.white);
        // createCharacterLabel.setFont(titleFont);
        // createCharacterPanel.add(titleNameLabel);

        // titleNameLabel = new JLabel("Enter Character Name:");
        // titleNameLabel.setForeground(Color.WHITE);
        // titleNameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        // titleNameLabel.setBounds(30, 70, 180, 30);
        // createCharacterPanel.add(titleNameLabel);

        // characterNameField = new JTextField();
        // characterNameField.setBounds(30, 110, 340, 30);
        // createCharacterPanel.add(characterNameField);

        // selectWeaponLabel = new JLabel("Select Weapon:");
        // selectWeaponLabel.setForeground(Color.WHITE);
        // selectWeaponLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        // selectWeaponLabel.setBounds(30, 160, 120, 30);
        // createCharacterPanel.add(selectWeaponLabel);

        //GAME SCREEN
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 500);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea("HALO BANG HALO");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtoPanel = new JPanel();
        choiceButtoPanel.setBounds(150,350,400,150);
        choiceButtoPanel.setBackground(Color.black);
        choiceButtoPanel.setLayout(new GridLayout(4,1));
        window.add(choiceButtoPanel);

        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtoPanel.add(choice1);

        choice2 = new JButton("choice 1");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c1");
        choiceButtoPanel.add(choice2);

        choice3 = new JButton("choice 1");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c1");
        choiceButtoPanel.add(choice3);

        choice4 = new JButton("choice 1");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c1");
        choiceButtoPanel.add(choice4);


        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        window.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpNumberLabel = new JLabel();
        hpNumberLabel.setForeground(Color.white);
        hpNumberLabel.setFont(normalFont);
        playerPanel.add(hpNumberLabel);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(normalFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);        

        window.setVisible(true);
    }
}
