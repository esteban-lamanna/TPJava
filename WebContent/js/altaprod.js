function validar()
{ 
	   	
    var bien = true;
   	var errores = "";
   	
   	if (document.getElementById("nombreprod").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el nombre del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   		if (document.getElementById("modelo").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el modelo del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   		if (document.getElementById("descripcion").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la descripcion del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   		if (document.getElementById("precio").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el precio del producto"; 
      	    
      	 bien =false; 
   	} 
   	   	
   	if(validaFloat(document.getElementById("precio").value))
     {
      errores += "\n Tiene que escribir el precio del producto en numeros";
      bien = false; 
     }
   	
   		if (document.getElementById("foto").value.length==0)
   	{ 
   		errores += "\n Tiene que subir una foto del producto"; 
      	    
      	 bien =false; 
   	} 

var cate=document.getElementById('categoria').options[document.getElementById('categoria').selectedIndex].value;
switch(cate) {
    case "gabinete":
        if (document.getElementById("taman").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el tamaño del producto"; 
      	    
      	 bien =false; 
   	} 
   	
        break;
        
    case "fuente":
        
   	  if (document.getElementById("amperaje").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el Amperaje del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   	 if (document.getElementById("watts").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir los Watts del producto"; 
      	    
      	 bien =false; 
   	} 
   	if(validaFloat(document.getElementById("amperaje").value))
     {
      errores += "\n Tiene que escribir el Amperaje del producto en numeros";
      bien = false; 
     }
if(validaEntero(document.getElementById("watts").value))
     {
      errores += "\n Tiene que escribir los Watts del producto en numeros sin coma";
      bien = false; 
     }
        break;
        
        case "hd":
        if (document.getElementById("capacidadhd").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la capacidad del producto"; 
      	    
      	 bien =false; 
   	} 
   	if (document.getElementById("interfaz").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la interfaz del producto"; 
      	    
      	 bien =false; 
   	} 
   	if (document.getElementById("rpm").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir los RPM del producto"; 
      	    
      	 bien =false; 
   	} 
   		if (document.getElementById("buffer").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el Buffer del producto"; 
      	    
      	 bien =false; 
   	} 
   	if(validaEntero(document.getElementById("buffer").value))
     {
      errores += "\n Tiene que escribir el Buffer en numeros sin comas";
      bien = false; 
     }
        break;
        
        case "memoria":
        
       	if (document.getElementById("frecuenciamem").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Frecuencia del producto"; 
      	    
      	 bien =false; 
   	} 	
   	
   	if(validaFloat(document.getElementById("frecuenciamem").value))
     {
      errores += "\n Tiene que escribir la frecuencia del producto en numeros";
      bien = false; 
     }
     
   	if (document.getElementById("capacidadmem").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Capacidad del producto"; 
      	    
      	 bien =false; 
   	} 	
   	
   	if(validaEntero(document.getElementById("capacidadmem").value))
     {
      errores += "\n Tiene que escribir la capacidad de la memoria en numeros sin comas";
      bien = false; 
     }
     
   	if (document.getElementById("latencia").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Latencia del producto"; 
      	    
      	 bien =false; 
   	} 
        break;
        
        case "micro":
        	if (document.getElementById("frecuenciamicro").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Frecuencia del producto"; 
      	    
      	 bien =false; 
   	} 	
   	
   	if(validaFloat(document.getElementById("frecuenciamicro").value))
     {
      errores += "\n Tiene que escribir la frecuencia del producto en numeros";
      bien = false; 
     }
     
   	if (document.getElementById("cachemicro").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Cache del producto"; 
      	    
      	 bien =false; 
   	} 	
   	
   	if(validaEntero(document.getElementById("cachemicro").value))
     {
      errores += "\n Tiene que escribir la Cache del producto en numeros sin coma";
      bien = false; 
     }
     
   	if (document.getElementById("socketmicro").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el Socket del producto"; 
      	    
      	 bien =false; 
   	} 
        break;
        
        case "placamadre":
        
           	if (document.getElementById("cantusb").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Cantidad de USB del producto"; 
      	    
      	 bien =false; 
   	} 	
   	if(validaEntero(document.getElementById("cantusb").value))
     {
      errores += "\n Tiene que escribir los Usb del producto en numeros sin coma";
      bien = false; 
     }
   	if (document.getElementById("socketmo").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el socket del producto"; 
      	    
      	 bien =false; 
   	} 	
   	if (document.getElementById("cantusb3").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Cantidad de USB 3.0 del producto"; 
      	    
      	 bien =false; 
   	} 	
   	if(validaEntero(document.getElementById("cantusb3").value))
     {
      errores += "\n Tiene que escribir los Usb 3.0 del producto en numeros sin coma";
      bien = false; 
     }
   	
   	if (document.getElementById("cantpcie").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Cantidad de PCI-E x16 del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   	if(validaEntero(document.getElementById("cantpcie").value))
     {
      errores += "\n Tiene que escribir la cantidad de PCI-E del producto en numeros sin coma";
      bien = false; 
     }
     
   		if (document.getElementById("chipset").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el Chipset del producto"; 
      	    
      	 bien =false; 
   	} 
   		if (document.getElementById("cantmaxmemmo").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la cantidad de Memoria Ram Maxima del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   	if(validaEntero(document.getElementById("cantmaxmemmo").value))
     {
      errores += "\n Tiene que escribir la cantidad maxima de memoria que soporta el producto en numeros sin coma";
      bien = false; 
     }
         break;
        
        case "pvideo":
        if (document.getElementById("frecuenciavideo").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Frecuencia del producto"; 
      	    
      	 bien =false; 
   	} 
   	 if (document.getElementById("pipelines").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir los Pipelines del producto, si no los sabe escriba 0"; 
      	    
      	 bien =false; 
   	} 
   	if(validaEntero(document.getElementById("pipelines").value))
     {
      errores += "\n Tiene que escribir los Pipelines del producto, si no los sabe escriba 0 en numeros sin coma";
      bien = false; 
     }
   	
   	 if (document.getElementById("shaders").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir los Shaders del producto, si no los sabe escriba 0"; 
      	    
      	 bien =false; 
   	} 
   	if(validaEntero(document.getElementById("shaders").value))
     {
      errores += "\n Tiene que escribir los Shaders del producto, si no los sabe escriba 0 en numeros sin coma";
      bien = false; 
     }
   	
   	if(validaFloat(document.getElementById("frecuenciavideo").value))
     {
      errores += "\n Tiene que escribir la Frecuencia del producto en numeros";
      bien = false; 
     }
   		if (document.getElementById("anchobus").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir el Ancho del Bus del producto"; 
      	    
      	 bien =false; 
   	} 
   	
if(validaEntero(document.getElementById("anchobus").value))
     {
      errores += "\n Tiene que escribir el ancho del bus del producto en numeros sin coma";
      bien = false; 
     }
   		if (document.getElementById("cantmemvideo").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la cantidad de Memoria del producto"; 
      	    
      	 bien =false; 
   	} 
   	
   	if(validaEntero(document.getElementById("cantmemvideo").value))
     {
      errores += "\n Tiene que escribir la cantidad de memoria del producto en numeros sin coma";
      bien = false; 
     }
   	
   		
        break;
        
        case "red":
           if (document.getElementById("velocidadr").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Velocidad del producto"; 
      	    
      	 bien =false; 
   	} 
   	
        break;
        
        case "psonido":
        if (document.getElementById("jacks").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la cantidad de Jacks del producto"; 
      	    
      	 bien =false; 
   	} 
   	
if(validaFloat(document.getElementById("jacks").value))
     {
      errores += "\n Tiene que escribir el precio del producto en numeros";
      bien = false; 
     }
        break;
        
        case "rcable":
        if (document.getElementById("velocidadc").value.length==0)
   	{ 
   		errores += "\n Tiene que escribir la Velocidad del producto"; 
      	    
      	 bien =false; 
   	} 
        break;
        
    default:
    	errores +="\n Debe seleccionar una categoria";
    	bien =false; 
    	break;
}
   	
	if(bien) 
		{
		errores+="Validacion de ingreso de correcta, presione aceptar para continuar";
		alert(errores);
		return true;
		}

   	//el formulario se envia 
   	   
    else
    	{
    	alert(errores); 
    	return false;
    	}
   
}

function validaEntero(numero){
    if (isNaN(numero)){
        return true;
    }
    else{
        if (numero % 1 == 0) {
            return false;
        }
        else{
            return true;
        }
    }
}

function validaFloat(numero)
{
  if (!/^([0-9])*[.]?[0-9]*$/.test(numero))
  {
   return true;
   }
   else
   {
   return false;
   }
}

