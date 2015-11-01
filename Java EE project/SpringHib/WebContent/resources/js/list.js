var item = item || {};

item.showDeleteModal = function() {	
	$('.delete').click(function() {
		var id = $(this).next('.item-id').val();		
		$("#dialog-confirm").dialog({			
			resizable : false,		
			modal : true,
			buttons : {
				"Delete" : function() {
					var formEl = $('#delete-item-form');
					formEl.find('[name=id]').val(id);
					formEl.submit();
					//$(this).dialog("close");								
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			}
		});
	});
};

$(document).ready(item.showDeleteModal);
$(document).ready(function() {
	$("#items-list").tablesorter();
});