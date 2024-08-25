# 2DGame-java
A 2d game made from scratch in Java with the help of the course of RyiSnow on youtube.

- I will not use any external library, everything will be made from scratch.

## How a game works?
In 2D games, we have a screen that is updated every frame. The screen is composed of pixels, and each pixel has a color. The screen is updated every frame, and the pixels are updated according to the game logic.

One example: A game that runs at 60 FPS (Frames per second) updates the screen 60 times per second. If a character moves 10 pixels per second, each frame it will move 10/60 pixels.

## Game loop
The game loop is a loop that runs the game. It is responsible for updating the game logic and rendering the screen. The game loop runs at a fixed rate, and it is responsible for updating the game logic and rendering the screen.

The game loop is composed of three parts:
1. Update the game logic
2. Render the screen
3. Sleep for a fixed amount of time

And this is repeated until the game is closed.

Example of a game loop:
```java
    public void run(){
        double drawInterval = 1000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
```
The <b>run</b> method implements the main game loop using the "Fixed Time Step" technique. Here is a detailed explanation of each part of the method:

1. <b>Variable Initialization:</b>  
```java
double drawInterval = 1000000000.0 / FPS;
double delta = 0;
long lastTime = System.nanoTime();
long currentTime;
```
- <b>drawInterval</b>: Defines the time interval between each frame, calculated as 1 second (in nanoseconds) divided by the number of frames per second (FPS).
- <b>delta</b>: Accumulates the elapsed time to determine when to update and render the next frame.
- <b>lastTime</b>: tores the time in nanoseconds of the last loop iteration.
- <b>currentTime</b>: Stores the current time in nanoseconds. 

2. <b>Main Game Loop:</b>

```java
while (gameThread != null) {
currentTime = System.nanoTime();

    delta += (currentTime - lastTime) / drawInterval;
    lastTime = currentTime;

    if (delta >= 1) {
        update();
        repaint();
        delta--;
    }
}
```
- <b>currentTime = System.nanoTime()</b>: Updates the current time.
- <b>delta += (currentTime - lastTime) / drawInterval</b>: Calculates the elapsed time since the last iteration and adds it to delta.
- <b>lastTime = currentTime</b>: Updates lastTime to the current time.
- <b>if (delta >= 1)</b>: Checks if delta has accumulated enough time for a frame.
- <b>update()</b>: Updates the game logic (player position, etc.).
- <b>repaint()</b>: Redraws the game screen.
- <b>delta--</b>: Decrements delta to indicate that a frame has been processed.

This method ensures that the game logic and rendering are updated at fixed time intervals, regardless of the frames per second (FPS)

### The Rendering
The rendering is the process of drawing the game screen. The screen is composed of pixels, and each pixel has a color. The rendering process involves updating the pixels according to the game logic.

The rendering process is done in the <b>paintComponent</b> method of the <b>JPanel</b> class. This method is called automatically by the Swing framework when the screen needs to be redrawn.

## Key Handling
Key handling is the process of detecting and responding to keyboard input. In Java, key handling is done using the <b>KeyListener</b> interface.

The <b>KeyListener</b> interface defines three methods:
- <b>keyPressed(KeyEvent e)</b>: Called when a key is pressed.
- <b>keyReleased(KeyEvent e)</b>: Called when a key is released.
- <b>keyTyped(KeyEvent e)</b>: Called when a key is typed (pressed and released).