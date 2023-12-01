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
    MemberController memberController = new MemberController();
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
                openManagerMethod();
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
                    JButton viewMainMenu = new JButton("View Main Menu");
                    // Set layout manager for the new JFrame
                    welcomeFrame.setLayout(new GridLayout(4, 1));

                    // Add components to the new JFrame
                    welcomeFrame.add(memberReportButton);
                    welcomeFrame.add(providerReportButton);
                    welcomeFrame.add(managerReportButton);
                    welcomeFrame.add(viewMainMenu);


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
                    viewMainMenu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            welcomeFrame.setVisible(false);
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

    public void openManagerMethod() {
        // Create a thread for openManagerTerminal
        Thread openManagerThread = new Thread(() -> openManagerTerminal());

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
        JFrame operatorTerminalFrame = new JFrame("Operator Terminal");
        operatorTerminalFrame.setSize(400, 200);
        operatorTerminalFrame.setLocationRelativeTo(this);
        operatorTerminalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the JFrame
        JLabel welcomeLabel = new JLabel("Welcome to Operator Terminal.");
        JLabel idLabel = new JLabel("Enter your 9-digit operator ID:");
        JTextField idTextField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // Set layout manager for the JFrame
        operatorTerminalFrame.setLayout(new GridLayout(4, 1));

        // Add components to the JFrame
        operatorTerminalFrame.add(welcomeLabel);
        operatorTerminalFrame.add(idLabel);
        operatorTerminalFrame.add(idTextField);
        operatorTerminalFrame.add(submitButton);

        // Add ActionListener to the Submit button
        submitButton.addActionListener(new ActionListener() {
            private int attempts = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the user has exceeded the maximum number of attempts
                if (attempts >= 5) {
                    JOptionPane.showMessageDialog(operatorTerminalFrame,
                            "You have exceeded the maximum number of attempts.",
                            "Max Attempts Exceeded", JOptionPane.ERROR_MESSAGE);
                    operatorTerminalFrame.dispose();
                    return;
                }

                // Get the entered manager ID
                String operatorID = idTextField.getText();

                // Check the validity of the manager ID (customize as needed)
                if (oTerminal.checkID(Integer.parseInt(operatorID))) {
                    // If valid, create a new window
                    JFrame welcomeFrame = new JFrame("Welcome to the Operator Terminal!");
                    welcomeFrame.setSize(400, 200);
                    welcomeFrame.setLocationRelativeTo(operatorTerminalFrame);
                    welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Create components for the new JFrame
                    JLabel welcomeLabel = new JLabel("What would you like to do?");
                    JButton manageMemberButton = new JButton("Manage Member Records");
                    JButton manageProviderButton = new JButton("Manage Provider Records");
                    JButton backUpDataButton = new JButton("Backup Data");
                    JButton viewMainMenu = new JButton("View Main Menu");
                    // Set layout manager for the new JFrame
                    welcomeFrame.setLayout(new GridLayout(4, 1));

                    // Add components to the new JFrame
                    welcomeFrame.add(manageMemberButton);
                    welcomeFrame.add(manageProviderButton);
                    welcomeFrame.add(backUpDataButton);
                    welcomeFrame.add(viewMainMenu);

                    // Add ActionListener to the buttons (you will implement the actions)
                    manageMemberButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Open a new JFrame for managing member records
                            JFrame manageMembersFrame = new JFrame("Manage Members");
                            manageMembersFrame.setSize(400, 200);
                            manageMembersFrame.setLocationRelativeTo(operatorTerminalFrame);
                            manageMembersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            // Create components for the new JFrame
                            JLabel promptLabel = new JLabel("What would you like to do?");
                            JButton addMemberButton = new JButton("Add Member");
                            JButton updateMemberButton = new JButton("Update Member");
                            JButton deleteMemberButton = new JButton("Delete Member");

                            // Set layout manager for the new JFrame
                            manageMembersFrame.setLayout(new GridLayout(4, 1));

                            // Add components to the new JFrame
                            manageMembersFrame.add(promptLabel);
                            manageMembersFrame.add(addMemberButton);
                            manageMembersFrame.add(updateMemberButton);
                            manageMembersFrame.add(deleteMemberButton);

                            // Add ActionListeners to the buttons (you will implement the actions)
                            addMemberButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Open a new JFrame for adding a member
                                    JFrame addMemberFrame = new JFrame("Add Member");
                                    addMemberFrame.setSize(400, 300);
                                    addMemberFrame.setLocationRelativeTo(manageMembersFrame);
                                    addMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    // Create components for the new JFrame
                                    JLabel nameLabel = new JLabel("Member's Name:");
                                    JTextField nameTextField = new JTextField();

                                    JLabel numberLabel = new JLabel("Member's Number:");
                                    JTextField numberTextField = new JTextField();

                                    JLabel addressLabel = new JLabel("Member's Address:");
                                    JTextField addressTextField = new JTextField();

                                    JLabel cityLabel = new JLabel("Member's City:");
                                    JTextField cityTextField = new JTextField();

                                    JLabel stateLabel = new JLabel("Member's State:");
                                    JTextField stateTextField = new JTextField();

                                    JLabel zipLabel = new JLabel("Member's ZIP:");
                                    JTextField zipTextField = new JTextField();

                                    JLabel balanceLabel = new JLabel("Member's Balance:");
                                    JTextField balanceTextField = new JTextField();

                                    JButton submitButton = new JButton("Submit");

                                    // Set layout manager for the new JFrame
                                    addMemberFrame.setLayout(new GridLayout(8, 2));

                                    // Add components to the new JFrame
                                    addMemberFrame.add(nameLabel);
                                    addMemberFrame.add(nameTextField);

                                    addMemberFrame.add(numberLabel);
                                    addMemberFrame.add(numberTextField);

                                    addMemberFrame.add(addressLabel);
                                    addMemberFrame.add(addressTextField);

                                    addMemberFrame.add(cityLabel);
                                    addMemberFrame.add(cityTextField);

                                    addMemberFrame.add(stateLabel);
                                    addMemberFrame.add(stateTextField);

                                    addMemberFrame.add(zipLabel);
                                    addMemberFrame.add(zipTextField);

                                    addMemberFrame.add(balanceLabel);
                                    addMemberFrame.add(balanceTextField);

                                    addMemberFrame.add(new JLabel()); // Placeholder for better layout
                                    addMemberFrame.add(submitButton);

                                    // Add ActionListener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Retrieve entered values
                                            String name = nameTextField.getText();
                                            int number = Integer.parseInt(numberTextField.getText());
                                            if (Integer.toString(number).length() != 10) {
                                                JOptionPane.showMessageDialog(addMemberFrame, "Member Number must be 10 digits");
                                                throw new IllegalArgumentException("Member number must be 10 digits");
                                            }
                                            String address = addressTextField.getText();
                                            String city = cityTextField.getText();
                                            String state = stateTextField.getText();
                                            int zip = Integer.parseInt(zipTextField.getText());
                                            if (Integer.toString(zip).length() != 5) {
                                                JOptionPane.showMessageDialog(addMemberFrame, "ZIP must be 5 digits");
                                                throw new IllegalArgumentException("ZIP must be 5 digits");
                                            }
                                            double balance = Double.parseDouble(balanceTextField.getText());

                                            // Use the retrieved values as needed (you can pass them to your memberController)
                                            // For now, just display them in a message
                                            JOptionPane.showMessageDialog(manageMemberButton, "Added Member!");
                                           memberController.addMember(name, number, address, city, state, zip, balance);

                                            // Optionally, perform additional actions with the entered values

                                            // Close the addMemberFrame
                                            addMemberFrame.dispose();
                                        }
                                    });

                                    // Show the new window
                                    addMemberFrame.setVisible(true);
                                }
                            });

                            updateMemberButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Implement logic for updating a member
                                    JOptionPane.showMessageDialog(manageMembersFrame, "Update Member functionality to be implemented.");
                                }
                            });

                            deleteMemberButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Implement logic for deleting a member
                                    JOptionPane.showMessageDialog(manageMembersFrame, "Delete Member functionality to be implemented.");
                                }
                            });
                            // Show the new window
                            manageMembersFrame.setVisible(true);
                        }
                    });

                    manageProviderButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            oTerminal.manageProviderRecords();
                        }
                    });

                    backUpDataButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            oTerminal.backupData();
                        }
                    });
                    viewMainMenu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            welcomeFrame.setVisible(false);
                        }
                    });

                    // Show the new window
                    welcomeFrame.setVisible(true);

                    // Close the Manager Terminal window
                    operatorTerminalFrame.dispose();
                } else {
                    // If invalid, show a message or prompt for re-input
                    JOptionPane.showMessageDialog(operatorTerminalFrame,
                            "Invalid manager ID. Please enter a valid 9-digit ID. " + (5 - attempts) + " attempts left",
                            "Invalid ID", JOptionPane.ERROR_MESSAGE);

                    // Optionally clear the input field for re-entry
                    idTextField.setText("");

                    // Increment the attempts counter
                    attempts++;
                }
            }
        });

        operatorTerminalFrame.setVisible(true);
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