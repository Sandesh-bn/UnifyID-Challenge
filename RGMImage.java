package unifyd;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class RGBImage {
	 public static void main(String args[])throws Exception{
	     //Image dimension
	     int width = 128;
	     int height = 128;
	     //Create buffered image object img
	     BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	     //File object
	     File f = null;
	     
	     String s = getData("https://www.random.org/integers/?num=8192&min=1&max=256&col=1&base=10&format=plain&rnd=new");
	     String[] firstHalfValues = s.split("\n");
	     s = getData("https://www.random.org/integers/?num=8192&min=1&max=256&col=1&base=10&format=plain&rnd=new");
	     String[] secondHalfValues = s.split("\n");  
	     
	     int numberOfPixels = 128 * 128;
	     int firstArrayIndex = 0;
	     int secondArrayIndex = 0;
	     for(int y = 0; y < height; y++){
	       for(int x = 0; x < width; x++){
	    	 // Value for alpha, blue, green, red channel
	    	 int a = 0, b = 0, g = 0, r = 0;
	    	 if (firstArrayIndex < firstHalfValues.length - 4){
	    		 a = Integer.parseInt(firstHalfValues[firstArrayIndex]);
	    		 firstArrayIndex++;
	    		 r = Integer.parseInt(firstHalfValues[firstArrayIndex]);
	    		 firstArrayIndex++;
	    		 g = Integer.parseInt(firstHalfValues[firstArrayIndex]);
	    		 firstArrayIndex++;
	    		 b = Integer.parseInt(firstHalfValues[firstArrayIndex]);
	    		 firstArrayIndex++;
	    	 }
	    	 else if (secondArrayIndex < secondHalfValues.length - 4){
	    		 a = Integer.parseInt(secondHalfValues[secondArrayIndex]);
	    		 secondArrayIndex++;
	    		 r = Integer.parseInt(secondHalfValues[secondArrayIndex]);
	    		 secondArrayIndex++;
	    		 g = Integer.parseInt(secondHalfValues[secondArrayIndex]);
	    		 secondArrayIndex++;
	    		 b = Integer.parseInt(secondHalfValues[secondArrayIndex]);
	    		 secondArrayIndex++;
	    	 }
	    	 else {
	    		 a = (int)(Math.random()*256); 
	             r = (int)(Math.random()*256); 
	             g = (int)(Math.random()*256); 
	             b = (int)(Math.random()*256); 
	    	 }
	 
	         int p = (a<<24) | (r<<16) | (g<<8) | b; 
	         img.setRGB(x, y, p);
	       }
	     }
	     //Write image
	     try{
	       // Specify the path here.
	       f = new File("C:\\op\\rgb_image.png");
	       ImageIO.write(img, "png", f);
	     }catch(IOException e){
	       System.out.println("Error: " + e);
	     }
	     
	     System.out.println("Done");
	  }
	 /*
	  * Makes an api request to random.org and gets 1000 random numbers.
	  * If server responds with an error, it returns an equivalent string instead.
	  * @param String for the url.
	  * @return A String which has random numbers separated by newline character.
	  * 
	  */
	 private static String getData(String urlString) throws IOException  {
		    BufferedReader reader = null;
		    try {
		        URL url = new URL(urlString);
		        reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 

		        return buffer.toString();
		    }
		    catch(Exception e){
		    	StringBuilder numbers = new StringBuilder();
		    	for (int i = 0; i < 1000; i++){
		    		numbers.append((int)Math.random()*256);
		    		numbers.append("\n");
		    	}
		    	return numbers.toString();
		    }
		    finally {
		        if (reader != null)
		            reader.close();
		    }
		}
}
