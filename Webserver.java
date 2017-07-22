///NAME:- AMEY JAYANT PURANIK.


import java.io.*; // importing input/output package for receiving and responding to the request.
import java.net.*; // importing .net package for socket connection.

//Public global class
public class Webserver {
	// Initiliazing the serversocket
	ServerSocket Serversocket;
	// Main method
	public static void main(String[] args) throws Exception {

		new Webserver().serverstarting(); // To avoid the Static problem, we are using the default main class to call the createsocket() method.
		 
	}
 // method to start the the socket and accept the request using the infinite looop.
	public void serverstarting() throws Exception {
        System.out.println(".............................................\n" + "Server Started.. waiting for Request\n");
		Serversocket = new ServerSocket(8080);
		acceptrequest();
	}

	private void acceptrequest() throws Exception {
		while (true) { /// to acceptt the connection.
			Socket s = Serversocket.accept();
			requestmanagement rm = new requestmanagement(s);
			rm.start(); // starting the thread.
		}

	}

	public void logs() { // TO keep the log at the server end.
		String logs = " The request outcome is ";
		try {

			System.out.println(logs);

		} catch (Exception e) {
			e.printStackTrace(); //printing the stack trace.
		}

	}
	

	
	///// client handler class
	public class requestmanagement extends Thread {

		Socket s;   // Initilizing variable according to their datatype
		PrintWriter pw;
		BufferedReader brfr;
		
 // method in the thread to accept the incoming request and respond.
		
		public requestmanagement(Socket s) throws Exception {
			this.s = s;
			brfr = new BufferedReader(new InputStreamReader(s.getInputStream()));  /// to read the incoming request.
			
			pw = new PrintWriter(s.getOutputStream());  //to flush out
			// the request.
		}
//Run method in the thread to create the class objects and pass request as a string.
		@Override
		public void run() {
			try {
				String ReqS = "";

				while (brfr.ready() || ReqS.length()==0)
					ReqS += (char) brfr.read();
				System.out.println("********************************************\n" +"The Request from the client \n\n "+ ReqS);
				
				requestprocessing req = new requestprocessing(ReqS); // creating the object
				responseprocessing res = new responseprocessing(req); //creating the object
				
				pw.write(res.httpresponse.toCharArray()); // flushing the response to the char array in bytes.
				
				pw.close(); // closing the printwriter. 
				brfr.close(); // closing the buffered reader.
				s.close(); //closing the socket.
				

			} catch (Exception e) {
				e.printStackTrace();//printing the stack trace.

			}
		}

	}

	/// httprequest class

	public class requestprocessing {

		String filename;

		public requestprocessing(String request) throws Exception {
         
			String httpreq[] = request.split("\r\n");     
			// spliting the string to
			// retreive filename from
			// the request.
			httpreq = httpreq[0].split(" ");
			
             filename= httpreq[1];
        
		}

	}

	////

	/// Htttpresponse class
	public class responseprocessing {
		requestprocessing req;

		String httpresponse;  //// Initilializing varaibles.
        String logs; // Initilializing String
		String filedestination = "E:/root";  // Initilializing string with file location.
        
		public responseprocessing(requestprocessing request) {

			req = request;
			
			System.out.println( ".........................................\n " + "The Requested file from the client= "+ req.filename); //print statement
			System.out.println("\n................................................."+"\nSending Response With file content...\n");  //print statement
			System.out.println("..............................................................." + "The Response sent to the client is as follows\n ");  //print statement
			// open the requested file
			File f = new File(filedestination + req.filename);
			
			// to read the file
			try {
             
				logs ="HTTP /1.1 200 OK \r\n"; // http log header message 
				
				httpresponse = "HTTP /1.1 200 OK \r\n";  //http header message
				httpresponse += "SERVER: WEBSERVER_AMEY1390\r\n";
				httpresponse += "Content-Type : text/html \r\n";
				httpresponse += "Content-Length:" + f.length() + "\r\n";
				httpresponse += " Connection: Closed \r\n";
				httpresponse += " \r\n";
				
				FileInputStream fis = new FileInputStream(f); // opening the file location
				int li;
				while ((li = fis.read()) != -1) {
					
					httpresponse += (char) li; // reading the file content and putting it in the httpreqest
					
				}
				
              fis.close(); /// closing the file input stream reader.
              
              System.out.println(logs); //printing the logs  
              
			} catch (FileNotFoundException e) {
				httpresponse=httpresponse.replace("200 OK", "404 File Not Found"); // handling the file not found exception
				
				
			} catch (Exception e) {
				httpresponse=httpresponse.replace("200 OK", "500 Error! "); // handling the bad request exception
				
				
			}
		}

	}
	//////
}
 
