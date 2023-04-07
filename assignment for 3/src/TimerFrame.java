import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerFrame extends JFrame implements ActionListener {

    private JLabel timeLabel;
    private JButton colorButton, stopButton, startButton;
    private Timer timer;
    private Color chosenColor = Color.BLACK;
    private boolean red = false;

    public TimerFrame() {
        setTitle("Sat");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateTime();
        add(timeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        colorButton = new JButton("Choose color");
        colorButton.addActionListener(this);
        buttonPanel.add(colorButton);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }


    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeString = sdf.format(new Date());
        timeLabel.setText(timeString);
        timeLabel.setForeground(red ? Color.RED : chosenColor);
        red = !red;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {

            Color newColor = JColorChooser.showDialog(this, "Choose color", chosenColor);
            if (newColor != null) {
                chosenColor = newColor;
                timeLabel.setForeground(chosenColor);
            }
        } else if (e.getSource() == stopButton) {

            timer.stop();
        } else if (e.getSource() == startButton) {

            timer.start();
        }
    }

}

