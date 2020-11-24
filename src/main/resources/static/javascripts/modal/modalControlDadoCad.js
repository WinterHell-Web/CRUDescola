$('#exampleModalCenter1').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var cpf = button.data('cpf');
    var user = button.data('user');

    var ra = button.data('ra');
    var nasc = button.data('nasc');

    var formacao = button.data('formacao')

    modal.find('.modal-body').find('#id1').val(id);  
    modal.find('.modal-body').find('#nome').val(nome);
    modal.find('.modal-body').find('#cpf').val(cpf);
    modal.find('.modal-body').find('#user').val(user);  
    
    modal.find('.modal-body').find('#ra').val(ra);
    modal.find('.modal-body').find('#inputNasc').val(nasc);

    modal.find('.modal-body').find('#formacao').val(formacao);    
});