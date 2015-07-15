/*
 * Cï¿½digo-fonte do livro "Programaï¿½ï¿½o Java para a Web"
 * Autores: Dï¿½cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN: 978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - todos os direitos reservados
 *
 * LICENï¿½A: Este arquivo-fonte estï¿½ sujeito a Atribuiï¿½ï¿½o 2.5 Brasil, da licenï¿½a Creative Commons,
 * que encontra-se disponï¿½vel no seguinte endereï¿½o URI: http://creativecommons.org/licenses/by/2.5/br/
 * Se vocï¿½ nï¿½o recebeu uma cï¿½pia desta licenï¿½a, e nï¿½o conseguiu obtï¿½-la pela internet, por favor,
 * envie uma notificaï¿½ï¿½o aos seus autores para que eles possam enviï¿½-la para vocï¿½ imediatamente.
 *
 *
 * Source-code of "Programaï¿½ï¿½o Java para a Web" book
 * Authors: Dï¿½cio Heinzelmann Luckow <decioluckow@gmail.com>
 *          Alexandre Altair de Melo <alexandremelo.br@gmail.com>
 *
 * ISBN: 978-85-7522-238-6
 * http://www.javaparaweb.com.br
 * http://www.novatec.com.br/livros/javaparaweb
 * Editora Novatec, 2010 - all rights reserved
 *
 * LICENSE: This source file is subject to Attribution version 2.5 Brazil of the Creative Commons
 * license that is available through the following URI:  http://creativecommons.org/licenses/by/2.5/br/
 * If you did not receive a copy of this license and are unable to obtain it through the web, please
 * send a note to the authors so they can mail you a copy immediately.
 *
 */
package br.com.compra.combinada.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static final SessionFactory	sessionFactory	= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	} 

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
