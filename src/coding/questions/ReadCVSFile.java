package coding.questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReadCVSFile {
	
	private static int size = 0;
	private static int k = 5;
	private static PriorityQueue<Track> minHeap = new PriorityQueue<>(k);

	public static void main(String[] args) throws IOException {
		
		
	
		InputStream is = new FileInputStream(new File("dsp_streaming_report_us.csv"));
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String line;
		while((line = br.readLine()) != null) {
			if(!line.contains("ISRC")) {
				add(mapToTrack(line));
			}
		}
		
		br.close();
		System.out.println("Tracks:"+minHeap);
		
	}
	
	private static Track mapToTrack(String line) {
		System.out.println("Line: "+line);
		String[] p = line.split(";");
		return new Track(p[0], p[1], p[2], Integer.parseInt(p[3]), Float.parseFloat(p[4]), p[5]);
	}

	public static void add(Track track) {
		if(track != null) {
			if (size == k) {
				float min = minHeap.peek().getAMOUNT();
				
				if (track.getAMOUNT() > min) {
					minHeap.poll();
					minHeap.offer(track);
				}
			} else {
				minHeap.offer(track);
				size++;
			}
		}
		
	}
}

class Track implements Comparator<Track>{
	private String ISRC;
	private String TRACK_NAME;
	private String ARTIST_NAME;
	private int UNITS;
	private float AMOUNT;
	private String CURRENCY;
	public Track(String iSRC, String tRACK_NAME, String aRTIST_NAME, int uNITS, float aMOUNT, String cURRENCY) {
		ISRC = iSRC;
		TRACK_NAME = tRACK_NAME;
		ARTIST_NAME = aRTIST_NAME;
		UNITS = uNITS;
		AMOUNT = aMOUNT;
		CURRENCY = cURRENCY;
	}
	
	@Override
	public int compare(Track o1, Track o2) {
		if(o1.getAMOUNT()>o2.getAMOUNT()) return 1;
		else return -1;
	}
	
	public String getISRC() {
		return ISRC;
	}



	public void setISRC(String iSRC) {
		ISRC = iSRC;
	}



	public String getTRACK_NAME() {
		return TRACK_NAME;
	}



	public void setTRACK_NAME(String tRACK_NAME) {
		TRACK_NAME = tRACK_NAME;
	}



	public String getARTIST_NAME() {
		return ARTIST_NAME;
	}



	public void setARTIST_NAME(String aRTIST_NAME) {
		ARTIST_NAME = aRTIST_NAME;
	}



	public int getUNITS() {
		return UNITS;
	}



	public void setUNITS(int uNITS) {
		UNITS = uNITS;
	}



	public float getAMOUNT() {
		return AMOUNT;
	}



	public void setAMOUNT(float aMOUNT) {
		AMOUNT = aMOUNT;
	}



	public String getCURRENCY() {
		return CURRENCY;
	}



	public void setCURRENCY(String cURRENCY) {
		CURRENCY = cURRENCY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(AMOUNT);
		result = prime * result + ((ARTIST_NAME == null) ? 0 : ARTIST_NAME.hashCode());
		result = prime * result + ((CURRENCY == null) ? 0 : CURRENCY.hashCode());
		result = prime * result + ((ISRC == null) ? 0 : ISRC.hashCode());
		result = prime * result + ((TRACK_NAME == null) ? 0 : TRACK_NAME.hashCode());
		result = prime * result + UNITS;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		if (Float.floatToIntBits(AMOUNT) != Float.floatToIntBits(other.AMOUNT))
			return false;
		if (ARTIST_NAME == null) {
			if (other.ARTIST_NAME != null)
				return false;
		} else if (!ARTIST_NAME.equals(other.ARTIST_NAME))
			return false;
		if (CURRENCY == null) {
			if (other.CURRENCY != null)
				return false;
		} else if (!CURRENCY.equals(other.CURRENCY))
			return false;
		if (ISRC == null) {
			if (other.ISRC != null)
				return false;
		} else if (!ISRC.equals(other.ISRC))
			return false;
		if (TRACK_NAME == null) {
			if (other.TRACK_NAME != null)
				return false;
		} else if (!TRACK_NAME.equals(other.TRACK_NAME))
			return false;
		if (UNITS != other.UNITS)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [ISRC=" + ISRC + ", TRACK_NAME=" + TRACK_NAME + ", ARTIST_NAME=" + ARTIST_NAME + ", UNITS="
				+ UNITS + ", AMOUNT=" + AMOUNT + ", CURRENCY=" + CURRENCY + "]";
	}

}
