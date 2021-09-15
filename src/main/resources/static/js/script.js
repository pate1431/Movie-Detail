function getTvshows(id)
{
	if(document.getElementById("tvshows"+id).innerHTML=="")
	{
		
		fetch('http://localhost:8080/getTvshows/'+id)  // fetch data via our HomeController
		.then(data => data.json()) // JSONifythe data returned
		.then(function(data) 
		{
					
			var textToDisplay=""; 
			textToDisplay+= "ID: " + data.id + "<br>";
			textToDisplay+= "Show Name: " + data.showName + "<br>";
			textToDisplay+= "Total Seasons: " + data.totalSeasons + "<br>";
			textToDisplay+= "Star Cast: " + data.actors + "<br>";
			
			document.getElementById("tvshows"+id).innerHTML=textToDisplay;
		});
		
		
		document.getElementById("tvshows"+id).innerHTML="hello";
	}
	else
	{
		document.getElementById("tvshows"+id).innerHTML="";
	}
}
function getLikes(id)
{
	fetch('http://localhost:8080/getTvshows/'+id)  // fetch data via our HomeController
	.then(data => data.json()) // JSONifythe data returned
	.then(function(data) 
	{
				
	
	});
}

