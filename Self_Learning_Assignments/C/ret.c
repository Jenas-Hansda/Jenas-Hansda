#include<stdio.h>
#include<stdlib.h>

double cube(double num){
    double result = num*num*num;
    return result;
}
int main(){
    /*printf("Enter Value: ");
    scanf("%f", cube);*/
    printf("Answer: %f", cube(25.0));
    return 0;
}