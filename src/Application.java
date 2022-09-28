import java.io.Console;

public class Application {
    public static void main(String args[])  //static method
    {
       Proyecto proyecto = new Proyecto("Proyecto numero 1");

       proyecto.agregarTarea("Extraccion de requisitos", 12, Fase.ANALISIS);
        proyecto.agregarTarea("Definición de casos de uso”", 6, Fase.ANALISIS);
        proyecto.agregarTarea("Diseño del modelo de datos", 10, Fase.DISENO);
        proyecto.agregarTarea("Implementación de la UI", 20, Fase.IMPLEMENTACION);
        proyecto.agregarTarea("Implementación del modelo", 20, Fase.IMPLEMENTACION);
        proyecto.agregarTarea("Implementación de las pruebas", 8, Fase.IMPLEMENTACION);
        proyecto.agregarTarea("Configuración de la base de datos", 4, Fase.DESPLIEGUE);
        proyecto.agregarTarea("Instalación en el servidor", 6, Fase.DESPLIEGUE);
        proyecto.agregarTarea("Programación nuevos requisitos", 20, Fase.MANTENIMIENTO);

        proyecto.getTareas().forEach(tarea -> {
            if(tarea.getDuracion() < 7) proyecto.borrarTarea(tarea);
        });

        proyecto.getTareas().forEach(tarea -> {
            if(tarea.getFase().equals(Fase.ANALISIS)) proyecto.finalizarTarea(tarea);
        });

        System.out.println(proyecto);
    }
}
