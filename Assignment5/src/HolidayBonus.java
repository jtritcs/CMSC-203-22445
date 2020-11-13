public class HolidayBonus {

    /**
     * Calculates the holiday bonus for each store
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
        int maxIndex = 0, minIndex = 0;
        double max = 0, min = 0;
        int rowIndex = 0;
        for (double[] row : data) {
            double total = TwoDimRaggedArrayUtility.getRowTotal(data, rowIndex);
            if (total > max) {
                max = total;
                maxIndex = rowIndex;
            }
            if (total < min) {
                min = total;
                minIndex = rowIndex;
            }
            rowIndex++;
        }

        double[] bonuses = new double[rowIndex + 1];

        for (int i = 0; i < bonuses.length; i++) {
            if (i == maxIndex) bonuses[i] = high;
            else if (i == minIndex) bonuses[i] = low;
            else bonuses[i] = other;
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
        double sum = 0;
        sum += high + low;
        int rows = -2;
        for (double[] row : data) rows++;
        sum += (rows) * other;
        return sum;
    }
}
