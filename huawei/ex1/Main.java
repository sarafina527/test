import java.util.*;

public class Main{

	public static void main(String[] args) {
        
		Scanner input = new Scanner(System.in);

		
			String str = input.next();
        	boolean flag = false;
        	
            if(str==null||str.equals(""))
				System.out.println("false");
            else{
                LinkedList<Character> stack = new LinkedList<Character>();
                for(int i=0;i<str.length();i++){

                    char c = str.charAt(i);

                    if(c=='('||c=='['||c=='{'){
                        flag = true;
                        stack.push(c);
                    }else if(c==')'||c==']'||c=='}'){
                    	if(stack.size()==0){
                    		System.out.println("false");
                    	}
							
                    }
                    if(c==')'){
                       
                        else{
                            char top = stack.pop();
                            if(top!='(')
                                System.out.println("false");
                        }
                        
                    }else if(c==']'){
                        if(stack.isEmpty()) 
							System.out.println("false");
                        else{
                            char top = stack.pop();
                            if(top!='[')
                                System.out.println("false");
                        }
                    }else if(c=='}'){
                        if(stack.isEmpty()) 
							System.out.println("false");
                        else{
                            char top = stack.pop();
                            if(top!='{')
                                System.out.println("false");
                        }
                    }
                }
                if(stack.size()==0)
                    System.out.println("true");
                else 
                    System.out.println("false");
            }
			
						
		
        
        		
	}
}