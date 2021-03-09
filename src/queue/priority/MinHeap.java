package queue.priority;

import java.util.PriorityQueue;

public class MinHeap {
	
	private int k;
	private double min = 0;
	private PriorityQueue<Track> minHeap;
	
	public MinHeap(int k) {
		this.k = k;
		minHeap = new PriorityQueue<>(new TrackComparator());
	}
	
	public Track add(Track track) {
		if(minHeap.size() == 0) min = track.getAmount();
		if (minHeap.size() == k) {
			min = Math.min(min, track.getAmount());
			if (track.getAmount() > min) {
				minHeap.poll();
				minHeap.offer(track);
			}
		} else {
			minHeap.offer(track);
		}
		return minHeap.peek();
	}
	
	
	
}
