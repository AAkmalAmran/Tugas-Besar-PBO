package Main;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class UI {

    JFrame window;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtoPanel, playerPanel, createCharacterPanel, createButtonPanel, monsterPanel;
    JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel, createCharacterLabel, selectWeaponLabel, hpMonsterLabel, hpNumberMonsterLabel;
    JButton starButton, choice1, choice2, choice3, choice4, createButton;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 26);
    JTextField characterNameField;
    JComboBox<String> weaponComboBox;
    Player player = new Player(); // Tambahkan di kelas Game


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
        titleNameLabel = new JLabel("ADVENTURE");
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
        choiceButtoPanel.setBounds(50, 350, 700, 150);
        choiceButtoPanel.setBackground(Color.black);
        choiceButtoPanel.setLayout(new GridLayout(4, 1));
        window.add(choiceButtoPanel);

        choice1 = new JButton("choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(cHandler);
        choice1.setActionCommand("c1");
        choiceButtoPanel.add(choice1);

        choice2 = new JButton("choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(cHandler);
        choice2.setActionCommand("c2");
        choiceButtoPanel.add(choice2);

        choice3 = new JButton("choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(cHandler);
        choice3.setActionCommand("c3");
        choiceButtoPanel.add(choice3);

        choice4 = new JButton("choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(cHandler);
        choice4.setActionCommand("c4");
        choiceButtoPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
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

        // CREATE CHARACTER SCREEN
        createCharacterPanel = new JPanel();
        createCharacterPanel.setBounds(100, 100, 600, 500);
        createCharacterPanel.setBackground(Color.black);
        createCharacterPanel.setLayout(new GridLayout(3, 1)); // Elemen berurutan secara vertikal

        // Label untuk layar
        createCharacterLabel = new JLabel("CREATE");
        createCharacterLabel.setForeground(Color.white);
        createCharacterLabel.setFont(titleFont);
        createCharacterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createCharacterPanel.add(createCharacterLabel);

        // Input nama karakter
        JPanel nameInputPanel = new JPanel();
        nameInputPanel.setBackground(Color.black);
        nameInputPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Enter Name: ");
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(normalFont);
        nameInputPanel.add(nameLabel);

        characterNameField = new JTextField(15);
        characterNameField.setFont(normalFont);
        characterNameField.setBackground(Color.white);
        characterNameField.setForeground(Color.black);
        nameInputPanel.add(characterNameField);

        createCharacterPanel.add(nameInputPanel);

        // Tombol CONFIRM
        createButtonPanel = new JPanel();
        createButtonPanel.setBackground(Color.black);

        createButton = new JButton("CONFIRM");
        createButton.setActionCommand("CONFIRM");
        createButton.addActionListener(cHandler);

        createButton.setBackground(Color.black);
        createButton.setForeground(Color.white);
        createButton.setFont(normalFont);
        createButton.setFocusPainted(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String playerName = characterNameField.getText(); // Ambil nama dari input
                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please insert your character name!");
                } else {
                    player.setPlayerName(playerName);

                    createCharacterPanel.setVisible(false);
                    mainTextPanel.setVisible(true);
                    choiceButtoPanel.setVisible(true);
                    playerPanel.setVisible(true);
                }
            }
        });
        createButtonPanel.add(createButton);
        createCharacterPanel.add(createButtonPanel);


        createCharacterPanel.setVisible(false);
        window.add(createCharacterPanel);

        window.setVisible(true);
    }
}
