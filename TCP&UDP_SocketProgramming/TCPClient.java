import java.io.*; 
import java.net.Socket; 
import java.util.*; 
/*Chương trình client:
-  cho phép người dùng nhập chuổi từ  bàn phím để gửi đến chương trình Server 
- nhận chuổi từ server gửi về và hiển thị lên màn hình
*/
public class TCPClient { 
      Socket socket ;
      BufferedReader stream_in ;
      PrintWriter stream_out;

      public TCPClient()
      {
     
      try{	
        Socket socket = new Socket("localhost", 7000); //gửi yêu cầu kết nối đến server
        BufferedReader stream_in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter stream_out = new PrintWriter(socket.getOutputStream(), true);

        while (true)
        {
        //Tạo luồng nhận dữ liệu từ bàn phím
         Scanner kb = new Scanner(System.in); 
      
       //Nhập chuổi từ bàn phím
        System.out.print("Enter a string: "); 
        String msg=kb.nextLine(); 
      
      //Gửi dữ liệu đến server
       stream_out.println(msg); 
       stream_out.flush();
     
      //nhận dữ liệu từ server và hiển thị lên màn hình
       String st = stream_in.readLine(); 
       System.out.println(st); 
      kb = kb.reset(); 
         
        }
      //socket.close();
     }catch(Exception e){}
  }

     public static void main(String[] args) throws Exception 
       { 
       new TCPClient();
       } 
} 
