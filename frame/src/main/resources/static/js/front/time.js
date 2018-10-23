$(function(){
	initLoad();
	//获取页数
   var totalPages =  [[${totalPages}]];
   var liNums =  [[${liNums}]]; 
	$("#page").Page({
	    totalPages: totalPages,
	    liNums:liNums, 
	    activeClass: 'activP', 
	    firstPage: '首页',
	    lastPage: '末页',
	   // prv: 'prv',
	    //next: 'next',
	    hasFirstPage: true,
	    hasLastPage: true,
	    hasPrv: true,
	    hasNext: true,
	    callBack : function(page){
	    	var pageIndex = page; //页码
	    	var pageSize = 15; //每页大小
	    	//获取页码
	    	var url =  [[@{/}]]+"/blog/timeshaftController/showTimeshaftJson?pageSize="+pageSize+"&pageIndex="+pageIndex;
			$.ajax({
				  type: 'POST',
				  url: url,
				  data: "",
				  dataType: 'json',
		          contentType: 'application/json',
		          async: true,
				  success:function(data, textStatus){
					  $('#list li').remove();
					  var objInfo = data.reuslt_data
					  $.each(objInfo, function (index, obj) {
						  $('#list').append('<li><span>'+obj.strTimeIssueTime+'</span><a href="javascript:void(0)" title="'+obj.timeTitle+'">'+obj.timeContent+'</a></li>')
			            });
			       }
				  ,error:function(XMLHttpRequest, textStatus, errorThrown){
				  }
			 });
	    }
	})
	
	//初始化加载数据
	function initLoad(){
		  //获取总分页数
	        var pageIndex = 1; //页码
	    	var pageSize = 15; //每页大小
	    	//获取页码
	    	var url =  [[@{/}]]+"/blog/timeshaftController/showTimeshaftJson?pageSize="+pageSize+"&pageIndex="+pageIndex;
			$.ajax({
				  type: 'POST',
				  url: url,
				  data: "",
				  dataType: 'json',
		          contentType: 'application/json',
		          async: true,
				  success:function(data, textStatus){
					  $('#list li').remove();
					  var objInfo = data.reuslt_data
					  $.each(objInfo, function (index, obj) {
						  $('#list').append('<li><span>'+obj.strTimeIssueTime+'</span><a href="javascript:void(0)" title="'+obj.timeTitle+'">'+obj.timeContent+'</a></li>')
			            });
			       }
				  ,error:function(XMLHttpRequest, textStatus, errorThrown){
				  }
			 });
	
	}
	
});