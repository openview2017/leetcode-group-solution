# Channel Quality
**reference link**: (https://leetcode.com/discuss/interview-question/1633362/Amazon-OA-or-Channel-Quality)

A large cloud provider provides fast efficient server solutions. The developers want to sttress-test the quality of the server's channels. They must ensure the following:

- Each of the packets must be sent via a single channel.
- Each of the channels must transfer at least one packet.
The quality of the transfer for a channel is defined by the median of the sizes of all the data packets sent through that channel.

**Note**: The median of an array is the middle element if the array is sorted in non-decreasing order. If the number of elements in the array is even, the median is the average of the twwo middle elements.

Find the maximum possible sum of the qualities of all channels. If the answer is a floating-point value, round it to the next higher integer.

**Example**
packets = [1, 2, 3. 4, 5]
channels = 2

At least one packet has to go though each of the 2 channels. One maximal solution is to transfer packets {1, 2, 3, 4} throuigh channel 1 and packet {5} through channel 2.

           [1] [2] [3] [4]
Channel 1

                        [5]
Channel 2

**Function Description**
Complete the function maximum_quality.

maximum_quality has the following parameters:

int packets[n]L the packet sizes
int channels: the number of channels
Returns
long int: the maximum sum possible

**Constraints**

1 <= len(packets) <= 5 * 10^5
1 <= packets[i] <= 10^9
1 <= channels <= len(packets)
Sample Test Case 0
packets[] size n = 5
packets = [2, 2, 1, 5, 3]
channels = 2

**Sample Output**
7

Explanation
One solution is to send packet {5} through one channel and {2, 2, 1, 3} through the other. The sum of qquality is 5 + (2+2)/2 = 7

Sample Test Case 1
packets[] size n = 5
packets = [1, 2, 3, 4. 5]
channels = 2

**Sample Output**
8

Explanation
*One maximal solution is to transfer packets [1,2,3,4] through channel 1 and packet [5] through channel 2. The quality of transfer for channel 1 is (2+3)/2=2.5 and that of channel 2 is 5. Their sum is 2.5+5 =7.5 which is round up to 8.
*

**Sample Test Case 2**
packets[] size n = 3
packets = [89, 48, 14]
channels = 2

**Sample Output**
151

**Explanation**
There are 3 channels for each 3 packets. Each channel carries one, so the overall sum of quantity is 89+48+14=151

**Sample Test Case 3**
packets[] size n = 1
packets = [1]
channels = 1

**Sample Output**
1

**Explanation**
There is only 1 channel and only 1 packet so output is 1