<%--
  Created by IntelliJ IDEA.
  User: 35041
  Date: 2021/1/3
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>NoticeManage</title>
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
        </div>
    </div>
</div>
<div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#CourseArranging" id="CourseArranging1" aria-controls="Scouse" role="tab" data-toggle="tab">通知管理</a></li>
        <li role="presentation"><a href="${appPath}/CourseSchedulingPageServlet">排课管理</a></li>
        <li role="presentation"><a href="${appPath}/TeacherPageServlet">教师管理</a></li>
        <li role="presentation"><a href="${appPath}/StudentPageServlet">学生管理</a></li>
        <li role="presentation"><a href="${appPath}/CoursePageServlet">课程管理</a></li>
        <li role="presentation"><a href="${appPath}/ClassPageServlet">班级管理</a></li>
        <li role="presentation"><a href="${appPath}/StudentPageServlet">学生管理</a></li>
        <li role="presentation"><a href="${appPath}/SwitchPageServlet">调课申请</a></li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="CourseArranging">
            <c:if test="${not empty requestScope.noticeList}">
                <div class="item">
                    <div  class="container">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr class="active">
                                <th>通知编号</th>
                                <th>通知名</th>
                                <th>信息</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.noticeList}" var ="notice">
                                <tr class="success">
                                    <td>${notice.noticeid}</td>
                                    <td>${notice.nname}</td>
                                    <td>${notice.matter}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a id="dropdown-toggle1" data-target="#" href="http://example.com" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                                操作
                                                <span class="caret"></span>
                                            </a>
                                            <ul class="dropdown-menu" aria-labelledby="dLabel">
                                                <li>
                                                    <a data-toggle="modal" data-target="#myModal">
                                                        增加
                                                    </a>
                                                </li>
                                                <li>
                                                    <a data-toggle="modal" data-target="#myModa5">
                                                        修改
                                                    </a>
                                                </li>
                                                <li>
                                                    <a  href="${appPath}/CssNoticeServlet?method=delete&noticeid=${room.noticeid}">
                                                        删除
                                                    </a>
                                                </li>
                                            </ul>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
            <!--模态框-->
            <!--增加通知信息 -->
            <form action="${appPath}/CssNoticeServlet?method=add" method="post">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">通知发布</h4>
                            </div>
                            <!--增加通知信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">通知编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="noticeid" value=""></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">通知名：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="nname" value="调课通知"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">信息：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="matter" value="三班的课程星期一上午的1、2节计算机课调到星期五下午5、6节"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" name="add1" value="发布" ></div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </form>
            <!--修改通知信息 -->
            <form action="${appPath}/CssNoticeServlet?method=update" method="post">
                <div class="modal fade" id="myModa5" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">修改通知</h4>
                            </div>
                            <!--修改通知信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">通知编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="noticeid" value="1"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">通知名：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="nname" value="调课通知"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">信息：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="matter" value="三班的课程星期一上午的1、2节计算机课调到星期五下午5、6节"></td>
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

