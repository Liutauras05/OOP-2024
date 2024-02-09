package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class MultiSensoryFoLoopExperience extends PApplet {

    int mode = 0;
    float[] starX, starY, starTwinkleRate;
    int numStars = 100;

    Minim minim;
    AudioOutput out;

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        colorMode(HSB);
        starX = new float[numStars];
        starY = new float[numStars];
        starTwinkleRate = new float[numStars];

        for (int i = 0; i < numStars; i++) {
            starX[i] = random(width);
            starY[i] = random(height);
            starTwinkleRate[i] = random(0.05f, 0.1f); 

        }
    }

    public void draw()
    {
        background(0);
        stroke(255);
        switch(mode)
        {
            case 0:
                line(0, 0, width, height);
                float angleStep = TWO_PI / 36; 
                for (float angle = 0; angle < TWO_PI; angle += angleStep) {
                    float lineLength = dist(mouseX, mouseY, width / 2, height / 2) / 2; 
                    float endX = mouseX + cos(angle) * lineLength;
                    float endY = mouseY + sin(angle) * lineLength;

                    stroke(angle * (255 / TWO_PI), 255, 255);

                    line(mouseX, mouseY, endX, endY);
                }
                break;
            case 1:
                for (int i = 0 ; i < 10 ; i ++)
                {

                    int numberOfStripes = 10; 
                    float stripeWidth = width / (float) numberOfStripes; 

                    for (int j = 0; j < numberOfStripes; j++) {
                        float hue = map(j, 0, numberOfStripes - 1, 0, 255);
                        fill(hue, 255, 255);
                        rect(j * stripeWidth, 0, stripeWidth, height);
                    }
                
                }
                break;
            
            case 2: 
                int sides = 6; 
                float radius = 200; 
                float angleOffset = TWO_PI / sides; 

            beginShape();
                for (int i = 0; i < sides; i++) {
                float angle = angleOffset * i;
                float x = width / 2 + cos(angle) * radius;
                float y = height / 2 + sin(angle) * radius;
                vertex(x, y);
            }
            endShape(CLOSE); 
            break;

            case 3:
                int numCircles = 10; 
                float maxRadius = min(width, height) * 0.4f; 

                for (int i = numCircles; i > 0; i--) {
                    float radius1 = maxRadius * (i / (float)numCircles);
                    float distanceToMouse = dist(mouseX, mouseY, width / 2, height / 2);
                    float brightness = map(distanceToMouse, 0, width / 2, 255, 0);

                    fill(i * (255 / numCircles), 255, brightness);

                    ellipse(width / 2, height / 2, radius1 * 2, radius1 * 2);
                }
                break;

            case 4:
                for (int i = 0; i < numStars; i++) {
                    float twinkle = map(noise(millis() * starTwinkleRate[i]), 0, 1, 0, 255);
                    stroke(twinkle);
                    point(starX[i], starY[i]);
            }
            break;


            default:
                // Code goes here
                break;
        }
    }

    public void keyPressed()
    {
        
        if (key >= '0' && key <= '9')
        {
            mode = key - '0';
        }
    }
    
}




    




    

