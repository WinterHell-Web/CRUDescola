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

    modal.find('.modal-body').find('#inputId1').val(id);  
    modal.find('.modal-body').find('#inputNome').val(nome);
    modal.find('.modal-body').find('#inputCPF1').val(cpf);
    modal.find('.modal-body').find('#inputCPF2').val(cpf);
    modal.find('.modal-body').find('#inputUser').val(user);  
    
    modal.find('.modal-body').find('#inputRA').val(ra);
    modal.find('.modal-body').find('#inputNasc').val(nasc);

    modal.find('.modal-body').find('#inputFormacao').val(formacao);    
});