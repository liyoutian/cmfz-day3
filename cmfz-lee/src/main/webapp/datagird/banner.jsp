<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#dd").dialog("open");
            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-edit',
            handler: function () {
                $('#dg').edatagrid('destroyRow')
                $
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                 //使当前选中行可编辑模式
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
            updateUrl: "${pageContext.request.contextPath}/banner/update.do",
            destroyUrl: "${pageContext.request.contextPath}/banner/delete.do",
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
    function submit() {
        $("#ff").form("submit", {
            url: "${pageContext.request.contextPath}/banner/save.do"
        })
    };
</script>

<table id="dg"></table>
<div id="dd" class="easyui-dialog" title="认真添加哦！" style="width:400px;height:250px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                     submit();
                      $('#dd').dialog('close');
                      $('#dg').edatagrid('reload');
				}
			},{
				text:'关闭',
				handler:function(){
                     $('#dd').dialog('close');
				}
			}]">
    <form id="ff" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    <label for="title">标题:</label>+
                </td>
                <td>
                    <input class="easyui-validatebox" id="title" type="text" name="title" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="desc">描述:</label>
                </td>
                <td>
                    <input class="easyui-textbox" type="text" id="desc" name="desc" data-options=""/>
                </td>
            </tr>
            <tr>
                <td>
                    展示状态：
                </td>
                <td>
                    <select id="cc" class="easyui-combobox" name="status" style="width:200px;">
                        <option value="y">展示</option>
                        <option value="n">不展示</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="img">图片:</label>
                </td>
                <td>
                    <input class="easyui-filebox" id="img" name="img" style="width:300px">
                </td>
            </tr>
        </table>
    </form>
</div>