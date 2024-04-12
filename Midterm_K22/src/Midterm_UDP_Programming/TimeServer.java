package Midterm_UDP_Programming;

import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeServer {
	private static boolean running = true;
    private static boolean printedStatus = false; // Cờ theo dõi trạng thái đã in
    private static DatagramSocket socket; // Socket UDP
	
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 4445; // Cổng UDP
        
     // Khởi tạo socket UDP
        socket = new DatagramSocket(port);

        // Khởi chạy thread xử lý kết nối UDP
        Thread connectionThread = new Thread(() -> {
            try {
                handleClientConnection(socket);
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        connectionThread.start();

        // In thông báo server khởi động
        System.out.println("Time Server started on port " + port);

        // Chờ cho đến khi server dừng
        while (running) {
            // ... (Có thể thêm code xử lý khác) ...
        }

        // Dừng socket và thread
        socket.close();
        connectionThread.interrupt();

        // In thông báo server dừng
        System.out.println("Time Server stopped");
    }
    
    	private static void handleClientConnection(DatagramSocket socket) throws IOException, InterruptedException {
    		while (running) {
                // Tạo gói tin trống để nhận dữ liệu từ client
                byte[] buffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                // Nhận gói tin từ client
                socket.receive(receivePacket);

                // Lấy địa chỉ IP và cổng của client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Gửi thời gian hiện tại cho client
            	long currentTime = System.currentTimeMillis();

                Date date = new Date(currentTime);
            	// Format time
            	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            	String time = formatter.format(date);
            	
            	// Convert time to byte[]
            	byte[] data = time.getBytes();

                // Gửi gói tin UDP cho tất cả client
                DatagramPacket packet = new DatagramPacket(data, data.length, clientAddress, clientPort);
                socket.send(packet);

                // Chờ 1 giây trước khi gửi cập nhật tiếp theo
                Thread.sleep(1000);
            }
        
     // Tạo và khởi chạy thread trạng thái
//        Thread statusThread = new Thread(() -> {
//        	while (running) {
//                if (!printedStatus) { // In trạng thái 1 lần khi server còn chạy
//                    System.out.println("Server status: running");
//                    printedStatus = true; // Đánh dấu đã in
//                }
//
//                try {
//                    Thread.sleep(1000); // Cập nhật trạng thái mỗi giây
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    running = false; // Dừng server khi có lỗi
//                    System.out.println("Server status: stopped");
//                }
//            }
//        });
//        statusThread.start();
//
//        try (DatagramSocket socket = new DatagramSocket(port)) {
//            while (running) {
//                // Lấy thời gian hiện tại
//            	long currentTime = System.currentTimeMillis();
//
//                Date date = new Date(currentTime);
//            	// Format time
//            	SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//            	String time = formatter.format(date);
//            	
//            	// Convert time to byte[]
//            	byte[] data = time.getBytes();
//
//                // Gửi gói tin UDP cho tất cả client
//                DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), port);
//                socket.send(packet);
//
//                // Chờ 1 giây trước khi gửi cập nhật tiếp theo
//                Thread.sleep(1000);
//            }
//        }
//        running = false;
//        statusThread.interrupt();
    }
}
