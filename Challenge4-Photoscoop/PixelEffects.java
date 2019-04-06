//UIUC CS125 SPRING 2017 MP. File: PixelEffects.java, CS125 Project: Challenge4-Photoscoop, Version: 2017-02-28T16:51:16-0600.709551000

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author mapope2
 */
public class PixelEffects {

	/** Copies the source image to a new 2D integer image */
	public static int[][] copy(int[][] source) {
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		int width = source.length, height = source[0].length;
		int[][] copy = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				copy[i][j] = source[i][j];// Fix Me
			}
		return copy;
	}
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		int srcW = source.length;
		int srcH = source[0].length;
		int[][] tgt = new int[newWidth][newHeight];
		for (int tgtX = 0; tgtX < newWidth; tgtX++)
			for (int tgtY = 0; tgtY < newHeight; tgtY++) {
				int srcY = (int)((tgtY/(double)newHeight)*srcH);
				int srcX = (int)((tgtX/(double)newWidth)*srcW);
				tgt[tgtX][tgtY] = source[srcX][srcY];
			}
		return tgt;
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	public static int[][] half(int[][] source) {
		return resize(source, source.length/2, (source[0].length)/2); 
	}
	
	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[][] resize(int[][] source, int[][] reference) {
		return resize(source, reference.length, reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[][] flip(int[][] source) {
		int srcW = source.length;// Fix Me
		int srcH = source[0].length;
		int tgtW = srcW;
		int tgtH = srcH;
		int [][] tgt = new int[tgtW][tgtH];
		for (int tgtX=0; tgtX<tgtW; tgtX++)
			for (int tgtY=0; tgtY<tgtH; tgtY++) {
				int srcY = (tgtH-tgtY-1);
				int srcX = tgtX;
				tgt[tgtX][tgtY] = source[srcX][srcY];
			}
		return tgt;
	}

	/** Reverse the image horizontally */
	public static int[][] mirror(int[][] source) {
		int srcW = source.length;// Fix Me
		int srcH = source[0].length;
		int tgtW = srcW;
		int tgtH = srcH;
		int [][] tgt = new int[tgtW][tgtH];
		for (int tgtX=0; tgtX<tgtW; tgtX++)
			for (int tgtY=0; tgtY<tgtH; tgtY++) {
				int srcY = tgtY;
				int srcX = (tgtW-tgtX-1);
				tgt[tgtX][tgtY] = source[srcX][srcY];
			}
		return tgt;
	}

	/** Rotate the image */
	public static int[][] rotateLeft(int[][] source) {
		int srcH = source.length;
		int srcW = source[0].length;
		int tgtW = srcW;
		int tgtH = srcH;
		int[][] tgt = new int[tgtW][tgtH];
		for (int tgtX=0; tgtX < tgtW; tgtX++){
			for (int tgtY = 0; tgtY < tgtH; tgtY++){	
				int srcX = source.length - tgtY -1;
				int srcY = tgtX;
				tgt[tgtX][tgtY] = source[srcX][srcY];
			}
		}
		return tgt;
	}

	/** Merge the red,blue,green components from two images */
	public static int[][] merge(int[][] sourceA, int[][] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel ofthe background).
		int width = sourceA.length;
		int height = sourceA[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgbA = sourceA[i][j];
				int redA = RGBUtilities.toRed(rgbA);
				int greenA = RGBUtilities.toGreen(rgbA);
				int blueA = RGBUtilities.toBlue(rgbA);
				int rgbB = sourceB[i][j];
				int redB = RGBUtilities.toRed(rgbB);
				int greenB = RGBUtilities.toGreen(rgbB);
				int blueB = RGBUtilities.toBlue(rgbB);
				int red = (redA + redB)/2;
				if (red > 255)
					red = 255;
				int green = (greenA + greenB)/2;
				if (green > 255)
					green = 255;
				int blue = (blueA + blueB)/2;
				if (blue > 255)
					blue = 255;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		}	
		return result;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		if ((foreImage.length != backImage.length) || (foreImage[0].length != backImage[0].length))
			foreImage = resize(foreImage, backImage.length, backImage[0].length);
		int newImage[][] = new int[foreImage.length][foreImage[0].length];
		for (int i = 0; i<foreImage.length;i++) {
			for (int j = 0; j<foreImage[0].length;j++) {
				newImage[i][j] = foreImage[i][j];
			}
		}
		for (int i = 0; i <newImage.length; i++) {
			for (int j = 0; j < newImage[0].length; j++) {
				int rgb = newImage[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (green > (red + blue))
					newImage[i][j] = backImage[i][j];
				else if ((green > 100) && (blue < 100))
					newImage[i][j] = backImage[i][j];
				else if (green>Math.max(blue, red))
					newImage[i][j] = backImage[i][j];
				else if (green > blue)
					newImage[i][j] = backImage[i][j];
			}
		}	
		
		return newImage;
	}

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[][] redeye(int[][] source, int[][] sourceB) {

		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[][] funky(int[][] source, int[][] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		int width = source.length, height = source[0].length;
		int[][] result = new int[width][height];
		for (int i =0;i<source.length;i++) {
			for (int j = 0; j<source[0].length;j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				red = 255 - red;
				green = 255 - green;
				blue = 255 - blue;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		}
		return result;
	}
}
