package Midterm_UDP_Programming;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class TimeClient extends JFrame implements ActionListener {

    private JLabel timeLabel; // Nhãn hiển thị thời gian
    private DatagramSocket socket; // Socket UDP
    private InetAddress address; // Địa chỉ IP của server
    private int port; // Cổng UDP
    private Timer timer; // Timer để cập nhật thời gian

    public TimeClient() {
        super("Time Client");

        // Khởi tạo các thành phần GUI
        timeLabel = new JLabel("Waiting for time...", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(timeLabel, BorderLayout.CENTER);

        // Kết nối với server
        try {
            port = 4445; // Cổng UDP
            address = InetAddress.getByName("localhost"); // Địa chỉ IP của server
            socket = new DatagramSocket();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi kết nối với server!");
            System.exit(1);
        }

        // Khởi tạo timer để cập nhật thời gian mỗi giây
        timer = new Timer(1000, this);
        timer.start();

        // Hiển thị cửa sổ
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gửi thông báo "Client connected" khi cửa sổ được đóng
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                sendClientDisconnectMessage();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateTime(); // Cập nhật thời gian
    }

    private void updateTime() {
        try {
            // Tạo gói tin trống để nhận dữ liệu từ server
            byte[] buffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

            // Nhận gói tin từ server
            socket.receive(receivePacket);

            // Lấy dữ liệu thời gian từ gói tin
            String receivedTime = new String(receivePacket.getData(), 0, receivePacket.getLength());

            // Cập nhật nhãn hiển thị thời gian
            timeLabel.setText(receivedTime);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi kết nối với server!");
            timer.stop(); // Dừng timer nếu gặp lỗi
        }
    }
    
    private void sendClientDisconnectMessage() {
        try {
            // Tạo gói tin thông báo "Client disconnected"
            String message = "Client disconnected";
            byte[] data = message.getBytes();
            DatagramPacket disconnectPacket = new DatagramPacket(data, data.length, address, port);

            // Gửi gói tin thông báo cho server
            socket.send(disconnectPacket);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Lỗi khi gửi thông báo disconnect!");
        }
    }
    
}
            
