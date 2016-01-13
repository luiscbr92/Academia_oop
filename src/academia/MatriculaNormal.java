package academia;

/**
 * Implementa las matriculas para los cursos de tipo normal, almacenando dicho
 * curso, el alumno que se matricula y su estado de pago
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class MatriculaNormal extends Matricula {
	private Alumno alumno;
	private CursoNormal curso;

	/**
	 * Metodo que inicializa una matricula normal mediante el CursoNormal y el
	 * Alumno que se matricula
	 * 
	 * @param alumno
	 *            Alumno al que corresponde la nueva matricula
	 * @param curso
	 *            CursoNormal en el que el alumno se inscribe
	 */
	public MatriculaNormal(Alumno alumno, CursoNormal curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
	}

	/**
	 * Devuelve el alumno al que corresponde esta matricula.
	 * 
	 * @return Alumnos correspondiente a esta MatriculaNormal
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	/**
	 * Modifica el curso de esta matricula
	 * 
	 * @param curso
	 *            CursoNormal que representa el nuevo curso que se asigna a esta
	 *            Matricula Normal
	 */
	public void setCurso(CursoNormal curso) {
		this.curso = curso;
	}
}
