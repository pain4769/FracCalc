import java.util.*; 

/**
 * Calculates fractions.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FracCalc {

    /**
     * Runs a fraction calculator.
     * 
     * @param args Not used
     */
    

    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        String inputLine = inputScanner.nextLine();
        System.out.println(produceAnswer(inputLine));
    }

    /**
     * ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.
     * This function will be used to test your code
     * This function takes a String 'input' and produces the result
     * 
     * @param input A fraction string that needs to be evaluated.
     * For your program, this will be the user input.
     *     e.g. input ==> "1/2 + 3/4"
     * @return The result of the fraction after it has been calculated
     *     e.g. return ==> "1_1/4"
     */
    public static String produceAnswer(String input)
    { 
        int space = input.indexOf(" ");
        String operator = input.substring(space + 1, space + 2);
        String first_operand = input.substring(0, space);
        String second_operand = input.substring(space + 3);
        
        String first_whole = " ";
        String first_numerator = " ";
        String first_denominator = " ";
        
        String second_whole = " ";
        String second_numerator = " ";
        String second_denominator = " ";
        
        if(first_operand.contains("_")){
            first_whole = first_operand.substring(0, first_operand.indexOf("_"));
            first_numerator = first_operand.substring(first_operand.indexOf("_") + 1, first_operand.indexOf("/"));
            first_denominator = first_operand.substring(first_operand.indexOf("/") + 1);
        }
        else {
            if(first_operand.contains("/")){
                first_whole = "0";
                first_numerator = first_operand.substring(0, first_operand.indexOf("/"));
                first_denominator = first_operand.substring(first_operand.indexOf("/") + 1);
                
            }
            else {
                first_whole = first_operand;
                first_numerator = "0";
                first_denominator = "1";
            }
        }
        
        if(second_operand.contains("_")){
            second_whole = second_operand.substring(0, second_operand.indexOf("_"));
            second_numerator = second_operand.substring(second_operand.indexOf("_") + 1, second_operand.indexOf("/"));
            second_denominator = second_operand.substring(second_operand.indexOf("/") + 1);
            
        }
        else {
            if(second_operand.contains("/")){
                second_whole = "0";
                second_numerator = second_operand.substring(0, second_operand.indexOf("/"));
                second_denominator = second_operand.substring(second_operand.indexOf("/") + 1);
                
            }
            else {
                second_whole = second_operand;
                second_numerator = "0";
                second_denominator = "1";
            }
        }
        
        int int_first_whole = Integer.parseInt(first_whole);
        int int_second_whole = Integer.parseInt(second_whole);
        int int_first_numerator = Integer.parseInt(first_numerator);
        int int_second_numerator = Integer.parseInt(second_numerator);
        int int_first_denominator = Integer.parseInt(first_denominator);
        int int_second_denominator = Integer.parseInt(second_denominator);
        
        int whole = 0;
        int numerator = 0;
        int denominator = 0;
        
         
        if(operator.equals("+")){
            if(first_whole.contains("-")){
                int_first_numerator *= -1;
            }
            
            if(second_whole.contains("-")){
                int_second_numerator *= -1;
            }
            whole = int_first_whole + int_second_whole;
            numerator = int_first_numerator * int_second_denominator + int_second_numerator * int_first_denominator;
            denominator = int_first_denominator * int_second_denominator;
            int gcf = gcf(numerator, denominator);
            numerator /= gcf;
            denominator /= gcf;
            
            int temp = numerator/denominator;
            
            whole += temp;
            numerator -= temp;
        }
        
        if(operator.equals("-")){
            if(first_whole.contains("-")){
                int_first_numerator *= -1;
            }
            
            if(second_whole.contains("-")){
                int_second_numerator *= -1;
            }
            whole = int_first_whole - int_second_whole;
            numerator = int_first_numerator * int_second_denominator - int_second_numerator * int_first_denominator;
            denominator = int_first_denominator * int_second_denominator;
            int gcf = gcf(numerator, denominator);
            numerator /= gcf;
            denominator /= gcf;
            
            int temp = numerator/denominator;
            
            whole += temp;
            numerator -= temp;
            

        }
        
        if(operator.equals("*")){
            if(first_whole.contains("-")){
                int_first_numerator = int_first_whole * int_first_denominator - int_first_numerator;   
            }
            else {
                int_first_numerator = int_first_whole * int_first_denominator + int_first_numerator;
            }
            
            if(second_whole.contains("-")){
                int_second_numerator = int_second_whole * int_second_denominator - int_second_numerator;   
            }
            else {
                int_second_numerator = int_second_whole * int_second_denominator + int_second_numerator;
            }
            
            numerator = int_first_numerator * int_second_numerator;
            denominator = int_first_denominator * int_second_denominator;
            whole = numerator/denominator;
            numerator = numerator%denominator;
            int gcf = gcf(numerator, denominator);
            numerator /= gcf;
            denominator /= gcf;
        }
        
        else {
            if(first_whole.contains("-")){
                int_first_numerator = int_first_whole * int_first_denominator - int_first_numerator;   
            }
            else {
                int_first_numerator = int_first_whole * int_first_denominator + int_first_numerator;
            }
            
            if(second_whole.contains("-")){
                int_second_numerator = int_second_whole * int_second_denominator - int_second_numerator;   
            }
            else {
                int_second_numerator = int_second_whole * int_second_denominator + int_second_numerator;
            }
            
            numerator = int_first_numerator * int_second_denominator;
            denominator = int_first_denominator * int_second_numerator;
            whole = numerator/denominator;
            numerator = numerator%denominator;
            int gcf = gcf(numerator, denominator);
            numerator /= gcf;
            denominator /= gcf;
        }
        
        if(numerator == 0){
            return String.valueOf(whole);
        }
        if(numerator < 0){
                numerator *= -1;
            }
            
        if(denominator < 0){
            numerator *= -1;
        }
        return whole + "_" + numerator + "/" + denominator;
    }
    
    // TODO: Fill in the space below with any helper methods

    /**
     * GCF
     * 
     * @param p first int
     * @param q second int
     * @return The GCF
     */
    public static int gcf(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

}

