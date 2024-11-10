package chatapplication;

import java.net.*;
import java.io.*;

public class MulticastClient extends javax.swing.JFrame {
    public static String name;
    public static String message;
    public static MulticastSocket socket = null;
    public static InetAddress address;
    public static DatagramSocket s = null;

    public MulticastClient() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        // GUI components for message display, input, and online user list
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String text = jTextArea2.getText();
        if (!text.equals("")) {
            message = name + ": " + text;
            try {
                byte[] buf = message.getBytes();
                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                s.send(packet);
            } catch (IOException e) {
                socket.close();
            }
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String x = "***** " + name + " has logged out from the chat room *****";
        byte[] buf = x.getBytes();
        try {
            InetAddress group = InetAddress.getByName("230.0.0.1");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
            s.send(packet);
        } catch (Exception e) {}

        x = "exited";
        buf = x.getBytes();
        try {
            InetAddress group = InetAddress.getByName("230.0.0.2");
            DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 5000);
            s.send(packet);
            socket.leaveGroup(address);
            s.close();
        } catch (Exception e) {}

        this.setVisible(false);
        new ChatApp().setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MulticastClient().setVisible(true);
            }
        });
    }
}
