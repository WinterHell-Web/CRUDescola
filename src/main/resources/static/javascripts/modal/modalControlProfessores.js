$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var cpf = button.data('cpf');
    var formacao = button.data('formacao');
    var user = button.data('user');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#cpf').val(cpf);  
    modal.find('.modal-body').find('#formacao').val(formacao);
    modal.find('.modal-body').find('#selectUsuario').val(user);  
})