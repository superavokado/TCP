package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMainServer {
    public static void main(String args[]) throws IOException {
        byte b[] = new byte[100];
        DatagramSocket dsock = new DatagramSocket(9000);
        FileWriter fileWriter = new FileWriter("UDPfile.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        DatagramPacket dp = new DatagramPacket(b, b.length);
        dsock .receive(dp);
        String str = new String(new String(dp.getData(), 0, dp.getLength()));
        bufferedWriter.write(str);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
