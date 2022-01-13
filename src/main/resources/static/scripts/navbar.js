window.addEventListener('load',()=>{


    const switchAudio = document.getElementById("switchAudio");
    const switchColors = document.getElementById("switchAutism");
    const submitQuizBtn = document.getElementById("btnSubmit");
    const predictBtn = document.getElementById("file-upload2");

    if(window.localStorage.getItem('preferBW') == "on")
    {
        console.log("on culori");
        switchColors.setAttribute("checked","true");
        switchColors.checked = true;
        document.documentElement.style.setProperty('filter', 'grayscale(100%)');
    }
    else if(window.localStorage.getItem('preferBW') == "off")
    {
        console.log("off culori");
        switchColors.setAttribute("checked","false");
        switchColors.checked = false;
        document.documentElement.style.setProperty('filter', 'grayscale(0%)');
    }

    $("#switchAutism").click(function (){
        if(window.localStorage.getItem('preferBW') == "off")
        {
            window.localStorage.setItem('preferBW',"on");
            document.documentElement.style.setProperty('filter', 'grayscale(100%)');
            console.log('bifat bw');
        }
        else {
            window.localStorage.setItem('preferBW',"off");
            document.documentElement.style.setProperty('filter', 'grayscale(0%)');
            console.log('nu bifat bw');
        }
    });

    if(window.localStorage.getItem('preferAU') == "on" )
    {
        console.log("on audio");
        switchAudio.setAttribute("checked","true");
        switchAudio.checked = true;
        $('a').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
        })
        $('input').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
        })
        $('.closebtn').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance("Close"));
        })
        $('.form-check-label').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
        })
        $('#hamburger').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance("User menu"));
        })
        $('#openNavLeft').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance("Preferences menu"));
        })
        $('.btn-outline-warning').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
        })
        $('#add-new-course').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance("Add new course"));
        })
        $(submitQuizBtn).mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance("Submit responses"));
        })

    }
    else if(window.localStorage.getItem('preferAU') == "off" ){
        console.log("off audio");
        switchAudio.setAttribute("checked","false");
        switchAudio.checked = false;
        $('a').mouseenter(function () {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('input').mouseenter(function () {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('.closebtn').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('.form-check-label').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('#hamburger').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('#openNavLeft').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('.btn-outline-warning').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $('#add-new-course').mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })
        $(submitQuizBtn).mouseenter(function() {
            speechSynthesis.cancel();
            speechSynthesis.speak(new SpeechSynthesisUtterance(""));
        })

    }
    $('#switchAudio').click(function (){
        if(window.localStorage.getItem('preferAU') == "off")
        {
            window.localStorage.setItem('preferAU',"on");
            let utterance = new SpeechSynthesisUtterance("Welcome to Stud Source!");
                 speechSynthesis.speak(utterance);

            $('a').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
            })
            $('input').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
            })
            $('.closebtn').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance("Close"));
            })
            $('.form-check-label').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
            })
            $('#hamburger').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance("User menu"));
            })
            $('#openNavLeft').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance("Preferences menu"));
            })
            $('.btn-outline-warning').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance($(this).text()));
            })
            $('#add-new-course').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance("Add new course"));
            })
            $(submitQuizBtn).mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance("Submit responses"));
            })


        }
        else{
            window.localStorage.setItem('preferAU',"off")
            $('a').mouseenter(function () {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('input').mouseenter(function () {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('.closebtn').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('.form-check-label').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('#hamburger').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('#openNavLeft').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('.btn-outline-warning').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $('#add-new-course').mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
            $(submitQuizBtn).mouseenter(function() {
                speechSynthesis.cancel();
                speechSynthesis.speak(new SpeechSynthesisUtterance(""));
            })
        }
    });


});

window.onload = function(){

    $('#nav-icon1,#nav-icon2,#nav-icon3,#nav-icon4').click(function(){
        $(this).toggleClass('open');
    });

    var navbar = document.getElementById("navbar");
    var navitems = document.getElementsByClassName("nav-item");
    var hamburger = document.getElementById("hamburger");
    var logo = document.getElementById("logo");

    if(document.documentElement.scrollTop==0)
    {
        hamburger.style.filter = "invert(0%) sepia(100%) \
    saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
        logo.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

        navbar.style.setProperty("background-color","transparent","important");
        document.body.style.setProperty("--top-border-dist","0px");
    }
    window.onscroll = function(e) {
        var scrollY = window.pageYOffset || document.documentElement.scrollTop;
        if(document.documentElement.scrollTop == 0)
        {
            hamburger.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
            logo.style.filter = "invert(0%) sepia(100%) \
        saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

            document.body.style.setProperty("--top-border-dist","0px");
            navbar.style.setProperty("background-color","transparent","important");

            for ( var i = 0; i < navitems.length ; i ++ )
                navitems[i].style.color = "white";
            document.getElementById("favourites").style.filter="invert(0%) sepia(100%) \
      saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";
            document.getElementById("search").style.filter="invert(100%) sepia(0%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
        }
        else{
            navbar.style.setProperty("background-color","white","important");
            hamburger.style.filter = "invert(60%) sepia(9%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            logo.style.filter = "invert(60%) sepia(9%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            for ( var i = 0; i < navitems.length ; i ++ )
                navitems[i].style.color = "black";
            document.getElementById("favourites").style.filter="invert(100%) sepia(0%) saturate(616%) \
      hue-rotate(62deg) brightness(93%) contrast(91%)";
            document.getElementById("search").style.filter="invert(0%) sepia(100%) \
      saturate(0%) hue-rotate(338deg) brightness(200%) contrast(200%)";

        }

        if(scrollY <= this.lastScroll)
        {
            navbar.style.top = '0';
            if(document.documentElement.scrollTop != 0)
                document.body.style.setProperty("--top-border-dist","64px");
        }
        else{
            navbar.style.top = '-65px';
            document.body.style.setProperty("--top-border-dist","0px");
            document.getElementById("quiz-title").setAttribute("background-color","transparent");
        }

        this.lastScroll = scrollY ;

    }
};
