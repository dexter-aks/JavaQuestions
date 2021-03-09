package queue.priority;

import java.util.ArrayList;
import java.util.List;

public class TrackUtil {
	
	public static List<Track> formTrackList(){
		Track t1 = new Track("65037E030309", "Thriller", "The Slits", getTotalEuroAmount(3, 0.91, "USD"));
		Track t2 = new Track("Z349S33869V0", "Backstreet's Back", "George Michael", getTotalEuroAmount(5, 0.70, "USD"));
		Track t3 = new Track("4364W633B3P5", "Gold: Greatest Hits", "Michael Jackson", getTotalEuroAmount(1, 0.63, "USD"));
		Track t4 = new Track("65037E030301", "X Thriller", "X The Slits", getTotalEuroAmount(3, 0.91, "USD"));
		Track t5 = new Track("Z349S33869V2", "Y Backstreet's Back", "Y George Michael", getTotalEuroAmount(5, 0.70, "USD"));
		Track t6 = new Track("4364W633B3P3", "Z Gold: Greatest Hits", "Z Michael Jackson", getTotalEuroAmount(1, 0.63, "USD"));
		Track t7 = new Track("65037E030304", "A Thriller", "A The Slits", getTotalEuroAmount(3, 0.91, "USD"));
		Track t8 = new Track("65037E030305", "B Thriller", "B The Slits", getTotalEuroAmount(3, 0.91, "USD"));
		Track t9 = new Track("65037E030306", "C Thriller", "C The Slits", getTotalEuroAmount(3, 0.91, "USD"));
		
		List<Track> tracks = new ArrayList<>();
		
		tracks.add(t8);
		tracks.add(t7);
		tracks.add(t9);
		tracks.add(t3);
		tracks.add(t1);
		tracks.add(t4);
		tracks.add(t5);
		tracks.add(t6);
		tracks.add(t2);
		
		
		return tracks;
	}
	
	public static Track mapToTrack(String line) {
		String[] p = line.split(";");
		Track track = new Track(p[0], p[1], p[2], getTotalEuroAmount(Integer.parseInt(p[3]), Double.parseDouble(p[4]), p[5]));
		return track;
	}
	
	private static double getTotalEuroAmount(int units, double amount, String currency) {
		if(currency.equalsIgnoreCase("USD")) {
			return units * amount * 0.85;
		}else if(currency.equalsIgnoreCase("GBP")) {
			return units * amount * 1.11;
		}else {
			return units * amount;
		}
	}

}
