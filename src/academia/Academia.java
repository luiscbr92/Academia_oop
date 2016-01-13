package academia;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase compruba el correcto funcionamiento del resto de clases
 * 
 * @author Luis Alberto Centeno, Irene de Olmos, Ángel Posada
 *
 */
public class Academia {

	/**
	 * Imprime el idioma, nivel y cantidad de alumnos matriculados de un curso
	 * normal
	 * 
	 * @param c
	 *            Curso del que se quiere imprimir la informacion
	 */
	public static void imprimeCurso(Curso c) {
		System.out.print(c.getIdioma() + " ");
		System.out.print(c.getPrecio() + " ");
		System.out.println("Alumnos matriculados: " + c.getAlumnos().size());
	}

	/**
	 * Imprime nombre, apellidos, dni, deuda y matriculas realizadas de un
	 * alumno
	 * 
	 * @param a
	 *            Alumno del que se quiere imprimir la informacion
	 */
	public static void imprimeAlumno(Alumno a) {
		System.out.println(a.getNombre() + " " + a.getApellidos());
		System.out.println("\t\tDeuda total de este alumno: " + a.deuda());
		System.out.println("\t\tMatriculas realizadas: " + a.getMatriculas().size());
	}

	public static void main(String[] args) {
		int i, j;
		ArrayList<Curso> misCursos = new ArrayList<Curso>();
		ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();

		System.out.println("****** CREACION DE ALUMNOS ******");
		System.out.println("Creando 5 alumnos de tipo adulto: ");

		Adulto angel = new Adulto("12345678G", "Angel", "Posada");
		misAlumnos.add(angel);
		Adulto luis = new Adulto("87654321H", "Luis", "Centeno");
		misAlumnos.add(luis);
		Adulto pedro = new Adulto("15975346F", "Pedro", "Gomez");
		misAlumnos.add(pedro);
		Adulto elena = new Adulto("81294637R", "Elena", "Perez");
		misAlumnos.add(elena);
		Adulto maria = new Adulto("36172849S", "Maria", "Lopez");
		misAlumnos.add(maria);

		System.out.println("Creando 5 alumnos de tipo junior: ");

		Junior irene = new Junior("Irene", "De Olmos", LocalDate.of(2007, 10, 1), angel);
		misAlumnos.add(irene);
		Junior andrea = new Junior("Andrea", "Gomez", LocalDate.of(2002, 3, 30), elena);
		misAlumnos.add(andrea);
		Junior juana = new Junior("Juana", "Garcia", LocalDate.of(2005, 1, 7), pedro);
		misAlumnos.add(juana);
		Junior antonio = new Junior("Antonio", "Sanchez", LocalDate.of(2013, 12, 16), luis);
		misAlumnos.add(antonio);

		System.out.println("Imprimiendo la lista de alumnos creados");
		for (i = 0; i < misAlumnos.size(); i++) {
			imprimeAlumno(misAlumnos.get(i));
			for (j = 0; j < misAlumnos.get(i).getCursos().size(); j++) {
				System.out.print('\t');
				imprimeCurso(misAlumnos.get(i).getCursos().get(j));
			}
		}
		System.out.println("------------------------------\n");

		System.out.println("****** CREACION DE CURSOS NORMALES******");
		System.out.println("Creando 3 cursos normales de ingles, 3 de frances, 2 de aleman: ");
		System.out.println("Creando 3 cursos junior, 1 de ingles, 1 de frances, 1 de aleman: ");

		CursoNormal ingles1 = new CursoNormal("ingles", LocalDate.of(2015, 12, 26), LocalDate.of(2016, 6, 22), 18, 15,
				75, 1);
		misCursos.add(ingles1);
		CursoNormal frances1 = new CursoNormal("frances", LocalDate.of(2015, 12, 26), LocalDate.of(2016, 6, 22), 18, 15,
				75, 1);
		misCursos.add(frances1);
		CursoNormal aleman1 = new CursoNormal("aleman", LocalDate.of(2015, 12, 26), LocalDate.of(2016, 6, 22), 18, 15,
				75, 1);
		misCursos.add(aleman1);
		CursoNormal ingles2 = new CursoNormal("ingles", LocalDate.of(2015, 12, 27), LocalDate.of(2016, 6, 23), 18, 15,
				85, 2);
		misCursos.add(ingles2);
		CursoNormal frances2 = new CursoNormal("frances", LocalDate.of(2015, 12, 27), LocalDate.of(2016, 6, 23), 18, 15,
				85, 2);
		misCursos.add(frances2);
		CursoNormal aleman2 = new CursoNormal("aleman", LocalDate.of(2015, 12, 27), LocalDate.of(2016, 6, 23), 18, 10,
				85, 2);
		misCursos.add(aleman2);
		CursoNormal ingles3 = new CursoNormal("ingles", LocalDate.of(2015, 12, 28), LocalDate.of(2016, 6, 24), 18, 15,
				95, 3);
		misCursos.add(ingles3);
		CursoNormal frances3 = new CursoNormal("frances", LocalDate.of(2015, 12, 28), LocalDate.of(2016, 6, 24), 18, 1,
				95, 3);
		misCursos.add(frances3);

		CursoJunior ingles = new CursoJunior("ingles", LocalDate.of(2015, 12, 26), LocalDate.of(2016, 6, 26), 5, 15, 65,
				7, 18);
		misCursos.add(ingles);
		CursoJunior frances = new CursoJunior("frances", LocalDate.of(2015, 12, 27), LocalDate.of(2016, 6, 27), 5, 15,
				65, 9, 16);
		misCursos.add(frances);
		CursoJunior aleman = new CursoJunior("aleman", LocalDate.of(2015, 12, 28), LocalDate.of(2016, 6, 28), 5, 2, 65,
				5, 15);
		misCursos.add(aleman);
		CursoJunior chino = new CursoJunior("chino", LocalDate.of(2015, 12, 28), LocalDate.of(2016, 6, 28), 5, 2, 65, 5,
				6);
		misCursos.add(aleman);

		System.out.println("Imprimiendo la lista de cursos:");
		for (i = 0; i < misCursos.size(); i++) {
			imprimeCurso(misCursos.get(i));
			for (j = 0; j < misCursos.get(i).getAlumnos().size(); j++) {
				System.out.print('\t');
				imprimeAlumno(misCursos.get(i).getAlumnos().get(j));
			}
		}
		System.out.println("------------------------------\n");

		System.out.println("****** MATRICULACION DE UN ALUMNO JUNIOR EN UN CURSO NORMAL ******");
		System.out.print("Intentando matricular al alumno Irene en aleman 2: ");
		irene.matricula(aleman2);
		if (irene.puedeMatricularse(aleman2)) {
			irene.matricula(aleman2);
			System.out.println("OK");
		}
		imprimeAlumno(irene);
		System.out.println("------------------------------\n");

		System.out.println("****** CAMBIO DE NIVEL EN UN CURSO ******");
		System.out.print("Intentando cambiar al alumno Irene de aleman 2 a aleman 1:");
		if (irene.puedeCambiarNivel(aleman2, aleman1)) {
			System.out.println(" OK");
			irene.cambiarNivel(aleman2, aleman1);
		}
		System.out.println("------------------------------\n");

		System.out.println("****** MATRICULACIONES DE ALUMNOS EN CURSOS NORMALES ******");
		System.out.print("Intentando matricular al alumno Angel en ingles 2: ");
		if (angel.puedeMatricularse(ingles2)) {
			angel.matricula(ingles2);
			System.out.println("OK");
		}
		imprimeAlumno(angel);
		System.out.println("-------------------------------------\n");

		System.out.print("Intentando matricular al alumno Luis en aleman 2: ");
		if (luis.puedeMatricularse(aleman2)) {
			luis.matricula(aleman2);
			System.out.println("OK");
		}

		System.out.print("Intentando matricular al alumno Pedro en frances 2: ");
		if (pedro.puedeMatricularse(frances2)) {
			pedro.matricula(frances2);
			System.out.println("OK");
		}

		System.out.println("------------------------------\n");
		System.out.println("****** CAMBIO DE NIVEL EN UN CURSO ******");
		System.out.print("Intentando cambiar al alumno Pedro de frances 2 a frances 3:");
		if (pedro.puedeCambiarNivel(frances2, frances3)) {
			pedro.cambiarNivel(frances2, frances3);
			System.out.println(" OK");
		}
		System.out.println("------------------------------\n");

		System.out.println("****** MATRICULACIONES DE ALUMNOS JUNIOR EN CURSOS JUNIOR ******");
		System.out.print("Intentando matricular al alumno junior Andrea en ingles: ");
		if (andrea.puedeMatricularse(ingles)) {
			andrea.matricula(ingles, "568457865");
			System.out.println("OK");
		}

		System.out.print("Intentando matricular al alumno junior Juana en aleman: ");
		if (juana.puedeMatricularse(aleman)) {
			juana.matricula(aleman, "123456789");
			System.out.println("OK\n");
		}

		System.out.print("Intentando matricular al alumno junior Irene en aleman: ");
		if (irene.puedeMatricularse(aleman)) {
			irene.matricula(aleman, "123456789");
			System.out.println("OK\n");
		}

		System.out.println("****** PAGAR MATRICULA DE UN ALUMNO ******");
		System.out.println("Itentado pagar deuda del alumno Angel");
		System.out.println("Deuda pendiente: " + angel.deuda());
		angel.paga(ingles2);
		System.out.println("Pagando curso ingles 2 del alumno Angel");
		System.out.println("Deuda pendiente: " + angel.deuda() + "\n");

		System.out.println("****** PAGAR MATRICULA DE UN ALUMNO JUNIOR******");
		System.out.println("Itentado pagar deuda del alumno Irene del cual es responsable el adulto Angel");
		System.out.println("Deuda pendiente: " + angel.deuda());
		angel.paga(aleman, irene);
		System.out.println("Pagando curso aleman del alumno Irene");
		System.out.println("Deuda pendiente: " + angel.deuda() + "\n\n");

		System.out.println("#### Probando asserts ####\n");

		System.out.println("*****INTENTANDO CREAR A UN JUNIOR MAYOR DE 18******");
		try {
			System.out.print("Intentando crear al alumno junior Juan ayor de 18: ");
			@SuppressWarnings("unused") // No mostrar warning sobre que la
										// variable juan no es usada
			Junior juan = new Junior("Juan", "Garcia", LocalDate.of(1991, 5, 22), pedro);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO PAGAR UN CURSO EN EL QUE NO ESTA MATRICULADO******");
		try {
			System.out.println("Intentado pagar de nuevo deuda del alumno Angel");
			System.out.println("Deuda pendiente: " + angel.deuda());
			angel.paga(ingles3);
			System.out.println("Pagando curso ingles 3 del alumno Angel");
			System.out.println("Deuda pendiente: " + angel.deuda() + "\n");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO PAGAR UN CURSO YA PAGADO******");
		try {
			System.out.println("Intentado pagar de nuevo deuda del alumno Angel");
			System.out.println("Deuda pendiente: " + angel.deuda());
			angel.paga(ingles2);
			System.out.println("Pagando curso ingles 2 del alumno Angel");
			System.out.println("Deuda pendiente: " + angel.deuda() + "\n");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO PAGAR UN CURSO DE JUNIOR RESPONSABLE NO MATRICULADO******");
		try {
			System.out.println("Intentado pagar deuda del alumno Irene del cual es responsable el adulto Angel");
			System.out.println("Deuda pendiente: " + angel.deuda());
			angel.paga(frances, irene);
			System.out.println("Pagando curso aleman del alumno Irene");
			System.out.println("Deuda pendiente: " + angel.deuda() + "\n");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO PAGAR UN CURSO DE JUNIOR NO RESPONSABLE ******");
		try {
			System.out.println("Intentado pagar deuda del alumno Irene del cual no es responsable el adulto Elena");
			System.out.println("Deuda pendiente: " + elena.deuda());
			elena.paga(aleman, irene);
			System.out.println("Pagando curso aleman del alumno Irene");
			System.out.println("Deuda pendiente: " + elena.deuda() + "\n");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO PAGAR UN CURSO DE JUNIOR RESPONSABLE YA PAGADO******");
		try {
			System.out.println("Intentado pagar deuda del alumno Irene del cual es responsable el adulto Angel");
			System.out.println("Deuda pendiente: " + angel.deuda());
			angel.paga(aleman, irene);
			System.out.println("Pagando curso aleman del alumno Irene");
			System.out.println("Deuda pendiente: " + angel.deuda() + "\n");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		try {
			System.out.println("\n****** MATRICULACION DE UN ALUMNO EN UN CURSO NORMAL LLENO ******");
			System.out.print("Intentando matricular al alumno Angel en frances 3: ");
			angel.matricula(frances3);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n****** MATRICULACION DE UN ALUMNO EN UN CURSO YA MATRICULADO******");
			System.out.print("Intentando matricular al alumno Angel de nuevo en ingles 2: ");
			angel.matricula(ingles2);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n****** CAMBIO DE NIVEL EN UN CURSO NO MATRICULADO EN ORIGEN ******");
			System.out.print("Intentando cambiar al alumno Pedro de frances 1 a frances 2: ");
			pedro.cambiarNivel(frances1, frances2);

			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		pedro.matricula(frances2);

		try {
			System.out.println("\n****** CAMBIO DE NIVEL EN UN CURSO MATRICULADO EN DESTINO ******");
			System.out.print("Intentando cambiar al alumno Pedro de frances 2 a frances 3:");
			pedro.cambiarNivel(frances2, frances3);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		luis.matricula(frances2);

		try {
			System.out.println("\n****** CAMBIO DE NIVEL A UN CURSO LLENO ******");
			System.out.print("Intentando cambiar al alumno Luis de frances 2 a frances 3:");
			luis.cambiarNivel(frances2, frances3);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		luis.matricula(ingles3);

		try {
			System.out.println("\n****** CAMBIO DE NIVEL ENTRE CURSOS DE DISTINTO IDIOMA ******");
			System.out.print("Intentando cambiar al alumno Luis de ingles 3 a aleman 1:");
			luis.cambiarNivel(ingles3, aleman1);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n****** CAMBIO DE NIVEL ENTRE CURSOS DE DISTINTO IDIOMA ******");
			System.out.print("Intentando cambiar al alumno Luis de ingles 3 a ingles 1:");
			luis.cambiarNivel(ingles3, ingles1);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n****** MATRICULACION EN CURSO JUNIOR LLENO ******");
			System.out.print("Intentando matricular a Andrea en aleman: ");
			andrea.matricula(aleman, "5666");
			;
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("\n****** MATRICULACION DE JUNIOR EN CURSO JUNIOR YA MATRICULADO ******");
			System.out.print("Intentando matricular a Andrea en ingles: ");
			andrea.matricula(ingles, "5666");
			;
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n*****INTENTANDO MATRICULAR A UN JUNIOR MENOR DE LA EDAD MINIMA******");
		try {
			System.out.print("Intentando matricular al alumno junior Antonio en frances: ");
			antonio.matricula(frances, "458765989");
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}

		System.out.println("\n*****INTENTANDO MATRICULAR A UN JUNIOR MAYOR DE LA EDAD MAXIMA******");
		try {
			System.out.print("Intentando matricular al alumno junior Andrea en chino: ");
			andrea.matricula(chino, "458765989");
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}

		System.out.println("\n*****INTENTANDO CREAR UN CURSO CON FECHA INICIO POSTERIOR A FIN******");
		try {
			System.out.print("Intentando crear Curso con fecha de inicio 21/12/2015 y de fin 20/12/2015: ");
			@SuppressWarnings("unused")
			CursoNormal chino3 = new CursoNormal("chino", LocalDate.of(2015, 12, 21), LocalDate.of(2015, 12, 20), 10,
					10, 35, 3);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}

		System.out.println("\n*****INTENTANDO CREAR UN CURSO CON MAXIMO DE ALUMNOS 0******");
		try {
			System.out.print("Intentando crear Curso con maximo de alumnos 0: ");
			@SuppressWarnings("unused")
			CursoNormal chino3 = new CursoNormal("chino", LocalDate.of(2015, 11, 22), LocalDate.of(2015, 12, 20), 10, 0,
					35, 3);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}

		System.out.println("\n*****INTENTANDO CREAR UN CURSO JUNIOR CON EDAD MAXIMA 19******");
		try {
			System.out.print("Intentando crear CursoJunior con edad maxima 19: ");
			@SuppressWarnings("unused")
			CursoJunior portugues = new CursoJunior("portugues", LocalDate.of(2015, 9, 20), LocalDate.of(2015, 12, 20),
					11, 10, 35, 10, 19);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println("\n*****INTENTANDO CREAR UN CURSO JUNIOR CON EDAD MAXIMA MENOR QUE MINIMA******");
		try {
			System.out.print("Intentando crear CursoJunior con edad maxima menor que minima: ");
			@SuppressWarnings("unused")
			CursoJunior portugues = new CursoJunior("portugues", LocalDate.of(2015, 9, 20), LocalDate.of(2015, 12, 20),
					11, 10, 35, 10, 8);
			System.out.println("OK");
		} catch (AssertionError e) {
			System.out.println(e.getMessage() + "\n");
		}
	}
}
