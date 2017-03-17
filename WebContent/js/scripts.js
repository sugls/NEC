function getRootPath(){
    var curPath = window.document.location.href;   // http://localhost:8080/NEC/index.jsp
    var pathName = window.document.location.pathname;  //  /NEC/share/meun.jsp
    var position = curPath.indexOf(pathName);
    var localhost = curPath.substr(0,position);
    var appName = pathName.substr(0,pathName.substr(1).indexOf('/')+1);
    return localhost + appName;
}

jQuery(document).ready(function() {

    /*
        Fullscreen background
    */
	console.log(getRootPath());
    $.backstretch([getRootPath()+"/img/backgrounds/bg.jpg",getRootPath()+"/img/backgrounds/bg1.jpg"],{duration:10000});
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"]').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    $(".select > p").on("click",function () {
        $(this).removeClass('input-error');
        $(this).addClass('input-focus');
    });
    $(".select > p").mouseout(function () {
        $(".select > p").removeClass('input-focus');
    });

    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"]').each(function(){
    		if( $(this).val().trim() == "") {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
        if ($("#postname").attr("value") == -1){
            e.preventDefault();
            $(".select > p").addClass('input-error');
        } else {
            $(".select > p").removeClass('input-error');
        }
    });

});




