package com.company;

import jdk.internal.util.xml.impl.Input;
import sun.awt.SubRegionShowable;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void tcp() throws IOException {
        Socket sock = null;
        DataInputStream is = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            sock = new Socket("localhost", 5555);
            System.out.println("Connecting...");

            // receive file
            byte[] buffer = new byte[1024];
            is = new DataInputStream(sock.getInputStream());
            int size = is.readInt();
            System.out.println("File size = " + size);
            fos = new FileOutputStream("TCPfile.txt");
            bos = new BufferedOutputStream(fos);
            System.out.println("Reading");
            long b = System.nanoTime();
            int byteReaded = is.read(buffer,0,buffer.length);
            System.out.println("Writing");
            while(byteReaded > 0){
                bos.write(buffer,0, buffer.length);
                byteReaded = is.read(buffer,0,buffer.length);
            }
            bos.flush();
            long e = System.nanoTime()-b;
            System.out.println("Send("+e+")");
        }
        finally {
            if (fos != null) fos.close();
            if (is != null) is.close();
            if (bos != null) bos.close();
            if (sock != null) sock.close();
        }
    }

    public static void main(String[] args) throws IOException {
        tcp();
    }
}
