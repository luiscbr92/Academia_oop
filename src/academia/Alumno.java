package academia;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Implementa los alumnos y almacena su dni, su nombre y apellidos y una lista
 * de matriculas del propio alumno
 * 
 * @author Luis Alberto Centeno, Irene de Olmos Raposo, Ángel Posada García
 *
 */
public abstract class Alumno {
	private UUID id;
	private String nombre;
	private String apellidos;
	private ArrayList<Matricula> matriculas;

	/**
	 * Metodo de inicializacion de un nuevo alumno a partir de nombre, apellidos
	 * 
	 * @param nombre
	 *            String que representa el nombre del alumno
	 * @param apellidos
	 *            String que representa los apellidos del alumno
	 */
	public Alumno(String nombre, String apellidos) {
		id = UUID.randomUUID();
		this.nombre = nombre;
		this.apellidos = apellidos;
		matriculas = new ArrayList<Matricula>();
	}

	/**
	 * Devuelve el identificador unico de este alumno
	 * 
	 * @return UUID que repersenta el identificador unico de este alumno
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Devuelve el nombre de este alumno
	 * 
	 * @return String que representa el nombre de este alumno
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Devuelve los apellidos de este alumno
	 * 
	 * @return String que representa los apellidos de este alumno
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Devuelve la lista de matriculas del alumno
	 * 
	 * @return ArrayList que representa las matriculas de este alumno
	 */
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	/**
	 * Comprueba si este alumno es igual a otro especificado por parametro
	 * 
	 * @param otro
	 *            Alumno con el que se compara
	 * @return {@code true} si se trata del mismo alumno, o {@code false} en
	 *         caso contrario
	 */
	public boolean igual(Alumno otro) {
		return getId().compareTo(otro.getId()) == 0;
	}

	/**
	 * Comprueba si el alumno puede matricularse en un curso normal
	 * 
	 * @param curso
	 *            CursoNormal en el que se intenta matricular al alumno
	 * @return {@code true} si el alumno se puede matricular en el curso
	 *         especificado, o {@code false} en caso contrario
	 */
	public boolean puedeMatricularse(CursoNormal curso) {
		return !curso.estaLleno() && !curso.estaMatriculado(this);
	}

	/**
	 * Matricula a este Alumno en el CursoNormal especificado
	 * 
	 * @param curso
	 *            CursoNormal en el que se matricula este alumno
	 * @assert.pre El curso especificado no esta lleno
	 * @assert.pre Este alumno no esta matriculado en el curso especificado
	 * @assert.post Este alumno es matriculado en el curso especificado
	 */
	public void matricula(CursoNormal curso) {
		assert(!curso.estaLleno()) : "El curso especificado esta lleno";
		assert(!curso.estaMatriculado(this)) : "El alumno ya esta matriculado en el curso especificado";

		MatriculaNormal matricula = new MatriculaNormal(this, curso);
		getMatriculas().add(matricula);
		curso.getMatriculas().add(matricula);
	}

	/**
	 * Comprueba si el alumno puede cambiar de nivel en un curso
	 * 
	 * @param cursoOrigen
	 *            CursoNormal que representa el curso actual
	 * @param cursoDestino
	 *            CursoNormal que representa el curso al que se quiere cambiar
	 * @return {@code true} si este alumno puede cambiar entre los cursos
	 *         especificados, o {@code false} en caso contrario
	 */
	public boolean puedeCambiarNivel(CursoNormal cursoOrigen, CursoNormal cursoDestino) {
		return cursoOrigen.estaMatriculado(this) && !cursoDestino.estaMatriculado(this) && !cursoDestino.estaLleno()
				&& cursoDestino.getIdioma().equals(cursoOrigen.getIdioma())
				&& Math.abs(cursoOrigen.getNivel() - cursoDestino.getNivel()) == 1;
	}

	/**
	 * Cambia el nivel de este alumno indicandole el curso de origen y el de
	 * destino
	 * 
	 * @param cursoOrigen
	 *            CursoNormal que representa el curso actual
	 * @param cursoDestino
	 *            CursoNormal que representa el curso al que se cambia
	 * @assert.pre Este alumno esta matriculado en el curso de origen
	 *             especificado
	 * @assert.pre Este alumno no esta matriculado en el curso de destino
	 *             especificado
	 * @assert.pre El curso de destino especificado no esta lleno
	 * @assert.pre Los idiomas de los cursos especificados son el mismo
	 * @assert.pre Los niveles de los cursos especificados son adyacentes
	 * @assert.post Este alumno cambia de nivel
	 */
	public void cambiarNivel(CursoNormal cursoOrigen, CursoNormal cursoDestino) {
		assert(cursoOrigen.estaMatriculado(this)) : "El alumno no esta matriculado en el curso de origen";
		assert(!cursoDestino.estaMatriculado(this)) : "El alumno ya esta matriculado en el curso de destino";
		assert(!cursoDestino.estaLleno()) : "El curso de destino esta lleno";
		assert(cursoDestino.getIdioma()
				.equals(cursoOrigen.getIdioma())) : "Los idiomas de los cursos especificados son distintos";
		assert(Math.abs(cursoOrigen.getNivel()
				- cursoDestino.getNivel()) == 1) : "Los niveles de los cursos especificados no son adyacentes";

		int i = 0;
		while (i < getMatriculas().size() && !getMatriculas().get(i).getCurso().igual(cursoOrigen))
			i++;
		if (i < getMatriculas().size()) {
			MatriculaNormal miMatricula = (MatriculaNormal) getMatriculas().get(i);
			cursoOrigen.eliminarMatricula(miMatricula);
			miMatricula.setCurso(cursoDestino);
			cursoDestino.anadirMatricula(miMatricula);
		}
	}

	/**
	 * Devuelve la lista de cursos en los que está matriculado el alumno
	 * 
	 * @return ArrayList que representa la lista de cursos en los que
	 *         este alumno esta matriculado
	 */
	public ArrayList<Curso> getCursos() {
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		for (int i = 0; i < getMatriculas().size(); i++)
			cursos.add(getMatriculas().get(i).getCurso());
		return cursos;
	}
	
	/**
	 * Devuelve la deuda de este de Alumno
	 * 
	 * @return Decimal que representa la deuda total de este Alumno
	 */
	public abstract float deuda();
}
