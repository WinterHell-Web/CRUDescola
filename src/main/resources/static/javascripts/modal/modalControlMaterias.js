$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var id_curso = button.data('curso');
    var id_semestre = button.data('semestre');
    var id_professor = button.data('professor');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#selectCurso').val(id_curso);  
    modal.find('.modal-body').find('#inputSemestre').val(id_semestre);  
    modal.find('.modal-body').find('#selectProfessor').val(id_professor); 
})