class Over
{
void sum(int a,int b)
{
System.out.println("a method invoked");
}
void sum(long a,int b)
{
System.out.println("b method invoked");
}
public static void main(String args[])
{
Over ov=new Over();
ov.sum(1,100,10);
}
}