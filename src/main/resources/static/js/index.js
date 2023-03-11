var url = '';
$('button[id*="btn_"]').click(function(){
    url = 'http://localhost:8080/'+$(this).attr('id').split("_")[1];
    $("#myModal").modal('show');
});

$('button[id="ok_confirm"]').click(function(){
    document.location.href = url;
});
$('button[id="cancel_confirm"]').click(function(){
    $("#myModal").modal('hide');
    url = '';
});
$(function() {
    $('[data-toggle="popover"]').popover();
});

$(document).ready(function($){
    $(".navbar-toggle").click(function(){
        $(".sidebar").toggleClass("sidebar-open");
    });
    $('.currency').mask('000.000.000.000,00', {reverse: true});
});