#include <iostream>
#include <graphics.h> // Include graphics library
#include <conio.h>   // For getch()

using namespace std;

// Function to draw the circle using Bresenham's algorithm
void drawCircle(int xc, int yc, int x, int y) {
    putpixel(xc + x, yc + y, WHITE);
    putpixel(xc - x, yc + y, WHITE);
    putpixel(xc + x, yc - y, WHITE);
    putpixel(xc - x, yc - y, WHITE);
    putpixel(xc + y, yc + x, WHITE);
    putpixel(xc - y, yc + x, WHITE);
    putpixel(xc + y, yc - x, WHITE);
    putpixel(xc - y, yc - x, WHITE);
}

// Function to implement Bresenham's circle drawing algorithm
void bresenhamCircle(int xc, int yc, int r) {
    int x = 0;
    int y = r;
    int d = 3 - 2 * r; // Decision parameter

    while (y >= x) {
        drawCircle(xc, yc, x, y); // Draw the circle points
        x++;

        // Update decision parameter based on the decision rule
        if (d > 0) {
            y--;
            d = d + 4 * (x - y) + 10;
        } else {
            d = d + 4 * x + 6;
        }
        
        drawCircle(xc, yc, x, y); // Draw again for symmetry
        delay(50); // Optional delay for visualization
    }
}

int main() {
    int gdriver = DETECT, gmode;
    char data[] = "C:\\TDM-GCC-32\\liblibbgi.a"; // Path to libbgi.a
    initgraph(&gdriver, &gmode, data) ; // Initialize graphics mode

    int xc, yc, r;

    cout << "Enter center coordinates of the circle (xc yc): ";
    cin >> xc >> yc; // Input center point
    cout << "Enter radius of the circle: ";
    cin >> r; // Input radius

    bresenhamCircle(xc, yc, r); // Call Bresenham's circle drawing function

    getch(); // Wait for a key press
    closegraph(); // Close graphics mode
    return 0;
}