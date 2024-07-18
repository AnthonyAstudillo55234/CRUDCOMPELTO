import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {
    private JPanel mainPanel;
    private JButton ACTUALIZARButton;
    private JButton BORRARButton;
    private JButton CERRARButton;

    public form1() {
        setTitle("Menu");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600,400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form2();
                setVisible(false);
            }
        });
        ACTUALIZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form3();
                setVisible(false);
            }
        });
        CERRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
