class Calculation2
{
void sum(int a,int b)
{
System.out.println(a+b);
}
void sum(double a,double b)
{
System.out.println(a+b);
}
public static void main(String args[])
{
Calculation2 cal=new Calculation2();
cal.sum(11.5,11.5);
cal.sum(30,30);
}
}