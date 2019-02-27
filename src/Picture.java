import java.awt.image.BufferedImage;
//Img este o clasa abstracta ce contine definiea variabilelor ce corespund dimensiunilor clasei
//precum si un obiect BufferedImage pentru stocarea imaginii

public abstract class Picture {
	
	double width; //latimea imaginii
	double height; //inaltimea imaginii
	BufferedImage img; //obiectul imagine in sine
	
	public //metode publice de afisare, modificare si accesare dimensiuni (getter, setter)
	abstract void printWidth();
	abstract void printHeight();
	abstract double getWidth();
	abstract void setWidth(double wdt);
	abstract double getHeight();
	abstract void setHeight(double hgt);

	Picture(){ };//constructor fara parametri cu ajutorul caruia se vor construi obiecte de tipul claselor derivate	
	Picture(String y){ };//constructor cu parametu cale cu ajutorul caruia se vor construi obiecte de tipul claselor derivate	
	
	
}