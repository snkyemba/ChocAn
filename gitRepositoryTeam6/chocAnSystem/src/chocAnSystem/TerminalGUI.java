package chocAnSystem;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class TerminalGUI extends JFrame {
    private JTextArea terminalOutput;
    private Clip clip;

    public TerminalGUI() {
        // Set up the main frame

        setTitle("Terminal Selector");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initClip();
        // Create buttons
        JLabel welcome = new JLabel("Welcome to the Chocoholics Software!", SwingConstants.CENTER);
        JButton managerButton = new JButton("Manager Terminal");
        JButton providerButton = new JButton("Provider Terminal");
        JButton operatorButton = new JButton("Operator Terminal");
        ImageIcon emoji = new ImageIcon(getClass().getResource("NoEmoji.jpeg"));
        JLabel noEmoji = new JLabel(emoji);
        ImageIcon chocolatePic = new ImageIcon(getClass().getResource("Chocolate.jpeg"));
        JLabel chocolate = new JLabel(chocolatePic);

        // Add action listeners to the buttons
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openManagerTerminal();
            }
        });

        providerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProviderTerminal();
            }
        });

        operatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOperatorTerminal();
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        welcome.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        mainPanel.add(welcome, BorderLayout.NORTH);

        JPanel imagePanel = new JPanel(new FlowLayout());
        imagePanel.add(noEmoji);
        imagePanel.add(chocolate);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        Dimension buttonSize = new Dimension(600, 200);
        managerButton.setPreferredSize(buttonSize);
        providerButton.setPreferredSize(buttonSize);
        operatorButton.setPreferredSize(buttonSize);

        buttonPanel.add(managerButton);
        buttonPanel.add(providerButton);
        buttonPanel.add(operatorButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);

        playBackgroundMusic();
    }

    private void initClip() {
        try {
            // Load audio file from the same directory as the program
            URL audioFileURL = getClass().getResource("gangnam.wav");

            if (audioFileURL != null) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFileURL);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
            } else {
                System.err.println("Audio file not found.");
            }

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }


    private void playBackgroundMusic() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    private void openManagerTerminal() {

//        ManagerTerminal mTerminal = new ManagerTerminal();
//        mTerminal.startManagerTerminal();
        JOptionPane.showMessageDialog(this, "Manager Provider Terminal");
    }

    private void openProviderTerminal() {
        // Add logic to open Provider Terminal
        JOptionPane.showMessageDialog(this, "Opening Provider Terminal");
    }

    private void openOperatorTerminal() {
        // Add logic to open Operator Terminal
        JOptionPane.showMessageDialog(this, "Opening Operator Terminal");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TerminalGUI().setVisible(true);
            }
        });
    }
}