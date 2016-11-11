class Calz
{
int num1;
int num2;
int res;
void add(int a,int b)
{
num1=a;
num2=b;
res=a+b;
}
void sub(int a,int b)
{
num1=a;
num2=b;
res=a-b;
}
void multiple(int a,int b)
{
num1=a;
num2=b;
res=a*b;
}
void division(int a,int b)
{
num1=a;
num2=b;
res=a/b;
}
void display()
{
System.out.println("result" +res);
}
public static void main(String args[])
{
Calz c1=new Calz();
Calz c2=new Calz();
c1.add(3,3);
c1.display();
c1.sub(9,3);
c1.display();
c1.multiple(9,3);
c1.display();
c1.division(18,3);
c1.display();
}
}