	
	$(function () {
		
		$('#nav').tree({
			//url : 'tree.json',
			data : [{
				"id":1,
				"text" : "图书管理",
				
				//"state": "closed",
				"children":[{  
					"id": 11,
			        "text":"图书信息管理",    
			        "attributes" : {
			        	url: "bookinfomanager.jsp"
			        } 
			    },{  
			    		"id":12 ,
				        "text":"电子资源管理",    
				        "attributes" : {
				        	//url: "textsourcemanager2.jsp"
				        	//url: "uploadify/index.jsp"
				        	url : "yyjfile.jsp"
				        }  
				    }]},{
				    	  	"id": 2,
							"text" : "流通管理",
							"children":[{
						    	"id":21 ,
						        "text":"流通状态管理",  
						        "attributes" : {
						        	url: "circulatestatemanager.jsp"
						        }
						         }]  
					    
				    },{
			    	"id": 3,
			    	"text" : "用户管理",
					//"state": "closed",
			    	"children":[{  
						"id": 31,
				        "text":"用户信息管理",    
				        "attributes" : {
				        	url: "adminmanager.jsp"
				        }  
				    },{  
				    	"id": 32,
				        "text":"权限分配管理",    
				        "attributes" : {
				        	url: "authoritymanager.jsp"
				        }   
				    }]
				    }
			],
			
			formatter : function (node) {
				return node.text;
			},
			onClick : function (node) {
				/*if($('#tabs').tabs('isLeaf', node.target)){$('#tabs').tabs('add', {
					title : node.text,
					//iconCls : node.iconCls,
					closable : true,
					href : node.id
				});}*/
				//($('#tabs').tabs('isLeaf', node.target)){
				if(node.id!=1&&node.id!=2&&node.id!=3){
					if ($('#tabs').tabs('exists', node.text)) {
						//$('#tabs').tabs('close', node.text);
						
						
						//var tab = $('#tt').tabs('getSelected');  // 获取选择的面板
						//tab.panel('refresh', node.id);
						$('#tabs').tabs('select', node.text);

						
						
					} else {
						//if($('#tabs').tabs('isLeaf', node.target)){
						$('#tabs').tabs('add', {
							title : node.text,
							//iconCls : node.iconCls,
							closable : true,
							href : node.attributes.url
						});
					}}
			}
		//}
	});
		
		/*$('#nav1').tree({
			url : 'tree.json',
			data : [{
				"text" : "用户信息管理"
					"text2":"登录管理"
			}],
			formatter : function (node) {
				return node.text;
			},
			onClick : function (node) {
					if ($('#tabs').tabs('exists', node.text)) {
						$('#tabs').tabs('select', node.text);
					} else {
						$('#tabs').tabs('add', {
							title : node.text,
							iconCls : node.iconCls,
							closable : true,
							href : 'manager.jsp',
						});
					}
				}
		});*/
		$('#tabs').tabs({
			fit : true,
			border : false,
		});

	});
	
