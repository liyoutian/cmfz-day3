<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text: "专辑详情",
            handler: function () {
                $('#lyt').treegrid('getRoot');
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-edit',
            handler: function () {

            }
        }, '-', {
            text: "添加章节",
            iconCls: 'icon-help',
            handler: function () {
            }
        }, '-', {
            text: "下载音频",
            iconCls: 'icon-edit',
            handler: function () {
            }
        }]
        $('#lyt').treegrid({
            url: '${pageContext.request.contextPath}/album/showAlbum.do',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名称', width: 60},
                {field: 'size', title: '大小', width: 60},
                {field: 'audloPath', title: '路径', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns:true,
            toolbar:toolbar
        });
    })
</script>
<table id="lyt"></table>


