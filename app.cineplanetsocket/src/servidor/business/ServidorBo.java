package servidor.business;

import entity.Pelicula;
import entity.Producto;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorBo implements Runnable{
    private final int puerto;
    private final List<Socket> socketList;

    private ServerSocket serverSocket;
    private Socket socket;
    private DataOutputStream dataOutputStream;

    public ServidorBo(int puerto) {
        this.socketList = new ArrayList<>();
        this.puerto = puerto;
    }
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(puerto);
            while(true){
                socket = serverSocket.accept();
                socketList.add(socket);
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorBo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarInformacion(List<Pelicula> peliculaList) throws IOException{
        for(int i=0; i<socketList.size(); i++){
            dataOutputStream=new DataOutputStream(socketList.get(i).getOutputStream());
            
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(dataOutputStream);
            objectOutputStream.writeObject(peliculaList);
            /*for(int j=0; j<ap.size(); j++){
                out.writeInt(ap.get(j).getCodigo());
                out.writeUTF(ap.get(j).getNombre());
                out.writeDouble(ap.get(j).getPrecio());   
            }*/
        }
    }
    
   
}
