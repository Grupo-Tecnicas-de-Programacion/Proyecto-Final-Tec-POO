
import java.util.ArrayList;

public class Mesero extends Usuario{
    
    private ArrayList<Pedido> pedidos;

    public Mesero() {
    }

    public Mesero(ArrayList<Pedido> pedidos, String nombreUsuario, String constrasenia) {
        super(nombreUsuario, constrasenia);
        this.pedidos = pedidos;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
