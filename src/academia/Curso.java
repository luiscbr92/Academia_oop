package academia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Implementa los cursos, almacenando idioma, nivel, fechas de inicio y fin,
 * hora a la que si imparte, maximo de alumnos del curso, precio y una lista de
 * matriculas correspondientes al curso.
 * 
 * @author Luis Alberto Centeno, Irene de Olmos Raposo, Ángel Posada García
 *
 */
public abstract class Curso {
	private UUID id;
	private String idioma;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int hora;
	private int maximoAlumnos;
	private float precio;

	/**
	 * Inicializa un nuevo curso indicando idioma, nivel, fecha inicio, fecha
	 * fin, hora, maximo de alumnos y precio.
	 * 
	 * @param idioma
	 *            String que representa el idioma que se va a impartir
	 * @param fechaInicio
	 *            LocalDate que almacena la fecha de inicio del curso
	 * @param fechaFin
	 *            LocalDate que almacena la fecha de final del curso
	 * @param hora
	 *            Entero que representa la hora a la que se va a impartir el
	 *            curso
	 * @param maximoAlumnos
	 *            Entero que representa el numero maximo de alumnos
	 * @param precio
	 *            Decimal que representa el precio del curso
	 * @assert.pre El maximo de alumnos es mayor que 0
	 * @assert.pre La fecha de inicio especificada es anterior a la fecha de fin
	 *             del curso que se crea
	 * @assert.post El curso es creado
	 */
	public Curso(String idioma, LocalDate fechaInicio, LocalDate fechaFin, int hora, int maximoAlumnos, float precio) {
		assert(maximoAlumnos > 0) : "El curso ha de tener como minimo 1 para el maximo de alumnos";
		assert(fechaInicio
				.isBefore(fechaFin)) : "La fecha de inicio no es anterior a la fecha de finalizacion del curso";
		id = UUID.randomUUID();
		this.idioma = idioma;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.hora = hora;
		this.maximoAlumnos = maximoAlumnos;
		this.precio = precio;
	}

	/**
	 * Devuelve el identificador unico de este curso
	 * 
	 * @return UUID que repersenta el identificador unico de este curso
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Devuelve el idioma de este curso
	 * 
	 * @return String que representa el idioma de este curso
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Devuelve la fecha de inicio de este curso
	 * 
	 * @return LocalDate que representa la fecha de inicio de este curso
	 */
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Devuelve la fecha de finalizacion de este curso
	 * 
	 * @return LocalDate que representa la fecha de finalizacion de este curso
	 */
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	/**
	 * Devuelve la hora de este curso
	 * 
	 * @return Entero que representa la hora de inicio de este curso
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * Devuelve el numero maximo de alumnos que pueden matricularse en este
	 * curso
	 * 
	 * @return entero que representa el numero maximo de alumnos que pueden
	 *         matricularse en este curso
	 */
	public int maximoAlumnos() {
		return maximoAlumnos;
	}

	/**
	 * Comprueba si este curso es el mismo que otro
	 * 
	 * @param otro
	 *            Curso que representa el curso con el que se compara
	 * @return {@code true} si los cursos son iguales, o {@code false} en caso
	 *         contrario
	 */
	public boolean igual(Curso otro) {
		return getId().compareTo(otro.getId()) == 0;
	}

	/**
	 * Devuelve el precio de este curso
	 * 
	 * @return Float que representa el precio de este curso
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Comprueba si el curso esta lleno
	 * 
	 * @return {@code true} si este curso esta lleno, o {@code false} en caso
	 *         contrario
	 */
	public abstract boolean estaLleno();

	/**
	 * Comprueba si el alumno especificado por parametro está matriculado en
	 * este curso
	 * 
	 * @param alumno
	 *            Alumno que se quiere comprobar que este matriculado en este
	 *            curso
	 * @return {@code true} si el alumno está matriculado, o {@code false} en
	 *         caso contrario
	 */
	public abstract boolean estaMatriculado(Alumno alumno);

	/**
	 * Devuelve la lista de alumnos matriculados en este curso
	 * 
	 * @return ArrayList que representa la lista de alumnos matriculados en este
	 *         curso
	 */
	public abstract ArrayList<Alumno> getAlumnos();

	/**
	 * Devuelve la lista de alumnos que no han pagado su matricula de este curso
	 * 
	 * @return ArrayList que representa la lista de alumnos que no han pagado su
	 *         matricula de este curso
	 */
	public abstract ArrayList<Alumno> alumnosSinPagar();
}
