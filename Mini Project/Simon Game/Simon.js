let gameSeq = [];
let userSeq = [];
let btns = ["red", "blue", "green", "purple"];

let started = false;
let level = 0;

let hs =localStorage.getItem("highScore") || 0;

let h2 = document.querySelector("h2.level");
let uScore = document.querySelector("h2.userScore");
let hScore = document.querySelector("h2.highScore");


document.addEventListener("keypress" , function() {
    if (started == false) {
    console.log("game started");
    started = true ;

    levelup();
    }
});


function gameFlash(btn) {
    btn.classList.add("flash");
    setTimeout(function() {
        btn.classList.remove("flash");
    }, 200);
}


function userFlash(btn) {
    btn.classList.add("userflash");
    setTimeout(function() {
        btn.classList.remove("userflash");
    }, 200);
}


function levelup() {
    userSeq=[];
    level++;
    h2.innerText = `Level ${level}`;
    uScore.innerText= `Your Score is ${level-1}`
    hScore.innerText= `Highest Score is ${hs}`

    let randIdx = Math.floor(Math.random() * 4);
    let randColor = btns[randIdx];
    let randBtn = document.querySelector(`.${randColor}`);
    gameSeq.push(randColor);
    console.log(gameSeq);
    gameFlash(randBtn);
    
}

function checkAns(idx) {
    
    if(userSeq[idx] === gameSeq[idx]) {
        if(userSeq.length == gameSeq.length){
            setTimeout(levelup, 1000);
            if(hs<gameSeq.length){
                hs = gameSeq.length;
                localStorage.setItem("highScore", hs);
            }
        }

    } else {
        h2.innerHTML=`Game Over! 
        Your Level was <b> ${level}</b> 
        <br>
        Press any key to Restart`;
        document.querySelector("body").style.backgroundColor="red";
        setTimeout(function() {
            document.querySelector("body").style.backgroundColor="white";
        }, 170);
        reset();
    }
}

function btnPress () {
        let btn = this;
    
    userFlash(btn);
    let userColor = btn.getAttribute("id");
    userSeq.push(userColor);

    checkAns(userSeq.length-1);
}


let allBtns = document.querySelectorAll(".btn");
for(btn of allBtns) {
    btn.addEventListener("click", btnPress);
}

function reset() {
    started = false;
    gameSeq = [];
    userSeq = [];
    level = 0;
}