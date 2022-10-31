public class Bishop extends ChessPiece {

    public Bishop(String color) {
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
        /*  проверяем: 1) слон может ходить только по диагонали, 2) слон не может сходить в точку, в которой он сейчас находится,
        3) конечная позиция должна быть пустой или занята фигурой противника */
        } else if ((Math.abs(toLine - line) == Math.abs(toColumn - column)) && (Math.abs(toLine - line) != 0) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
        // проверяем, чтобы между начальной и конечной позицией не было других фигур
            if (toLine - line > 0 && toColumn - column > 0) {
                for (int i = 1; (i + line) < toLine; i++) {
                    if (chessBoard.board[line + i][column + i] != null) {
                        return false;
                    }
                }
            }
            if (toLine - line > 0 && toColumn - column < 0) {
                for (int i = 1; (i + line) < toLine; i++) {
                    if (chessBoard.board[line + i][column - i] != null) {
                        return false;
                    }
                }
            }
            if (toLine - line < 0 && toColumn - column > 0) {
                for (int i = 1; (i + toLine) < line; i++) {
                    if (chessBoard.board[line - i][column + i] != null) {
                        return false;
                    }
                }
            }
            if (toLine - line < 0 && toColumn - column < 0) {
                for (int i = 1; (i + toLine) < line; i++) {
                    if (chessBoard.board[line - i][column - i] != null) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
