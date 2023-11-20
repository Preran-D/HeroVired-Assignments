const size = 9;

function isNumberInRow(board, number, row) {
    for (let i = 0; i < size; i++) {
        if (board[row][i] === number) {
            return true;
        }
    }
    return false;
}

function isNumberInCol(board, number, col) {
    for (let i = 0; i < size; i++) {
        if (board[i][col] === number) {
            return true;
        }
    }
    return false;
}

function isNumberInBox(board, number, row, col) {
    let boxRow = row - row % 3;
    let boxCol = col - col % 3;

    for (let i = boxRow; i < boxRow + 3; i++) {
        for (let j = boxCol; j < boxCol + 3; j++) {
            if (board[i][j] === number) {
                return true;
            }
        }
    }
    return false;
}

function isValidSudoku(board) {
    for (let row = 0; row < size; row++) {
        for (let col = 0; col < size; col++) {
            if (board[row][col] !== ".") {
                let currentNumber = board[row][col];
                board[row][col] = "."; 
                if (!isValid(board, currentNumber, row, col)) {
                    return false;
                }
                board[row][col] = currentNumber;
            }
        }
    }
    return true;
}
function isValid(board, number, row, col) {
    return !isNumberInRow(board, number, row) &&
        !isNumberInCol(board, number, col) &&
        !isNumberInBox(board, number, row, col);
}
let board = [
    ["5", "3", ".", ".", "7", ".", ".", ".", "."],
    ["6", ".", ".", "1", "9", "5", ".", ".", "."],
    [".", "9", "8", ".", ".", ".", ".", "6", "."],
    ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
    ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
    ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
    [".", "6", ".", ".", ".", ".", "2", "8", "."],
    [".", ".", ".", "4", "1", "9", ".", ".", "5"],
    [".", ".", ".", ".", "8", ".", ".", "7", "9"]
]

if (isValidSudoku(board)) {
    console.log("Valid Sudoku!");
} else {
    console.log("Invalid Sudoku!");
}
