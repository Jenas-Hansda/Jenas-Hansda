#include <graphics.h>

int main()
{
    int gd=DETECT , gm ;
    initgraph(&gd,&gm,(char*)"");
    circle(200,200,150);
    getch();
    closegraph();
    return 0;
}