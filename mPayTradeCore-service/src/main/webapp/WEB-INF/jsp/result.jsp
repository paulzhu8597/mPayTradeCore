<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>业务结果</title>
 
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
  <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
</head>
<body>
  <div class="demo-content">
 
    <div class="doc-content">
      <h1>业务结果</h1>
      <hr>
      <div class="form-horizontal form-horizontal-simple">
	  <!-- 业务成功 -->
	  <div class="row">
		<div class="span10">
			<div class="tips tips-large tips-success">
			  <span class="x-icon x-icon-success"><i class="icon icon-ok icon-white"></i></span>
			  <div class="tips-content">
				<h2>成功信息</h2>
				<p class="auxiliary-text">
				  你可以继续操作以下内容：
				</p>
				<p>
				  <a class="direct-lnk" title="返回菜单" href="">返回菜单</a>
				</p>
			  </div>
			</div>
		</div> 
	  </div>
	  <div class="row detail-row">
        <div class="span8">
          <label class="control-label">收单机构编号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
        <div class="span8">
          <label class="control-label">商户标识号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
	  </div>
	  <div class="row detail-row">
        <div class="span8">
          <label class="control-label">外部订单号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
        <div class="span8">
          <label class="control-label">支付宝订单号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
	   </div>
	   
		<!-- 业务失败 -->
		<div class="row">
			<div class="span10">
				<div class="tips tips-large tips-warning">
				  <span class="x-icon x-icon-error">×</span>
				  <div class="tips-content">
					<h2>失败信息</h2>
					<p class="auxiliary-text">
					  你可以继续操作以下内容：
					</p>
					<p>
					  <a class="direct-lnk" title="返回菜单" href="userManage.html">返回菜单</a>
					</p>
				  </div>
				</div>
			</div> 
		</div> 
		
		<div class="row detail-row">
        <div class="span8">
          <label class="control-label">收单机构编号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
        <div class="span8">
          <label class="control-label">商户标识号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
	  </div>
	  <div class="row detail-row">
        <div class="span8">
          <label class="control-label">外部订单号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
        <div class="span8">
          <label class="control-label">支付宝订单号：</label>
          <div class="controls">
          <span class="control-text"></span>
          </div>
        </div>
	   </div>
	   <div class="row detail-row">
			<div class="span8">
			  <label class="control-label">结果码：</label>
			  <div class="controls">
			  <span class="control-text"></span>
			  </div>
			</div>
			<div class="span8">
			  <label class="control-label">结果信息：</label>
			  <div class="controls">
			  <span class="control-text"></span>
			  </div>
			</div>
		</div>
		<div class="row detail-row">
			<div class="span8">
			  <label class="control-label">子结果码：</label>
			  <div class="controls">
			  <span class="control-text"></span>
			  </div>
			</div>
			<div class="span8">
			  <label class="control-label">子信息：</label>
			  <div class="controls">
			  <span class="control-text"></span>
			  </div>
			</div>
		</div>
		
      </div>
    </div>
      
<!-- script end -->
  </div>
</body>
</html>  