//IDENTIFICANDO EL NAVEGADOR
//==========================
function getXMLHTTPRequest() 
{
	try 
	{req = new XMLHttpRequest();} // p.e. Firefox } 
    catch(err1) 
    {
       try 
       {req = new ActiveXObject('Msxml2.XMLHTTP'); }// algunas versiones IE } 
       catch (err2) 
       {
         try 
         {req = new ActiveXObject('Microsoft.XMLHTTP');} // algunas versiones IE } 
         catch (err3) 
         {req = false;}
       }
     }
     return req;   
}

//DECLARANDO LAS VARIABLES GLOBALES
//=================================
var elemento="", form="";
var httpX = getXMLHTTPRequest();

function ajax_listado()
{
	var url ='ajax/ajax_busqueda_xml.jsp';
	var rand= parseInt(Math.random()*99999999);
	
	var nom = document.frmPublicacionYVenta.vendedor.value;
	
	var modurl = url+"?rand="+rand+"&nom="+nom;
	httpX.open("POST", modurl, true);		
	
	httpX.onreadystatechange = rpta_ajax_listado;
	httpX.send(null);		
}	

function rpta_ajax_listado()
{
	if (httpX.readyState == 4) 
	{
  		if(httpX.status == 200) 
  		{
			var j;
			
			//OBTENEMOS EL XML
			//================
			elemento = httpX.responseXML.getElementsByTagName("vendedor");
			
			//GENERAMOS LA RESPUESTA PARA EL JSP
			//==================================
			form="";
			for(j=0; j<elemento.length; j++)
			{
				form+="<b>"+elemento.item(j).getAttribute('nom')+" ";
				form+="<b>"+elemento.item(j).getAttribute('cod')+" ";
				form+="</b><br>";	       	 	
	       	}	    
			
			//INSERTAMOS LA RESPUESTA AL JSP
			//==============================
	  		document.getElementById("resultados").innerHTML = form;  		  			  			
  		}
  		else
		{alert("Ha habido un problema al acceder al servidor: 5 " + httpX.statusText);}	
	}
}