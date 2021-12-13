window.onload = () => {
    var nextButton = document.getElementById("arrow-next");
    console.log(nextButton);
    let i = 1;
    while(i<10)
    {
        i++;
        setTimeout(10);
        nextButton.click();
    }
    
}