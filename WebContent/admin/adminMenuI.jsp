<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>学生成绩系统功能列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath}/css/bootstrap3.3.5.min.css'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<script type="text/javaScript" src="js/jquery-1.8.1.js"></script>
<script type="text/javaScript">
	$(document).ready(function() {

		/*  $("a").mouseover(function(){
			$("a").css("color","yellow");
		 });
		 $("a").mouseout(function(){
			$("a").css("color","#333300");
		 }); */
		$(".txt").hide();
		$(".t").click(function() {
			$(".txt").slideToggle("slow");
		});
		$(".txt1").hide();
		$(".t1").click(function() {
			$(".txt1").slideToggle("slow");
		});
		$(".txt2").hide();
		$(".t2").click(function() {
			$(".txt2").slideToggle("slow");
		});
		$(".txt3").hide();
		$(".t3").click(function() {
			$(".txt3").slideToggle("slow");
		});
		$(".txt4").hide();
		$(".t4").click(function() {
			$(".txt4").slideToggle("slow");
		});
		$(".txt5").hide();
		$(".t5").click(function() {
			$(".txt5").slideToggle("slow");
		});

	});
</script>
<body>
<div class="container">
    <div id="wrapper"  class="toggled">
        <!-- Sidebar -->
<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
        <li class="sidebar-brand">
           <a class="fa fa-fw fa-home">
              您的身份：管理员                       
            </a>
        </li>

        <li>
            <div class="t">
				<i></i><a class="fa fa-fw fa-folder"><h4>个人信息</h4>
				</a>
			</div>
			<div class="txt">
				<p>
					<a href="ServletselectPwd" target="mainRight">查询登录密码</a>
					</p>
					<p>
					<a href="ServletInfo" target="mainRight">查询个人信息</a>
				</p>
			</div>
            	
        </li>
         <li>
            <div class="t1">
						<i></i><a class="fa fa-fw fa-folder"><h4>课程管理</h4>
						</a>
					</div>
					<div class="txt1">
						<p>
							<a href="ServletFindAllCos" target="mainRight">课程信息查看</a>
						</p>
						<p>
							<a href="admin/addCourse.jsp" target="mainRight">添加课程信息</a>
						</p>
					</div>
        </li>
        <li>
            <div class="t2">
						<i></i><a class="fa fa-fw fa-folder"><h4>成绩管理</h4>
						</a>
					</div>
					<div class="txt2">
						<p>
							<a href="ServletFindAllScore" target="mainRight">成绩信息查看</a>
						</p>
						<p>
							<a href="admin/addScore.jsp" target="mainRight">添加学生成绩</a>
						</p>
						<p>
							<a href="ServletStuSum" target="mainRight">学生成绩总分</a>
						</p>
						<p>
							<a href="ServletStuSumList?f=1" target="mainRight">学生成绩排名</a>
						</p>
					</div>
        </li>
         <li>
            <div class="t3">
						<i></i><a class="fa fa-fw fa-folder"><h4>教师管理</h4>
						</a>
					</div>
					<div class="txt3">
						<p>
							<a href="ServletFindAllTea" target="mainRight">查询教师信息</a>
						</p>
						<p>
							<a href="admin/addTeacher.jsp" target="mainRight">添加教师信息</a>
						</p>
					</div>
        </li>
        <li>
            <div class="t4">
						<i></i><a class="fa fa-fw fa-folder"><h4>学生管理</h4>
						</a>
					</div>
					<div class="txt4">
						<p>
							<a href="ServletFindAllStu" target="mainRight">查询学生信息</a>
						</p>
						<p>
							<a href="admin/addStudent.jsp" target="mainRight">添加学生信息</a>
						</p>
					</div>
        </li>
        <li>
            <div class="t5">
						<i></i><a class="fa fa-fw fa-folder"><h4>账号管理</h4>
						</a>
					</div>
					<div class="txt5">
						<p>
							<a href="PageServlet" target="mainRight">查询所有账号</a>
						</p>
						<!-- <p>ServletFindAllUser
									<a href="admin/addStudent.jsp" target="mainRight">查询</a>
								</p> -->
					</div>
        </li>
    </ul>
</nav>
</div>
</div>

<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
<script type="text/javascript">
    $(document).ready(function () {
        var trigger = $('.hamburger'),
            overlay = $('.overlay'),
            isClosed = false;

        trigger.click(function () {
            hamburger_cross();
        });

        function hamburger_cross() {

            if (isClosed == true) {
                overlay.hide();
                trigger.removeClass('is-open');
                trigger.addClass('is-closed');
                isClosed = false;
            } else {
                overlay.show();
                trigger.removeClass('is-closed');
                trigger.addClass('is-open');
                isClosed = true;
            }
        }

        $('[data-toggle="offcanvas"]').click(function () {
            $('#wrapper').toggleClass('toggled');
        });
    });
</script>