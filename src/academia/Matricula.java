package academia;

import java.util.UUID;

/**
 * Implementa las matriculas, que representan la inscripcion de un alumno en un
 * curso. Almacena su identificador unico, el alumno, el curso y si la
 * inscripcion ha sido pagada.
 * 
 * @author Luis Alberto Centeno, Irene de Olmos Raposo, Ángel Posada García
 *
 */

public abstract class Matricula {
	private UUID id;
	private boolean pagado;

	/**
	 * Metodo que inicializa una Matricula, cuyo estado de pago inicial es
	 * siempre falso
	 * 
	 */
	public Matricula() {
		id = UUID.randomUUID();
		pagado = false;
	}

	/**
	 * Devuelve el identificador unico de esta matricula
	 * 
	 * @return UUID que repersenta el identificador unico de esta matricula
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Compueba si esta matricula está pagada o no
	 * 
	 * @return {@code true} si la matricula ha sido pagada, o {@code false} en
	 *         caso contrario
	 */
	public boolean estaPagada() {
		return pagado;
	}

	/**
	 * Comprueba si esta matricula es igual a otra especificada por parametro
	 * 
	 * @param otra
	 *            Matricula con la que se compara
	 * @return {@code true} si se trata de la misma matricula, o {@code false}
	 *         en caso contrario
	 */
	public boolean igual(Matricula otra) {
		return getId().compareTo(otra.getId()) == 0;
	}

	/**
	 * Devuelve el curso al que corresponde esta Matricula
	 * 
	 * @return Curso correspondiente a esta Matricula
	 */
	public abstract Curso getCurso();

	/**
	 * Establece esta matricula como pagada
	 */
	public void establecerPagada() {
		pagado = true;
	}

}
