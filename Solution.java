import java.util.*;
class Solution{
   static char placeHolder = '0' ;
   public static void main(String []argh)
   {
      Scanner sc = new Scanner(System.in);
      
      while (sc.hasNext()) {
         String input=sc.next();
         //Complete the code
         boolean hasLooped = false ;
         StringBuilder nextInput = new StringBuilder(input) ;
         while(true){
             if(nextInput.length() != 0){
                if( isOdd(nextInput) ){
                    System.out.println( false );
                    break;
                }else{
                    for(int i = 0 ; i < nextInput.length() -1  ; i++ ){
                        char currentChar = nextInput.charAt(i) ;
                        char nextChar = nextInput.charAt(i+1) ;

                        if( isOpenAndClose(currentChar,nextChar ) ){
                            nextInput.setCharAt(i, placeHolder ) ;  
                            nextInput.setCharAt(i+1, placeHolder ) ;
                        }
                    }
                    StringBuilder newInput = removeDots(nextInput);
                    if( newInput.length() == nextInput.length() ){
                        System.out.println( false );
                        break;
                    }else{
                        nextInput = newInput ;
                    }
                }
             }else{
                 System.out.println( true );
                 break;
             } 
         }// loop till length is null or nothing to replace

      }
      
   }
    
    private static StringBuilder removeDots(StringBuilder str){
        return new StringBuilder(str.toString().replaceAll(placeHolder+"", "")) ;
    }
     private static boolean isOdd(StringBuilder str){  
        return ((str.length() % 2) != 0) ;
     }
    
     private static boolean isEmpty(String input){
        if( (input == null) || (input=="") ){
            return true;
        }else{
            return false ;
        }
    }
    
    
    private static boolean isOpenAndClose(char open, char close){
        switch(open){
            case '{' : 
                return '}' == ( close ) ;                
            case '[' : 
                return ']' == ( close ) ;                
            case '(' : 
                return ')' == (close) ;
            default :
                return false ;
        }
    }
}

