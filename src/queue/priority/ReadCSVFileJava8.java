package queue.priority;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCSVFileJava8 {

	public static void main(String[] args) {
		ReadCSVFileJava8 rf8 = new ReadCSVFileJava8();
		String[] files = {"dsp_streaming_report_us.csv", "dsp_streaming_report_uk.csv"};
		
		List<Track> tracks = rf8.csvToList(files);
		
		System.out.println("List Size:"+tracks.size());
		
		Collections.sort(tracks, new TrackComparator());
		
		for(int i =0; i< 5; i++) {
			System.out.println(tracks.get(i));
		}
		
		List<Track> top5 = tracks.stream().limit(5).collect(Collectors.toList());
		System.out.println(top5);

	}
	
	List<Track> csvToList(String[] files){
		List<Track> tracks = new ArrayList<>();
		try {
			for(String file: files) {
				InputStream is = new FileInputStream(new File(file));
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				List<Track> listOfTrack = br.lines()
						.skip(1)
						.map(TrackUtil::mapToTrack)
						.collect(Collectors.toList());
				/*String line;
				while((line = br.readLine()) != null) {
					if(!line.contains("ISRC")) {
						Track track = TrackUtil.mapToTrack(line);
						tracks.add(track);
					}
				}*/
				tracks.addAll(listOfTrack);
				br.close();
			}
		}catch(Exception e) {
			System.out.println("Exception:"+e);
		}
		return tracks;
	}

}
