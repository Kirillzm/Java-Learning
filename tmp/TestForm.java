package tmp;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestForm extends JFrame {
    private JTable table1;
    private JTextArea textArea1;
    private JButton button1;
    private JButton wererwerButton;
    private JPanel panel1;

    public TestForm() {
        super("MyForm");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked" + e.getX());
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
