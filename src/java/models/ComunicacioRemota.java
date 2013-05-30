/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Adria
 */
public class ComunicacioRemota {
    private Socket socket;

    public ComunicacioRemota(String ipString, int port) throws IOException {
        this.socket = new Socket(ipString, port);
    }
    
    public void enviarOrdre (String ordre) throws IOException {
    try{
        OutputStream canal = socket.getOutputStream();
        DataOutputStream dades = new DataOutputStream(canal);
        dades.writeUTF(ordre);
        dades.close();
        canal.close();
        socket.close();
    } catch (UnknownHostException unknownHost) {
        System.out.println("No es trova la màquina servidora");
    }
    }
    
}
