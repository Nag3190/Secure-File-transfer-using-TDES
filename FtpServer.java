import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
public class FtpServer 
{
private JFrame frame;
static InputStream in;
static OutputStream out,out1;
static ServerSocket serverSocket,serverSocket1;
static JLabel lblNewLabel_1;
static JLabel lblNewLabel_2;
static JLabel lblNewLabel_3;
static JLabel JLabellblServer;
static JLabel lblNewLabel_4;
static JLabel lblNewLabel_5;
 static JLabel lblNewLabel_6;
public static void main(String[] args) throws IOException {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
FtpServer window = new FtpServer();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}}); serverSocket = new ServerSocket(21);
Socket socket = serverSocket.accept();
lblNewLabel_4.setText("new Client accepted");
lblNewLabel_4.setForeground(new Color(127, 255, 0));
in = socket.getInputStream();
DataInputStream dd1=new DataInputStream(in);
 String s1=dd1.readUTF(); 
out = new FileOutputStream("Server"+"//"+s1);
System.out.println(s1);
byte [] b = new byte[16*1024];
 switch(s1){
case "11":
 out1=socket.getOutputStream();
 break;
default:
 int count ;
 while ((count = in.read(b)) >0) {
out.write(b, 0, count);
lblNewLabel_5.setText("new file recieved1 !");
lblNewLabel_5.setForeground(Color.ORANGE);
}
}
}
public FtpServer()
{
initialize();
}
private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(new Color(128, 128, 128));
frame.setBackground(Color.WHITE);
frame.setBounds(100, 100, 527, 300);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JLabel lblServer = new JLabel("Server");
lblServer.setForeground(new Color(255, 255, 255));
lblServer.setFont(new Font("Khmer OS Content", Font.BOLD, 50));
lblServer.setBounds(186, 10, 192, 98);
frame.getContentPane().add(lblServer);
JLabel lblNewLabel = new JLabel("Status : ");
lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
lblNewLabel.setForeground(new Color(255, 255, 255));
lblNewLabel.setBounds(34, 111, 94, 34);
frame.getContentPane().add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Client connection : ");
lblNewLabel_1.setForeground(new Color(255, 255, 255));
lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
lblNewLabel_1.setBounds(30, 157, 208, 39);
frame.getContentPane().add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Recieved files : ");
lblNewLabel_2.setForeground(new Color(255, 255, 255));
lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
lblNewLabel_2.setBounds(30, 208, 192, 33);
frame.getContentPane().add(lblNewLabel_2);
 lblNewLabel_3 = new JLabel("Running");
lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
lblNewLabel_3.setForeground(new Color(255, 255, 0));
lblNewLabel_3.setBounds(129, 120, 249, 22);
frame.getContentPane().add(lblNewLabel_3);
lblNewLabel_4 = new JLabel("no new Clients");
lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
lblNewLabel_4.setBounds(224, 157, 249, 39);
frame.getContentPane().add(lblNewLabel_4);
lblNewLabel_5 = new JLabel("no file recieved1");
lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 18));
lblNewLabel_5.setBounds(224, 208, 221, 33);
frame.getContentPane().add(lblNewLabel_5);
}
}