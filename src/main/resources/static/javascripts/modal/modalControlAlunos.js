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

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#ra').val(ra);
    modal.find('.modal-body').find('#cpf').val(cpf);
    modal.find('.modal-body').find('#nasc').val(nasc);
});