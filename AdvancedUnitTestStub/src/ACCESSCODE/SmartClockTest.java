package ACCESSCODE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class SmartClockTest {
    IDialog StubUnderRange = DialogStubUnderRange.GetInstance();
    IDialog StubOverRange = DialogStubOverRange.GetInstance();

    // #region TimeZone
    @Test
    void SetTimeZone_Between0And23() throws Exception {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();

        // Act
        clock.setUpDialog(StubUnderRange);
        clock.setTimeZone(); // clock.setTimeZone(0);

        // Assert
        assertEquals(0, clock.getTimeZone());
    }

    @Test
    void SetTimeZone_OutOfRange() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();

        // Act
        clock.setUpDialog(StubOverRange);

        // Assert
        assertThrows(Exception.class, () -> {
            clock.setTimeZone();
        });
    }

    @Test
    void SetTimeZone_Null() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();

        // Act
        clock.setUpDialog(null);

        // Assert
        assertThrows(Exception.class, () -> {
            clock.setTimeZone();
        });
    }
    // #endregion

    // #region GetCurrentTime
    @Test
    void GetCurrentTime_Midnight() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        Calendar cal = Calendar.getInstance();
        // Set date 10Oct2022
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        // Set time 00:00:00
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // Set datetime
        clock.setCurrentTime(cal.getTime());

        // Assert
        assertEquals("2022-10-10 00:00:00", clock.getCurrentTimeStamp());
    }

    @Test
    void GetCurrentTime_Noon() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        Calendar cal = Calendar.getInstance();
        // Set date 10Oct2022
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        // Set time 00:00:00
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // Set datetime
        clock.setCurrentTime(cal.getTime());

        // Assert
        assertEquals("2022-10-10 12:00:00", clock.getCurrentTimeStamp());
    }

    @Test
    void GetCurrentTime_Null() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        clock.setCurrentTime(null);

        // Assert
        assertThrows(NullPointerException.class, () -> {
            clock.getCurrentTimeStamp();
        });
    }
    // #endregion

    // #region GetLocalTimeStamp
    @Test
    void GetLocalTimeStamp_NeitherSpecialDayNorSpecialTime() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        Calendar cal = Calendar.getInstance();
        // Set date 10Oct2022
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        // Set time 00:00:00
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // Set datetime
        clock.setCurrentTime(cal.getTime());

        // Assert
        assertEquals("2022-01-01 08:00:00", clock.getLocalCurrentTimeStamp());
    }

    @Test
    void GetLocalTimeStamp_DoubleTenNoon() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        Calendar cal = Calendar.getInstance();
        // Set date 10Oct2022
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.OCTOBER);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        // Set time 00:00:00
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // Set datetime
        clock.setCurrentTime(cal.getTime());

        // Assert
        assertEquals("2022-10-10 DOUBLE-TEN NOON", clock.getLocalCurrentTimeStamp());
    }

    @Test
    void GetLocalTimeStamp_ChristmasMidnight() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        Calendar cal = Calendar.getInstance();
        // Set date 10Oct2022
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 25);
        // Set time 00:00:00
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        // Set datetime
        clock.setCurrentTime(cal.getTime());

        // Assert
        assertEquals("2022-12-25 X'MAS MIDNIGHT", clock.getLocalCurrentTimeStamp());
    }

    @Test
    void GetLocalTimeStamp_Null() {
        // Arrange
        OoooSmartClock clock = new OoooSmartClock();
        clock.setUpDialog(StubUnderRange);

        // Act
        clock.setCurrentTime(null);

        // Assert
        assertThrows(NullPointerException.class, () -> {
            clock.getLocalCurrentTimeStamp();
        });
    }
    // #endregion
}
