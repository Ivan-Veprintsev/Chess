public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        }
        // первый ход пешка может сдвинуться на 2 поля вперед, если они не заняты другими фигурами
        if (color.equals("White") && line == 1 && Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 0 &&
                chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + 1][toColumn] == null) {
            return true;
        }
        // первый ход пешка может сдвинуться на 2 поля вперед, если они не заняты другими фигурами
        if (color.equals("Black") && line == 6 && Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 0 &&
                chessBoard.board[toLine][toColumn] == null && chessBoard.board[line - 1][toColumn] == null) {
            return true;
        }
        // пешка может ходить на одно поле вперед, если оно не занято другими фигурами
        if ((Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 0) &&
                chessBoard.board[toLine][toColumn] == null) {
            return true;
        }
        // пешка может взять фигуру противника
        if (((Math.abs(toLine - line) == Math.abs(toColumn - column)) && (Math.abs(toLine - line) == 1)) &&
                !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
            return true;
        }
        // пешка не может сходить в точку, в которой она сейчас находится
        if (Math.abs(toLine - line) == 0) {
            return false;
        }
        // пешка не может ходить назад
        if (toLine <= line && getColor().equals("White")) {
            return false;
        }
        // пешка не может ходить назад
        if (toLine >= line && getColor().equals("Black")) {
            return false;
        }
        // пешка не может ходить, если конечная позиция занята другой фигурой
        if (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 0 && chessBoard.board[toLine][toColumn] != null) {
            return false;
        }
        // пешка не может ходить по диагонали
        if (Math.abs(toColumn - column) != 0) {
            return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

}
