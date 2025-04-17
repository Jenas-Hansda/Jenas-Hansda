#include <iostream>
#include <graphics.h> // Include graphics library
#include <conio.h>    // For getch()

using namespace std;

void bresenham(int x1, int y1, int x2, int y2)
{
    int dx = x2 - x1;
    int dy = y2 - y1;
    int sx = (dx > 0) ? 1 : -1;
    int sy = (dy > 0) ? 1 : -1;

    dx = abs(dx);
    dy = abs(dy);

    if (dx > dy)
    {
        int err = dx / 2;
        while (x1 != x2)
        {
            putpixel(x1, y1, WHITE); // Draw pixel
            err -= dy;
            if (err < 0)
            {
                y1 += sy;
                err += dx;
            }
            x1 += sx;
        }
    }
    else
    {
        int err = dy / 2;
        while (y1 != y2)
        {
            putpixel(x1, y1, WHITE); // Draw pixel
            err -= dx;
            if (err < 0)
            {
                x1 += sx;
                err += dy;
            }
            y1 += sy;
        }
    }

    putpixel(x2, y2, WHITE); // Draw the last pixel
}

int main()
{
    int gdriver = DETECT, gmode;
    char data[] = "C:\\TDM-GCC-32\\liblibbgi.a"; // Path to libbgi.a

    // Initialize graphics mode
    initgraph(&gdriver, &gmode, data); // Change path as needed

    if (gdriver == -1) // Check for initialization error
    {
        cout << "Graphics initialization failed!" << endl;
        return 1; // Exit with error code
    }

    int x1, y1, x2, y2;

    cout << "Enter coordinates of first point (x1 y1): ";
    cin >> x1 >> y1; // Input first point
    cout << "Enter coordinates of second point (x2 y2): ";
    cin >> x2 >> y2; // Input second point 

    bresenham(x1, y1, x2, y2); // Call Bresenham function

    getch();      // Wait for a key press
    closegraph(); // Close graphics mode
    return 0;
}