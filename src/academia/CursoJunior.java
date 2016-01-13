package academia;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementa los cursos junior, almacenando el idioma, las fechas de inicio y
 * de finalizacion, la hora de inicio de la clase, el numero maximo de alumnos,
 * el precio, las edades minima y maxima para poder entrar en estos cursos, y
 * una lista de inscripciones
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class CursoJunior extends Curso {
	private int edadMinima;
	private int edadMaxima;
	private ArrayList<MatriculaJunior> matricula;

	/**
	 * Inicializa un nuevo CursoJunior indicando idioma, fecha de inicio, fecha
	 * de finalizacion, hora de inicio, numero maximo de alumnos, precio, la
	 * edad minima y la edad maxima para participar en dicho curso
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
	 * @param edadMinima
	 *            Entero que repensenta la edad minima del alumno para acceder
	 *            al curso
	 * @param edadMaxima
	 *            Entero que repensenta la edad maxima del alumno para acceder
	 *            al curso
	 * @assert.pre La edad maxima es menor o igual que 18
	 * @assert.pre La edad minima es menor o igual que la edad maxima
	 * @assert.post El curso es creado
	 */
	public CursoJunior(String idioma, LocalDate fechaInicio, LocalDate fechaFin, int hora, int maximoAlumnos,
			float precio, int edadMinima, int edadMaxima) {
		super(idioma, fechaInicio, fechaFin, hora, maximoAlumnos, precio);
		assert(edadMaxima <= 18) : "La edad maxima es mayor que 18";
		assert(edadMinima <= edadMaxima) : "La edad minima es mayor que la edad maxima";
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		matricula = new ArrayList<MatriculaJunior>();
	}

	/**
	 * Devuelve la edad minima para poder matricularse en el curso junior
	 * 
	 * @return Entero que representa la edad minima con la que se puede acceder
	 *         a este CursoJunior
	 */
	public int getEdadMinima() {
		return edadMinima;
	}

	/**
	 * Devuelve la edad maxima para poder matricularse en el curso junior
	 * 
	 * @return Entero que representa la edad maxima con la que se puede acceder
	 *         a este CursoJunior
	 */
	public int getEdadMaxima() {
		return edadMaxima;
	}

	/**
	 * Devuelve la lista de matriculas de este CursoJunior
	 * 
	 * @return ArrayList que representa la lista de matriculas de este
	 *         CursoJunior
	 */
	public ArrayList<MatriculaJunior> getMatriculas() {
		return matricula;
	}

	public boolean estaLleno() {
		return maximoAlumnos() == getMatriculas().size();
	}

	public boolean estaMatriculado(Alumno alumno) {
		int i = 0;
		while (i < getMatriculas().size() && !getMatriculas().get(i).getAlumno().igual(alumno))
			i++;
		return i < getMatriculas().size();
	}

	public ArrayList<Alumno> getAlumnos() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		for (int i = 0; i < getMatriculas().size(); i++)
			alumnos.add(getMatriculas().get(i).getAlumno());
		return alumnos;
	}

	public ArrayList<Alumno> alumnosSinPagar() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		for (int i = 0; i < getMatriculas().size(); i++)
			if (!getMatriculas().get(i).estaPagada())
				alumnos.add(getMatriculas().get(i).getAlumno());
		return alumnos;
	}
}
