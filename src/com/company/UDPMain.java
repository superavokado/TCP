package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPMain {

    public static void main(String[] args) throws IOException {
//        byte sdata[] = new byte[1024];
//        DatagramSocket dsoc = new DatagramSocket();
//        InetAddress ip = InetAddress.getByName("localhost");
//        FileInputStream inputStream = new FileInputStream("file.txt");
//        int nRead = 0;
//        long l = System.nanoTime();
//        while ((nRead = inputStream.read(sdata)) != -1) {
//            dsoc.send(new DatagramPacket(sdata, sdata.length, ip, 9000));
//        }
//        long e = System.nanoTime() - l;
//        System.out.println("Send(" + e + ")");
        byte sdata[] = new byte[1024];
        DatagramSocket dsoc = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");
        FileInputStream inputStream = new FileInputStream("file.txt");
        int nRead = 0;
        long l = System.nanoTime();
        nRead = inputStream.read(sdata);
        dsoc.send(new DatagramPacket(sdata, sdata.length, ip, 9000));
        long e = System.nanoTime() - l;
        System.out.println("Send(" + e + ")");
    }
}
