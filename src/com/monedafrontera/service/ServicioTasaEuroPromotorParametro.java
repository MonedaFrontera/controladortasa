package com.monedafrontera.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import com.monedafrontera.dao.AuditUsuarioHome;
import com.monedafrontera.dao.TasaeuropromotorparametroHome;
import com.monedafrontera.dto.AuditUsuario;
import com.monedafrontera.dto.AuditUsuarioId;
import com.monedafrontera.dto.Tasaeuropromotorparametro;

public class ServicioTasaEuroPromotorParametro {
	
	private TasaeuropromotorparametroHome tasaeuro;
	
	/**
	 *Método que cierra la tasa de Euro negociada a un promotor 
	 */
	public String cerrarTasaEuroPromotorParametro(int idTabla, String ip){
		
		this.tasaeuro=new TasaeuropromotorparametroHome();
		Transaction te=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String respuesta=null;
		
		try {
			
			Date fechafin;
			//Comenzamos la transaccion
			te=this.tasaeuro.getSession().beginTransaction();
			
			//Buscamos la tasadolarpromotorparametro 
			Tasaeuropromotorparametro tasaeuropromotor= this.tasaeuro.findById(idTabla);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date()); 
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			fechafin = sdf.parse(sdf.format( calendar.getTime()));
			
			if(tasaeuropromotor.getFechafin()==null){
				
			tasaeuropromotor.setFechafin(fechafin);
			
			//auditamos el cierre de la tasa del euro
			this.auditarUsuario(ip, tasaeuropromotor);
			
			respuesta="La tasa de Euro negociada al Promotor: "+tasaeuropromotor.getPromotor().getPersonal().getNombre()+
					" "+tasaeuropromotor.getPromotor().getPersonal().getApellido()+
					" se cerró correctamente para "+tasaeuropromotor.getPais().getNombre()+" el día: "+sdf.format(tasaeuropromotor.getFechafin());
			
			this.tasaeuro.merge(tasaeuropromotor);
			te.commit();
			}
			else{
				respuesta="No se puede ejecutar la acción porque la tasa de euro negociada al promotor para "+
			               tasaeuropromotor.getPais().getNombre()+" ya se encuentra cerrada";
			}
			
		} catch (Exception e) {
			te.rollback();
			e.printStackTrace();
		}finally{
			this.tasaeuro.getSession().close();
		}
		
		return respuesta;
	}
	
	
	/**
	 *Método que registra una auditoría sobre el cierre de la tasa a un promotor
	 */
	private void auditarUsuario(String ip, Tasaeuropromotorparametro tasa){
		
		AuditUsuarioHome audithome=new AuditUsuarioHome();
		
		AuditUsuario auditar=new AuditUsuario();
		
		AuditUsuarioId usuarioId=new AuditUsuarioId();
		usuarioId.setUsuario(ip);
		usuarioId.setDescripcion("Cerró la tasa del euro:"+tasa.getTasaeuro()+" del promotor: "+
		tasa.getPromotor().getPersonal().getNombre()+" "+tasa.getPromotor().getPersonal().getApellido()+
		" para el pais: "+tasa.getPais().getNombre());
		usuarioId.setFecha(new Date());
		usuarioId.setOperacion(34);
		
		auditar.setId(usuarioId);
		audithome.persist(auditar);
	}

}







