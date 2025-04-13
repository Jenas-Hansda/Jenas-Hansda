import javax.swing.*;
import java.awt.*;

public class MidPointEllipseWithInput extends JPanel {

    private int xc, yc, rx, ry;
    private boolean draw = false;

    public MidPointEllipseWithInput() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
    }

    public void setEllipse(int xc, int yc, int rx, int ry) {
        this.xc = xc;
        this.yc = yc;
        this.rx = rx;
        this.ry = ry;
        draw = true;
        repaint(); // Trigger paintComponent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (draw) {
            drawEllipseMidPoint(g, xc, yc, rx, ry);
        }
    }

    private void drawEllipseMidPoint(Graphics g, int xc, int yc, int rx, int ry) {
        int x = 0;
        int y = ry;

        double rxSq = rx * rx;
        double rySq = ry * ry;
        double dx = 2 * rySq * x;
        double dy = 2 * rxSq * y;

        // Region 1
        double p1 = rySq - (rxSq * ry) + (0.25 * rxSq);
        while (dx < dy) {
            plotEllipsePoints(g, xc, yc, x, y);
            x++;
            dx = dx + (2 * rySq);
            if (p1 < 0) {
                p1 = p1 + dx + rySq;
            } else {
                y--;
                dy = dy - (2 * rxSq);
                p1 = p1 + dx - dy + rySq;
            }
        }

        // Region 2
        double p2 = (rySq * (x + 0.5) * (x + 0.5)) + (rxSq * (y - 1) * (y - 1)) - (rxSq * rySq);
        while (y >= 0) {
            plotEllipsePoints(g, xc, yc, x, y);
            y--;
            dy = dy - (2 * rxSq);
            if (p2 > 0) {
                p2 = p2 - dy + rxSq;
            } else {
                x++;
                dx = dx + (2 * rySq);
                p2 = p2 + dx - dy + rxSq;
            }
        }
    }

    private void plotEllipsePoints(Graphics g, int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc + x, yc - y, 1, 1);
        g.fillRect(xc - x, yc - y, 1, 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mid-Point Ellipse Drawing Algorithm");
        MidPointEllipseWithInput drawPanel = new MidPointEllipseWithInput();

        // Input fields
        JTextField xcField = new JTextField(5);
        JTextField ycField = new JTextField(5);
        JTextField rxField = new JTextField(5);
        JTextField ryField = new JTextField(5);
        JButton drawButton = new JButton("Draw");

        // Top panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("xc:"));
        inputPanel.add(xcField);
        inputPanel.add(new JLabel("yc:"));
        inputPanel.add(ycField);
        inputPanel.add(new JLabel("rx:"));
        inputPanel.add(rxField);
        inputPanel.add(new JLabel("ry:"));
        inputPanel.add(ryField);
        inputPanel.add(drawButton);

        drawButton.addActionListener(e -> {
            try {
                int xc = Integer.parseInt(xcField.getText());
                int yc = Integer.parseInt(ycField.getText());
                int rx = Integer.parseInt(rxField.getText());
                int ry = Integer.parseInt(ryField.getText());
                if (rx <= 0 || ry <= 0) throw new NumberFormatException();
                drawPanel.setEllipse(xc, yc, rx, ry);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid positive integers.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(drawPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
