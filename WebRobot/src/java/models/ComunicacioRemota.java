/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Adria
 */
public class ComunicacioRemota {
    private Socket socket;
    private OutputStream canal;
    private DataOutputStream dades;
    private String ordre;

    public ComunicacioRemota(String ipString, int port) throws IOException {
        InetAddress ip = InetAddress.getByName(ipString);
        this.socket = new Socket(ip, port);
    }
    
    public void enviarOrdre (String ordre) throws IOException {
    try{
        canal = socket.getOutputStream();
        dades = new DataOutputStream(canal);
        dades.writeUTF(ordre);
        dades.close();
        canal.close();
        socket.close();
    } catch (UnknownHostException unknownHost) {
        System.out.println("No es trova la màquina servidora");
    }
    }
    
}
