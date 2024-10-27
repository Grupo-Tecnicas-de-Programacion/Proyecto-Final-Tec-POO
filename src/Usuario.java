
public class Usuario {
    protected String nombreUsuario;
    protected String contrasenia;
    protected boolean sesionIniciada;
    protected Usuario supervisor;
    
    public Usuario(){
    
    }
    
    public Usuario(String nombreUsuario, String constrasenia){
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = constrasenia;
        this.supervisor = null;
        this.sesionIniciada = false;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Usuario supervisor) {
        this.supervisor = supervisor;
    }
    
    public void iniciarSesion(String nombreUsuario, String contrasenia){
        
        boolean usuario, contra;
        
        if (this.nombreUsuario.toLowerCase().equals(nombreUsuario.toLowerCase())) {
            System.out.println("Nombre de usuario correcto");
            usuario = true;
        }else{
            System.out.println("Nombre de usuario incorrecto");
            usuario = false;
        }
        
        if (this.contrasenia.toLowerCase().equals(contrasenia.toLowerCase())) {
            
            System.out.println("Contrasenia de usuario correcta");
            contra = true;
        }else{
            
            System.out.println("Contrasenia de usuario ingresada incorrecta");
            contra = false;
        }
        
        if (usuario && contra) {
            System.out.println("Sesion iniciada correctamente");
            this.sesionIniciada = true;
        }else{
            System.out.println("Sesion no inciada");
            this.sesionIniciada = false;
        }
    }
    
    public void cerrarSesion(){
        if (this.sesionIniciada) {
            System.out.println("Sesion cerrada correctamente");
            this.sesionIniciada = false;
        }else{
            System.out.println("No hay una sesion iniciada");
        }
    }
    
    public void asignarSupervisor(Usuario supervisor){
        this.supervisor = supervisor;
        System.out.println("Supervisor asignado: " + supervisor.getNombreUsuario());

    }
    
}
