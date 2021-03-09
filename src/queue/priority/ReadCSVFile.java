package queue.priority;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCSVFile {

	public static void main(String[] args) {
		
		try{
			List<Track> tracks = new ArrayList<>();
			
			InputStream is = new FileInputStream(new File("dsp_streaming_report_us.csv"));
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int k = 5;
			String line;
			while((line = br.readLine()) != null) {
				if(!line.contains("ISRC")) {
					Track track = TrackUtil.mapToTrack(line);
					double amount = track.getAmount();
					if(tracks.size() == k) {
						Collections.sort(tracks, new TrackComparator());
						double currMin = tracks.get(k-1).getAmount();
						if(amount > currMin) {
							tracks.remove(k-1);
							tracks.add(track);
						}
					}else {
						tracks.add(track);
					}
				}	
			}
			
			br.close();
			
			System.out.println("List Size:"+tracks.size());
			
//			Collections.sort(tracks, new TrackComparator());
			
//			for(int i =0; i< 5; i++) {
//				System.out.println(tracks.get(i));
//			}
			System.out.println(tracks);
			
		}catch(Exception e) {
			
		}
	}
}
