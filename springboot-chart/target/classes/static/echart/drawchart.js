function connectChart() {

	for(var i in arguments){
		for(var j in arguments){
			if(i != j){
				arguments[i].connect(arguments[j]);
			}
		}
	}
}

function drawChart(divId, url, param) {
	var myChart = echarts.init(document.getElementById(divId));

	$.getJSON(url, param, function(result) {
		if (result.xaxis == null) {
			drawPie(myChart, result);
		} else {
			drawBar(myChart, result);
		}
	});

	return myChart;
}

function drawBar(chart, data) {

	chart.setOption({
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		title : {
			text : data.title,
			subtext : data.subTitle,
			x : 'center'
		},
		legend : {
			// 1. json数据中的图例
			data : data.legend,
			orient : 'vertical',
			left : 'left',
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : data.xaxis
		// 2. json数据中的横坐标
		} ],
		yAxis : [ {
			type : 'value',
			splitArea : {
				show : true
			}
		} ],
		series : data.lineAndBarChartBeanList
	// 3. json数据中的显示数据
	});
}

function drawPie(chart, data) {
	var option = {
		title : {
			text : data.title,
			subtext : data.subTitle,
			x : 'center'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			orient : 'vertical',
			left : 'left',
			data : data.legend,
		},
		series : [ {
			name : data.promptMessage,
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : data.pieChartEntryBeanList,
			itemStyle : {
				emphasis : {
					shadowBlur : 10,
					shadowOffsetX : 0,
					shadowColor : 'rgba(0, 0, 0, 0.5)'
				}
			}
		} ]
	};

	chart.setOption(option);
}