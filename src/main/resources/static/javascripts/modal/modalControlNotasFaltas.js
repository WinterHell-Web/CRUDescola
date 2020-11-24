$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var nota1 = button.data('nota1');
    var nota2 = button.data('nota2');
    var faltas = button.data('faltas');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);  
    modal.find('.modal-body').find('#nota1').val(nota1);
    modal.find('.modal-body').find('#nota2').val(nota2);
    modal.find('.modal-body').find('#faltas').val(faltas);
})