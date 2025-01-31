import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new LinkedList<>(); 
        int N =Integer.parseInt(br.readLine());
        
        while(N -->0){
           StringTokenizer st = new StringTokenizer(br.readLine()," ");
           
            switch(st.nextToken()){
                case"push_front" :
                    q.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                    
               case"push_back" : 
                    q.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                    
                case "pop_front" :
                    if(q.isEmpty())
                        sb.append(-1+"\n");
                    else
                        sb.append(q.pollFirst()+"\n");
                    break;
                    
                case "pop_back" :
                    if(q.isEmpty())
                        sb.append(-1+"\n");
                    else
                        sb.append(q.pollLast()+"\n");
                    break;
                    
                case "size" :
                    sb.append(q.size()+"\n");
                    break;
                    
                case "empty" : 
                    if(q.isEmpty())
                        sb.append(1+"\n");
                    else
                        sb.append(0+"\n");
                    break;

                 case "front" : 
                    if(q.isEmpty())
                        sb.append(-1+"\n");
                    else
                        sb.append(q.peek()+"\n");
                    break;
                        
                 case "back" : 
                    if(q.isEmpty())
                        sb.append(-1+"\n");
                    else
                        sb.append(q.peekLast()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}