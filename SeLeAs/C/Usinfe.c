#include<stdio.h>
#include<stdlib.h>
int main()
{

    int age;
    double cgpa;
    char grade;
    char name[20]; /*Initialize size fo data*/
    printf("Enter Your Name: ");
    fgets(name, 20 , stdin);
    printf("Enter your age: ");
    scanf("%d", &age); /* %d for integer data*/
    printf("Enter your CGPA: ");
    scanf("%lf", &cgpa); /* %lf for receiving double data*/
    printf("Enter your Grade: ");
    scanf("%s", &grade); /* %s for receiving string data*/
    
    printf("your Name is %s", name);
    printf("Age is  %d", age);
    printf("\n"); /* To change line*/
    printf("CGPA is  %f", cgpa); /* %f to give double data*/
    printf("\n");
    printf("Grade is  %c", grade); /* %c to give single string data*/
    printf("\n");
    return 0;
}