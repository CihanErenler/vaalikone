const questions = document.querySelectorAll(".question-card");

questions.forEach((item, i) => {
	const val = item.getAttribute("data-val").split(";");
	
	item.querySelectorAll(".chart").forEach((b, index) => {
		b.querySelectorAll(".chart-wrap").forEach((w, wi) => {
			w.children[2].textContent = val[wi]
			w.children[1].children[0].style.width = calculate(parseInt(val[wi]), questions.length)+"%";
		})
	})
})

function calculate(x,y){
	return (100 / y) * x;
	
}