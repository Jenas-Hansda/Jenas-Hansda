import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SutherlandHodgmanClipping extends JPanel {

    private List<Point> polygon; // Original polygon vertices
    private List<Point> clippedPolygon; // Clipped polygon vertices
    private int x_min = 100, y_min = 100, x_max = 400, y_max = 400; // Clipping window

    public SutherlandHodgmanClipping() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
        polygon = new ArrayList<>();
        clippedPolygon = new ArrayList<>();
    }

    // Sutherland-Hodgman Polygon Clipping Algorithm
    public void sutherlandHodgmanClip(List<Point> polygon, int x_min, int y_min, int x_max, int y_max) {
        clippedPolygon.clear();
        List<Point> subjectPolygon = new ArrayList<>(polygon);

        // Clip against each of the four clipping window edges (left, right, bottom, top)
        clippedPolygon = clip(subjectPolygon, x_min, y_min, x_max, y_max);
        repaint();
    }

    // Clip a polygon against one edge of the clipping window (left, right, bottom, top)
    private List<Point> clip(List<Point> subjectPolygon, int x_min, int y_min, int x_max, int y_max) {
        List<Point> output = new ArrayList<>();
        Point S = subjectPolygon.get(subjectPolygon.size() - 1); // Last point in polygon

        for (Point E : subjectPolygon) {
            // Check intersection with each of the four edges
            if (E.x >= x_min && E.x <= x_max && E.y >= y_min && E.y <= y_max) { // Inside the rectangle
                if (S.x < x_min && E.x >= x_min) { // Intersection with left
                    output.add(intersect(S, E, x_min, y_min, x_max, y_max));
                }
                if (S.x > x_max && E.x <= x_max) { // Intersection with right
                    output.add(intersect(S, E, x_min, y_min, x_max, y_max));
                }
                if (S.y < y_min && E.y >= y_min) { // Intersection with bottom
                    output.add(intersect(S, E, x_min, y_min, x_max, y_max));
                }
                if (S.y > y_max && E.y <= y_max) { // Intersection with top
                    output.add(intersect(S, E, x_min, y_min, x_max, y_max));
                }
                if ((S.x >= x_min && S.x <= x_max) && (S.y >= y_min && S.y <= y_max)) {
                    output.add(E); // Add the inside vertex
                }
            }
            S = E;
        }
        return output;
    }

    // Calculate intersection point with edge of clipping window
    private Point intersect(Point p1, Point p2, int x_min, int y_min, int x_max, int y_max) {
        float m = (float) (p2.y - p1.y) / (p2.x - p1.x);
        float c = p1.y - m * p1.x;

        int x = 0, y = 0;

        if (p1.x < x_min && p2.x >= x_min) { // Intersection with left
            x = x_min;
            y = (int) (m * x + c);
        }
        if (p1.x > x_max && p2.x <= x_max) { // Intersection with right
            x = x_max;
            y = (int) (m * x + c);
        }
        if (p1.y < y_min && p2.y >= y_min) { // Intersection with bottom
            y = y_min;
            x = (int) ((y - c) / m);
        }
        if (p1.y > y_max && p2.y <= y_max) { // Intersection with top
            y = y_max;
            x = (int) ((y - c) / m);
        }
        return new Point(x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw clipping window (blue)
        g.setColor(Color.BLUE);
        g.drawRect(x_min, y_min, x_max - x_min, y_max - y_min);

        // Draw original polygon (light gray)
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < polygon.size() - 1; i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // Draw clipped polygon (red)
        g.setColor(Color.RED);
        for (int i = 0; i < clippedPolygon.size() - 1; i++) {
            Point p1 = clippedPolygon.get(i);
            Point p2 = clippedPolygon.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sutherland-Hodgman Polygon Clipping");

        // Create a panel for polygon and clipping
        SutherlandHodgmanClipping panel = new SutherlandHodgmanClipping();

        // Input fields for polygon vertices
        JTextField verticesField = new JTextField("50,50 200,50 200,200 50,200", 20);
        JButton clipButton = new JButton("Clip Polygon");

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter polygon vertices (e.g. 50,50 200,50 200,200 50,200):"));
        inputPanel.add(verticesField);
        inputPanel.add(clipButton);

        clipButton.addActionListener(e -> {
            try {
                String input = verticesField.getText();
                String[] points = input.split(" ");
                List<Point> newPolygon = new ArrayList<>();

                for (String point : points) {
                    String[] coordinates = point.split(",");
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    newPolygon.add(new Point(x, y));
                }

                panel.polygon = newPolygon;
                panel.sutherlandHodgmanClip(newPolygon, panel.x_min, panel.y_min, panel.x_max, panel.y_max);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid vertices.");
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
