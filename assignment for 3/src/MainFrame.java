import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JButton settingsButton;
    private JButton closeButton;

    public MainFrame(){
        super("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        settingsButton = new JButton("Settings");
        closeButton = new JButton("Close");

        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimerFrame timerFrame = new TimerFrame();
                timerFrame.setVisible(true);
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonsPanel.add(settingsButton);
        buttonsPanel.add(closeButton);
        add(buttonsPanel, BorderLayout.CENTER);
    }
}
