<%--
  Created by IntelliJ IDEA.
  User: 35041
  Date: 2021/1/2
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="app.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>classManage</title>
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
        <li role="presentation" class="active"><a href="#CourseArranging" id="CourseArranging1" aria-controls="Scouse" role="tab" data-toggle="tab">班级管理</a></li>
        <li role="presentation"><a href="${appPath}/TeacherPageServlet">教师管理</a></li>
        <li role="presentation"><a href="${appPath}/StudentPageServlet">学生管理</a></li>
        <li role="presentation"><a href="${appPath}/CourseSchedulingPageServlet">排课管理</a></li>
        <li role="presentation"><a href="${appPath}/CoursePageServlet">课程管理</a></li>
        <li role="presentation"><a href="${appPath}/RoomPageServlet">教室管理</a></li>
        <li role="presentation"><a href="${appPath}/NoticePageServlet">通知管理</a></li>
        <li role="presentation"><a href="${appPath}/SwitchPageServlet">调课申请</a></li>
    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="CourseArranging">
            <!--内容区域-->
            <%--分页查询--%>
            <c:if test="${not empty requestScope.ClassInfoList}">
                <div class="item">
                    <div  class="container">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr class="active">
                                <th>班级编号</th>
                                <th>班级名</th>
                                <th>专业</th>
                                <th>年级</th>
                                <th>学院</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.ClassInfoList}" var ="classInfo">
                                <tr class="success">
                                    <td>${classInfo.classid}</td>
                                    <td>${classInfo.classname}</td>
                                    <td>${classInfo.profname}</td>
                                    <td>${classInfo.gradename}</td>
                                    <td>${classInfo.departname}</td>
                                    <td>
                                        <div class="dropdown">
                                            <a id="dropdown-toggle" data-target="#" href="http://example.com" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
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
                                                    <a  href="${appPath}/CssClassInfoServlet?method=delete&classid=${classInfo.classid}">
                                                        删除
                                                    </a>
                                                </li>
                                                <li>
                                                    <a data-toggle="modal" data-target="#myModa6">
                                                        查询
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
            <!--增加排课信息 -->
            <form action="${appPath}/CssClassInfoServlet?method=add" method="post">
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">增加班级信息</h4>
                            </div>
                            <!--增加班级信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">班级编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="classid" value=""></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">班级名：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="classname" value="1班"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">专业：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="profname" value="电商"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">年级：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="gradename" value="G17"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">排课数：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="coursenum" value="0"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">学院：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="departname" value="电商"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" name="add1" value="添加" ></div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </form>
            <%--修改班级信息--%>
            <form action="${appPath}/CssClassInfoServlet?method=update" method="post">
                <div class="modal fade" id="myModa5" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">修改班级信息</h4>
                            </div>
                            <!--修改班级信息-->
                            <div class="modal-body">
                                <div table_style>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">班级编号：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="classid" value=""></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">班级名：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="classname" value="1班"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">专业：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="profname" value="电商"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">年级：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="gradename" value="G17"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">排课数：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="coursenum" value="0"></td>
                                        </tr>
                                    </table>
                                    <div class="he"></div>
                                    <table  width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                        <tr>
                                            <th width="110" align="right" bgcolor="#F8F8F8">学院：</th>
                                            <td bgcolor="#F8F8F8"><input type="text" name="departname" value="电商"></td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" name="add1" value="修改" ></div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </form>
            <!--查询模态框-->
            <form action="${appPath}/CssClassInfoServlet?method=check" method="post">
                <div class="modal fade" id="myModa6" tabindex="-1" role="dialog">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title">查询</h4>
                            </div>
                            <div class="modal-body">
                                <p>
                                <table width="300" border="0" cellpadding="3" cellspacing="1" bgcolor="#EEEEEE">
                                    <tr>
                                        <th width="110" align="right" bgcolor="#F8F8F8">专业：</th>
                                        <td bgcolor="#F8F8F8">
                                            <input type="text" name="profnames" value="" placeholder="专业"></td>
                                    </tr>
                                </table>
                            </div><div><input class="btn btn-primary" type="submit" name="add1" value="查询" ></div>
                            </p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
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

