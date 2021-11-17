var button = document.querySelector("button");
function helloWorld() {
    return "hello world";
}
button.addEventListener("click", function () {
    console.log(helloWorld());
});
