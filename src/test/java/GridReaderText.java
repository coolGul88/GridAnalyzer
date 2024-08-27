import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.grid.connected.shapes.reader.GridReader.readGrid;
import static org.junit.jupiter.api.Assertions.*;

public class GridReaderText {

    @Test
    public void testIncorrectFile() {
        //given
        String filename = null;

        //when , then
        assertThrows(RuntimeException.class, () -> readGrid(filename));
    }

    @Test
    public void  testFileReads() {
        //Given
        String file1 = "src/test/resources/data_1X1.txt";
        List<char[]> grid1 = Collections.singletonList(new char[]{'1'});
        String file2 = "src/test/resources/data_2X4.txt";
        List<char[]> grid2 = Arrays.asList(new char[]{'0', '1', '0', '0'}, new char[]{'1', '0', '1', '1'});

        //When
        List<char[]> resGrid1 = readGrid(file1);
        List<char[]> resGrid2 = readGrid(file2);

        //Then
        assertArrayEquals(grid1.toArray(), resGrid1.toArray());
        assertArrayEquals(grid2.toArray(), resGrid2.toArray());
    }
}
