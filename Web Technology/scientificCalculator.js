// Function to append values to the display
function appendToDisplay(value) {
    document.getElementById('display').value += value;
}

// Function to clear the display
function clearDisplay() {
    document.getElementById('display').value = '';
}

// Function to calculate the result of the expression
function calculateResult() {
    const display = document.getElementById('display');
    try {
        // Calculate result using eval (make sure to sanitize input in production)
        display.value = eval(display.value);
    } catch (error) {
        display.value = 'Error';
    }
}

// Function to calculate the square root
function calculateSquareRoot() {
    const display = document.getElementById('display');
    display.value = Math.sqrt(display.value);
}

// Function to calculate the square
function calculateSquare() {
    const display = document.getElementById('display');
    display.value = Math.pow(display.value, 2);
}

// Function to calculate the cube
function calculateCube() {
    const display = document.getElementById('display');
    display.value = Math.pow(display.value, 3);
}

// Function to generate the table of squares and cubes for numbers 0 to 10
function generateSquaresAndCubes() {
    const tableBody = document.getElementById('table-body');
    for (let i = 0; i <= 10; i++) {
        let row = document.createElement('tr');

        let cell1 = document.createElement('td');
        cell1.textContent = i;
        row.appendChild(cell1);

        let cell2 = document.createElement('td');
        cell2.textContent = Math.pow(i, 2); // Square of the number
        row.appendChild(cell2);

        let cell3 = document.createElement('td');
        cell3.textContent = Math.pow(i, 3); // Cube of the number
        row.appendChild(cell3);

        tableBody.appendChild(row);
    }
}

// Call the function to generate the table when the page loads
window.onload = generateSquaresAndCubes;
