package com.monedafrontera.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import com.monedafrontera.dao.AuditUsuarioHome;
import com.monedafrontera.dao.PorcentcomisiontxparampromoHome;
import com.monedafrontera.dto.AuditUsuario;
import com.monedafrontera.dto.AuditUsuarioId;
import com.monedafrontera.dto.Porcentcomisiontxparampromo;



public class ServicioPorcentajeComisiontxParamPromo {
	
      private PorcentcomisiontxparampromoHome porcentaje;
	
      /**
  	 *M�todo que cierra el porcentaje de promoci�n negociado a un promotor 
  	 */
	public String cerrarPorcentajeComisionPromotorParametro(int idTabla, String ip){
		
		this.porcentaje=new PorcentcomisiontxparampromoHome();
		Transaction te=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String respuesta="";
		
		try {
			
			Date fechafin;
			//Comenzamos la transaccion
			te=this.porcentaje.getSession().beginTransaction();
			
			//Buscamos el porcentcomisiontxparampromo por el Id (consecutivo)
			Porcentcomisiontxparampromo pComision= this.porcentaje.findById(idTabla);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date()); 
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			fechafin = sdf.parse(sdf.format( calendar.getTime()));
	
			if(pComision.getFechafin()==null){
			pComision.setFechafin(fechafin);
			
			//auditamos el cierre del porcentaje negociado
			this.auditarUsuario(ip, pComision);
			
			respuesta="El Porcentaje de Comisi�n negociado al Promotor: "+pComision.getPromotor().getPersonal().getNombre()+
					" "+pComision.getPromotor().getPersonal().getApellido()+
					" se cerr� correctamente para "+pComision.getPais().getNombre()+" el d�a: "+pComision.getFechafin();
			
			this.porcentaje.merge(pComision);
			te.commit();
			}
			else{
				 respuesta="No se puede ejecutar la acci�n porque el porcentaje de comisi�n negociado al promotor para "+
			                pComision.getPais().getNombre()+" ya se encuentra cerrado";
			}
			
		} catch (Exception e) {
			te.rollback();
			e.printStackTrace();
		}finally{
			this.porcentaje.getSession().close();
		}
		
		return respuesta;
	}
	
	/**
	 *M�todo que registra una auditor�a sobre el cierre del porcentaje de comision de un promotor
	 */
	private void auditarUsuario(String ip, Porcentcomisiontxparampromo porcentaje){
		
		AuditUsuarioHome audithome=new AuditUsuarioHome();
		
		AuditUsuario auditar=new AuditUsuario();
		
		AuditUsuarioId usuarioId=new AuditUsuarioId();
		usuarioId.setUsuario(ip);
		usuarioId.setDescripcion("Cerr� el porcentaje de comisi�n:"+porcentaje.getPorcentaje()+" del promotor: "+
		porcentaje.getPromotor().getPersonal().getNombre()+" "+porcentaje.getPromotor().getPersonal().getApellido()+
		" para el pais: "+porcentaje.getPais().getNombre());
		usuarioId.setFecha(new Date());
		usuarioId.setOperacion(36);
		
		auditar.setId(usuarioId);
		audithome.persist(auditar);
	}

}
