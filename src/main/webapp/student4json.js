function exec_iframe(json,callback){
	if(typeof(exec_obj)=='undefined'){
		exec_obj = document.createElement('iframe');
		exec_obj.name = 'tmp_frame';
		exec_obj.src = 'http://127.0.0.1/cxf/execB.jsp?json='+JSON.stringify(json)+'&callback='+callback;
		exec_obj.style.display = 'none';
		document.body.appendChild(exec_obj);
	}else{
		exec_obj.src = 'http://127.0.0.1/cxf/execB.jsp?json='+JSON.stringify(json)+'&callback='+callback+'&'+Math.random();
	}
  }
