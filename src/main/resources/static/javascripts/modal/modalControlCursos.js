$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var periodo = button.data('periodo');

    modal.find('.modal-body').find('#inputId').val(id);  
    modal.find('.modal-body').find('#inputNome').val(nome);
    modal.find('.modal-body').find('#selectPeriodo').val(periodo);
})