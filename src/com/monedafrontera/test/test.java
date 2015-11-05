package com.monedafrontera.test;

import org.hibernate.Transaction;

import com.monedafrontera.dao.PersonalHome;
import com.monedafrontera.dto.Personal;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PersonalHome person = new PersonalHome();

		Transaction t = person.getSession().beginTransaction();

		Personal p = person.findById("11111111");
        System.out.println("Nombre: "+p.getNombre()+"----"+p.getApellido());
		t.commit();
		person.getSession().close();

	}

}
