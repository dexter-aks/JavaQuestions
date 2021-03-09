package queue.priority;

import java.util.List;
import java.util.TreeSet;

public class SortTreeSet {

	TreeSet<Track> ts;
	
	public SortTreeSet() {
		ts = new TreeSet<>(new TrackComparator());
	}
	public static void main(String[] args) {
		SortTreeSet sts = new SortTreeSet();
		List<Track> tracks = TrackUtil.formTrackList();
		for(Track track: tracks) {
			sts.ts.add(track);
		}
		System.out.println("TreeSet:\n"+sts.ts);
	}
	
	void add(Track track) {
		if(ts.size() == 5) {
			double min = ts.last().getAmount();
			if(track.getAmount() > min) {
				ts.remove(ts.last());
				ts.add(track);
			}
		}else {
			ts.add(track);
		}
	}

}
