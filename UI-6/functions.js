


function openSidebar(){
    document.getElementById("sidebar").style.display="block";
    document.getElementById("closeSidebarButton").style.display="block";
}

function closeSidebar(){
    document.getElementById("sidebar").style.display="none";
}


function myFunction(x) {
    if (x.matches) { // If media query matches
      document.getElementById("openSidebarButton").style.display = "block";
      document.getElementById("closeSidebarButton").style.display = "block";
      document.getElementById("sidebar").style.display = "none";
      document.getElementById("mainDiv").style.marginLeft  = "0px";
      
    } else {
        document.getElementById("openSidebarButton").style.display ="none";
        document.getElementById("closeSidebarButton").style.display = "none";
        document.getElementById("openNavbarButton").style.display = "none";
        document.getElementById("sidebar").style.display = "block";
        document.getElementById("mainDiv").style.marginLeft  = "240px";
    }
  }
  
  var x = window.matchMedia("(max-width: 767px)")
  myFunction(x) // Call listener function at run time
  x.addListener(myFunction) // Attach listener function on state changes


  var y = window.matchMedia("(min-width: 767px)")
  myFunction1(y) // Call listener function at run time
  y.addListener(myFunction1) // Attach listener function on state changes


  function myFunction1(x) {
    if (x.matches) { // If media query matches
        document.getElementById("openSidebarButton").style.display ="none";
        document.getElementById("closeSidebarButton").style.display = "none";
        document.getElementById("sidebar").style.display = "block";
      
    } else {
        

        document.getElementById("openSidebarButton").style.display = "block";
      document.getElementById("closeSidebarButton").style.display = "block";
      document.getElementById("sidebar").style.display = "none";
    }
  }

 
// 
window.onload = function () {

  var lineChart = new CanvasJS.Chart("splineChartContainer", {
    title: {
      text: "Overview",
      horizontalAlign: "left"
    },
    axisX: {
      valueFormatString: "YYYY",
      gridLines: {
        display:"none"
    }
    },
    
    scales:{
      xAxes:[{
        gridLines: {
          color: "rgba(0, 0, 0, 0)",
      }
      }]
    },

    toolTip: {
      shared: true
    },
    legend: {
      cursor: "pointer",
      verticalAlign: "top",
      horizontalAlign: "center",
      dockInsidePlotArea: true,
      itemclick: toogleDataSeries
    },
    data: [{
      type:"spline",
      axisYType: "primary",
      name: "A",
      showInLegend: true,
      markerSize: 0,
      dataPoints: [		
        { x: new Date(2009, 00, 01), y: 0 },
        { x: new Date(2010, 01, 01), y: 150 },
        { x: new Date(2011, 02, 01), y: 20 },
        { x: new Date(2012, 03, 01), y: 150 },
        { x: new Date(2013, 04, 01), y: 20 },
        { x: new Date(2014, 05, 01), y: 50 },
        { x: new Date(2015, 05, 01), y: 150 }

      ]
    },
    {
      type: "spline",
      axisYType: "primary",
      name: "B",
      showInLegend: true,
      markerSize: 0,
      dataPoints: [
        { x: new Date(2009, 00, 01), y: 0 },
        { x: new Date(2010, 01, 01), y: 30 },
        { x: new Date(2011, 02, 01), y: 50 },
        { x: new Date(2012, 03, 01), y: 80 },
        { x: new Date(2013, 04, 01), y: 110 },
        { x: new Date(2014, 05, 01), y: 150 },
        { x: new Date(2015, 05, 01), y: 170 }
     
      ]
    },
    {
      type: "spline",
      axisYType: "primary",
      name: "C",
      showInLegend: true,
      markerSize: 0,
      dataPoints: [
        { x: new Date(2009, 00, 01), y: 0 },
        { x: new Date(2010, 01, 01), y: 50 },
        { x: new Date(2011, 02, 01), y: 150 },
        { x: new Date(2012, 03, 01), y: 40 },
        { x: new Date(2013, 04, 01), y: 50 },
        { x: new Date(2014, 05, 01), y: 40 },
        { x: new Date(2015, 05, 01), y: 130 }
      ]
    }]
  });
 
  function toogleDataSeries(e){
    if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
      e.dataSeries.visible = false;
    } else{
      e.dataSeries.visible = true;
    }
  }

    var doughnutChart = new CanvasJS.Chart("doughnutChartContainer", {
      animationEnabled: true,
      title:{
        text: "Revenue By Country",
        horizontalAlign: "left"
      },
      data: [{
        type: "doughnut",
        startAngle: 60,
        //innerRadius: 60,
        indexLabelFontSize: 20,
        indexLabel: "{label}",
        toolTipContent: "<b>{label}:</b> {y} (#percent%)",
        dataPoints: [
          { y: 67, label: "Canada" },
          { y: 28, label: "Usa" },
          { y: 10, label: "London" }
        ]
      }]
    });


    var areaChart = new CanvasJS.Chart("areaChartContainer", {
      animationEnabled: true,
      title: {
        text: "Bandwidth usage"
      },
      axisX: {

      },
      axisY: {
      },
      legend: {
        verticalAlign: "top",
        horizontalAlign: "right",
        dockInsidePlotArea: true
      },
      toolTip: {
      },
      data: [{
        name: "A",
        showInLegend: true,
        legendMarkerType: "square",
        type: "area",
        color: "rgba(40,175,101,0.6)",
        markerSize: 0,
        dataPoints: [
          { x: new Date(2011, 1, 6), y: 10 },
          { x: new Date(2012, 1, 7), y: 30 },
          { x: new Date(2013, 1, 8), y: 10 },
          { x: new Date(2014, 1, 9), y: 55 },
          { x: new Date(2015, 1, 10), y: 30 },
          { x: new Date(2016, 1, 11), y: 40 },
          { x: new Date(2017, 1, 12), y: 10 },
          { x: new Date(2018, 1, 12), y: 25 }
        ]
      },
      {
        name: "B",
        showInLegend: true,
        legendMarkerType: "square",
        type: "area",
        color: "rgba(0,75,141,0.7)",
        markerSize: 0,
        dataPoints: [
          { x: new Date(2011, 1, 6), y: 15 },
          { x: new Date(2012, 1, 7), y: 35 },
          { x: new Date(2013, 1, 8), y: 25 },
          { x: new Date(2014, 1, 9), y: 45 },
          { x: new Date(2015, 1, 10), y: 20 },
          { x: new Date(2016, 1, 11), y: 35 },
          { x: new Date(2017, 1, 12), y: 25 },
          { x: new Date(2018, 1, 12), y: 30 }
        ]
      }]
    });

    lineChart.render();
    doughnutChart.render();
    areaChart.render();
  }
  

// 