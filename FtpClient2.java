
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.ServerSocket;
import javax.swing.UIManager;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.*; 
import javax.swing.*; 
import java.io.IOException; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
public class FtpClient2 {
private JFrame frame;
private JTextField textField,textField1;
static Socket socket;
String str,ss;
static InputStream in,in1;
static OutputStream out,out1;
public static void main(String[] args) throws UnknownHostException, IOException {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
FtpClient2 window = new FtpClient2();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();}}});
 socket = new Socket("127.0.0.1", 21);
}
 /**
* Create the application.
*/
public FtpClient2() {
initialize();
}/**
* Initialize the contents of the frame.

*/private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(UIManager.getColor("Button.highlight"));
frame.setBackground(UIManager.getColor("Button.highlight"));
frame.setBounds(100, 100, 629, 307);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().setLayout(null);
JLabel lblNewLabel = new JLabel("Select file : ");
lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
lblNewLabel.setBounds(12, 12, 120, 33);
frame.getContentPane().add(lblNewLabel);
JLabel lblNewLabel1 = new JLabel("Key : ");
lblNewLabel1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
lblNewLabel1.setBounds(12, 60, 120, 33);
frame.getContentPane().add(lblNewLabel1);
JButton btnBrowse = new JButton("Browse");
btnBrowse.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
JFileChooser fileChooser = new JFileChooser();
fileChooser.showOpenDialog(btnBrowse);
 str = fileChooser.getSelectedFile().getAbsolutePath();
textField.setText(str);}});
btnBrowse.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
btnBrowse.setForeground(Color.ORANGE);
btnBrowse.setBackground(Color.DARK_GRAY);
btnBrowse.setBounds(510, 12, 105, 33);
frame.getContentPane().add(btnBrowse);
textField = new JTextField();
textField.setFont(new Font("Caladea", Font.PLAIN, 20));
textField.setBounds(127, 12, 376, 33);
frame.getContentPane().add(textField);
textField.setColumns(10);
textField1 = new JTextField();

textField1.setFont(new Font("Caladea", Font.PLAIN, 20));
textField1.setBounds(127, 60, 376, 33);
frame.getContentPane().add(textField1);
textField1.setColumns(10);
JButton btnReceive = new JButton("Receive");
btnReceive.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
TripleDes d1=new TripleDes();
try{out = socket.getOutputStream();
DataOutputStream dd=new DataOutputStream(out);
dd.writeUTF("11");
 in1 = socket.getInputStream();}
catch(IOException e1){
e1.printStackTrace();}
 ss=textField1.getText(); 
 d1.fun1(str,ss);
Path path1 = Paths.get(str); 
 Path fileName = path1.getFileName();
System.out.println("FileName: "+ fileName.toString());
File file = new File("D://Decrypt"+"//"+fileName.toString());
System.out.println("FileName: " + fileName.toString());}});
btnReceive.setFont(new Font("Dialog", Font.BOLD, 20));
btnReceive.setForeground(Color.DARK_GRAY);
btnReceive.setBackground(Color.ORANGE);
btnReceive.setBounds(100, 211, 117, 48);
frame.getContentPane().add(btnReceive);}}

