final class Tarea {
    private String descripcion;
    private Integer duracion;
    private Fase fase;

    public Tarea(String descripcion, Integer duracion, Fase fase) {
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fase = fase;
    }

    public Tarea(String descripcion, Fase fase) {
        this.descripcion = descripcion;
        this.fase = fase;
        this.duracion = 10;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Fase getFase() {
        return fase;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                ", fase=" + fase +
                '}';
    }
}
