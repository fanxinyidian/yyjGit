	
	$(function () {
		/*$('#nav').tree({
			url : 'php/nav.php'
		});*/
		$('#nav').tree({
			//url : 'tree.json',
			
			data : [{  
				"id": 1,
		        "text":"用户信息管理", 
		        "attributes" : {
		        	url: "adminmanager.jsp"
		        },
				"children":[{  
			    		"id": 3,
				        "text":"电子资源管理",    
				        "attributes" : {
				        	url: "textsourcemanager2.jsp"
				        } 
				    }]
		           
		    },{  
				"id": 2,
		        "text":"图书信息管理",    
		        "attributes" : {
		        	url: "bookinfomanager2.jsp"
		        }  
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
						href : node.attributes.url
					});
				}
			}
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
	
