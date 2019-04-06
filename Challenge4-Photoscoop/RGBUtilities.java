//UIUC CS125 SPRING 2017 MP. File: RGBUtilities.java, CS125 Project: Challenge4-Photoscoop, Version: 2017-02-28T16:51:16-0600.709551000
/* Manipulates RGB values
 * 
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author mapope2
 */

public class RGBUtilities {

/**
 * Extracts the red component (0..255)
 * Hint: see ch13.1.2 Working With Pixels 
 * http://math.hws.edu/javanotes/c13/s1.html#GUI2.1.2
 * 
 * ... also see the notes in READ-ME-FIRST
 * 
 * @param rgb the encoded color int
 * @return the red component (0..255)
 */
	public static int toRed(int rgb) {
		int red = (rgb >> 16) & 0xFF; // FIX ME
		return red;
	}

	public static int toGreen(int rgb) {
		int green = (rgb >> 8) & 0xFF; // FIX THIS
		return green;
	}

	public static int toBlue(int rgb) {
		int blue = rgb & 0xFF; // FIX THIS
		return blue;
	}

	/**
	 * 
	 * @param r the red component (0..255)
	 * @param g the green component (0..255)
	 * @param b the blue component (0..255)
	 * @return a single integer representation the rgb color (8 bits per component) rrggbb
	 */
	static int toRGB(int r, int g, int b) {
		r = (r << 16); // FIX THIS
		g = (g << 8);
		b = (b);
		return r+g+b;
	}

}
