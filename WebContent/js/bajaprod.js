/**
 * 
 */
$(document).ready(function() {
   $('#categoria').change(function(event){
					var cate=document.getElementById('categoria').options[document.getElementById('categoria').selectedIndex].value;
					switch(cate) 
					{
    case "gabinete":
     $.ajax({
						    type: "POST",
						    url: "Gabinetes",
						    success: function(a) {
					                $('#results').html(a);
						    }
					       });
   	
     break;
     
     case "fuente":
     
      $.ajax({
							    type: "POST",
							    url: "Fuentes",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
     
        break;
        
        case "hd":
       $.ajax({
							    type: "POST",
							    url: "HD",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
        case "memoria":
        $.ajax({
							    type: "POST",
							    url: "Memorias",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
       
        break;
        
        case "micro":
        	$.ajax({
							    type: "POST",
							    url: "Micros",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
        case "placamadre":
        $.ajax({
							    type: "POST",
							    url: "PlacasMadres",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
         break;
        
        case "pvideo":
       $.ajax({
							    type: "POST",
							    url: "PlacaVideo",
							    success: function(a) {
						                $('#results').html(a);
							    }
					});
   	
   		
        break;
        
        case "red":
        $.ajax({
							    type: "POST",
							    url: "PlacaRed",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
   	
        break;
        
        case "psonido":
        $.ajax({
							    type: "POST",
							    url: "PlacaSonido",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        
        break;
        
        case "rcable":
       $.ajax({
							    type: "POST",
							    url: "RedCable",
							    success: function(a) {
						                $('#results').html(a);
							    }
						       });
        break;
        
    default:
    	
    	break;
}
  });
						});
					