$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var id_curso = button.data('curso');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#selectCurso').val(id_curso);  
})