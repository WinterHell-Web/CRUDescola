$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var ra = button.data('ra');
    var cpf = button.data('cpf');
    var nasc = button.data('nasc');
    var id_curso = button.data('curso');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#ra').val(ra);
    modal.find('.modal-body').find('#cpf').val(cpf);
    modal.find('.modal-body').find('#nasc').val(nasc);
    modal.find('.modal-body').find('#selectCurso').val(id_curso);  
});