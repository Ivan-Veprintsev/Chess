public class Horse extends ChessPiece {

    public Horse(String color) {
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
        // конь может ходить буквой "Г"
        } else if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) ||
                (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2)) {
        // конечная позиция должна быть пустой или занята фигурой противника
            if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "H";
    }

}
