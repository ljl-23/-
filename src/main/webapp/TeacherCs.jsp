<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student</title>
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/office.css" />
</head>
<body>
<div class="top">
    <div class="top-clo">
        <div class="stu-top">
            <label class="stu-item1"><a href="javascript:;">排课系统</a></label>
        </div>

        <div class="stu-inform">
            <label class="stu-item2">${teacher.tname}已登录</label>
            <label class="stu-item4"><a href="${appPath}/login.jsp">退出</a></label>
        </div>
    </div>
</div>

<div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#CourseArranging" id="CourseArranging1" aria-controls="Scouse" role="tab" data-toggle="tab">课程</a></li>
        <li role="presentation"><a href="${appPath}/TeacherSelfServlet?method=self&teacherids=${teacher.teacherid}">个人信息</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=cswitch&tnamet=${teacher.tname}">调课申请</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=notice">通知</a></li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="CourseArranging">
            <c:if test="${not empty requestScope.courseSchedulingList}">
                <div class="item">
                    <div  class="container">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr class="active">
                                <th>排课编号</th>
                                <th>星期</th>
                                <th>节数</th>
                                <th>班级</th>
                                <th>课程</th>
                                <th>教室</th>
                                <th>教师</th>
                                <th>年级</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.courseSchedulingList}" var ="courseScheduling">
                                <tr class="success">
                                    <td>${courseScheduling.lessid}</td>
                                    <td>${courseScheduling.weeks}</td>
                                    <td>${courseScheduling.howless}</td>
                                    <td>${courseScheduling.classname}</td>
                                    <td>${courseScheduling.cousename}</td>
                                    <td>${courseScheduling.roomname}</td>
                                    <td>${courseScheduling.tname}</td>
                                    <td>${courseScheduling.grade}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
<script>
    $('.dropdown-toggle').dropdown();
    $('.dropdown-toggle1').dropdown();
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').focus()
    })
</script>
<!--json-->
<script>
    var obj = {
        "local:": $(this).tab('show'),
        "default":e.preventDefault(),
        "function":function(e){
            this.local
            this.default
        }
    }
    $('#CourseArranging1').click(obj.function)
    $('#teacher1').click(obj.function)
    $('#student1').click(obj.function)
    $('#course1').click(obj.function)
    $('#class1').click(obj.function)
    $('#classroom1').click(obj.function)
</script>
</html>
