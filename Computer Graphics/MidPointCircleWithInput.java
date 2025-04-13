import javax.swing.*;
import java.awt.*;

public class MidPointCircleWithInput extends JPanel {

    private int xc, yc, radius;
    private boolean draw = false;

    public MidPointCircleWithInput() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.WHITE);
    }

    public void setCircle(int xc, int yc, int radius) {
        this.xc = xc;
        this.yc = yc;
        this.radius = radius;
        draw = true;
        repaint(); // Trigger paintComponent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (draw) {
            drawCircleMidPoint(g, xc, yc, radius);
        }
    }

    private void drawCircleMidPoint(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int p = 1 - r;

        plotCirclePoints(g, xc, yc, x, y);

        while (x < y) {
            x++;
            if (p < 0) {
                p += 2 * x + 1;
            } else {
                y--;
                p += 2 * (x - y) + 1;
            }
            plotCirclePoints(g, xc, yc, x, y);
        }
    }

    // Plots all 8 symmetric points of the circle
    private void plotCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        g.fillRect(xc + x, yc + y, 1, 1);
        g.fillRect(xc - x, yc + y, 1, 1);
        g.fillRect(xc + x, yc - y, 1, 1);
        g.fillRect(xc - x, yc - y, 1, 1);
        g.fillRect(xc + y, yc + x, 1, 1);
        g.fillRect(xc - y, yc + x, 1, 1);
        g.fillRect(xc + y, yc - x, 1, 1);
        g.fillRect(xc - y, yc - x, 1, 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mid-Point Circle Drawing Algorithm");
        MidPointCircleWithInput drawPanel = new MidPointCircleWithInput();

        // Input fields
        JTextField xcField = new JTextField(5);
        JTextField ycField = new JTextField(5);
        JTextField radiusField = new JTextField(5);
        JButton drawButton = new JButton("Draw");

        // Top input panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("xc:"));
        inputPanel.add(xcField);
        inputPanel.add(new JLabel("yc:"));
        inputPanel.add(ycField);
        inputPanel.add(new JLabel("Radius:"));
        inputPanel.add(radiusField);
        inputPanel.add(drawButton);

        drawButton.addActionListener(e -> {
            try {
                int xc = Integer.parseInt(xcField.getText());
                int yc = Integer.parseInt(ycField.getText());
                int radius = Integer.parseInt(radiusField.getText());
                if (radius <= 0) throw new NumberFormatException();
                drawPanel.setCircle(xc, yc, radius);
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
