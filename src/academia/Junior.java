package academia;

import java.time.LocalDate;

/**
 * Implementa los alumnos de tipo junior conociendo su nombre, sus apellidos, su
 * fecha de nacimiento y el adulto responsable del mismo
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class Junior extends Alumno {
	private LocalDate fechaNacimiento;
	private Adulto responsable;

	/**
	 * Metodo que inicializa un Junior a traves de nombre, apellidos, fecha de
	 * nacimiento y adulto responsable del alumno junior
	 * 
	 * @param nombre
	 *            String que representa el nombre del alumno junior
	 * @param apellidos
	 *            String que representa los apellidos del alumno junior
	 * @param fechaNacimiento
	 *            LocalDate que representa la fecha de nacimiento del alumno
	 *            junior
	 * @param responsable
	 *            Adulto que representa el responsable del alumno junior
	 * @assert.pre La edad del alumno es menor de 18
	 * @assert.post El Junior es creado
	 * 
	 */
	public Junior(String nombre, String apellidos, LocalDate fechaNacimiento, Adulto responsable) {
		super(nombre, apellidos);
		assert(fechaNacimiento.plusYears(18).isAfter(LocalDate.now())) : "El alumno no es menor de 18";
		this.fechaNacimiento = fechaNacimiento;
		this.responsable = responsable;
		responsable.anadeJunior(this);
	}

	/**
	 * Devuelve la fecha de nacimiento del alumno junior
	 * 
	 * @return LocalDate que representa la fecha de nacimiento de este Junior
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Delvuelve el Adulto responsable de este alumno junior
	 * 
	 * @return Adulto que se hace responsable de los pagos de este Junior
	 */
	public Adulto getResponsable() {
		return responsable;
	}

	/**
	 * Comprueba si este alumno puede matricularse en un curso junior
	 * 
	 * @param curso
	 *            CursoJunior en el que se intenta matricular al alumno
	 * @return {@code true} si el alumno puede matricularse en el curso
	 *         especificado, o {@code false} en caso contrario
	 */
	public boolean puedeMatricularse(CursoJunior curso) {
		return !curso.estaLleno() && !curso.estaMatriculado(this) && cumpleEdad(curso);
	}

	/**
	 * Matricula a este Junior en el curso especificado y proporciona un
	 * telefono de contacto
	 * 
	 * @param curso
	 *            CursoJunior en el que se matricula este Junior
	 * @param telefono
	 *            String que representa el telefono de contacto
	 * @assert.pre El curso especificado no esta lleno
	 * @assert.pre Este alumno no esta matriculado en el curso especificado
	 * @assert.pre Este alumno tiene al menos la edad minima para matricularse
	 *             en el curso especificado
	 * @assert.pre Este alumno tiene como mucho la edad maxima para matricularse
	 *             en el curso especificado
	 * @assert.post Este alumno es matriculado en el cursoJunior especificado
	 */
	public void matricula(CursoJunior curso, String telefono) {
		assert(!curso.estaLleno()) : "El curso especificado esta lleno";
		assert(!curso.estaMatriculado(this)) : "El alumno ya esta matriculado en el curso especificado";
		// System.err.println(!getFechaNacimiento().plusYears(curso.getEdadMinima()).isAfter(curso.getFechaInicio()));
		assert(!getFechaNacimiento().plusYears(curso.getEdadMinima())
				.isAfter(curso.getFechaInicio())) : "El alumno no tiene la edad minima";
		assert(getFechaNacimiento().plusYears(curso.getEdadMaxima())
				.isAfter(curso.getFechaInicio())) : "El alumno ha sobrepasado la edad maxima";

		MatriculaJunior matricula = new MatriculaJunior(this, curso, telefono);
		getMatriculas().add(matricula);
		curso.getMatriculas().add(matricula);
	}

	/**
	 * Dado que los alumnos Junior no tienen responsabilidad economica, su deuda
	 * es siempre 0
	 */
	public float deuda() {
		return 0;
	}

	private boolean cumpleEdad(CursoJunior curso) {
		return !getFechaNacimiento().plusYears(curso.getEdadMinima()).isAfter(curso.getFechaInicio())
				&& getFechaNacimiento().plusYears(curso.getEdadMaxima()).isAfter(curso.getFechaInicio());
	}
}
