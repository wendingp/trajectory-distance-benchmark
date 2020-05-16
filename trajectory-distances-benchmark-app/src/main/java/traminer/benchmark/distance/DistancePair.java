package traminer.benchmark.distance;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Object to store the distance between a pair of trajectories.
 *
 * @author douglasapeixoto
 */
@SuppressWarnings("serial")
public class DistancePair implements Serializable {
    private final String tid1;
    private final String tid2;
    private final double distance;

    /**
     * @param tid1     Trajectory 1 ID
     * @param tid2     Trajectory 2 ID
     * @param distance Distance between T1 and T2
     */
    public DistancePair(String tid1, String tid2, double distance) {
        this.tid1 = tid1;
        this.tid2 = tid2;
        this.distance = distance;
    }

    /**
     * @return ID of trajectory 1.
     */
    public String getTrajectory1ID() {
        return tid1;
    }

    /**
     * @return ID of trajectory 2.
     */
    public String getTrajectory2ID() {
        return tid2;
    }

    /**
     * @return Distance between T1 and T2.
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return tid1 + "," + tid2 + "," + distance;
    }

    /**
     * Compare a pair of trajectory distances by the ID of the first trajectory.
     */
    public static final Comparator<DistancePair> id1Comparator = Comparator.comparing(o -> o.tid1);

    /**
     * Compare a pair of trajectory distances by the ID of the sacond trajectory.
     */
    public static final Comparator<DistancePair> id2Comparator = Comparator.comparing(o -> o.tid2);

    /**
     * Compare a pair of trajectory distances by distance.
     */
    public static final Comparator<DistancePair> distanceComparator = (o1, o2) -> {
        if (o1.distance < o2.distance) {
            return -1;
        } else if (o1.distance > o2.distance) {
            return 1;
        }
        return 0;
    };
}
