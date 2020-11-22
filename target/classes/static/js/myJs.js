 

var chartDatastr= decodehtml(chartData); 
var chartJsonArray= JSON.parse(chartDatastr);

var arrayLength=chartJsonArray.length;
var numericdata=[];
var labeldata=[];


for(var i=0;i<arrayLength;i++)
	{
	numericdata[i]= chartJsonArray[i].value;
	labeldata[i]=chartJsonArray[i].label;
	
	}

new Chart(document.getElementById("MyPieChart"), {
    type: 'doughnut',
    // The data for our dataset
    data: {
        labels: labeldata,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#FF0000", "#0000FF", "#00FF00"],
            data: numericdata
        }]
    },
    
    // Configuration options go here
    options: {
    	title: {
    	display:true,
    	text:'Project Statuses'
    	}
    }	
});
 
 function decodehtml(html)
 {
	 
	 var txt=document.createElement("textarea");
	 txt.innerHTML=html;
	 return txt.value;
 }