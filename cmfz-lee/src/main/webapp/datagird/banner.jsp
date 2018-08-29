<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                // 初始化dialog
                $('#di').dialog({
                    title:'编辑',
                    iconCls:'icon-edit',
                    width:600,
                    height:300,
                    buttons:[
                        {
                            text:'提交',
                            iconCls:'icon-ok',
                            handler:function(){
                                // 提交表单
                                $('#from').submit();
                            }
                        }
                    ]
                });
                // 初始化表单
                $('#from').form("submit",{
                    url:'${pageContext.request.contextPath}/banner/save.do',
                    onSubmit:function(param){
                        return true;
                    },
                    success:function(data){
                        console.log(data);
                        //关闭dialog
                        $('#di').dialog('close');
                        // 刷新datagrid
                        $('#dg').datagrid('load');
                    }
                });
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-edit',
            handler: function () {
                /*
                 * 删除数据
                 *
                 * */
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                /*
                 *使当前选中行可编辑模式
                 * */
                var row = $("#dg").edatagrid("getSelected");
                if (row != null) {

                    var index = $("#dg").edatagrid("getRowIndex", row)
                    //当前行可编辑
                    $("#dg").edatagrid("editRow", index)

                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow")
            }
        }]

        $('#dg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/showBanner.do',
            updateUrl: "${pageContext.request.contextPath}/cmfz/banner/add",
            columns: [[

                {field: 'id', title: '编号', width: 100},
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                    type: "text",
                    options: {
                        required: true
                    }
                }
                },
                {field: 'desc', title: '描述', width: 100},
                {field: 'createDate', title: '时间', width: 100}

            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageSize: 2,
            pageList: [2, 4, 6, 8],
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.createDate + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });

    })

</script>

<table id="dg"></table>
    <div id="di" style="padding:20px;display:none;">
        <form id="from" method="get">
            <table>
                <tr>
                    <td>
                        图片名:
                    </td>
                    <td>
                        <input id="id" name="title" class="easyui-textbox" data-options="required:true" style="width: 150px"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        图片路径:
                    </td>
                    <td>
                        <input id="username" name="imgPath" class="easyui-textbox" data-options="required:true" style="width: 150px"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        图片描述:
                    </td>
                    <td>
                        <input id="password" name="desc" class="easyui-textbox" data-options="required:true" style="width: 150px"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        是否上架:
                    </td>
                    <td>
                        <input id="salary" name="status" class="easyui-textbox" data-options="required:true" style="width: 150px"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        上架时间:
                    </td>
                    <td>
                        <input id="age" name="createDate" class="easyui-datebox" data-options="required:true" style="width: 150px"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>