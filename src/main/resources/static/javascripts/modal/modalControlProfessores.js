$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var cpf = button.data('cpf');
    var formacao = button.data('formacao');
    var user = button.data('user');
    var userId = button.data('userid');

    if (user)
    {
        modal.find('.modal-body').find('#optionUser').val(userId).text(user);
    }
    else
    {
        modal.find('.modal-body').find('#optionUser').val(0).text("");
    }
    
    modal.find('.modal-body').find('#inputId').val(id);  
    modal.find('.modal-body').find('#inputNome').val(nome);
    modal.find('.modal-body').find('#inputCPF').val(cpf);  
    modal.find('.modal-body').find('#inputFormacao').val(formacao);
})