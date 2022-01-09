package cliente;

import entity.Pelicula;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Producto;

public class Cliente extends Observable implements Runnable{
    private final int port;
    private final String host="127.0.0.1";
    private Socket socket;

    public Cliente(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        int cod;
        String nom;
        double pre;
        try {
            socket=new Socket(host, port);
          
            while(true){ 
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                List<Pelicula> peliculas = (List<Pelicula>)objectInputStream.readObject();

                System.out.println("peliculas "+peliculas);
                this.setChanged();
                this.notifyObservers(peliculas);
                this.clearChanged(); 
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
