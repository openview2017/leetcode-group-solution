package ObjectOrientedDesign.Elevator;

import java.util.*;

public class Elevator {
    public int currentLevel;
    public Direction direction;
   // private Status status;
    private List<Boolean> upStops;
    private List<Boolean> downStops;

    // constructor
    public Elevator(int n) {

        upStops = new ArrayList<Boolean>();
		downStops = new ArrayList<Boolean>();
		currentLevel = 0;
		direction = Direction.IDLE;

        for(int i = 0; i < n; i++) {
			upStops.add(false);
			downStops.add(false);
		}
    }

    public void handleExternalRequest(ExternalRequest externalRequest) {
        if (externalRequest.getDirection() == Direction.UP) {
            upStops.set(externalRequest.getLevel() - 1, true);
            if (noRequests(downStops)) {
                direction = Direction.UP;
            }
        } else {
            downStops.set(externalRequest.getLevel() - 1, true);
            if (noRequests(upStops)) {
                direction = Direction.DOWN;
            }
        }
    }

    public void handleInternalRequest(InternalRequest internalRequest) {
        // check valid
        if (direction == Direction.UP) {
            if (internalRequest.getLevel() >= currentLevel + 1) {
                upStops.set(internalRequest.getLevel() - 1, true);
            }
        } else if (direction == Direction.DOWN) {
            if (internalRequest.getLevel() <= currentLevel + 1) {
                downStops.set(internalRequest.getLevel() - 1, true);
            }
        }
    }
    private boolean noRequests(List<Boolean> stops)
	{
		for(int i = 0; i < stops.size(); i++)
		{
			if(stops.get(i))
			{
				return false;
			}
		}
		return true;
	}

    public void run() {
        // 走一步,到了之后开门
        if (direction == Direction.UP) {
            for (int i = 0; i < upStops.size(); i++) {
                int checkLevel = (currentLevel + i) % upStops.size();
                if (upStops.get(checkLevel)) {
                    currentLevel = checkLevel;
                    upStops.set(checkLevel, false);
                    break;
                }
            }
        } else if (direction == Direction.DOWN) {
            for (int i = 0; i < downStops.size(); i++) {
                int checkLevel = (currentLevel + downStops.size() - i) % downStops.size();
                if (downStops.get(checkLevel)) {
                    currentLevel = checkLevel;
                    downStops.set(checkLevel, false);
                    break;
                }
            }
        }
    }
    public void closeDoor() {
        // 在close door之前，可以又加入新的request
		if(direction == Direction.IDLE) {
			if(noRequests(downStops)) {
				direction = Direction.UP;
				return;
			}
			if(noRequests(upStops)) {
				direction = Direction.DOWN;
				return;
			}
		}
		else if(direction == Direction.UP)
		{
			if(noRequests(upStops))
			{
				if(noRequests(downStops))
				{
					direction = Direction.IDLE;
				}
				else direction = Direction.DOWN;
			}
		}
		else {
			if(noRequests(downStops))
			{
				if(noRequests(upStops))
				{
					direction = Direction.IDLE;
				}
				else direction = Direction.UP;
			}
		}
	}
}
