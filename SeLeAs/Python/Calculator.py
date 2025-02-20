print('''
+ Addition
- Substraction
* Multiplication
/ Division''')
a = eval(input("Enter 1st Value :-"))
b = eval(input("Enter 2nd Value :-"))
opr = input("Enter the Operator (+,-,*,/) ")
if opr == "+":
    print("Addition between",a," + ", b, " = " ,a+b)
elif opr=="-" :
    print("Substraction between",a," - " , b , " = " , a-b)
elif opr == "*":
    print("Multiplication between",a," * ", b, " = ", a*b)
elif opr == "/":
    print("Division between",a," / ", b ," = ", a/b)
else :
    print("Invalid Operator")