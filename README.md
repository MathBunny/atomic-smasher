# Atomic Smasher
###About This Game:
The purpose of this game is to teach children about basic chemistry concepts. It accomplishes this by allowing the user to understand how compounds are formed through an interactive game. The involves placing pipes to transport particles, and when correctly timed the particles can collide forming compounds. There are different types of blocks with different features.

###Game Features:
* Unique graphics
* Multiple block types
* Six built-in levels
* Pause/continue game
* Installer
* Readme and JavaDoc
* High-scores
* Game profiles

###Software Architecture:
The game-itself (along with graphics) were designed by myself. The gameplay was made possible through heavy use of Object Oriented Principles. There is a `World` class containing the grid and making use of encapsulation. Every piece in the grid is a `ObjectInGrid`, and then they all inherit properties that provide special abilities. The `Physics` class permits the physics engine of the moving particles.

###How to run this game
Simply compile the classes in the `/classes/` folder, and then run `GameApp.java`. Optionally you can install the `javax.video` library, but it is not required (it is only for the educational videos). 

###Known Issues
Sometimes the particles can be moving slowly depending on the computer's speed, or they can go slightly off track if there is a lot of turning. If you find any other issues feel free to report on GitHub.

###Screenshot (Main Screen)
![Screenshot](http://www.horatiulazu.ca/software/images/AtomicSmasherGameplay.png)
