class Calculation3
{
int sum(int a,int b)
{
return a+b;
}
int sum(int a,int b,int c)
{
return a+b+c;
}
public static void main(String args [])
{
Calculation3 cal=new Calculation3();
System.out.println(cal.sum(2,20,2));
}
}
