import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class SocketServer {

	  ServerSocket server = null;
	  Socket client = null;
	  BufferedReader in = null;
	  PrintWriter out = null;
	  String line = "";
	  String type="";
	  int n=0;
	  double m=0;
	  Tree<String> d1 = new Tree<String>();
	  Tree<Integer> d2 = new Tree<Integer>();
	  Tree<Double> d3 = new Tree<Double>();
	  

	  SocketServer() { 
	    try {
	      server = new ServerSocket(4444); 
	    } 
	    catch (IOException e) {
	      System.out.println("Could not listen on port 4444"); System.exit(-1);
	    }
	  }

	  public void listenSocket() {
		    try {
		      client = server.accept();
		    } 
		    catch (IOException e) {
		      System.out.println("Accept failed: 4444"); System.exit(-1);
		    }
		    try {
		      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		      out = new PrintWriter(client.getOutputStream(), true);
		    } 
		    catch (IOException e) {
		      System.out.println("Accept failed: 4444"); System.exit(-1);
		    }
	//try{ type = in.readLine();}
	//catch(IOException e){System.exit(-1);}
		    	try {
		    		
		    		while(line!=null)
		    		
		    		{
		    		//	if("String".equals(in.readLine())) {
		    			switch(in.readLine()) {
		    	    	
		    			case "insert":
		    	    	line = in.readLine();
		    			d1.insert(line);
		    	   		out.println(d1);
		    	   		break;
		    	   		
			    	    case "delete":	
		    	    	line = in.readLine();
		    	    	d1.delete(line);
		    	    	out.println(d1);
		    	    	break;
		    	    	
		    	    	case "search":
		    	    		
		    	    	line = in.readLine();
		    	    	out.println(d1.isElement(line));
		    	    	break;
		    	    	
		    	    	case "draw":
		    	    	
		    	    	line = in.readLine();
		    	    	out.println(d1);
		    			break;
		    			}
		    		//	}
		    			
		    /*			if("Integer".equals(type))
	    					
		    			{
		    			switch(in.readLine()) {
		    			
		    			case "insert":
		    				
		    			line = in.readLine();
		    			n = Integer.parseInt(line);	
		    			d2.insert(n);
		    	   		out.println(d2);
		    	   		break;
		    	   		
			    	    case "delete":	
		    	    	line = in.readLine();
		    	    	d2.delete(Integer.parseInt(line));
		    	    	out.println(d2);
		    	    	break;
		    	    	
		    	    	case "search":
		    	    		
		    	    	line = in.readLine();
		    	    	try{n=Integer.parseInt(line);}
		    	    	catch(NumberFormatException e){out.println("To nie liczba");}	
		    	    	
		    	    	out.println(d2.isElement(n));
		    	    	break;
		    	    	
		    	    	case "draw":
		    	    	
		    	    	line = in.readLine();
		    	    	out.println(d1);
		    			break;
		    			}
		    			}
		    	*/	}
		    	} 
		        
		      catch (IOException e) {
		        System.out.println("Read failed"); System.exit(-1);
		      } 
		    }
		    
		    
		  
	  
	  protected void finalize() {
		    try {
		      in.close();
		      out.close();
		      client.close();
		      server.close();
		    } 
		    catch (IOException e) {
		      System.out.println("Could not close."); System.exit(-1);
		    }
		  }
	
	  public static void main(String[] args) {
		    SocketServer server = new SocketServer();
		    server.listenSocket();
		  }
}
