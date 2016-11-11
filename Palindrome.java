class palindrome
{
public static void main(String args [ ])
{
char [ ] name={'m','a','d','a','m'};
char [ ] name1={'m','e','d','a','m'};
for(int i=0;i<5;i++)
{
if(name[i]==name1[i])
{
System.out.println("Palindrome");
}
else
{
System.out.println("Not a palindrome");
break;
}
}
}
}


