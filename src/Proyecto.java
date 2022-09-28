import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;
    private List<Tarea> tareasFinalizadas;
    private Integer duracion;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.duracion = 0;
        this.tareas = new ArrayList<>();
        this.tareasFinalizadas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Tarea> getTareasFinalizadas() {
        return tareasFinalizadas;
    }

    public void setTareasFinalizadas(List<Tarea> tareasFinalizadas) {
        this.tareasFinalizadas = tareasFinalizadas;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<Tarea> tareasPorFase(Fase fase){
        return this.tareas.stream().filter(elemento -> elemento.getFase() == fase).collect(Collectors.toList());
    }

    public Tarea agregarTarea(String descripcion, Integer duracion, Fase fase){
        Tarea tarea = new Tarea(descripcion, duracion, fase);
        this.tareas.add(tarea);
        return tarea;
    }

    public boolean borrarTarea(Tarea tarea){
        List<Tarea> aux = new ArrayList<>();
        AtomicBoolean flag = new AtomicBoolean(false);
        this.tareas.forEach(item-> {
            if(item.equals(tarea)){
                flag.set(true);
            }else{
                aux.add(item);
            }
        });

        this.setTareas(aux);

        return flag.get();
    }

    public Boolean finalizarTarea(Tarea tarea){
        AtomicBoolean flag = new AtomicBoolean(false);
        for (Tarea item : this.tareas) {
            if (item.equals(tarea)) {
                flag.set(true);
                break;
            }
        }

        if(flag.get()){
            this.tareasFinalizadas.add(tarea);
        }

        return flag.get();
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "nombre='" + nombre + '\'' +
                ", tareas=" + tareas +
                ", tareasFinalizadas=" + tareasFinalizadas +
                ", duracion=" + duracion +
                '}';
    }
}
