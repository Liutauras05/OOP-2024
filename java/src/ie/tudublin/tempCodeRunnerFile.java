case 1:
                for (int i = 0 ; i < 10 ; i ++)
                {
                    // Map the position to a hue value between 0 and 255
                    float hue = map(i, 0, width, 0, 255);
                    // Set the stroke color to the calculated hue value
                    stroke(hue, 255, 255);
                    // Draw a vertical line for each stripe
                    line(i, 0, i, height);
                }
                break;