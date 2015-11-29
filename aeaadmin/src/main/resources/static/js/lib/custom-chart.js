/* Custom functions that help in getting remote data and drawing a chart to a div */

function createNewLineChart(divId) {
    var chart = {
        options: {
            chart: {
                renderTo: divId
            }
        }
    };
    chart = jQuery.extend(true, {}, getBaseChart1(), chart);
    chart.init(chart.options);
    return chart;
}

function getBaseChart1() {

    var baseChart = {
        highchart: null,
        defaults: {

        	chart: {
                type: 'bar'
            },
            
            xAxis: {
                categories: ['Bhopal', 'Chennai', 'Hyderabad', 'Mumbai', 'Kolkatta'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: 'No. of worksites',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 80,
                floating: true,
                borderWidth: 1,
                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: 'Year 1800',
                data: [107, 31, 635, 203, 2]
            }, {
                name: 'Year 1900',
                data: [133, 156, 947, 408, 6]
            }, {
                name: 'Year 2012',
                data: [1052, 954, 4250, 740, 38]
            }]
        },

        // here you'll merge the defaults with the object options
        init: function(options) {
            this.highchart = jQuery.extend({}, this.defaults, options);
        },

        create: function() {
            new Highcharts.Chart(this.highchart);
        }

    };
    return baseChart;
}//function end


function getBaseChart() {

    var baseChart = {
        highchart: null,
        defaults: {

            chart: {
            	type: 'column',
                renderTo: null,
                shadow: true,
                borderColor: '#ebba95',
                borderWidth: 2,
                defaultSeriesType: 'line',
                width: 400,
                height: 250
            },
            credits: {
                enabled: false
            },
            exporting: {
                enabled: false
            },
            title: {
                text: null,
                x: -20,
                style: {
                    color: '#3366cc',
                    fontWeight: 'bold',
                    fontSize: '16px',
                    fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                }
            },
            xAxis: {
                categories: [],
                gridLineDashStyle: 'dot',
                gridLineColor: '#197f07',
                gridLineWidth: 1,
                tickColor: '#ff40ff',
                tickWidth: 2,
                title: {
                    text: null,
                    style: {
                        color: '#3366cc',
                        fontWeight: 'bold',
                        fontSize: '12px',
                        fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                    }
                },
                labels: {
                    rotation: -25,
                    align: 'right',
                    style: {
                        color: '#3366cc',
                        fontWeight: 'normal',
                        fontSize: '9px',
                        fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                    }
                }
            },
            yAxis: {
                min: 0,
                gridLineWidth: 1,
                gridLineColor: '#197F07',
                gridLineDashStyle: 'dot',
                title: {
                    text: null,
                    style: {
                        color: '#3366cc',
                        fontWeight: 'bold',
                        fontSize: '12px',
                        fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                    }
                },
                labels: {
                    style: {
                        color: '#3366cc',
                        fontSize: '12px',
                        fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                    }
                },
                plotLines: [{
                    value: 0,
                    width: 1
                }]
            },
            tooltip: {
                crosshairs: true,
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.x +': '+ this.y;
                }
            },
            legend: {
                layout: 'horizontal',
                backgroundColor: '#ffffff',
                align: 'center',
                verticalAlign: 'top',
                borderWidth: 1,
                shadow: true,
                style: {
                    color: '#3366cc',
                    fontWeight: 'bold',
                    fontSize: '9px',
                    fontFamily: 'Trebuchet MS, Verdana, sans-serif'
                }
            },
            series: []

        },

        // here you'll merge the defaults with the object options
        init: function(options) {
            this.highchart = jQuery.extend({}, this.defaults, options);
        },

        create: function() {
            new Highcharts.Chart(this.highchart);
        }

    };
    return baseChart;
}//function end


function getRemoteDataDrawChart(url, linechart) {

    $.ajax({
        url: url,
        dataType: 'json',
        success: function(data) {

            var categories = data.categories;
            var title = data.title;
            var yTitle = data.yAxisTitle;
            var xTitle = data.xAxisTitle;
            var divId =  data.divId;

            //populate the lineChart options (highchart)
            linechart.highchart.xAxis.categories = categories;
            linechart.highchart.title.text = title;
            linechart.highchart.yAxis.title.text = yTitle;
            linechart.highchart.xAxis.title.text = xTitle;
            linechart.highchart.chart.renderTo = divId;

            $.each(data.series, function(i, seriesItem) {
                console.log(seriesItem) ;
                var series = {
                    data: []
                };
                series.name = seriesItem.name;
                series.color = seriesItem.color;

                $.each(seriesItem.data, function(j, seriesItemData) {
                    console.log("Data (" + j +"): "+seriesItemData) ;
                    series.data.push(parseFloat(seriesItemData));
                });

                linechart.highchart.series[i] = series;
            });

            //draw the chart
            linechart.create();
        },
        error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
        },
        cache: false
    });
} //function end