package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import org.junit.Assert;
import ru.job4j.chess.firuges.black.QueenBlack;

public class LogicTest {

    @Ignore
    @Test
    public void moveFromD2ToA5()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.D2, Cell.A5);
        Assert.assertSame(Cell.A5, new BishopBlack(Cell.A5).position());
    }

    @Ignore
    @Test(expected = OccupiedCellException.class)
    public void moveWhenOccupiedCell()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.add(new QueenBlack(Cell.A5));
        logic.move(Cell.D2, Cell.A5);
    }

    @Ignore
    @Test(expected = ImpossibleMoveException.class)
    public void moveWhenImpossible()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.D2, Cell.D5);
    }

    @Ignore
    @Test(expected = FigureNotFoundException.class)
    public void moveWhenFigureNotFound()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.D2));
        logic.move(Cell.D6, Cell.C3);
    }
}