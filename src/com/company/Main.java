package com.company;

import jdk.internal.util.xml.impl.Input;
import sun.awt.SubRegionShowable;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void tcp() throws IOException {
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock = null;
        try {
            sock = new Socket("localhost", 5555);
            System.out.println("Connecting...");

            // receive file
            byte [] mybytearray  = new byte [100];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream("TCPfile.txt");
            bos = new BufferedOutputStream(fos);
            System.out.println("Reading");
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;
            System.out.println("Writing");
            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead > 0) current += bytesRead;
                System.out.println(bytesRead);
            } while(bytesRead > 0);
            long b = System.nanoTime();
            bos.write(mybytearray, 0 , 100);
            bos.flush();
            long e = System.nanoTime()-b;
            System.out.println("Send("+e+")");
        }
        finally {
            if (fos != null) fos.close();
            if (bos != null) bos.close();
            if (sock != null) sock.close();
        }
    }

    public static void main(String[] args) throws IOException {
        tcp();
    }
}
