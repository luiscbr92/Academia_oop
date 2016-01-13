package academia;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementa los cursos normales, almacenando el idioma, las fechas de inicio y
 * de finalizacion, la hora de inicio de la clase, el numero maximo de alumnos,
 * el precio, el nivel y una lista de inscripciones
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class CursoNormal extends Curso {
	private int nivel;
	private ArrayList<MatriculaNormal> matriculas;

	/**
	 * Metodo que inicializa un curso normal indicando idioma, fecha de inicio,
	 * fecha de finalizacion del curso, hora de inicio, numero maximo de
	 * alumnos, precio y nivel
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
	 * @param nivel
	 *            Entero que representa el nivel del curso
	 */
	public CursoNormal(String idioma, LocalDate fechaInicio, LocalDate fechaFin, int hora, int maximoAlumnos,
			float precio, int nivel) {
		super(idioma, fechaInicio, fechaFin, hora, maximoAlumnos, precio);
		this.nivel = nivel;
		matriculas = new ArrayList<MatriculaNormal>();
	}

	/**
	 * Devuelve el nivel del curso normal
	 * 
	 * @return Entero que representa el nivel de este CursoNormal
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Devuelve la lista de matriculas de este curso
	 * 
	 * @return ArrayList que representa la lista de matriculas
	 *         de este CursoNormal
	 */
	public ArrayList<MatriculaNormal> getMatriculas() {
		return matriculas;
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

	/**
	 * Elimina la Matricula especificada de la lista de matriculas de este curso
	 * 
	 * @param matricula
	 *            Matricula que se desea eliminar
	 * @assert.pre La matricula esta en la lista de matriculas de este curso
	 * @assert.post La matricula es eliminada de la lista de matriculas de este
	 *              curso
	 */
	public void eliminarMatricula(Matricula matricula) {
		int i = 0;
		while (i < getMatriculas().size() && !getMatriculas().get(i).igual(matricula))
			i++;
		assert(i < getMatriculas().size()) : "La matricula no figura en la lista de matriculas de este curso";
		getMatriculas().remove(i);
	}

	/**
	 * Añade una nueva matricula a la lista de matriculas de este curso
	 * 
	 * @param matricula
	 *            Matricula que se añade a la lista de matriculas de este curso
	 */
	public void anadirMatricula(MatriculaNormal matricula) {
		matriculas.add(matricula);
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
