public class Persona {
    private int id;
    private String nombre;
    private String cedula;
    private String tel;
    private static int numeroPersonas = 0;

    public Persona() {
        this.id = ++Persona.numeroPersonas;
    }

    public Persona(String nombre, String tel, String cedula) {
        this();
        this.nombre = nombre;
        this.tel = tel;
        this.cedula = cedula;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String tel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String cedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public static int numeroPersonas() {
        return numeroPersonas;
    }

    public static void setNumeroPersonas(int numeroPersonas) {
        Persona.numeroPersonas = numeroPersonas;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", tel=" + tel +
                ", cedula=" + cedula +
                '}';
    }

    public static void main(String[] args) {
        Persona persona1 = new Persona("juan", "8099532703", "juan@mail.com");
        System.out.println(persona1);
    }
}
