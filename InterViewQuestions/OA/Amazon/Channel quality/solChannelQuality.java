import java.util.*;

public class solChannelQuality { // ???
    public static void main(String[] args) {
        ChannelQuality sol = new ChannelQuality();
        int[] packets;
        int channels;
        double res;

        packets = new int[]{1, 2, 3, 4, 5};
        channels = 2;
        res = sol.calcQuality(packets, channels);
        System.out.println(res);
    }
}


class ChannelQuality {
    public double calcQuality(int[] packets, int channels) {
        Arrays.sort(packets);
        return dfs(packets, 0, channels);
    }

    private double dfs(int[] packets, int index, int channelsLeft) { // [index, length) >= left
        if (channelsLeft == 1) {
            return getMedian(packets, index, packets.length - 1);
        }
        if (packets.length - index == channelsLeft) {
            double sum = 0;
            for (int i = index; i < packets.length; i++) {
                sum += packets[i];
            }
            return sum;
        }        
        double maxSum = 0.0;
        for (int i = index + 1; i <= packets.length - channelsLeft && i < packets.length; i++) { // [i, len) >= left-1; len - i >= left-1
            maxSum = Math.max(maxSum, getMedian(packets, index, i-1) + dfs(packets, i, channelsLeft-1));
        }
        return maxSum;
    }

    private double getMedian(int[] packets, int left, int right) {
        if ((right - left + 1) % 2 != 0) {
            return packets[left + (right - left + 1) / 2];
        }
        return (double) (packets[left + (right - left + 1) / 2] + packets[left + (right - left + 1) / 2 + 1]) / 2.0;
    }
}