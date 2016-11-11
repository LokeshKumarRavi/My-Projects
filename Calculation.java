class Calculation
{
void sum(int a,int b)
{
System.out.println(a+b);
}
void sum(int a,int b,int c)
{
System.out.println(a+b+c);
}
public static void main(String args [])
{
Calculation cal=new Calculation();
cal.sum(1,2,2);
cal.sum(3,3);
}
}