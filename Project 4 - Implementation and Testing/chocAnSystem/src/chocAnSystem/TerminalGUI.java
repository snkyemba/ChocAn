package chocAnSystem;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;


public class TerminalGUI extends JFrame {
    private boolean isPlaying = false;
    String [] pTerminalArgs = new String[1];
    ProviderController controller = new ProviderController();
    ProviderControllerOp providerController = new ProviderControllerOp();
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
        JButton playPauseButton = new JButton("Play/Pause Music");

        // Add action listeners to the buttons
        playPauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isPlaying) {
                    pauseBackgroundMusic();
                } else {
                    playBackgroundMusic();
                }
            }
        });
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

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5));

        Dimension buttonSize = new Dimension(600, 200);
        managerButton.setPreferredSize(buttonSize);
        providerButton.setPreferredSize(buttonSize);
        operatorButton.setPreferredSize(buttonSize);

        buttonPanel.add(managerButton);
        buttonPanel.add(providerButton);
        buttonPanel.add(operatorButton);
        buttonPanel.add(playPauseButton);
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
        if (clip != null && !clip.isRunning()) {
            clip.start();
            isPlaying = true;
        }
    }

    private void pauseBackgroundMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            isPlaying = false;
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
                    welcomeFrame.setLayout(new GridLayout(5, 1));

                    // Add components to the new JFrame
                    welcomeFrame.add(welcomeLabel);
                    welcomeFrame.add(memberReportButton);
                    welcomeFrame.add(providerReportButton);
                    welcomeFrame.add(managerReportButton);
                    welcomeFrame.add(viewMainMenu);


                    // Add ActionListener to the buttons (you will implement the actions)
                    memberReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //JOptionPane.showMessageDialog(managerTerminalFrame, "Request report functionality to be implemented.");
                            mTerminal.requestReport(1);
                            JOptionPane.showMessageDialog(managerTerminalFrame, "Member Report Generated");
                        }
                    });

                    providerReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //JOptionPane.showMessageDialog(managerTerminalFrame, "Request report functionality to be implemented.");
                            mTerminal.requestReport(2);
                            JOptionPane.showMessageDialog(managerTerminalFrame, "Provider Report Generated");
                        }
                    });

                    managerReportButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(managerTerminalFrame, "Request report functionality to be implemented.");
                            mTerminal.requestReport(3);
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
       JFrame providerTerminalFrame = new JFrame("Provider Terminal");
        providerTerminalFrame.setSize(400, 200);
        providerTerminalFrame.setLocationRelativeTo(this);
        providerTerminalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create components for the JFrame
        JLabel welcomeLabel = new JLabel("Welcome to Provider Terminal.");
        JLabel idLabel = new JLabel("Enter your 9-digit provider ID:");
        JTextField idTextField = new JTextField();
        JButton submitButton = new JButton("Submit");

        // Set layout manager for the JFrame
        providerTerminalFrame.setLayout(new GridLayout(4, 1));

        // Add components to the JFrame
        providerTerminalFrame.add(welcomeLabel);
        providerTerminalFrame.add(idLabel);
        providerTerminalFrame.add(idTextField);
        providerTerminalFrame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            private int attempts = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the user has exceeded the maximum number of attempts
                if (attempts >= 5) {
                    JOptionPane.showMessageDialog(providerTerminalFrame,
                            "You have exceeded the maximum number of attempts.",
                            "Max Attempts Exceeded", JOptionPane.ERROR_MESSAGE);
                    providerTerminalFrame.dispose();
                    return;
                }

                // Get the entered manager ID
                String providerID = idTextField.getText();

                // Check the validity of the manager ID (customize as needed)
                if (pTerminal.providerVerify(Integer.parseInt(providerID), controller)) {
                    // If valid, create a new window
                    JFrame welcomeFrame = new JFrame("Welcome to the Provider Terminal!");
                    welcomeFrame.setSize(400, 200);
                    welcomeFrame.setLocationRelativeTo(providerTerminalFrame);
                    welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                    // Create components for the new JFrame
                    JLabel welcomeLabel = new JLabel("What would you like to do?");
                    JButton requestProviderDirecButton = new JButton("Request Provider Directory");
                    JButton logServiceButton = new JButton("Log a Service");
                    JButton viewMainMenu = new JButton("View Main Menu");
                    // Set layout manager for the new JFrame
                    welcomeFrame.setLayout(new GridLayout(5, 1));

                    // Add components to the new JFrame
                    welcomeFrame.add(welcomeLabel);
                    welcomeFrame.add(requestProviderDirecButton);
                    welcomeFrame.add(logServiceButton);
                    welcomeFrame.add(viewMainMenu);


                    // Add ActionListener to the buttons (you will implement the actions)
                    requestProviderDirecButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JFrame actionFrame = new JFrame("Service Options");
                            actionFrame.setSize(400, 200);
                            actionFrame.setLocationRelativeTo(providerTerminalFrame);
                            actionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            // Create components for the new JFrame
                            JLabel titleLabel = new JLabel("What would you like to do?");
                            JButton searchByServiceCodeButton = new JButton("Search by Service Code");
                            JButton searchByServiceNameButton = new JButton("Search by Service Name");
                            JButton viewAllServicesButton = new JButton("View all Services");
                            JButton returnToMainMenuButton = new JButton("Return to Main Menu");

                            // Set layout manager for the new JFrame
                            actionFrame.setLayout(new GridLayout(5, 1));

                            // Add components to the new JFrame
                            actionFrame.add(titleLabel);
                            actionFrame.add(searchByServiceCodeButton);
                            actionFrame.add(searchByServiceNameButton);
                            actionFrame.add(viewAllServicesButton);
                            actionFrame.add(returnToMainMenuButton);

                            // Add ActionListener to the buttons
                            searchByServiceCodeButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame searchByServiceCodeFrame = new JFrame("Search by Service Code");
                                    searchByServiceCodeFrame.setSize(400, 200);
                                    searchByServiceCodeFrame.setLocationRelativeTo(providerTerminalFrame);
                                    searchByServiceCodeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    // Create components for the new JFrame
                                    JLabel titleLabel = new JLabel("Enter the Service Code you would like to search for:");
                                    JTextField serviceCodeTextField = new JTextField();
                                    JButton submitButton = new JButton("Submit");

                                    // Set layout manager for the new JFrame
                                    searchByServiceCodeFrame.setLayout(new GridLayout(3, 1));

                                    // Add components to the new JFrame
                                    searchByServiceCodeFrame.add(titleLabel);
                                    searchByServiceCodeFrame.add(serviceCodeTextField);
                                    searchByServiceCodeFrame.add(submitButton);

                                    // Add ActionListener to the submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the action for the submit button
                                            String enteredServiceCode = serviceCodeTextField.getText();
                                            // Add your code here to perform the search using the entered service code
                                            Optional<ProviderDirectory> serviceByCode = controller.searchServiceCode(Integer.parseInt(enteredServiceCode), "gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerDirectory.json");

                                            if (serviceByCode.isPresent()) {
                                                JOptionPane.showMessageDialog(searchByServiceCodeFrame, "Service Code: " + serviceByCode.get().getServiceCode() + "\n" +
                                                        "Service Name: " + serviceByCode.get().getServiceName() + "\n" +
                                                        "Service Fee: " + serviceByCode.get().getServiceFee(), "Service Record", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(searchByServiceCodeFrame, "Service Code not found. Please enter a valid Service Code.");
                                            }
                                        }
                                    });

                                    // Show the new window
                                    searchByServiceCodeFrame.setVisible(true);
                                }
                            });


                            searchByServiceNameButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    JFrame searchByServiceNameFrame = new JFrame("Search by Service Name");
                                    searchByServiceNameFrame.setSize(400, 200);
                                    searchByServiceNameFrame.setLocationRelativeTo(providerTerminalFrame);
                                    searchByServiceNameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    // Create components for the new JFrame
                                    JLabel titleLabel = new JLabel("Enter the Service Name you would like to search for:");
                                    JTextField serviceNameTextField = new JTextField();
                                    JButton submitButton = new JButton("Submit");

                                    // Set layout manager for the new JFrame
                                    searchByServiceNameFrame.setLayout(new GridLayout(3, 1));

                                    // Add components to the new JFrame
                                    searchByServiceNameFrame.add(titleLabel);
                                    searchByServiceNameFrame.add(serviceNameTextField);
                                    searchByServiceNameFrame.add(submitButton);

                                    // Add ActionListener to the submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the action for the submit button
                                            String enteredServiceName = serviceNameTextField.getText();
                                            Optional<ProviderDirectory> serviceByName = controller.searchServiceName(enteredServiceName, "gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerDirectory.json");

                                            if (serviceByName.isPresent()) {
                                                JOptionPane.showMessageDialog(searchByServiceNameFrame, "Service Code: " + serviceByName.get().getServiceCode() + "\n" +
                                                        "Service Name: " + serviceByName.get().getServiceName() + "\n" +
                                                        "Service Fee: " + serviceByName.get().getServiceFee(), "Service Record", JOptionPane.INFORMATION_MESSAGE);
                                            } else {
                                                JOptionPane.showMessageDialog(searchByServiceNameFrame, "Service Name not found. Please enter a valid Service Code.");
                                            }
                                        }
                                    });

                                    // Show the new window
                                    searchByServiceNameFrame.setVisible(true);
                                }
                            });

                            viewAllServicesButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Handle the action for "View all Services" button
                                    // Add your code here
                                    Vector<ProviderDirectory> serviceTypes;
                                    serviceTypes = controller.getServiceTypes("gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerDirectory.json");

                                    // Create and show the frame
                                    SwingUtilities.invokeLater(() -> {
                                        JFrame frame = new JFrame("View all Services");
                                        frame.setSize(400, 400);
                                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                        JTextArea textArea = new JTextArea();
                                        textArea.setEditable(false);

                                        // Loop through the service records and append them to the text area
                                        for (ProviderDirectory entry : serviceTypes) {
                                            textArea.append("Service Code: " + entry.getServiceCode() + "\n" +
                                                    "Service Name: " + entry.getServiceName() + "\n" +
                                                    "Service Fee: " + entry.getServiceFee() + "\n\n");
                                        }

                                        // Create a JScrollPane to make the text area scrollable
                                        JScrollPane scrollPane = new JScrollPane(textArea);

                                        // Add the scroll pane to the frame
                                        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

                                        // Make the frame visible
                                        frame.setVisible(true);
                                    });
                                }

                            });

                            returnToMainMenuButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Handle the action for "Return to Main Menu" button
                                    // Add your code here
                                    actionFrame.dispose(); // Close the current frame
                                    // You may also show the main menu frame or perform other actions here
                                }
                            });

                            // Show the new window
                            actionFrame.setVisible(true);
                        }
                    });


                    logServiceButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // ...

// Create and show the frame
                            SwingUtilities.invokeLater(() -> {
                                JFrame frame = new JFrame("Enter Service Information");
                                frame.setSize(400, 300);
                                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JTextField memberIDTextField = new JTextField();
                                JTextField serviceCodeTextField = new JTextField();
                                JTextField dateTextField = new JTextField();
                                JTextField commentsTextField = new JTextField();

                                JButton submitButton = new JButton("Submit");

                                // Set layout manager for the new JFrame
                                frame.setLayout(new BorderLayout());

                                // Create a panel to hold your labels and text fields
                                JPanel inputPanel = new JPanel(new GridLayout(4, 2));

                                // Add components to the input panel
                                inputPanel.add(new JLabel("9-Digit Member ID:"));
                                inputPanel.add(memberIDTextField);

                                inputPanel.add(new JLabel("Service Code:"));
                                inputPanel.add(serviceCodeTextField);

                                inputPanel.add(new JLabel("Date of Service (MM-DD-YYYY):"));
                                inputPanel.add(dateTextField);

                                inputPanel.add(new JLabel("Comments:"));
                                inputPanel.add(commentsTextField);

                                // Add the input panel to the frame's center
                                frame.add(inputPanel, BorderLayout.CENTER);

                                // Add the submit button to the frame's south
                                frame.add(submitButton, BorderLayout.SOUTH);

                                // Add ActionListener to the submit button
                                submitButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Get the input values as strings
                                        String memberID = memberIDTextField.getText();
                                        if(!controller.checkIDNumber(Integer.parseInt(memberID), "gitRepositoryTeam6/chocAnSystem/ProgramFiles/memberIDs.json")){
                                            JOptionPane.showMessageDialog(frame, "Member ID not found. Please enter a valid Member ID.");
                                            return;
                                        }
                                        String serviceCode = serviceCodeTextField.getText();
                                        String dateOfService = dateTextField.getText();
                                        if(dateOfService.length() != 10){
                                            JOptionPane.showMessageDialog(frame, "Invalid date. Please enter a valid date. (MM-DD-YYYY)");
                                            return;
                                        }
                                        String comments = commentsTextField.getText();
                                        Optional<ProviderDirectory> serviceByCode = controller.searchServiceCode(Integer.parseInt(serviceCode), "gitRepositoryTeam6/chocAnSystem/ProgramFiles/providerDirectory.json");
                                        if (serviceByCode.isPresent()) {
                                            // Ask the user to confirm the selected service
                                            int option = JOptionPane.showConfirmDialog(frame,
                                                    "Is this the correct service?\n" +
                                                            "Service Code: " + serviceByCode.get().getServiceCode() + "\n" +
                                                            "Service Name: " + serviceByCode.get().getServiceName() + "\n" +
                                                            "Service Fee: " + serviceByCode.get().getServiceFee(),
                                                    "Confirm Service",
                                                    JOptionPane.YES_NO_OPTION);

                                            if (option == JOptionPane.YES_OPTION) {
                                                // User confirmed, process the data further
                                                // Add your code here to handle the input values
                                                controller.saveServiceRecord(dateOfService, Integer.parseInt(providerID), Integer.parseInt(memberID), Integer.parseInt(serviceCode), comments, "gitRepositoryTeam6/chocAnSystem/ProgramFiles/serviceRecords.json");
                                                JOptionPane.showMessageDialog(frame, "Successfully logged service!");
                                                // Optionally, close the frame after submitting
                                                frame.dispose();
                                            } else {
                                                return;
                                            }
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(frame, "Service Code not found. Please enter a valid Service Code.");
                                            return;
                                        }

                                        // frame.dispose(); // Optionally close the frame here after processing
                                    }
                                });

                                // Make the frame visible
                                frame.setVisible(true);
                            });

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
                    providerTerminalFrame.dispose();
                } else {
                    // If invalid, show a message or prompt for re-input
                    JOptionPane.showMessageDialog(providerTerminalFrame,
                            "Invalid provider ID. Please enter a valid 9-digit ID. " + (5 - attempts) + " attempts left",
                            "Invalid ID", JOptionPane.ERROR_MESSAGE);

                    // Optionally clear the input field for re-entry
                    idTextField.setText("");

                    // Increment the attempts counter
                    attempts++;
                }
//                pTerminal.main(pTerminalArgs);
            }
        });
        providerTerminalFrame.setVisible(true);
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
                if (oTerminal.checkIDNumber(Integer.parseInt(operatorID), "gitRepositoryTeam6/chocAnSystem/ProgramFiles/operatorIDs.json")) {
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
                            JButton exitButton = new JButton("Exit");

                            // Set layout manager for the new JFrame
                            manageMembersFrame.setLayout(new GridLayout(5, 1));

                            // Add components to the new JFrame
                            manageMembersFrame.add(promptLabel);
                            manageMembersFrame.add(addMemberButton);
                            manageMembersFrame.add(updateMemberButton);
                            manageMembersFrame.add(deleteMemberButton);
                            manageMembersFrame.add(exitButton);

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
                                            if (Double.isNaN(balance)) {
                                                JOptionPane.showMessageDialog(addMemberFrame, "Balance must be a double");
                                                throw new IllegalArgumentException("Balance must be a double");
                                            }

                                            // Use the retrieved values as needed (you can pass them to your memberController)
                                            // For now, just display them in a message
                                            memberController.addMember(name, number, address, city, state, zip, balance);
                                            JOptionPane.showMessageDialog(manageMemberButton, "Added Member!");

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
                                    // Create a new JFrame
                                    JFrame updateMemberFrame = new JFrame("Enter member's information");

                                    // Set the layout manager for the frame
                                    updateMemberFrame.setLayout(new GridBagLayout());

                                    // Create labels and text fields
                                    JLabel nameLabel = new JLabel("Member's Name:");
                                    JTextField nameTextField = new JTextField();

                                    JLabel aspectLabel = new JLabel("Aspect to change:");
                                    JTextField aspectTextField = new JTextField();

                                    JLabel valueLabel = new JLabel("New Aspect Value:");
                                    JTextField valueTextField = new JTextField();

                                    // Create the Submit button
                                    JButton submitButton = new JButton("Submit");

                                    // Add action listener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the "Submit" button click event
                                            // You can retrieve values from text fields and perform specific actions here

                                            // For example, retrieve values from text fields
                                            String memberName = nameTextField.getText();
                                            String aspectToChange = aspectTextField.getText();
                                            String newAspectValue = valueTextField.getText();

                                            // Implement logic for updating a member with the entered information
                                            // You can replace the following line with your actual implementation
                                            memberController.updateMember(memberName, aspectToChange, newAspectValue);
                                            JOptionPane.showMessageDialog(updateMemberFrame, "If the member exists, their information has been updated!");
                                            // Close the updateMemberFrame after submitting
                                            updateMemberFrame.dispose();
                                        }
                                    });

                                    // Create a GridBagConstraints to make the "Submit" button span the entire width
                                    GridBagConstraints gbc = new GridBagConstraints();
                                    gbc.gridx = 0;
                                    gbc.gridy = 3; // Row 3
                                    gbc.gridwidth = 2; // Span 2 columns
                                    gbc.fill = GridBagConstraints.HORIZONTAL; // Make the button expand horizontally

                                    // Add labels and text fields to the frame with GridBagConstraints
                                    updateMemberFrame.add(nameLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(nameTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(aspectLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(aspectTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(valueLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(valueTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(submitButton, gbc);

                                    // Center the frame on the screen
                                    updateMemberFrame.setLocationRelativeTo(null);

                                    // Set frame properties
                                    updateMemberFrame.setSize(400, 200);
                                    updateMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    updateMemberFrame.setVisible(true);
                                }
                            });

                            deleteMemberButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Create a new JFrame
                                    JFrame deleteMemberFrame = new JFrame("What is the name of the member you would like to delete?");

                                    // Set the layout manager for the frame
                                    deleteMemberFrame.setLayout(new GridBagLayout());

                                    // Create labels and text fields
                                    JLabel nameLabel = new JLabel("Name:");
                                    JTextField nameTextField = new JTextField();

                                    // Create the Submit button
                                    JButton submitButton = new JButton("Submit");

                                    // Add action listener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the "Submit" button click event
                                            // You can retrieve values from text fields and perform specific actions here

                                            // For example, retrieve the name from the text field
                                            String memberNameToDelete = nameTextField.getText();
                                            memberController.deleteMember(memberNameToDelete);
                                            JOptionPane.showMessageDialog(deleteMemberFrame, "Deleted member " + memberNameToDelete + " if their file exists");

                                            // Close the deleteMemberFrame after submitting
                                            deleteMemberFrame.dispose();
                                        }
                                    });

                                    // Create a GridBagConstraints to arrange components
                                    GridBagConstraints gbc = new GridBagConstraints();
                                    gbc.gridx = 0;
                                    gbc.gridy = 0;
                                    gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
                                    gbc.anchor = GridBagConstraints.WEST; // Align components to the left

                                    // Add labels and text fields to the frame with GridBagConstraints
                                    deleteMemberFrame.add(nameLabel, gbc);
                                    gbc.gridy++;
                                    gbc.fill = GridBagConstraints.HORIZONTAL;
                                    deleteMemberFrame.add(nameTextField, gbc);
                                    gbc.gridy++;
                                    gbc.weightx = 1.0; // Make the submit button take up the entire width
                                    gbc.fill = GridBagConstraints.HORIZONTAL;
                                    deleteMemberFrame.add(submitButton, gbc);

                                    // Center the frame on the screen
                                    deleteMemberFrame.setLocationRelativeTo(null);

                                    // Set frame properties
                                    deleteMemberFrame.setSize(300, 200);
                                    deleteMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    deleteMemberFrame.setVisible(true);
                                }

                            });
                            exitButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Handle the "Exit" button click event
                                    manageMembersFrame.dispose(); // Close the options frame
                                }
                            });
                            // Show the new window
                            manageMembersFrame.setVisible(true);
                        }
                    });

                    manageProviderButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Create a new JFrame
                            JFrame optionsFrame = new JFrame("Provider Records");

                            // Set the layout manager for the frame
                            optionsFrame.setLayout(new GridLayout(5, 1, 0, 0)); // 4 rows, 1 column, with zero gaps

                            // Create buttons
                            JLabel title = new JLabel("What would you like to do?");
                            JButton addProviderButton = new JButton("Add Provider");
                            JButton updateProviderButton = new JButton("Update Provider");
                            JButton deleteProviderButton = new JButton("Delete Provider");
                            JButton exitButton = new JButton("Exit");

                            // Add action listeners to the buttons
                            addProviderButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Open a new JFrame for adding a member
                                    JFrame addProviderFrame = new JFrame("Add Provider");
                                    addProviderFrame.setSize(400, 300);
                                    addProviderFrame.setLocationRelativeTo(optionsFrame);
                                    addProviderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                    // Create components for the new JFrame
                                    JLabel nameLabel = new JLabel("Provider's Name:");
                                    JTextField nameTextField = new JTextField();

                                    JLabel numberLabel = new JLabel("Provider's Number:");
                                    JTextField numberTextField = new JTextField();

                                    JLabel addressLabel = new JLabel("Provider's Address:");
                                    JTextField addressTextField = new JTextField();

                                    JLabel cityLabel = new JLabel("Provider's City:");
                                    JTextField cityTextField = new JTextField();

                                    JLabel stateLabel = new JLabel("Provider's State:");
                                    JTextField stateTextField = new JTextField();

                                    JLabel zipLabel = new JLabel("Provider's ZIP:");
                                    JTextField zipTextField = new JTextField();

                                    JLabel balanceLabel = new JLabel("Provider's Balance:");
                                    JTextField balanceTextField = new JTextField();

                                    JButton submitButton = new JButton("Submit");

                                    // Set layout manager for the new JFrame
                                    addProviderFrame.setLayout(new GridLayout(8, 2));

                                    // Add components to the new JFrame
                                    addProviderFrame.add(nameLabel);
                                    addProviderFrame.add(nameTextField);

                                    addProviderFrame.add(numberLabel);
                                    addProviderFrame.add(numberTextField);

                                    addProviderFrame.add(addressLabel);
                                    addProviderFrame.add(addressTextField);

                                    addProviderFrame.add(cityLabel);
                                    addProviderFrame.add(cityTextField);

                                    addProviderFrame.add(stateLabel);
                                    addProviderFrame.add(stateTextField);

                                    addProviderFrame.add(zipLabel);
                                    addProviderFrame.add(zipTextField);

                                    addProviderFrame.add(balanceLabel);
                                    addProviderFrame.add(balanceTextField);

                                    addProviderFrame.add(new JLabel()); // Placeholder for better layout
                                    addProviderFrame.add(submitButton);

                                    // Add ActionListener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Retrieve entered values
                                            String name = nameTextField.getText();
                                            int number = Integer.parseInt(numberTextField.getText());
                                            if (Integer.toString(number).length() != 10) {
                                                JOptionPane.showMessageDialog(addProviderFrame, "Provider Number must be 10 digits");
                                                throw new IllegalArgumentException("Provider number must be 10 digits");
                                            }
                                            String address = addressTextField.getText();
                                            String city = cityTextField.getText();
                                            String state = stateTextField.getText();
                                            int zip = Integer.parseInt(zipTextField.getText());
                                            if (Integer.toString(zip).length() != 5) {
                                                JOptionPane.showMessageDialog(addProviderFrame, "ZIP must be 5 digits");
                                                throw new IllegalArgumentException("ZIP must be 5 digits");
                                            }
                                            double balance = Double.parseDouble(balanceTextField.getText());
                                            if (Double.isNaN(balance)) {
                                                JOptionPane.showMessageDialog(addProviderFrame, "Balance must be a double");
                                                throw new IllegalArgumentException("Balance must be a double");
                                            }

                                            // Use the retrieved values as needed (you can pass them to your memberController)
                                            // For now, just display them in a message
                                            JOptionPane.showMessageDialog(manageMemberButton, "Added Provider!");
                                            providerController.addProvider(name, number, address, city, state, zip, balance);

                                            // Optionally, perform additional actions with the entered values

                                            // Close the addMemberFrame
                                            addProviderFrame.dispose();
                                        }
                                    });

                                    // Show the new window
                                    addProviderFrame.setVisible(true);
                                }
                            });

                            updateProviderButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Create a new JFrame
                                    JFrame updateMemberFrame = new JFrame("Enter provider's information");

                                    // Set the layout manager for the frame
                                    updateMemberFrame.setLayout(new GridBagLayout());

                                    // Create labels and text fields
                                    JLabel nameLabel = new JLabel("Provider's Name:");
                                    JTextField nameTextField = new JTextField();

                                    JLabel aspectLabel = new JLabel("Aspect to change:");
                                    JTextField aspectTextField = new JTextField();

                                    JLabel valueLabel = new JLabel("New Aspect Value:");
                                    JTextField valueTextField = new JTextField();

                                    // Create the Submit button
                                    JButton submitButton = new JButton("Submit");

                                    // Add action listener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the "Submit" button click event
                                            // You can retrieve values from text fields and perform specific actions here

                                            // For example, retrieve values from text fields
                                            String providerName = nameTextField.getText();
                                            String aspectToChange = aspectTextField.getText();
                                            String newAspectValue = valueTextField.getText();

                                            // Implement logic for updating a member with the entered information
                                            // You can replace the following line with your actual implementation
                                            providerController.updateProvider(providerName, aspectToChange, newAspectValue);
                                            JOptionPane.showMessageDialog(updateMemberFrame, "If the provider exists, their information has been updated!");
                                            // Close the updateMemberFrame after submitting
                                            updateMemberFrame.dispose();
                                        }
                                    });

                                    // Create a GridBagConstraints to make the "Submit" button span the entire width
                                    GridBagConstraints gbc = new GridBagConstraints();
                                    gbc.gridx = 0;
                                    gbc.gridy = 3; // Row 3
                                    gbc.gridwidth = 2; // Span 2 columns
                                    gbc.fill = GridBagConstraints.HORIZONTAL; // Make the button expand horizontally

                                    // Add labels and text fields to the frame with GridBagConstraints
                                    updateMemberFrame.add(nameLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(nameTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(aspectLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(aspectTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(valueLabel, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(valueTextField, gbc);
                                    gbc.gridy++;
                                    updateMemberFrame.add(submitButton, gbc);

                                    // Center the frame on the screen
                                    updateMemberFrame.setLocationRelativeTo(null);

                                    // Set frame properties
                                    updateMemberFrame.setSize(400, 200);
                                    updateMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    updateMemberFrame.setVisible(true);
                                }
                            });

                            deleteProviderButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Create a new JFrame
                                    JFrame deleteMemberFrame = new JFrame("What is the name of the provider you would like to delete?");

                                    // Set the layout manager for the frame
                                    deleteMemberFrame.setLayout(new GridBagLayout());

                                    // Create labels and text fields
                                    JLabel nameLabel = new JLabel("Name:");
                                    JTextField nameTextField = new JTextField();

                                    // Create the Submit button
                                    JButton submitButton = new JButton("Submit");

                                    // Add action listener to the Submit button
                                    submitButton.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Handle the "Submit" button click event
                                            // You can retrieve values from text fields and perform specific actions here

                                            // For example, retrieve the name from the text field
                                            String providerNameToDelete = nameTextField.getText();
                                            providerController.deleteProvider(providerNameToDelete);
                                            JOptionPane.showMessageDialog(deleteMemberFrame, "Deleted provider " + providerNameToDelete + " if their file exists");

                                            // Close the deleteMemberFrame after submitting
                                            deleteMemberFrame.dispose();
                                        }
                                    });

                                    // Create a GridBagConstraints to arrange components
                                    GridBagConstraints gbc = new GridBagConstraints();
                                    gbc.gridx = 0;
                                    gbc.gridy = 0;
                                    gbc.insets = new Insets(10, 10, 10, 10); // Add some padding
                                    gbc.anchor = GridBagConstraints.WEST; // Align components to the left

                                    // Add labels and text fields to the frame with GridBagConstraints
                                    deleteMemberFrame.add(nameLabel, gbc);
                                    gbc.gridy++;
                                    gbc.fill = GridBagConstraints.HORIZONTAL;
                                    deleteMemberFrame.add(nameTextField, gbc);
                                    gbc.gridy++;
                                    gbc.weightx = 1.0; // Make the submit button take up the entire width
                                    gbc.fill = GridBagConstraints.HORIZONTAL;
                                    deleteMemberFrame.add(submitButton, gbc);

                                    // Center the frame on the screen
                                    deleteMemberFrame.setLocationRelativeTo(null);

                                    // Set frame properties
                                    deleteMemberFrame.setSize(300, 200);
                                    deleteMemberFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    deleteMemberFrame.setVisible(true);
                                }
                            });

                            exitButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Handle the "Exit" button click event
                                    optionsFrame.dispose(); // Close the options frame
                                }
                            });

                            // Add buttons to the frame
                            optionsFrame.add(title);
                            optionsFrame.add(addProviderButton);
                            optionsFrame.add(updateProviderButton);
                            optionsFrame.add(deleteProviderButton);
                            optionsFrame.add(exitButton);

                            // Center the frame on the screen
                            optionsFrame.setLocationRelativeTo(null);

                            // Set frame properties
                            optionsFrame.setSize(300, 200);
                            optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            optionsFrame.setVisible(true);
                        }

                    });

                    backUpDataButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //potentially implement actual backup functionality?
                            JOptionPane.showMessageDialog(welcomeFrame, "Data backed up!");
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