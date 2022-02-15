import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Naming {

    public static final int STATUS_VALUE = 0;
    public static final int FLAGGED = 4;
    public static final int WORK_DAYS_PER_WEEK = 5;

    /*

    * 1.
    *
    * */

    /**
     * 의도를 분명히 드러냄
     * 1. 코드 맥락이 코드 자체에 명시적으로 드러나지 않는다
     * @return
     */
    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();
        for (int[] x : list1) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    /**
     * 2.
     *
     */
    public List<int[]> getFlaggedCells_1() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : flaggedCells) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    /**
     * 3.
     *
     */
    public List<Cell> getFlaggedCells_2() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : flaggedCells) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    private class Cell {
        public boolean isFlagged() {
            return false;
        }
    }

    // ex)발음하기 쉬운 이름 사용
    private class DtaRcrd102 {
        private Date genymdhms;
        private Date modymdhms;
        private final String pszqint = "102";
    }

    private class Customer {
        private Date generationTimestamp;
        private Date modificationTimestamp;
        private final String recordId = "102";
    }
    //

    // 검색하기 쉬운 이름 사용
    private class easyName {
        private static final int NUMBER_OF_TASKS = 34;

        private void example() {
            //
            int s  = 0;
            int[] t = new int[34];
            for (int j =0; j <34; j++) {
                s += (t[j] * 4) / 5;
            }

            int realDaysPerIdealDay = 4;
            int[] taskEstimate = new int[NUMBER_OF_TASKS];
            int sum = 0;
            for (int j = 0; j < NUMBER_OF_TASKS; j++) {
                int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
                int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
                sum += realTaskWeeks;
            }

            /**
             * 생성자를 중복저의 할 떄는 정적 팩토리 메서드를 사용
             */
            Complex fulcrumPoint_1 = new Complex(23.0);
            Complex fulcrumPoint_2 = Complex.FromRealNumber(23.0);
        }
    }

    /**
     * 의미있는 맥락을 추가
     */
    private class Context {
        private void printGuessStatistics(char candidate, int count) {
            String number;
            String verb;
            String pluralModifier;
            if (count == 0) {
                number = "no";
                verb = "are";
                pluralModifier = "s";
            } else if (count == 1) {
                number = "1";
                verb = "is";
                pluralModifier = "";
            } else {
                number = Integer.toString(count);
                verb = "are";
                pluralModifier = "s";
            }
            String guessMessage = String.format(
                    "There %s %s %s %s", verb, number, candidate, pluralModifier
            );
            print(guessMessage);
        }

        private void print(String guessMessage) {
            System.out.println("guessMessage = " + guessMessage);
        }
    }

    private class GuessStatisticsMessage {
        private String number;
        private String verb;
        String pluralModifier;

        private String make(char candidate, int count) {
            createPluralDependentMessageParts(count);
            return String.format(
                    "There %s %s %s %s", verb, number, candidate, pluralModifier
            );
        }

        private void createPluralDependentMessageParts(int count) {
            if (count == 0) {
                thereAreNoLetter();
            } else if (count == 1) {
                thereIsOneLetter();
            } else {
                thereAreManyLetters(count);
            }
        }

        private void thereAreManyLetters(int count) {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        private void thereIsOneLetter() {
            number = "1";
            verb = "is";
            pluralModifier = "";
        }

        private void thereAreNoLetter() {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        }
    }

}
