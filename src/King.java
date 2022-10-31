public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // проверяем, чтобы начальная и конечная позиции не выходили за пределы шахматной доски
        if (line < 0 || line > 7 || column < 0 || column > 7 || toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;

        // король ходит на соседнюю клетку по диагонали и конечная позиция должна быть пустой или занята фигурой противника
        } else if (((Math.abs(toLine - line) == Math.abs(toColumn - column)) && Math.abs(toLine - line) == 1) &&
                !isUnderAttack(chessBoard, toLine, toColumn) && (chessBoard.board[toLine][toColumn] == null ||
                !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
            return true;
        // король ходит на соседнюю клетку по вертикали или горизонтали и конечная позиция должна быть пустой или занята фигурой противника
        } else if (((Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 0) ||
                (Math.abs(toLine - line) == 0 && Math.abs(toColumn - column) == 1)) && !isUnderAttack(chessBoard, toLine, toColumn) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) &&
                            chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
