$(function () {
	
	$('#nav').tree({
		url : 'nav/getByNid2',
		
		lines : true,
		onClick : function (node) {
			if(node.url){
				if(node.url=='textsourcemanager'){
					window.open('textsourcemanager.jsp');
				}
				else {
					if ($('#tabs').tabs('exists', node.text)) {
						$('#tabs').tabs('select', node.text);
					} else {
						$('#tabs').tabs('add', {
							title : node.text,
							iconCls : node.iconCls,
							closable : true,
							href : node.url +'.jsp',
						});
					}
				}
			}
		
		}
	});
	
	$('#tabs').tabs({
		fit : true,
		border : false,
	});
	
});