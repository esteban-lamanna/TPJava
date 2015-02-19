package Servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet; 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

import Controlador.Controlador_encar;
/**
 * Servlet implementation class RegistroConUpload
 */
@WebServlet("/RegistroConUpload")
public class RegistroConUpload extends Padre {
	private static final long serialVersionUID = 1L;
	  private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 1024*1024*5;
	   private int maxMemSize = 1024*1024*5;
	   private File file ;
	   private String carpeta;
	   
	   public void init( ){
	      // Get the file location where it would be stored.
		   ServletContext context = getServletContext();
		   carpeta = "imagenesProductos\\";
		   String path = context.getRealPath("/");
		   filePath = getServletContext().getRealPath("")+ File.separator + carpeta;
	    //filePath = context.getInitParameter("file-upload");
		   /*String relativeWebPath = "/tempfiledir";
		   String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
		   filePath = "/css/images/productos";		  */
		   
		  
	    		  }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroConUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	        
	        throw new ServletException("GET method used with " +
	                getClass( ).getName( )+": POST method required.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8"); 
		String nombreprod="";
	 	String modelo="";
	 	String descripcion="";	
	 	Float precio = 0.0f;
	 	String tipo="";
	 	String capHD="";
	 	String interfaz="";
	 	String rpm="";
	 	String buffer="";
	 	String watts="";
	 	String flo = "";
	 	String amperaje = "";
	 	String frecuenciamicro="";
	 	String cachemicro="";
	 	String socketmicro="";
	 	String jacks="";
	 	String taman="";
	 	String velocidadr="";
	 	String cantusb="";
	 	String cantpcie="";
	 	String videoonboard="";
	 	String sonidoonboard="";
	 	String chipset="";
	 	String cantusb3="";
	 	String cantmaxmemmo="";
	 	String frecuenciamem=""; 
	 	String latencia=""; 
	 	String capacidadmem=""; 
	 	String frecuenciavideo=""; 
	 	String anchobus=""; 
	 	String cantmemvideo=""; 
	 	String pipelines=""; 
	 	String shaders=""; 
	 	String socketmo="";		
	 	String foto="";
	    HttpSession sesion = request.getSession(false);
		if(sesion==null)
		{
			sesion = request.getSession(true);
		}
		// Check that we have a file upload request
		
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      String direccion = "";
	      java.io.PrintWriter out = response.getWriter( );
	      if( !isMultipart ){
	         out.println("<html>");
	         out.println("<head>");
	         out.println("<title>Servlet upload</title>");  
	         out.println("</head>");
	         out.println("<body>");
	         out.println("<p>No file uploaded</p>"); 
	         out.println("</body>");
	         out.println("</html>");
	         return;
	      }
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);
	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("c:\\temp"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );

	      try{ 
	      // Parse the request to get file items.
	      
	      List fileItems = upload.parseRequest(request);	      
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>Servlet upload</title>");  
	      out.println("</head>");
	      out.println("<body>");

  			Controlador_encar contr= getControlador();
	      while ( i.hasNext () ) 
	      {
	    	  
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {
	            // Get the uploaded file parameters
	            String fieldName = fi.getFieldName();
	            String fileName = fi.getName();
	            String contentType = fi.getContentType();
	            boolean isInMemory = fi.isInMemory();
	            long sizeInBytes = fi.getSize();
	            // Write the file
	          
	            //filePath = "c:\\"+carpeta;
	            if( fileName.lastIndexOf("\\") >= 0 ){
	            	direccion = filePath + fileName.substring( fileName.lastIndexOf("\\"));
	               file = new File( direccion);
	            }else{
	            	direccion = filePath + fileName.substring( fileName.lastIndexOf("\\")+1);
	               file = new File(direccion) ;
	            }
	            foto = direccion;
	            
	            fi.write( file ) ;
	            out.println("Uploaded Filename: " + fileName + "<br>");          
	          
	               
	         }
	         else
	         {
	        	 String fieldName = fi.getFieldName();        	
	        	
	        	if(fieldName.equals("nombreprod"))
	        		nombreprod=	fi.getString("UTF-8").trim();	        		
	        	
	        	if(fieldName.equals("modelo"))
	        		modelo=	fi.getString("UTF-8").trim();	 
	        		
	        	if(fieldName.equals("descripcion"))
	        		descripcion=	fi.getString("UTF-8").trim();	 
	        		
	        	if(fieldName.equals("precio"))
	        		precio=	Float.parseFloat(fi.getString("UTF-8").trim());        	
	        	
	        	
	        	if(fieldName.equals("categoria"))
	        		tipo=	fi.getString("UTF-8").trim();	        		
	        	
	        		  
	        		if(fieldName.equals("taman"))
	        			taman=	fi.getString("UTF-8").trim();	 
		        			        		
	        		if(fieldName.equals("watts"))
	        			watts=	fi.getString("UTF-8").trim();	 
		        		
	        		if(fieldName.equals("amperaje"))
	        			amperaje=	fi.getString("UTF-8").trim();	 
		        		
	        		if(fieldName.equals("capacidadhd"))
	        			capHD=	fi.getString("UTF-8").trim();	        		
	        		
	        		if(fieldName.equals("interfaz"))
	        			interfaz=	fi.getString("UTF-8").trim();	        		
	        		
	        		if(fieldName.equals("rpm"))
	        			rpm=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("buffer"))
	        			buffer=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("frecuenciamem"))
	        			frecuenciamem=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("latencia"))
	        			latencia=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("capacidadmem"))
	        			capacidadmem=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("frecuenciamicro"))
	        			frecuenciamicro=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("cachemicro"))
	        			cachemicro=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("socketmicro"))
	        			socketmicro=	fi.getString("UTF-8").trim();
	        		

	        		if(fieldName.equals("cantusb"))
	        			cantusb=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("cantusb3"))
	        			cantusb3=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("cantpcie"))
	        			cantpcie=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("videoonboard"))
	        			videoonboard=	fi.getString("UTF-8").trim();
	        	
	        		
	        		if(fieldName.equals("sonidoonboard"))
	        			sonidoonboard=	fi.getString("UTF-8").trim();
	        	
	        		
	        		if(fieldName.equals("chipset"))
	        			chipset=	fi.getString("UTF-8").trim();
	        	
	        		if(fieldName.equals("cantmaxmemmo"))
	        			cantmaxmemmo=	fi.getString("UTF-8").trim();
	       
	        		if(fieldName.equals("socketmo"))
	        			socketmo=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("frecuenciavideo"))
	        			frecuenciavideo=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("anchobus"))
	        			anchobus=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("cantmemvideo"))
	        			cantmemvideo=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("pipelines"))
	        			pipelines=	fi.getString("UTF-8").trim();
	        		
	        		if(fieldName.equals("shaders"))
	        			shaders=	fi.getString("UTF-8").trim();
	        		
	        	
	        		if(fieldName.equals("jacks"))
	        			jacks=	fi.getString("UTF-8").trim();
	        		

	        		if(fieldName.equals("velocidadr"))
	        			velocidadr=	fi.getString("UTF-8").trim();
	         }
	         }
	        		String error;
	        		error=contr.nuevoProducto(nombreprod,modelo,descripcion,precio,capHD,interfaz,rpm,buffer,watts,amperaje,frecuenciamicro,cachemicro,socketmicro,jacks,taman,velocidadr,cantusb,cantpcie,videoonboard,sonidoonboard,chipset,cantusb3,cantmaxmemmo,frecuenciamem,latencia,capacidadmem,frecuenciavideo,anchobus,cantmemvideo,pipelines,shaders,socketmo,foto,tipo);

	        		if(error!=null)
	        		{ 
	        			sesion.setAttribute("confirm",error);
	        			  
	        		}
	        		else
	        		{
	        			sesion.setAttribute("confirm","bien");
	        		}

	        		response.sendRedirect("Altaproductos.jsp");    	 
	        	 
	              
	                // String fieldName = fi.getFieldName();                
	                 //String fieldValue = fi.getString();
	        	 
	                  
	         
	      
	      out.println("</body>");
	      out.println("</html>");
	   }
	      catch(Exception ex) {
	       System.out.println(ex);
	   }
	}
	

}
