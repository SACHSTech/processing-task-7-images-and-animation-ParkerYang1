import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	PImage imgBackground;
  PImage imgEagle; 
	
  float fltEagleX = 210;
  float fltEagleY = 250;

  float fltSunX = 500;
  float fltSunY = 0;

  float fltEagleXSpeed = 5;
  float fltEagleYSpeed = 5;

  float fltSunXSpeed = 1;
  float fltSunYSpeed = 1;

  float counter = 0;


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgEagle = loadImage("eagle2.png");
    
    imgBackground = loadImage("sky.jpeg");


    /**
     * resize eagle 
     * resize background
     */
    imgEagle.resize(imgEagle.width/4, imgEagle.height/4);
    
    imgBackground.resize(width, height);

  }
  
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    /**
     * draw sun and move
     * parabola motion 
     */
    if (counter == 0){
    fltSunX = fltSunX + fltSunXSpeed; 
    double quadratic; 
    quadratic = (0.0025 * (Math.pow(fltSunX, 2)) + -(1 * fltSunX) + 150);
    fltSunY= (float)quadratic;
    
    if(fltSunX == 525){
      fltSunX = 0;
      fltSunY = 500;
      }
    }
   
    /**
     * draw background
     */
    image(imgBackground, 0, 0);
    
    /** 
     * draw eagle and move
     * edge detection
     */
    image(imgEagle, fltEagleX, fltEagleY);
    fltEagleX += fltEagleXSpeed;
    fltEagleY += fltEagleYSpeed;
    
    if(fltEagleX < 0 || fltEagleX > 300){
      fltEagleXSpeed *= -1;
    }
    
    if(fltEagleY < 0 || fltEagleY > 300){
      fltEagleYSpeed *= -1;
    }
    
    fill(245, 245, 66);
    ellipse(fltSunX, fltSunY, 50, 50);
  }
}
  // define other methods down here.
