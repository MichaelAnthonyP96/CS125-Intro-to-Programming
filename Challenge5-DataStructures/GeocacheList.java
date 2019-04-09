//UIUC CS125 SPRING 2017 MP. File: GeocacheList.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000
/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *@author mapope2
 * Hint: Get the Geocache class working and passing its tests first.
 */
public class GeocacheList {
	private Geocache[] data = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return data[i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		data = new Geocache[other.data.length];
		size = other.size;
		if (deepCopy) {
			for (int i=0;i<other.getSize();i++)
				this.data[i] = new Geocache(other.data[i]);
		}
		else {
			GeocacheList newlist = new GeocacheList();
			for (int i=0;i<other.getSize();i++)
				this.data[i] = other.data[i];
		}
	}

	public void add(Geocache p) {
		size++;
		if (size > data.length) {
			Geocache[] old = data;
			data = new Geocache[size * 2];
			for (int i = 0; i < old.length; i++)
				data[i] = old[i];
		}
		data[size-1] = p;
	}

	public Geocache removeFromTop() {
		return this.data[--this.size];
	}

	public String toString() {
		StringBuffer s = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				s.append(',');
			s.append(data[i]);
		}
		return s.toString();
}	}
