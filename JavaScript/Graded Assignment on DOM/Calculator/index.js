let display = document.getElementById('display');
let stringExpression = '';

function appendCh(char) {
  stringExpression += char;
  display.value = stringExpression;
}

function setOp(op) {
  stringExpression += op;
  display.value = stringExpression;
}

function clearDisplay() {
  stringExpression = '';
  display.value = '';
}

function calculate() {
  try {
    const result = eval(stringExpression);
    clearDisplay();
    display.value = result;
    stringExpression = result.toString(); 
  } catch (error) {
    clearDisplay();
    display.value = 'Error';
    stringExpression = '';
  }
}