package academia;

import java.util.ArrayList;

/**
 * Implementa los alumnos Adulto, hereda de Alumno y almacena el dni y una lista
 * de alumnos Junior de los cuales el adulto es responsable de los pagos
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class Adulto extends Alumno {
	private String dni;
	private ArrayList<Junior> juniors;

	/**
	 * Metodo de inicializacion de un nuevo Adulto a partir de su dni, nombre y
	 * apellidos
	 * 
	 * @param dni
	 *            String que representa el dni del adulto
	 * @param nombre
	 *            String que representa el nombre del alumno
	 * @param apellidos
	 *            String que representa los apellidos del alumno
	 */
	public Adulto(String dni, String nombre, String apellidos) {
		super(nombre, apellidos);
		this.dni = dni;
		juniors = new ArrayList<Junior>();
	}

	/**
	 * Devuelve el dni de este alumno adulto
	 * 
	 * @return String que respresenta el dni del adulto
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Devuelve la lista de Junior de los que este Adulto es responsable
	 * 
	 * @return ArrayList que representa la lista de Junior de los que
	 *         este Adulto es responsable
	 */
	public ArrayList<Junior> getJuniors() {
		return juniors;
	}

	/**
	 * Añade un nuevo Junior del que este adulto se hara responsable
	 * 
	 * @param junior
	 *            Alumno tipo Junior
	 */
	public void anadeJunior(Junior junior) {
		juniors.add(junior);
	}

	/**
	 * Devuelve la suma de deudas de este de Adulto y de los Juniors a su cargo
	 */
	public float deuda() {
		int deuda = 0;
		for (int i = 0; i < getMatriculas().size(); i++)
			if (!getMatriculas().get(i).estaPagada())
				deuda += getMatriculas().get(i).getCurso().getPrecio();

		for (int i = 0; i < juniors.size(); i++)
			for (int j = 0; j < juniors.get(i).getMatriculas().size(); j++)
				if (!juniors.get(i).getMatriculas().get(j).estaPagada())
					deuda += juniors.get(i).getMatriculas().get(j).getCurso().getPrecio();

		return deuda;
	}

	/**
	 * Comprueba si este adulto es responsable del Junior que se especifica por
	 * parametro
	 * 
	 * @param junior
	 *            Alumno de tipo Junior
	 * @return {@code true} si el Adulto es responsable del Junior especificado,
	 *         o {@code false} en caso contrario
	 */
	public boolean esResponsable(Junior junior) {
		int i = 0;
		while (i < getJuniors().size() && !getJuniors().get(i).igual(junior))
			i++;
		return i < getJuniors().size();
	}

	/**
	 * Establece la matricula correspondiente a este adulto y al curso
	 * especificado por parametro como pagada
	 * 
	 * @param curso
	 *            CursoNormal que se desea pagar
	 * @assert.pre Este adulto esta matriculado en el curso especificado
	 * @assert.pre La matricula correppondiente a este adulto y el curso
	 *             especificado no esta pagada previamente
	 * @assert.post La matricula correspondiente a este adulto y el curso
	 *              especificado queda pagada
	 */
	public void paga(CursoNormal curso) {
		assert(curso.estaMatriculado(this)) : "El adulto no esta matriculado en el curso especificado";

		int i = 0;
		while (i < getMatriculas().size() && !getMatriculas().get(i).getCurso().igual(curso))
			i++;

		assert(!getMatriculas().get(i).estaPagada()) : "La matricula ya esta pagada";

		getMatriculas().get(i).establecerPagada();
	}

	/**
	 * Establece la matricula correspondiente al curso y al junior especificados
	 * por parametro
	 * 
	 * @param curso
	 *            Curso que se desea pagar
	 * @param junior
	 *            Junior del cual se desea pagar la matricula del curso
	 *            especificado
	 * @assert.pre Este adulto es responsable del Junior especificado
	 * @assert.pre El junior especificado esta matriculado en el curso
	 *             especificado
	 * @assert.pre La matricula correspondiente al curso y al junior
	 *             especificado no esta pagada previamente
	 * @assert.post La matricula correspondiente al Junior y al curso
	 *              especificado queda pagada
	 */
	public void paga(Curso curso, Junior junior) {
		assert(esResponsable(junior)) : "El adulto no es responsable del junior especificado";
		assert(curso.estaMatriculado(junior)) : "El junior no esta matriculado en el curso especificado";

		int i = 0;

		while (i < junior.getMatriculas().size() && !junior.getMatriculas().get(i).getCurso().igual(curso))
			i++;

		assert(!junior.getMatriculas().get(i).estaPagada()) : "La matricula ya esta pagada";

		junior.getMatriculas().get(i).establecerPagada();
	}
}
