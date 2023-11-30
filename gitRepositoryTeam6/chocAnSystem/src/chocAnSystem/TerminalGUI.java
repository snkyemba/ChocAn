package chocAnSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalGUI extends JFrame {

    public TerminalGUI() {
        // Set up the main frame
        setTitle("Terminal Selector");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        JButton managerButton = new JButton("Manager Terminal");
        JButton providerButton = new JButton("Provider Terminal");
        JButton operatorButton = new JButton("Operator Terminal");

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

        // Set up the layout
        setLayout(new GridLayout(3, 1));
        add(managerButton);
        add(providerButton);
        add(operatorButton);
    }

    private void openManagerTerminal() {
        // Add logic to open Manager Terminal
        JOptionPane.showMessageDialog(this, "Opening Manager Terminal");
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
