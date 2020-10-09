import static org.junit.jupiter.api.Assertions.*;

class GradeBookTester {
    GradeBook gradeBook1 = new GradeBook(5);
    GradeBook gradeBook2 = new GradeBook(5);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gradeBook1.addScore(4.4);
        gradeBook1.addScore(100);
        gradeBook2.addScore(60);
        gradeBook2.addScore(90);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        gradeBook1 = null;
        gradeBook2 = null;
    }

    @org.junit.jupiter.api.Test
    void getScoresSize() {
        assertEquals(gradeBook1.getScoresSize(), 2);
        assertEquals(gradeBook2.getScoresSize(), 2);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void addScore() {
        assertEquals(gradeBook1.toString(), "4.4 100");
        assertEquals(gradeBook1.toString(), "60 90");
    }

    @org.junit.jupiter.api.Test
    void sum() {
        assertEquals(gradeBook1.sum(), 4.4 + 100);
        assertEquals(gradeBook2.sum(), 60 + 90);
    }

    @org.junit.jupiter.api.Test
    void minimum() {
        assertEquals(gradeBook1.minimum(), 4.4);
        assertEquals(gradeBook2.minimum(), 60);
    }

    @org.junit.jupiter.api.Test
    void finalScore() {
        assertEquals(gradeBook1.finalScore(), 100);
        assertEquals(gradeBook1.finalScore(), 90);
    }
}