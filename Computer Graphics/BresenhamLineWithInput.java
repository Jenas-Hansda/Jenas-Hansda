import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BresenhamLineWithInput extends JPanel {

    private int x1, y1, x2, y2;
    private boolean draw = false;

    public BresenhamLineWithInput() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    public void setCoordinates(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        draw = true;
        repaint(); // Re-draw the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (draw) {
            drawLineBresenham(g, x1, y1, x2, y2);
        }
    }

    private void drawLineBresenham(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;

        boolean steep = dy > dx;

        if (steep) {
            // Swap x and y
            int temp = dx;
            dx = dy;
            dy = temp;
        }

        int err = 2 * dy - dx;
        int x = x1;
        int y = y1;

        for (int i = 0; i <= dx; i++) {
            if (steep) {
                g.fillRect(y, x, 1, 1); // Swap x and y back
            } else {
                g.fillRect(x, y, 1, 1);
            }

            while (err >= 0) {
                if (steep) {
                    x += sx;
                } else {
                    y += sy;
                }
                err -= 2 * dx;
            }

            if (steep) {
                y += sy;
            } else {
                x += sx;
            }

            err += 2 * dy;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bresenham's Line Drawing with Input");
        BresenhamLineWithInput drawPanel = new BresenhamLineWithInput();

        // Input fields
        JTextField x1Field = new JTextField(5);
        JTextField y1Field = new JTextField(5);
        JTextField x2Field = new JTextField(5);
        JTextField y2Field = new JTextField(5);
        JButton drawButton = new JButton("Draw");

        // Top panel for inputs
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("x1:"));
        inputPanel.add(x1Field);
        inputPanel.add(new JLabel("y1:"));
        inputPanel.add(y1Field);
        inputPanel.add(new JLabel("x2:"));
        inputPanel.add(x2Field);
        inputPanel.add(new JLabel("y2:"));
        inputPanel.add(y2Field);
        inputPanel.add(drawButton);

        drawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int x1 = Integer.parseInt(x1Field.getText());
                    int y1 = Integer.parseInt(y1Field.getText());
                    int x2 = Integer.parseInt(x2Field.getText());
                    int y2 = Integer.parseInt(y2Field.getText());
                    drawPanel.setCoordinates(x1, y1, x2, y2);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integer coordinates.");
                }
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
