<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="include/include-head-tag.jsp"/>
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
        }
    </style>
</head>

<body>
<jsp:include page="include/include-navigation-layout.jsp"/>

<div class="container-fluid">
    <div class="row">
        <jsp:include page="include/include-left-menu.jsp"/>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input class="form-control has-success" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="button" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i
                            class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button type="button" class="btn btn-primary" style="float:right;"
                            onclick="window.location.href='add.html'"><i class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope.adminRecordList}" var="admin" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td><input type="checkbox"></td>
                                    <td>${admin.loginAcct}</td>
                                    <td>${admin.userName}</td>
                                    <td>${admin.email}</td>
                                    <td>
                                        <button type="button" class="btn btn-success btn-xs"><i
                                                class=" glyphicon glyphicon-check"></i></button>
                                        <button type="button" class="btn btn-primary btn-xs"><i
                                                class=" glyphicon glyphicon-pencil"></i></button>
                                        <button type="button" class="btn btn-danger btn-xs"><i
                                                class=" glyphicon glyphicon-remove"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                            <tfoot>
                            //当前页 pageNum
                            //每页的数量 pageSize
                            //当前页的数量 size
                            //由于startRow和endRow不常用，这里说个具体的用法
                            //可以在页面中"显示startRow到endRow 共size条数据"
                            //当前页面第一个元素在数据库中的行号 startRow
                            //当前页面最后一个元素在数据库中的行号 endRow
                            //总记录数 total
                            //总页数 pages
                            //结果集 list
                            //前一页 prePage
                            //下一页 nextPage
                            //是否为第一页 isFirstPage
                            //是否为最后一页 isLastPage
                            //是否有前一页 hasPreviousPage
                            //是否有下一页 hasNextPage
                            //导航页码数 navigatePages
                            //所有导航页号 navigatepageNums
                            //导航条上的第一页 navigateFirstPage
                            //导航条上的最后一页 navigateLastPage
                            <tr>
                                <td colspan="6" align="center">
                                    <ul class="pagination">
                                        <li class="${requestScope.pageInfo.hasPreviousPage ? '' : 'disabled'}">
                                            <a href="admin/user.html?keyword=${requestScope.keyword}&pageNum=${requestScope.pageNum - 1}&pageSize=${requestScope.pageSize}">上一页</a></li>
                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li class="${requestScope.pageInfo.hasNextPage ? '' : 'disabled'}">
                                            <a href="admin/user.html?keyword=${requestScope.keyword}&pageNum=${requestScope.pageNum + 1}&pageSize=${requestScope.pageSize}">上一页</a></li>
                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                    </ul>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
    });
    $("tbody .btn-success").click(function () {
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function () {
        window.location.href = "edit.html";
    });
</script>
</body>
</html>
