const half1 = document.getElementById("half-1");
const half2 = document.getElementById("half-2");
const circle = document.querySelector(".circle");
const per = document.querySelector(".per");
const half = document.querySelector(".half");

const number = +circle.getAttribute("data-val");

window.addEventListener("load", update);

function update() {
  let num = 0;

  animate();

  setInterval(() => {
    if (num < number) {
      ++num;
      per.textContent = num + "%";
    } else {
      clearInterval();
    }
  }, calculateTime(number));
}

function animate() {
  const portion = number * 3.6;
  const time = calculateTime(portion);

  let i = 0;

  setInterval(() => {
    i++;

    if (i < portion) {
      if (i < 180) {
        half1.style.transform = `rotate(${i}deg)`;
      }

      if (i === 180) {
        half.style.opacity = "0";
      }

      half2.style.transform = `rotate(${i}deg)`;
    } else {
      clearInterval();
    }
  }, time);
}

function calculateTime(x) {
  return 2000 / x;
}
