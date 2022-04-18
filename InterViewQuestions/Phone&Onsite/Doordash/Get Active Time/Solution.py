# Given a sequence of timestamps & actions of a dasher's activity within a day, we would like to know the 
# active time of the dasher. Idle time is defined as the dasher has NO delivery at hand. (That means all 
# items have been dropped off at this moment and the dasher is just waiting for another pickup) Active time equals
# total time minus idle time.

# Ref: https://leetcode.com/discuss/interview-question/1302606/DoorDash-onsite-interview-(new-question!)



def get_active_time(activity):
    pickups = []
    dropoffs = []
    smallest_pickup = float('inf')
    highest_dropoff = float('-inf')

    for a in activity:
        a = a.split('|')
        a_type = a[1].strip()
        a_mins = get_mins(a[0].strip())

        if a_type == 'pickup':
            pickups.append(a_mins)
            smallest_pickup = min(smallest_pickup, a_mins)
        else:
            dropoffs.append(a_mins)
            highest_dropoff = max(highest_dropoff, a_mins)

    interval = []
    for p, d in zip(pickups, dropoffs):
        interval.append([p, d])

    total_time = highest_dropoff - smallest_pickup
    idle_time = 0
    for idx in range(len(interval) - 1):
        curr = interval[idx]
        nxt = interval[idx + 1]

        if curr[1] < nxt[0]:
            idle_time += nxt[0] - curr[1]
        else:
            nxt[1] = max(nxt[1], curr[1])

    return total_time - idle_time


def get_mins(t):
    t = t.split(':')
    hrs = int(t[0])
    mins = int(t[1][:-2])
    if t[1][-2:] == 'pm':
        if hrs < 12:
            hrs += 12
    else:
        if hrs == 12:
            hrs = 0

    return 60*hrs + mins


if __name__ == '__main__':
    activity = [
        '8:30am | pickup',
        '9:10am | dropoff',
        '10:20am| pickup',
        '12:15pm| pickup',
        '12:45pm| dropoff',
        '2:25pm | dropoff',
    ]

    idle_time = get_active_time(activity)

    print(idle_time)