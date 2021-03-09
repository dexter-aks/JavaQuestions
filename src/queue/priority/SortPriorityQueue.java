package queue.priority;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class SortPriorityQueue {
	
	PriorityQueue<Track> heap;
	
	public SortPriorityQueue() {
		heap = new PriorityQueue<>(new TrackComparator());
	}

	public static void main(String[] args) {
		SortPriorityQueue spq = new SortPriorityQueue();
		List<Track> tracks = TrackUtil.formTrackList();
		for(Track track: tracks) {
			spq.add(track);
		}
		System.out.println("PQ:\n"+spq.heap.size());
		
		Iterator<Track> it = spq.heap.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}
	
	public void add(Track track) {
//		System.out.println(track);
		if (heap.size() == 4) {
			double min = heap.peek().getAmount();
			if (track.getAmount() > min) {
				heap.poll();
				heap.offer(track);
			}
		} else {
			heap.offer(track);
		}
	}

}
