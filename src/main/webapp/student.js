function addStu(){
	var str='{"name":"指数","age":"12"}';
	$.ajax({ 
		type:'post', 
		url:'rs/student/add.json', 
		contentType:'application/json; charset=utf-8',
		data:str,//可以直接加一个函数名。 
		dataType:'json', 
		success:function(res){
			alert(res);
		},
		error:function(){
			alert("失败");
		}
		});
}

function addStu2(){
	var str={stu:'{"name":"指数","age":12}'};
	$.ajax({ 
		type:'get', 
		url:'rs/student/add2.json', 
		contentType:'application/json; charset=utf-8',
		data:str,
		dataType:'json', 
		success:function(res){
			alert(res);
		},
		error:function(){
			alert("失败");
		}
		});
}

function deleteStu(){
	$.ajax({ 
		type:'get', 
		url:'rs/student/delete/1.json', 
		contentType:'text/json; charset=utf-8',
		dataType:'json', 
		success:function(res){
			alert(res);
		},
		error:function(){
			alert("失败");
		}
		});
}

function findStu(){
	$.ajax({ 
		type:'get', 
		url:'rs/student/find/1.json', 
		contentType:'text/json; charset=utf-8',
		dataType:'json', 
		success:function(res){
			alert(res.name+":"+res.age);
		},
		error:function(){
			alert("失败");
		}
		});
}