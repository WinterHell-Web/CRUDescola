$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var nota1 = button.data('nota1');
    var nota2 = button.data('nota2');
    var faltas = button.data('faltas');

    modal.find('.modal-body').find('#inputId').val(id);  
    modal.find('.modal-body').find('#inputNome').val(nome);  
    modal.find('.modal-body').find('#inputNota1').val(nota1);
    modal.find('.modal-body').find('#inputNota2').val(nota2);
    modal.find('.modal-body').find('#inputFaltas').val(faltas);
})