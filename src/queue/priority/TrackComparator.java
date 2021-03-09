package queue.priority;

import java.util.Comparator;

public class TrackComparator implements Comparator<Track> {

	@Override
	public int compare(Track o1, Track o2) {
		if(o1.getAmount() < o2.getAmount()) return 1;
		else if(o1.getAmount() > o2.getAmount()) return -1;
		return 0;
	}

}
