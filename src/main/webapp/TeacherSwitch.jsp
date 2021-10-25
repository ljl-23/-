<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TeacherSwitch</title>
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
            <label class="stu-item2">已登录</label>
            <label class="stu-item4"><a href="${appPath}/login.jsp">退出</a></label>
            <label class="stu-item4"><a data-toggle="modal" data-target="#myModal">增加</a></label>
        </div>
    </div>
</div>
<div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#CourseArranging" id="CourseArranging1" aria-controls="Scouse" role="tab" data-toggle="tab">调课申请</a></li>
        <li role="presentation"><a href="${appPath}/TeacherSelfServlet?method=self&teacherids=${teacher.teacherid}">个人信息</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=check&tnames=${teacher.tname}">课程</a></li>
        <li role="presentation"><a href="${appPath}/TeacherCsShowServlet?method=notice">通知</a></li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="CourseArranging">
            <!--内容区域-->
            <c:if test="${not empty requestScope.switchInfoList}">
                <div class="item">
                    <div  class="container">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr class="active">
                                <th>编号</th>
                                <th>申请人</th>
                                <th>调课内容</th>
                                <th>调课原因</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.switchInfoList}" var ="swtichInfo">
                                <tr class="success">
                                    <td>${swtichInfo.switchid}</td>
                                    <td>${swtichInfo.tname}</td>
                                    <td>${swtichInfo.message}</td>
                                    <td>${swtichInfo.reason}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
            <!--模态框-->
            <!--增加排课信息 -->
            <form action="${appPath}/TeacherSwitchServlet?method=add" method="post">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">增加调课申请</h4>
                            </div>
                            <!--增加调课申请信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="switchid" value=""></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">申请人：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="tname" value="荣咏玉"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">调课内容：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="message" value="星期二的第一节课"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">调课原因：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="reason" value="有事"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" name="add1" value="添加" ></div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </form>
            <%--修改排课信息--%>
            <form action="${appPath}/CssSwitchServlet?method=update" method="post">
                <div class="modal fade" id="myModa5" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">修改调课申请</h4>
                            </div>
                            <!--修改调课申请信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="switchid" value="1"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">申请人：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="tname" value="星期一"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">调课内容：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="message" value="第一节课"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">调课原因：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="reason" value="C1001"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" name="add1" value="修改" ></div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </form>
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
