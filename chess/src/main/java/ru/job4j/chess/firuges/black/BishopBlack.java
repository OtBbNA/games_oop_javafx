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
        int deltaX = (destX - positX) / (Math.abs(destX - positX));
        int deltaY = (destY - positY) / (Math.abs(destY - positY));
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(positX + ((index + 1) * deltaX),
                    positY + ((index + 1) * deltaY));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean rsl = false;
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
