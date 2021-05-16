$( document ).ready(function() {

    $(".openbutton").on('click', function(){
        let id = $(this).data('teamid')
        window.open(`/team/showDialog/${id}`, "_blank",
            "status=no,location=no,menubar=no,width=450,height=450,centerscreen=yes,chrome=yes,toolbar=no,resizable=no")
    })

    $(".deletebutton").on('click', function(){
        let id = $(this).data('teamid');
        window.location.href=`/team/delete/${id}`
    })
});