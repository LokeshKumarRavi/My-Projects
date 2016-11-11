import java.util.*;
class reverse
{
public static void main(String args[ ])
{
System.out.println("Enter the values");
Scanner sc=new Scanner(System.in);
String s1=sc.next( );
char[ ] ch=s1.toCharArray( );
{
for(int i=s1.length()-1;i>=0;i--)
{
System.out.print(ch[i]  );
}
}
}
}