class Oc2
{
void sum(int a,int b)
{
System.out.println("int arg method invoked");
}
void sum(long a,long b)
{
System.out.println("long arg method invoked");
}
public static void main(String args[])
{
Oc2 oc=new Oc2();
oc.sum(20,20);
}
}