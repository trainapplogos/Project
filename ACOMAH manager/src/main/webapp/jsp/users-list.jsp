<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">


<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous"> -->

<title>Create Bill</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://kit-free.fontawesome.com/releases/latest/css/free.min.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/jquery-resizable-columns@0.2.3/dist/jquery.resizableColumns.css">

<script
	src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table-locale-all.min.js"></script>
<script
	src="https://unpkg.com/jquery-resizable-columns@0.2.3/dist/jquery.resizableColumns.min.js"></script>

<!--  -->


<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script> -->



<style>
.select, #locale {
	width: 100%;
}

.like {
	margin-right: 10px;
}

.header-panel {
	padding-bottom: 50px;
}
/* .bootstrap-table { margin-top: 50px;} */

/* .heart {
		  color: #fff; 
		} */
.
/* .bootstrap-table {margin-top: 50px;} */
</style>

</head>
<body>

	<jsp:include page="sidebar.jsp" />

	<div id="main">
		<div class="header-panel">
			<jsp:include page="panel.jsp">
				<jsp:param name="headerTitle" value="Control panel: Create Bill" />
			</jsp:include>
		</div>

		<div class="bootstrap-table bootstrap4">

			<!-- <div class="fixed-table-toolbar"> -->
			<div class="bs-bars float-left">
				<div id="toolbar">
					<button id="remove" class="btn btn-danger" disabled>
						<i class="fa fa-trash"></i> Delete
					</button>
				</div>
			</div>


			<form:form method="POST" action="${contextPath}/create-bill" modelAttribute="selectedId">
				<br>

				<table id="table" data-toolbar="#toolbar" data-search="true"
					data-show-refresh="true" data-show-toggle="true"
					data-show-fullscreen="true" data-show-columns="true"
					data-show-columns-toggle-all="true" data-detail-view="true"
					data-show-export="true" data-click-to-select="true"
					data-single-select="true" data-multiple-select-row="false"
					data-detail-formatter="detailFormatter"
					data-minimum-count-columns="7" data-show-pagination-switch="true"
					data-pagination="true" data-id-field="id"
					data-page-list="[10, 25, 50, 100, all]" data-show-footer="true"
					data-side-pagination="server" data-url="/api/get-data"
					data-response-handler="responseHandler">
				</table>
				
				<input type="hidden" value="0" name="selectedId">
				
				<button id="bill" class="btn btn-success"  type="submit" disabled> 	<!-- onclick="sendSelectedId()" -->		
					<i class="fa fa-id-card-o" aria-hidden="true"></i> Create Bill
				</button>
				
			
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form> 

		</div>
		<!--  </div> -->
	</div>



	<script>

		var $table = $('#table')
		var $remove = $('#remove')
		var $bill = $('#bill')
		var selections = []

		function getIdSelections() {
			return $.map($table.bootstrapTable('getSelections'), function(row) {
				$('input[name="selectedId"]').val(row.id)
				
				return row.id
			})
		}

		function responseHandler(res) {
			$.each(res.rows, function(i, row) {
				row.state = $.inArray(row.id, selections) !== -1
			})
			return res
		}

		function detailFormatter(index, row) {
			var html = []
			$.each(row, function(key, value) {
				html.push('<p><b>' + key + ':</b> ' + value + '</p>')
			})
			return html.join('')
		}

		function operateFormatter(value, row, index) {
			return [
					'<a class="like" href="javascript:void(0)" title="Like">',
					'<i class="fa fa-heart"></i>',
					'</a>  ',
					'<a class="remove" href="javascript:void(0)" title="Remove">',
					'<i class="fa fa-trash"></i>', '</a>'

			].join('')
		}

		/*'<a class="bill" href="javascript:void(0)" title="Create Bill">',
		'<i class="fa fa-id-card-o"></i>',
		'</a>'*/

		window.operateEvents = {
			'click .like' : function(e, value, row, index) {
				alert('You click like action, row: ' + JSON.stringify(row))
			},
			'click .remove' : function(e, value, row, index) {
				$table.bootstrapTable('remove', {
					field : 'id',
					values : [ row.id ]
				})
			}
		}

		function totalTextFormatter(data) {
			return 'Total'
		}

		function totalNameFormatter(data) {
			return data.length
		}

		function totalPriceFormatter(data) {
			var field = this.field
			return '$' + data.map(function(row) {
				return +row[field].substring(1)
			}).reduce(function(sum, i) {
				return sum + i
			}, 0)
		}

		function initTable() {
			$table.bootstrapTable('destroy').bootstrapTable({
				height : 550,
				locale : $('#locale').val(),
				columns : [ [ {
					field : 'state',
					/* data-field: 'state', */
					checkbox : true,
					rowspan : 2,
					align : 'center',
					valign : 'middle'
				}, {
					title : '#',
					field : 'number',
					/* data-field: 'number', */
					rowspan : 2,
					align : 'center',
					valign : 'middle',
					sortable : true,
					footerFormatter : totalTextFormatter
				},

				{
					title : 'User Details',
					colspan : 6,
					align : 'center'
				/* }, {
				  title: 'User Address',
				  colspan: 5,
				  align: 'center'  */
				} ], [ {
					field : 'email',
					title : 'Email',
					sortable : true,
					align : 'center',
					footerFormatter : totalNameFormatter
				//footerFormatter: totalPriceFormatter
				}, {
					field : 'firstName',
					title : 'First Name',
					sortable : true,
					/*  footerFormatter: totalNameFormatter, */
					align : 'center'
				}, {
					field : 'lastName',
					title : 'Last Name',
					sortable : true,
					align : 'center'
				/*  footerFormatter: totalNameFormatter */
				}, {
					field : 'patronymic',
					title : 'Patronymic',
					sortable : true,
					align : 'center'
				/* footerFormatter: totalNameFormatter */
				}, {
					field : 'phoneNumber',
					title : 'Phone num.',
					sortable : true,
					align : 'center',
				/*   footerFormatter: totalNameFormatter */

				/*   }, {
				        field: 'building',
				        title: 'Bld.',
				        sortable: true,
				        align: 'center'
					
				  }, {
				        field: 'apartment',
				        title: 'Apt.',
				        sortable: true,
				        align: 'center'
					
				  
				  }, {
				      field: 'street',
				      title: 'Str.',
				      sortable: true,
				      align: 'center'
					 
				  }, {
				        field: 'zipCode',
				        title: 'Zip-Code',
				        sortable: true,
				        align: 'center' */

				}, {
					field : 'operate',
					title : 'Item Operate',
					align : 'center',
					clickToSelect : false,
					events : window.operateEvents,
					formatter : operateFormatter
				} ] ]
			})

			$table.on('check.bs.table uncheck.bs.table '
					+ 'check-all.bs.table uncheck-all.bs.table', function() {
				$remove.prop('disabled', !$table
						.bootstrapTable('getSelections').length)

				$bill.prop('disabled', !$table
						.bootstrapTable('getSelections').length)
						
				// save your data, here just save the current page
				selections = getIdSelections()
				// push or splice the selections if you want to save all data selections
			})

			$table.on('all.bs.table', function(e, name, args) {
				console.log(name, args)
			})

			$remove.click(function() {
				var ids = getIdSelections()
				$table.bootstrapTable('remove', {
					field : 'id',
					values : ids
				})
				$remove.prop('disabled', true)
			})
		}

		$(function() {
			initTable()

			$('#locale').change(initTable)
		})
	</script>

	<script src="/js/sidebar.js">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
	<script
		src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
	<script
		src="https://unpkg.com/bootstrap-table@1.18.3/dist/extensions/resizable/bootstrap-table-resizable.min.js"></script>

</body>
</html>