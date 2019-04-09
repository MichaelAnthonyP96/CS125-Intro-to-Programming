//UIUC CS125 SPRING 2017 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2017-03-07T20:15:59-0600.396489000
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map

	/**
	 * @author mapope2
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 */
	private Color[] color = new Color[0];
	private String[] key1 = new String[0];
	
	public void add(String key, Color value) {
		Color[] newColor = new Color[color.length + 1];
		String[] newString = new String[key1.length + 1];
		for (int i=0;i<color.length;i++) {
			newColor[i]=color[i];
			newString[i]=key1[i];
		}
		newColor[newColor.length - 1]=value;
		newString[newString.length - 1]=key;
		color = newColor;
		key1 = newString;
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		int index = -1;
		for (int i=0;i<key1.length;i++) {
			if (key1[i] != null && key1[i].equals(key)) {
				index = i;
			}
		}
		if (index == -1)
			return null;
		else 
			return color[index];
	}

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		int index = -1;
		for (int i=0;i<key1.length;i++) {
			if (key1[i].equals(key)) {
				index = i;
			}
		}
		if (index != -1)
			return true;
		else 
			return false;
		
	}

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		Color[] newColor = new Color[color.length -1];
		String[] newString = new String[key1.length -1];
		int index = -1;
		for (int i=0;i<key1.length;i++) {
			if (key1[i].equals(key))
				index = i;
		}
		if (index == -1)
			return;
		else {
			for (int j=0;j<color.length;j++) {
				if (j<index)
					newColor[j]=color[j];
				else if (j>index)
					newColor[j-1]=color[j];
			}
			for (int y=0;y<key1.length;y++) {
				if (y<index)
					newString[y]=key1[y];
				else if (y>index)
					newString[y-1]=key1[y];
			}
		}
		color = newColor;
		key1 = newString;
	}

}
