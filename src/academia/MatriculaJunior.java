package academia;

/**
 * Implemanta las matriculas para los cursos de tipo junior. Almacena un alumno
 * tipo junior, un curso de tipo junior, un telefono de contacto del responsable
 * del alumno junior matriculado y su estado de pago
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class MatriculaJunior extends Matricula {
	private Junior alumno;
	private CursoJunior curso;
	private String telefono;

	/**
	 * Metodo que inicilaiza una MatriculaJunior conociendo el Junior, el
	 * CursoJunior y el telefono de contacto del responsable del alumno junior
	 * 
	 * @param alumno
	 *            Junior al que corresponde la nueva matricula
	 * @param curso
	 *            CursoJunior en el que el alumno se inscribe
	 * @param telefono
	 *            String que almacena el telefono de contacto del responsable
	 *            del alumno junior
	 */
	public MatriculaJunior(Junior alumno, CursoJunior curso, String telefono) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.telefono = telefono;
	}

	/**
	 * Devuelve el Junior que figura en esta MatrículaJunior
	 * 
	 * @return Junior correspondiente a esta MatriculaJunior
	 */
	public Junior getAlumno() {
		return alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	/**
	 * Devuelve el telefono de contacto para esta matricula
	 * 
	 * @return telefono String que representa el telefono de contacto
	 *         correspondiente a esta MatriculaJunior
	 */
	public String getTelefono() {
		return telefono;
	}

}
