package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int positX = position.getX();
        int positY = position.getY();
        int destX = dest.getX();
        int destY = dest.getY();
        int size = Math.abs(positX - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = destX - positX > 0 ? 1 : -1;
        int deltaY = destY - positY < 0 ? -1 : 1;
        for (int index = 0; index < size; index++) {
            positX += deltaX;
            positY += deltaY;
            steps[index] = Cell.findBy(positX, positY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
