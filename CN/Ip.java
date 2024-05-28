import java.net.*;
import java.io.*;
import java.util.*;
public class Ip{
    public static void main(String[] args){
        try{
            InetAddress localIP = InetAddress.getLocalHost();
            System.out.println("Local IP: "+localIP.getHostAddress());

    }
    catch(UnknownHostException e){
        System.out.println("Unable to find local ip address");
    }
    try{
        InetAddress domainIP = InetAddress.getByName("www.google.com");
        System.out.println("Domain ip"+domainIP.getHostAddress());

    }
    catch(UnknownHostException e){
        System.out.println("Unable to find domain ip address");
    }
    }
}