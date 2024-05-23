function displayA() {
  console.log('A');
}

function displayB(callback) {
  setTimeout(function () {
    console.log('B');
    callback();
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
