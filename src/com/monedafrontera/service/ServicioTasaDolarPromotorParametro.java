package com.monedafrontera.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.hibernate.Transaction;

import com.monedafrontera.dao.AuditUsuarioHome;
import com.monedafrontera.dao.TasadolarpromotorparametroHome;
import com.monedafrontera.dto.AuditUsuario;
import com.monedafrontera.dto.AuditUsuarioId;
import com.monedafrontera.dto.Tasadolarpromotorparametro;


public class ServicioTasaDolarPromotorParametro {
	
	private TasadolarpromotorparametroHome tasadolar;
	
	/**
	 *Método que cierra la tasa de dolar negociada a un promotor 
	 */
	public String cerrarTasaDolarPromotorParametro(int idTabla, String ip){
		
		this.tasadolar=new TasadolarpromotorparametroHome();
		Transaction te=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String respuesta="";
		
		try {
			
			Date fechafin;
			//Comenzamos la transaccion
			te=this.tasadolar.getSession().beginTransaction();
			
			//Buscamos la tasadolarpromotorparametro por el Id (consecutivo)
			Tasadolarpromotorparametro tasadolarpromotor= this.tasadolar.findById(idTabla);
			System.out.println(tasadolarpromotor.getTasadolar()+"-------"+tasadolarpromotor.getFechafin());
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date()); 
			calendar.add(Calendar.DAY_OF_YEAR, -1);
			fechafin = sdf.parse(sdf.format( calendar.getTime()));
			
			if(tasadolarpromotor.getFechafin()==null){
			tasadolarpromotor.setFechafin(fechafin);
			
			//Auditamos el cierre de la tasa
			this.auditarUsuario(ip, tasadolarpromotor);
			
			respuesta="La tasa de dólar negociada al Promotor: "+tasadolarpromotor.getPromotor().getPersonal().getNombre()+
					" "+tasadolarpromotor.getPromotor().getPersonal().getApellido()+
					" se cerró correctamente para "+tasadolarpromotor.getPais().getNombre()+" el día: "+sdf.format(tasadolarpromotor.getFechafin());
			
			this.tasadolar.merge(tasadolarpromotor);
			te.commit();
			
			}else{
			 respuesta="No se puede ejecutar la acción porque la tasa de dólar negociada al promotor para "+
			           tasadolarpromotor.getPais().getNombre()+" ya se encuentra cerrada";
			}
			
		} catch (Exception e) {
			te.rollback();
			e.printStackTrace();
		}finally{
			this.tasadolar.getSession().close();
		}
		
		return respuesta;
	}
	
	/**
	 *Método que registra una auditoría sobre el cierre de la tasa a un promotor
	 */
	private void auditarUsuario(String ip, Tasadolarpromotorparametro tasa){
		
		AuditUsuarioHome audithome=new AuditUsuarioHome();
		
		AuditUsuario auditar=new AuditUsuario();
		
		AuditUsuarioId usuarioId=new AuditUsuarioId();
		usuarioId.setUsuario(ip);
		usuarioId.setDescripcion("Cerró la tasa del dolar:"+tasa.getTasadolar()+" del promotor: "+
		tasa.getPromotor().getPersonal().getNombre()+" "+tasa.getPromotor().getPersonal().getApellido()+
		" para el pais: "+tasa.getPais().getNombre());
		usuarioId.setFecha(new Date());
		usuarioId.setOperacion(35);
		
		auditar.setId(usuarioId);
		audithome.persist(auditar);
	}

}
