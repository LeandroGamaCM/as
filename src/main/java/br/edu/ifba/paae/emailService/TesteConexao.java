package br.edu.ifba.paae.emailService;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class TesteConexao {
    public static void main(String[] args) {
        System.out.println(TesteConexao.testar());
    }
    public static boolean testar(){
        InetAddress endereco;
        try {
            endereco = InetAddress.getByName("www.google.com");
            int timeout = 30000;
            if (endereco.isReachable(timeout))
                return true;
            return false;
        } catch (UnknownHostException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }        
    }
}
