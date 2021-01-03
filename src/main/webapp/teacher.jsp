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
        <li role="presentation" class="active"><a href="#CourseArranging" id="CourseArranging1" aria-controls="Scouse" role="tab" data-toggle="tab">个人信息</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=check&tnames=${teacher.tname}">课程</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=cswitch&tnamet=${teacher.tname}">调课申请</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=notice">通知</a></li>
    </ul>
    <div class="tab-content">
        <form action="TeacherSelfServlet?method=update" method="post">
            <div role="tabpanel" class="tab-pane active" id="CourseArranging">
                <div class="modal-body">
                    <div table_style>
                        <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">教师编号：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="teacherid" value="${teacher.teacherid}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">邮箱：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="teachemail" value="${teacher.email}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">姓名：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="tname" value="${teacher.tname}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">性别：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="tsex" value="${teacher.tsex}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">职称：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="prof" value="${teacher.prof}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">学院：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="departname" value="${teacher.departname}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">手机号码：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="phone" value="${teacher.phone}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">密码：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="teachpwd" value="${teacher.teachpwd}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                        <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                            <tr>
                                <th width="110" align="right" bgcolor="#F8F8F8">备注：</th>
                                <td bgcolor="#F8F8F8"><input type="text" name="remark" value="${teacher.remark}"></td>
                            </tr>
                        </table>
                        <div class="he"></div>
                    </div>
                </div>
            </div>
            <div><input class="btn btn-primary" type="submit" name="add1" value="修改" ></div>
        </form>
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
