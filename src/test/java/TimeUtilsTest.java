import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TimeUtilsTest {

    @ParameterizedTest
    @CsvSource({"3600, '1:00:00'", "3665, '1:01:05'", "0, '0:00:00'", "32000, '-1'", "-1, '-1'"})
    public void testSecToTime(int seconds, String expected) {
        String result = TimeUtils.secToTime(seconds);
        assert result.equals(expected);
    }

    @ParameterizedTest
    @CsvSource({"'1:00:00', 3600", "'1:01:05', 3665", "'0:00:00', 0", "'-1', -1", "'error', -1"})
    public void testTimeToSec(String time, int expected) {
        int result = TimeUtils.timeToSec(time);
        assert result == expected;
    }
}
