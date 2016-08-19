<%@page contentType="text/html; charset=utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Jquery Uploadify上传带进度条</title>
    <link href="uploadify/uploadify.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="uploadify/jquery.uploadify.min.js"></script>
    <script type="text/javascript" src="uploadify/jquery.uploadify.js"></script>
    
</head>
<body>
    <!-- <form id="form1" runat="server">
    <div>

    </div>
    </form> -->

    <!-- <div id="fileQueue"></div> -->
    <input type="file" name="upload" id="upload" />
    <!-- p>
        <a href="javascript:$('#uploadify').uploadifyUpload()">上传</a>| 
        <a href="javascript:$('#uploadify').uploadifyClearQueue()">取消上传</a>
    </p> -->
</body>
<script type="text/javascript">
	<?php $timestamp = time();?>
		$(function() {
			$('#upload').uploadify({
				'formData'     : {
					'timestamp' : '<?php echo $timestamp;?>',
					'token'     : '<?php echo md5('unique_salt' . $timestamp);?>'
				},
				'swf'      : 'uploadify.swf',
				'uploader' : 'uploadify.php'
			});
		});
</script>
</html>


