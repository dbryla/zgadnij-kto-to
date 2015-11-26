import javax.swing.*;
import java.awt.*;

/**
 * Created by anna on 25.11.15.
 */
public class MainWindow extends JFrame {

    private static final String TAK = "Tak";
    private static final String NIE = "Nie";

    private JLabel label;
    private JButton yesButton;
    private JButton noButton;
    private String answer;

    public MainWindow(){
        init();
        initComponents();
        addButtonListeners();
    }

    private void init() {
        setTitle("Zgadnij kto to");
        setSize(300, 150);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        label = new JLabel("");
        yesButton = new JButton(TAK);
        noButton = new JButton(NIE);
        JPanel panel  = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(panel);

        JPanel buttonPanel  = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(yesButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(5,0)));
        buttonPanel.add(noButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(Box.createGlue());
        panel.add(buttonPanel);
        panel.setVisible(true);
    }

    private void addButtonListeners() {
        yesButton.addActionListener(actionEvent -> answer = "t");
        noButton.addActionListener(actionEvent -> answer = "n");
    }


    public void updateLabel(String string) {
        answer = null;
        label.setText(string.replace("_", " "));
    }

    public String getAnswer() {
        while(answer == null){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return answer;
    }
}
