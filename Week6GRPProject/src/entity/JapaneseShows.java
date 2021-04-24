package entity;

public class JapaneseShows {
	private int jShowId;
	private String jShowName;
	private String animated;
	
	public JapaneseShows(int jShowId, String jShowName, String animated) {
		this.setShowId(jShowId);
		this.setjShowName(jShowName);
		this.setAnimated(animated);
	}

	public int getjShowId() {
		return jShowId;
	}

	public void setShowId(int jShowId) {
		this.jShowId = jShowId;
	}

	public String getjShowName() {
		return jShowName;
	}

	public void setjShowName(String jShowName) {
		this.jShowName = jShowName;
	}

	public String getAnimated() {
		return animated;
	}

	public void setAnimated(String animated) {
		this.animated = animated;
	}
	
}
