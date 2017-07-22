# -Multi-threaded-Web-Server-and-Web-Client-using-Java-Sockets-
Building a Simple Web Client and a Multi-threaded Web Server.

NAME:- AMEY JAYANT PURANIK.


In this project, I have developed a multithreaded Web server and a simple web client. The Web server and Web client communicate using a protocol called HTTP (Hypertext Transfer Protocol).

This project is developed in Java SE 8 using multithreading programming. The basic and the most important requirement to run this project on any platform is to have Java SE 8 installed successfully.

There are two parts of the projects.
-Web Server.
-Web client.

Web server :- The server is able to handle multiple requests concurrently. This means the implementation is multithreaded.
Web client:- The client is able to connect to the server via a socket and to request a page on the server.

Guidelines :- 
-There are two files in the zip (1001451390_AmeyPuranik) folder named as Webserver and web_client. 

-These files are the .java files and are the source code of the entire project.


Important Note:- 
****************************
(Before compiling these project we need to create the folder in the  E:\  directory of the system. And we need to store the Html File in this folder. I have attached the root folder in the my zip file . We can just copy this root folder in the E:\ directory of the system. (Path is been hardcoded in the server code.)

(Moreover, this code is running on the port number : 8080 which is basically available port for the system where I developed this code. There is possibility that this port number may not be available to use in your system or platform.)

-Once this is done we need to copy and paste these two files (Webserver and web_client.) in the folder of java where it is been installed.

-We need to open the command prompt. (Make sure to open the command prompt in Administrative mode).

-Then we need to go the directory where we have saved this files. ((Webserver and web_client.))

Type..

CD \      (Hit enter)
C:\   CD Program Files\Java\jdk1.8.0_111\bin
C:\Program Files\Java\jdk1.8.0_111\bin \ javac Webserver.java    (We need to compile and run the server code first.)
C:\Program Files\Java\jdk1.8.0_111\bin \ java Webserver.



-Once this is done . We need to open another command prompt in administrator mode.

-And follow the same procedure stated above, however we need to run web_client code now.
  
Here client code is asking us to enter the file name in (filename.html ) format. We need to enter the file name of the html file that is stored in the root folder  (E:\root). (name of the root folder is case sensitive ).
 


-We will the following response from the server.


 The Http Response from the server
............................................
HTTP /1.1 200 OK
SERVER: WEBSERVER_AMEY1390
Content-Type : text/html
Content-Length:126
 Connection: Closed

<html>
<head>
<title> Welcome</title>
</head>
<body>
<p>This is para 1 baba
<p> this is para 2 nanan
</body>
</html>


	


-At the server end we will the following request from the server.
 
Server Started.. waiting for Request

********************************************
The Request from the client

 GET /a.html HTTP/1.1
Host: localhost:8080
Connection: keep-alive
Cache-Control: max-age=0
Accept: text/html
Accept-Encoding: gzip, deflate, sdch, br
Accept-Language: en-US,en;q=0.8


.........................................
 The Requested file from the client= /a.html

.................................................
Sending Response With file content...

...............................................................The Response sent to the client is as follows

HTTP /1.1 200 OK




-We can also send a request to the server from the from the browser.  (Mozilla Firefox mostly preferred.)

(Note:- Dose not work with IE due proxy level settings.)

-To send a request to the server from the web browser  we need to type in the url 

URL:- localhost:8080/(filename).html

********************************************
The Request from the client

 GET /n.html HTTP/1.1
Host: localhost:8080
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-GB,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1
Cache-Control: max-age=0


.........................................
 The Requested file from the client= /n.html

.................................................
Sending Response With file content...

...............................................................The Response sent to the client is as follows

HTTP /1.1 200 OK


	


-In addition to the Eclipse Project zip file is also there in the 1001451390_ameypuranik zip file.

-We, need to import this project in the Eclipse neon 2.0 version and run the project.

-Open the IDE.

-Click on the import the project.

-Run the code.


