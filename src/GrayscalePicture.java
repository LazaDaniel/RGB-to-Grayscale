import java.awt.Color;
import java.awt.image.BufferedImage;
//GreyScaleImage este o clasa folosita doar pentru conversia imaginii in alb-negru.
public class GrayscalePicture implements GrayscaleConverter { 
	
	RealPicture cimg; //contine un obiect de tipul RealPicture, care reprezinta imaginea ce va fi convertita, realizeaza agregarea
	double grayscaleHeight; 
	double grayscaleWidth;
	BufferedImage grayscaleImage; //ceilalti 3 parametri definesc caracteristicile rezultatului - dimensiunile si imaginea convertita propriu-zisa
	
	GrayscalePicture() throws InterruptedException { //constructor fara parametri - apeleaza constructorul RealPicturemage

		cimg = new RealPicture();
	}
	GrayscalePicture(String y) throws InterruptedException { //constructor fara parametri - apeleaza constructorul RealPicture

		//cimg = new RealPicture(y);
	}
	
	public BufferedImage ConvertToGreyscale() throws InterruptedException //metoda ce va realiza conversia alb-negru
	
	{
		long startTime = System.nanoTime();
		
		String filePath = cimg.ReadFile(); //se citeste numele fisierului prin intermediul metodei ReadFile() din clasa RealPicture
		cimg.ReadFromFile(filePath); //se citeste dn fisier imaginea in atributul de tip BUfferedImage al lui imgobj
		grayscaleImage = cimg.img; //pixelii acesteia vo fi resetati prin metoda de conversie
		grayscaleHeight = cimg.height; //dorim ca dimensiunile imaginii convertite sa fie aceleasi cu ale imaginii originale
		grayscaleWidth = cimg.width;
		
		for(int i = 0; i < grayscaleHeight; i++){
	         
            for(int j = 0; j < grayscaleWidth; j++){
            
               Color c = new Color(cimg.img.getRGB(j, i)); //fiecare culoare a imaginii este descompusa in valorile RGB componente
               int red = (int)(c.getRed());
               int green = (int)(c.getGreen());
               int blue = (int)(c.getBlue());
               Color newColor = new Color((red+green+blue)/3, 
               (red+green+blue)/3, (red+green+blue)/3); //iar noua culoare va fi cea obtinuta in urma conversiei fiecarei componente RGB. metoda folosita pentru conversie este media aritmetica
               
               grayscaleImage.setRGB(j,i,newColor.getRGB()); //pixelul respectiv ia valoarea nou calculata
            }		
		}
		
		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //se calculeaza timpul de executie al metodei
		System.out.println("Tmp de executie: conversie alb-negru: " + totalTime/1000000000 + " secunde");
		
		return grayscaleImage;	
	}
	
	
	
	
public BufferedImage ConvertToGreyscale(String y) throws InterruptedException //metoda ce va realiza conversia alb-negru
	
	{
		long startTime = System.nanoTime();
		
		 
		cimg.ReadFromFile(y); 
		grayscaleImage = cimg.img; //pixelii acesteia vo fi resetati prin metoda de conversie
		grayscaleHeight = cimg.height; //dorim ca dimensiunile imaginii convertite sa fie aceleasi cu ale imaginii originale
		grayscaleWidth = cimg.width;
		
		for(int i = 0; i < grayscaleHeight; i++){
	         
            for(int j = 0; j < grayscaleWidth; j++){
            
               Color c = new Color(cimg.img.getRGB(j, i)); //fiecare culoare a imaginii este descompusa in valorile RGB componente
               int red = (int)(c.getRed());
               int green = (int)(c.getGreen());
               int blue = (int)(c.getBlue());
               Color newColor = new Color((red+green+blue)/3, 
               (red+green+blue)/3, (red+green+blue)/3); //iar noua culoare va fi cea obtinuta in urma conversiei fiecarei componente RGB. metoda folosita pentru conversie este media aritmetica
               
               grayscaleImage.setRGB(j,i,newColor.getRGB()); //pixelul respectiv ia valoarea nou calculata
            }		
		}
		
		long endTime   = System.nanoTime();
		double totalTime = endTime - startTime; //se calculeaza timpul de executie al metodei
		System.out.println("Tmp de executie: conversie alb-negru: " + totalTime/1000000000 + " secunde");
		
		return grayscaleImage;	
	}
	
	
	
}
