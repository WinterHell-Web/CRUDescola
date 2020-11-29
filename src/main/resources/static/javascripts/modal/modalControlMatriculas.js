$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var materia = button.data('materia');  
    var nota = button.data('nota');
    var situacao = button.data('situacao');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#materia').val(materia);
    modal.find('.modal-body').find('#nota').val(nota);
    modal.find('.modal-body').find('#selectSituacao').val(situacao);
})