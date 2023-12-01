package chocAnSystem;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class TerminalGUI extends JFrame {
    private JTextArea terminalOutput;
    ManagerTerminal mTerminal = new ManagerTerminal();
    ProviderTerminal pTerminal = new ProviderTerminal();
    OperatorTerminal oTerminal = new OperatorTerminal();
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
                runParallelMethods();
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
        JFrame managerTerminalFrame = new JFrame("Manager Terminal");
        managerTerminalFrame.setSize(400, 200);
        managerTerminalFrame.setLocationRelativeTo(this);
        managerTerminalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the JFrame
        JLabel welcomeLabel = new JLabel("Welcome to Manager Terminal.");
        JLabel idLabel = new JLabel("Enter your 9-digit manager ID:");
        JTextField idTextField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // Set layout manager for the JFrame
        managerTerminalFrame.setLayout(new GridLayout(4, 1));

        // Add components to the JFrame
        managerTerminalFrame.add(welcomeLabel);
        managerTerminalFrame.add(idLabel);
        managerTerminalFrame.add(idTextField);
        managerTerminalFrame.add(submitButton);

        // Add ActionListener to the Submit button
        submitButton.addActionListener(new ActionListener() {
            private int attempts = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the user has exceeded the maximum number of attempts
                if (attempts >= 5) {
                    JOptionPane.showMessageDialog(managerTerminalFrame,
                            "You have exceeded the maximum number of attempts.",
                            "Max Attempts Exceeded", JOptionPane.ERROR_MESSAGE);
                    managerTerminalFrame.dispose();
                    return;
                }

                // Get the entered manager ID
                String managerID = idTextField.getText();

                // Check the validity of the manager ID (customize as needed)
                if (mTerminal.getManagerIDs().contains(Integer.parseInt(managerID))) {
                    // If valid, create a new window
                    JFrame welcomeFrame = new JFrame("Welcome to the Manager Terminal!");
                    welcomeFrame.setSize(400, 200);
                    welcomeFrame.setLocationRelativeTo(managerTerminalFrame);
                    welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Create components for the new JFrame
                    JLabel welcomeLabel = new JLabel("Which report would you like to request?");
                    JButton memberReportButton = new JButton("Member Report");
                    JButton providerReportButton = new JButton("Provider Report");
                    JButton managerReportButton = new JButton("Manager Report");

                    // Set layout manager for the new JFrame
                    welcomeFrame.setLayout(new GridLayout(4, 1));

                    // Add components to the new JFrame
                    welcomeFrame.add(welcomeLabel);
                    welcomeFrame.add(memberReportButton);
                    welcomeFrame.add(providerReportButton);
                    welcomeFrame.add(managerReportButton);

                    // Add ActionListener to the buttons (you will implement the actions)
                    memberReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mTerminal.requestReport();
                        }
                    });

                    providerReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mTerminal.requestReport();
                        }
                    });

                    managerReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            mTerminal.requestReport();
                        }
                    });

                    // Show the new window
                    welcomeFrame.setVisible(true);

                    // Close the Manager Terminal window
                    managerTerminalFrame.dispose();
                } else {
                    // If invalid, show a message or prompt for re-input
                    JOptionPane.showMessageDialog(managerTerminalFrame,
                            "Invalid manager ID. Please enter a valid 9-digit ID. " + (5 - attempts) + " attempts left",
                            "Invalid ID", JOptionPane.ERROR_MESSAGE);

                    // Optionally clear the input field for re-entry
                    idTextField.setText("");

                    // Increment the attempts counter
                    attempts++;
                }
                mTerminal.startManagerTerminal();
            }
        });

        managerTerminalFrame.setVisible(true);
    }
    private void startManagerTerminal() {
      mTerminal.startManagerTerminal();
    }

    public void runParallelMethods() {
        // Create a thread for openManagerTerminal
        Thread openManagerThread = new Thread(() -> openManagerTerminal());

//         Create a thread for startManagerTerminal
//        Thread startManagerThread = new Thread(() -> {
//            // Run startManagerTerminal asynchronously
//            new Thread(() -> startManagerTerminal()).start();
//        });

        // Start both threads
        openManagerThread.start();
//        startManagerThread.start();

        // Wait for openManagerThread to finish before proceeding (optional)
        try {
            openManagerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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