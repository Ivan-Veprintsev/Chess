public class Rook extends ChessPiece {

    public Rook(String color) {
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
        // ладья может ходить по вертикали или горизонтали и конечная позиция должна быть пустой или занята фигурой противника
        } else if (((Math.abs(toLine - line) > 0 && Math.abs(toColumn - column) == 0) ||
                (Math.abs(toLine - line) == 0 && Math.abs(toColumn - column) > 0)) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
        /// проверяем вертикаль, чтобы между начальной и конечной позицией не было других фигур
            if (Math.abs(toLine - line) > 1) {
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][toColumn] != null) {
                        return false;
                    }
                }
            }
        // проверяем горизонталь, чтобы между начальной и конечной позицией не было других фигур
            if (Math.abs(toColumn - column) > 1) {
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[toLine][i] != null) {
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
        return "R";
    }
}
