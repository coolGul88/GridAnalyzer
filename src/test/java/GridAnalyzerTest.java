import com.grid.connected.shapes.analyzer.GridAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridAnalyzerTest {

    @Test
    public void testEmptyGrid() {
        //Given
        GridAnalyzer gridAnalyzer = new GridAnalyzer(null);

        //When
        int numOfShapes = gridAnalyzer.getConnectedShapes();

        //Then
        assertEquals(0, numOfShapes);
    }

    @Test
    public void testSingleGrid() {
        //Given
        List<char[]> zeroGrid = Collections.singletonList(new char[]{'0'});
        List<char[]> oneGrid = Collections.singletonList(new char[]{'1'});
        GridAnalyzer zeroGridAnalyzer = new GridAnalyzer(zeroGrid);
        GridAnalyzer oneGridAnalyzer = new GridAnalyzer(oneGrid);

        //when
        int zeroGridShapes = zeroGridAnalyzer.getConnectedShapes();
        int oneGridShapes = oneGridAnalyzer.getConnectedShapes();

        //then
        assertEquals(0, zeroGridShapes);
        assertEquals(1, oneGridShapes);
    }

    @Test
    public void testMultiGrid() {
        //Given
        List<char[]> grid = Arrays.asList(new char[]{'0', '1', '0'}, new char[]{'1', '0', '1'});
        GridAnalyzer gridAnalyzer = new GridAnalyzer(grid);

        //when
        int shapes = gridAnalyzer.getConnectedShapes();

        //then
        assertEquals(3, shapes);
    }
}
