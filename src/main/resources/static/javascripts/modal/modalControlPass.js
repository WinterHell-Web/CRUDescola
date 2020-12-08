$('#exampleModalCenter2').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');

    modal.find('.modal-body').find('#inputId2').val(id);   
});