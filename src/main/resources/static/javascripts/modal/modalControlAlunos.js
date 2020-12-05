$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var ra = button.data('ra');
    var cpf = button.data('cpf');
    var nasc = button.data('nasc');
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
    modal.find('.modal-body').find('#inputRA').val(ra);
    modal.find('.modal-body').find('#inputCPF').val(cpf);
    modal.find('.modal-body').find('#inputNasc').val(nasc);
});