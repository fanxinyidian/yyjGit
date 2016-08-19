function initFile(){
		
				dwrFile.getFile(function(array){
					dwr.util.addRows("myfile", array, cellfuncs, {escapeHtml:false});
				});
				
}
var cellfuncs = [
	function(array){return array.filename;},
	function(array){return array.filepath;},
	function(array){return "<input type='button' value='download' onclick='download()'/>";}					
];
//debugger;
function download(){
	
	dwrFile.copyFile("D:/Workspaces/myeclipse/infodemo081801/myfile/testfile.txt","d:/downfile/testfile");
} 

$(document).ready(function() {  
            $("#uploadify").uploadify({  
                'buttonClass':'uploadify-button',
                'cancelImg'      : 'images/cancel.png',  
                'folder'         : 'uploads',//您想将文件保存到的路径  
                'queueID'        : 'fileQueue',//与下面的id对应  
                'queueSizeLimit'  :3,  //可以上传几个文件
                'fileTypeDesc'    :'pdf文件,word文件,txt文件,rar文件,zip文件,7z文件',
            	'fileTypeExts' : '*.png;*jpg;*.pdf;*.doc;*.docx;*.txt;*.rar; *.zip; *.7z', //控制可上传文件的扩展名，启用本项时需同时声明fileDesc  
               	'auto'           : false,  
                'multi'          : true,  
                'UploadLimit' : 2,  
                'buttonText'     : '选择文件',
                'method': 'post',
                'swf'      : 'easyui/uploadify.swf',
				'uploader' : 'servlet/Upfile',//java代码支撑
				'onSelect' : function(file) {  
				        this.addPostParam("file_name",encodeURI(file.name));//改变文件名的编码
				    },
            });  
        });  