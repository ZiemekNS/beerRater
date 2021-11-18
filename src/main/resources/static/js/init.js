/*///////////////// PORTFOLIO HOVER EFFECT /////////////////////////*/
$(document).ready(function(){
$('.enlarge').css({ opacity: 0 });
$('.enlarge').css({ cursor: 'pointer' });
$('.enlarge').hover(function(){
    $(this).stop().animate({ opacity: 1 }, 500);
    
}, function(){
   $(this).stop().animate({ opacity: 0 }, 300);
 
});
});
/*///////////////// END PORTFOLIO HOVER EFFECT /////////////////////////*/

/*///////////////// SOCIAL LINKS HOVER EFFECT /////////////////////////*/
$(document).ready(function(){
	$('.social-links li a img').hover(function(){
		$(this).stop().animate({ marginTop: "-5px"}, 300);
		
	}, function(){
	   $(this).stop().animate({ marginTop: "0px" }, 300);
	 
	});
});
/*///////////////// END SOCIAL LINKS HOVER EFFECT /////////////////////////*/

/*///////////////// SUBMENU HOVER EFFECT /////////////////////////*/
$(document).ready(function(){
	$('.box-body ul li a ').hover(function(){
		$(this).stop().animate({marginLeft: "30px" }, 300);
		
	}, function(){
	   $(this).stop().animate({marginLeft: "15px" }, 300);
	 
	});
});
/*///////////////// END SUBMENU HOVER EFFECT /////////////////////////*/

/*///////////////// FOOTER NAVIGATION HOVER EFFECT /////////////////////////*/
$(document).ready(function(){
	$('.footer-navigation li a').hover(function(){
		$(this).stop().animate({marginLeft: "15px" }, 300);
		
	}, function(){
	   $(this).stop().animate({marginLeft: "0px" }, 300);
	 
	});
});
/*///////////////// END FOOTER NAVIGATION HOVER EFFECT /////////////////////////*/

/*///////////////// LATEST POSTS HOVER EFFECT /////////////////////////*/
$(document).ready(function(){
	$('.latest-post').hover(function(){
		$(this).stop().animate({marginLeft: "10px" }, 300);
	
	}, function(){
	   $(this).stop().animate({marginLeft: "0px" }, 300);
	  
	 
	});
});
/*///////////////// END LATEST POSTS HOVER EFFECT /////////////////////////*/


/*///////////////// ACCORDION /////////////////////////*/
$(document).ready(function(){
	//Set default open/close settings
	$('.acc_container').hide(); //Hide/close all containers
	$('.acc_trigger:first').addClass('active').next().show(); //Add "active" class to first trigger, then show/open the immediate next container
	
	//On Click
	$('.acc_trigger').click(function(){
		if( $(this).next().is(':hidden') ) { //If immediate next container is closed...
			$('.acc_trigger').removeClass('active').next().slideUp(); //Remove all .acc_trigger classes and slide up the immediate next container
			$(this).toggleClass('active').next().slideDown(); //Add .acc_trigger class to clicked trigger and slide down the immediate next container
		}
		return false; //Prevent the browser jump to the link anchor
	});
});
/*///////////////// END ACCORDION /////////////////////////*/