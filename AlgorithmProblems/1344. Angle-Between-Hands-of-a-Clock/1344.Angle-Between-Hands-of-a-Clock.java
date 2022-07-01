/*
total 360 degress per round
we have 12 * 5 = 60 units per round
double degreePerUnit = 360 / 60 = 6.0

hourToTop = 5 * hour * 6.0 + min * 6.0 / 60
minToTop = min * 6

return abs value > 180 ?  360 - value : value

*/

class Solution {
    public double angleClock(int hour, int minutes) {
        double degreePerUnit = 360.0 / 60;
        double hourToTwelve = hour * 5 * degreePerUnit + degreePerUnit * minutes * 5 / 60;
        double minToTwelve = minutes * degreePerUnit;
        double value = Math.abs(minToTwelve - hourToTwelve);
        return value > 180 ? 360.0 - value : value;
    }
}