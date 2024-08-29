
public class Expressions 
{
  public static void main(String[] args)
  {
    int a = 3;
    int b = 4;
    int c = 5;
    int d = 17;
    
    /**********************************************************
     * 3 and 4 are added with sum 7 first because parenthesis 
     * forces the addition to come first
     * 7 is divided by 5 with 1 the result of integer division
     * The value displayed is 1
     ***********************************************************/
    System.out.println("#1 " + ((a + b) / c));   
    
    /**********************************************************
     * Because division has higher precedence, 4 is divided by 5 
     * with 0 the result of integer division 3 is added to 0 with
     * sum 3
     * The value displayed is 3
     ***********************************************************/
    System.out.println("#2 " + (a + b / c));       
    
    System.out.println("#3 " + (++a));       
    System.out.println("#4 " + (--a));
    System.out.println("#5 " + (a++));       
    System.out.println("#6 " + (a--));
    System.out.println("#7 " + (a + 1));        
    System.out.println("#8 " + (d % c));       
    System.out.println("#9 " + (d / c));       
    System.out.println("#10 " + (d % b));       
    System.out.println("#11 " + (d / b));       
    System.out.println("#12 " + (d + a / d + b));       
    System.out.println("#13 " + ((d + a) / (d + b)));       
    System.out.println("#14 " + (Math.sqrt(b)));       
    System.out.println("#15 " + (Math.pow(a, b)));       
    System.out.println("#16 " + (Math.abs(-a)));
    System.out.println("#17 " + (Math.max(a, b)));    
  } 
} 
