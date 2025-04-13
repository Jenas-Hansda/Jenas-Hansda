import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FloodFillAlgorithm extends JPanel implements MouseListener {

    private int width = 500, height = 500;
    private int[][] pixels; // Simulated screen buffer
    private final Color targetColor = Color.WHITE;
    private final Color fillColor = Color.CYAN;

    public FloodFillAlgorithm() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.WHITE);
        addMouseListener(this);

        // Initialize pixel buffer with background color
        pixels = new int[width][height];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                pixels[x][y] = targetColor.getRGB();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw a filled shape (rectangle with white interior)
        g.setColor(Color.BLACK);
        g.drawRect(100, 100, 200, 200);
        for (int i = 100; i <= 300; i++) {
            pixels[i][100] = Color.BLACK.getRGB();
            pixels[i][300] = Color.BLACK.getRGB();
            pixels[100][i] = Color.BLACK.getRGB();
            pixels[300][i] = Color.BLACK.getRGB();
        }

        // Draw the pixels that have been filled
        g.setColor(fillColor);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (pixels[x][y] == fillColor.getRGB()) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    // Flood Fill (4-connected)
    public void floodFill(int x, int y, int target, int replacement) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return;
        if (pixels[x][y] != target || pixels[x][y] == replacement)
            return;

        pixels[x][y] = replacement;

        floodFill(x + 1, y, target, replacement);
        floodFill(x - 1, y, target, replacement);
        floodFill(x, y + 1, target, replacement);
        floodFill(x, y - 1, target, replacement);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int target = pixels[x][y];
        floodFill(x, y, target, fillColor.getRGB());
        repaint();
    }

    // Unused mouse events
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flood Fill Algorithm - Click Inside Box to Fill");
        FloodFillAlgorithm panel = new FloodFillAlgorithm();
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
