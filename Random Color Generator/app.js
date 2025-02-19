let btn = document.querySelector("button");

btn.addEventListener("click" , function() {
    let h2 = document.querySelector("h2");
    let randomColor = getRandomColor();
    h2.innerText = randomColor;

    let div = document.querySelector("div");
    div.style.backgroundColor = randomColor;

    
    console.log("Color Updated");
});



function getRandomColor() {
    let r=Math.floor(Math.random() * 255);
    let b=Math.floor(Math.random() * 255);
    let g=Math.floor(Math.random() * 255);

    let color = `rgb(${r} , ${b}, ${g})`;
    return color;
}