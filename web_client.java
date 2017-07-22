///NAME:- AMEY JAYANT PURANIK.



import java.io.BufferedReader;  //// importing input/output package for receiving and responding to the request. 
import java.io.InputStreamReader; //// importing io input stream reader.
import java.io.PrintWriter; ////importing io printwriter
import java.net.Socket;  ////importing .net.socket.
import java.util.Scanner; //importing util package 

 //global class
public class web_client {
	Socket skt;  //initializing socket variable
//main method
	public static void main(String[] args) {

		new web_client().connectionrequest();  // To avoid the Static problem, we are using the default main class to call the connectionrequest() method.

	}
///method to create the socket and call the httprequest method.
	public void connectionrequest() {
		try {
			String ip = "localhost";
			System.out.print("Client connected to the server successfully.Please enter the file name in (filename.html) format in the next line. \n");
			skt = new Socket(ip, 8080);  //creating the socket.
			Sendhttpreq http = new Sendhttpreq(); //creating the class object.
			http.httprequest(); // calling the method.

		} catch (Exception e) {

			e.printStackTrace(); ///printing the stack trace.
		}

	}
 ///class for managing the client  request sent to server.
	public class clientmanagement {

		BufferedReader bfr; //declaring buffered reader.

		public void clienthandler() {
			try {
				bfr = new BufferedReader(new InputStreamReader(skt.getInputStream()));  //// creating object

				String Response = (String) ""; ////creating string
                String [] A;  //declaring string array
				while (bfr.ready() || Response.length() == 0) // while loop to read the response.
					Response += (char) bfr.read();
				System.out.println("\n\n The Http Response from the server\n............................................\n" +Response);
                A=Response.split("Closed");
                
                	System.out.print("The file content is as follows \n..........................\n " + A[1]);
                	
                
				bfr.close(); //closing the buffer reader.
				skt.close(); //closing the socket.

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
/// Class to send http reqeuset to the client.
	public class Sendhttpreq {

		 
		String httpreq = "";
		PrintWriter pw;

		public void httprequest() throws Exception {

			 Scanner input = new Scanner(System.in);
			 String filename = input.nextLine();/// to accept the file from command line.
			
			
			pw = new PrintWriter(skt.getOutputStream());  ///creating the printwriter object.

			httpreq = "GET /"+filename+" "+  "HTTP/1.1 \r\n";     ///http request sent to the server with the filename.
			httpreq += "Host: localhost:8080 \r\n";
			httpreq += "Connection: keep-alive \r\n";
			httpreq += "Cache-Control: max-age=0 \r\n";
			httpreq += "Accept: text/html \r\n";
			httpreq += "Accept-Encoding: gzip, deflate, sdch, br \r\n";
			httpreq += "Accept-Language: en-US,en;q=0.8 \r\n";
			
			System.out.println("THE REQUEST SENT TO SERVER WITH ENTERED FILE NAME AS A GET METHOD \n\n" +"*****************************************\n\n" + httpreq +"\n\n *****************************************");
			pw.println(httpreq.toCharArray());
			pw.flush(); /// flusing the request to the server.
			clientmanagement cm = new clientmanagement();
			cm.clienthandler();
			pw.close(); //closing the printwriter.

		}

	}

}

