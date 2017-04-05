public class PrintIntegerVertically {
public static void PrintVertically(int i){
if(i==0)
    return;
int reverse_number = 0;
while (i != 0)
{    
     int last_number = i % 10;
     reverse_number = reverse_number * 10 + last_number;
     i = i / 10;
}
int new_number = 0;
while (reverse_number != 0)
{    
     int first_digit = reverse_number % 10;
     System.out.println(first_digit);
     new_number = new_number * 10 + first_digit;
     reverse_number = reverse_number / 10;
}
}

public static void main(String args[])
{
    PrintVertically(123);
    PrintVertically(4321);
}
}