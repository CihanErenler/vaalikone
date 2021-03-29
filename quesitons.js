const questions = [
  "If You Had Three Wishes, What Would You Wish For?",
  "What Would You Rather Throw Away: Love Or Money?",
  "What’s The Most Beautiful Place You’ve Ever Seen?",
  "What Was Your Fondest Memory Of High School?",
  "What’s Your Favorite TV Show?",
  "What’s The Strangest Thing In Your Refrigerator?",
  "Have You Ever Been To A Five Star Resort?",
  "What Was Your Favorite Toy Growing Up?",
  "What’s The Funniest Way You’ve Ever Broken The Law?",
  "What’s Your Favorite Sports Team?",
  "What Talent Would You Want To Possess If You Could?",
  "If You Could Trade Lives With Someone, Who Would It Be?",
  "If You Could Erase One Event From History, Which One Would You Erase?",
  "What Was Your Favorite Toy As A Child?",
  "Who Do You Most Like To Poke Fun At?",
  "If You Were Suddenly Transported To Another Planet, How Would You Assess The Situation?",
  "When Do You Feel The Most In Control?",
  "Would You Rather Have 10 Hobbies Or One Passion?",
  "If You Could Interview A Famous Person, Who Would You Choose?",
  "If Your Food Is Bad At A Restaurant, Would You Say Something?",
];

const form = document.getElementById("qustions-form");
const next = document.getElementById("next");
const submit = document.getElementById("submit");
const bar = document.querySelector(".bar");
const wrapper = document.querySelector(".wrapper-question");
const questionIndex = document.querySelector(".question-index");

let amount = 5;

next.addEventListener("click", update);
submit.addEventListener("click", redirect);
window.addEventListener("load", () => {
  wrapper.textContent = questions[0];
});

const question = questionIterator(questions);

function update(e) {
  e.preventDefault();

  const isDone = question.next();
  let index = +questionIndex.textContent + 1;

  if (!isDone.done) {
    questionIndex.textContent = index;
    amount += 5;
    bar.style.width = amount + "%";
    wrapper.textContent = isDone.value;
  }

  if (index === 20) {
    next.style.display = "none";
    submit.style.display = "block";
  }
}

function redirect(e) {
  e.preventDefault();
  window.location.href = "top-3.html";
}

function questionIterator(questions) {
  let currentIndex = 1;

  return {
    next: function () {
      return currentIndex < questions.length
        ? {
            value: questions[currentIndex++],
            done: false,
          }
        : { done: true };
    },
  };
}
