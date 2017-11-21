public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        int minus = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            minus = timeSeries[i + 1] - timeSeries[i];
            total += minus >= duration ? duration : minus;
        }
        return timeSeries.length == 0 ? 0 : total + duration;
    }
}
