package com.monedafrontera.webcontroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monedafrontera.service.ServicioPorcentajeComisiontxParamPromo;
import com.monedafrontera.service.ServicioTasaDolarPromotorParametro;
import com.monedafrontera.service.ServicioTasaEuroPromotorParametro;

/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}
	

	/**
	 * Procesa los cierres de tasas y porcentajes negociados a un promotor
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo el parametro tipo que me permitira saber cual tabla modificar
		String tipo=request.getParameter("tipo");
		
		//Obtengo el id o consecutivo del registro que se debe modificar
		int idTabla=Integer.parseInt(request.getParameter("id"));
		
		//Obtengo el tipo de cliente que hace la peticion
		String agent=request.getHeader("User-Agent");
		
		//Obtengo la dirección ip de donde se realiza la petición
		String ip=request.getRemoteAddr();
		
		System.out.println(tipo+"---"+idTabla+"---"+agent+"---"+ip);
		String respuesta="Hubo un error, por favor comuníquese con el administrador del sistema";
		
		if( "euro".equals(tipo) ){
			//Nos comunicamos con la capa de servicio
			ServicioTasaEuroPromotorParametro servicioeuro= new ServicioTasaEuroPromotorParametro();
			respuesta=servicioeuro.cerrarTasaEuroPromotorParametro(idTabla, ip);
			System.out.println(respuesta);
		}else if("dolar".equals(tipo)){
			//Nos comunicamos con la capa de servicio
			ServicioTasaDolarPromotorParametro serviciodolar= new ServicioTasaDolarPromotorParametro();
			respuesta=serviciodolar.cerrarTasaDolarPromotorParametro(idTabla, ip);
			
		}else if("porcentaje".equals(tipo)){
			ServicioPorcentajeComisiontxParamPromo servicioporcentaje=new ServicioPorcentajeComisiontxParamPromo();
			respuesta=servicioporcentaje.cerrarPorcentajeComisionPromotorParametro(idTabla, ip);
		}
		
		request.setAttribute("mensaje", respuesta);
		request.getRequestDispatcher("confirmacion.jsp").forward(request, response);
		
	}
	
	

}
