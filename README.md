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