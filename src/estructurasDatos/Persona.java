package estructurasDatos;

import utilidades.ValidadorNIF;

public class Persona {


    private String nif;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String telefono;

    public Persona(String nif, String nombre, String apellidos, String domicilio, String telefono) {
        this.setNif(nif);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        boolean esValido = ValidadorNIF.ejecutar(nif);
        if (!esValido) {
            throw new IllegalArgumentException(nif + " no es un NIF válido");
        }

        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    private boolean validarNif(String nif) {
        return true;
    }
}
