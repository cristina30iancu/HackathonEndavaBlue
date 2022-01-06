window.onscroll = function() {scrollFunction()};

document.getElementById('file-upload').onchange = (e)=>{
  if (e.target.files) {
    let imageFile = e.target.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(imageFile);
    reader.onloadend = function (e) {
      let image = new Image();
      image.src = e.target.result;
      console.log(imageFile.name)

    }
  }
};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("navbar").style.top = "0";
  } else {
    document.getElementById("navbar").style.top = "-200px";
  }
}