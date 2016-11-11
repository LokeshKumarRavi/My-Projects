class OverloadingCalculation1
{
void sum(int a,long b)
{
System.out.println(a+b);
}
void sum(int a,int b,int c)
{
System.out.println(a+b+c);
}
public static void main(String args[])
{
OverloadingCalculation1 cal=new OverloadingCalculation1();
cal.sum(10,10);
cal.sum(10,10,10);
}
}