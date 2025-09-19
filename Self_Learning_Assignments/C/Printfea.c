#include<stdio.h>
#include<stdlib.h>
int main()
{
    int a = 100;
    double b = 98.98;
    char gra ='A';
    char grad[] = "A++"; /* [] is used for multiple string*/
    printf("Hello world!"); /*To Print String*/
    printf("\n"); /*To Change Line*/
    printf("Hello\"World"); /*To print " in between the String*/
    printf("\n");
    printf("wanted to Print number is %d",55); /* Use of %d for data followed by , and Number*/
    printf("\n");
    printf("%s wanted to Print number %d","User",500); /*Use of %s for string*/
    printf("\n");
    printf("%s number is %f","User",50.98); /*Use of %f for float,double */
    printf("\n");
    printf("%d",a); /*Calling declared data*/
    printf("\n");
    printf("%f",b);
    printf("\n");
    printf("%c",gra); /* Use of %c for single character*/
    printf("\n");
    printf("%s",grad);
    return 0;
}