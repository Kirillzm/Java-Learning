package tmp;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Snake implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Snake());
    }

    public void run() {
        JFrame frame = new JFrame("Super snake game");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(900, 700);

        frame.add(new GameCanvas(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    class GameCanvas extends JPanel {
        private int x = 0;
        private int y = 0;
        private int delta = 10;

        public GameCanvas() {
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    delta = -delta;
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.clearRect(0, 0, getWidth(), getHeight());

            g2.setColor(Color.BLUE);
            g2.setStroke(new BasicStroke(10));
//            g2.drawRoundRect(x, y, 400, 500, 5, 5);

            try {
                g2.drawImage(ImageIO.read(new File("C:\\JavaRush\\JavaRushHomeWork\\src\\tmp\\Penguins.jpg")), x, y, null);


                g2.drawString("Я твой дом труба шатал!", 50, 50);

                x += delta;
                y += delta;
                revalidate();
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


