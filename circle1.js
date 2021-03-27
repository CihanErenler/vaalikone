const circle = document.querySelectorAll(".circle");

window.addEventListener("load", update);

function update() {
  circle.forEach((item) => {
    const half1 = item.document.getElementById("half-1");
    const half2 = item.document.getElementById("half-2");
    const per = item.document.querySelector(".per");
    const half = item.document.querySelector(".half");

    const number = +item.getAttribute("data-val");

    let num = 0;

    animate(number);

    setInterval(() => {
      if (num < number) {
        ++num;
        per.textContent = num + "%";
      } else {
        clearInterval();
      }
    }, calculateTime(number));

    function animate(number) {
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
  });
}
