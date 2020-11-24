$('#exampleModalCenter').on('show.bs.modal', function (e) 
{
    var button = $(e.relatedTarget);
    var modal = $(this);

    var id = button.data('id');
    var nome = button.data('nome');
    var user = button.data('user');
    var p = button.data('p');
    var regra = button.data('regra');
    var ativo = button.data('ativo');

    modal.find('.modal-body').find('#id').val(id);  
    modal.find('.modal-body').find('#nome1').val(nome);
    modal.find('.modal-body').find('#nome2').val(nome);
    modal.find('.modal-body').find('#user1').val(user);
    modal.find('.modal-body').find('#user2').val(user);
    modal.find('.modal-body').find('#p').val(p);
    modal.find('.modal-body').find('#selectRegra').val(regra);
    modal.find('.modal-body').find('#ativo').prop('checked', ativo);
})