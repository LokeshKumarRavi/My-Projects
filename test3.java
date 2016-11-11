class test3
{
public static void main(String args[ ])
{
int i,j=5,k,x;
for(i=0;i<=5;i++)
{
for(k=0;k<i;k++)
{
System.out.print("     ");
}
for(x=0;x<=i;x++)
System.out.print( i+k );
System.out.println("     " );
}
j=j-i;
}
}