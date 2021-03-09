package queue.priority;

public class Track {
	
	private String isrc;
	private String trackName;
	private String artistName;
	private double amount;
	
	public Track(String isrc, String trackName, String artistName, double amount) {
		super();
		this.isrc = isrc;
		this.trackName = trackName;
		this.artistName = artistName;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((artistName == null) ? 0 : artistName.hashCode());
		result = prime * result + ((isrc == null) ? 0 : isrc.hashCode());
		result = prime * result + ((trackName == null) ? 0 : trackName.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (artistName == null) {
			if (other.artistName != null)
				return false;
		} else if (!artistName.equals(other.artistName))
			return false;
		if (isrc == null) {
			if (other.isrc != null)
				return false;
		} else if (!isrc.equals(other.isrc))
			return false;
		if (trackName == null) {
			if (other.trackName != null)
				return false;
		} else if (!trackName.equals(other.trackName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Track [isrc=" + isrc + ", trackName=" + trackName + ", artistName=" + artistName + ", amount=" + amount
				+ "]\n";
	}
}
