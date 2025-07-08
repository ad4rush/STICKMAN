# 🕹️ Stick Hero: Your Ultimate Arcade Game

## 🌐 Overview

**Stick Hero** is a captivating JavaFX application where players navigate a stick figure through various levels by controlling the length of the stick used to cross gaps between platforms. This project showcases the implementation of core gaming mechanics, clean software architecture, and a polished user experience.

---

## 🎮 Features of Game

-   **Dynamic Gameplay**: Enjoy interactive stick control for an immersive gaming experience.
-   **Score Display**: Keep track of your progress with a score and gem count display, complete with custom fonts and borders.
-   **Pause Functionality**: Need a break? Use the pause functionality to temporarily halt the game.
-   **Smooth Transitions**: Experience seamless gameplay with smooth animation transitions.
-   **Character Inversion**: Press the 'S' key to make the character flip upside down, adding a new layer of challenge.
-   **Revive Option**: Made a mistake? Use your collected gems to revive your character and continue your run.

### ✨ Additional Features

* **Custom Character Skins**: Unlock and choose from a variety of character skins to personalize your gameplay experience.
* **Power-Ups**: Discover and utilize power-ups like score multipliers and slow-motion to gain an edge.
* **Diverse Environments**: Traverse through multiple levels, each with unique backgrounds and obstacles.
* **Global Leaderboard**: Compete with players from around the world and climb the ranks to become the ultimate Stick Hero.
* **Sound and Music**: Immerse yourself in the game with engaging sound effects and a captivating soundtrack, with options to mute them as you please.

---

## 🕹️ Usage Overview

### 🏠 Usage of Home Menu

* Click the "**Play**" button to start the game.
* Click the "**Exit**" button to close the application.
* Navigate your stick figure across the platforms and aim for a high score!

### 🎲 Gameplay

* Click and hold to grow the stick.
* Release to drop the stick and rotate it into a bridge.
* Cross the gap safely to score points and collect gems.
* Press the pause button to pause the game at any time.

---

## ⏸️ Pause Functionality

The Stick Hero game includes a pause feature that allows players to temporarily halt the gameplay. This feature is particularly useful if players need to take a break or attend to something else without closing the game.

### How It Works

* The pause button is represented by a custom image and is positioned at the top-left corner of the game window.
* When the pause button is clicked, the game enters a paused state, and all game actions are suspended.
* A "Paused" label is displayed along with options to "Resume" the game or return to the "Home" screen.
* The current score is displayed, and the high score is retrieved and shown for comparison.
* Clicking the "Resume" button will remove the pause overlay and restore the game's interactive state, allowing players to continue from where they left off.

---

## 🏁 End Game Functionality

The Stick Hero game features an end game scenario that is triggered when the player's character meets an untimely end. This functionality provides players with options to either retry the level, return to the home screen, or use in-game currency to revive the character.

### How It Works

* When the player dies, the game displays a message "You Died!!" along with buttons for different actions.
* The "**Retry**" button resets the score to zero and restarts the game from the beginning of the level.
* The "**Revive**" button allows players to continue from where they left off by spending in-game currency (gems).
* If the player does not have enough gems, a message "Not enough gems" is displayed, and the score is reset.
* The end game screen also shows the player's current score and the high score for comparison.

---

## 🚀 Project Experience

### Stick Hero Game (Oct 2023 – Dec 2023)

* **Team Size**: 2
* **GitHub**: [Link to Repository]
* Engineered a scalable codebase for the JavaFX game using **Singleton** and **Factory** design patterns, leveraging multithreading for 100+ concurrent animations and ensuring reliability with JUnit tests that achieved 90% path coverage.

---

## 🛠️ Resources used

* **JavaFX SDK**: The primary framework used for creating the graphical user interface of the game.
* **Java Development Kit (JDK)**: The essential toolkit for developing Java applications, including the Stick Hero game.
* **Image Assets**: Custom images for backgrounds, buttons, and icons, which are loaded using the Image class in JavaFX.
* **Custom Fonts**: Fonts like “DM Sans” and “Times New Roman” are used to style text elements such as labels and buttons.
* **Event Handling Classes**: Classes like EventHandler, MouseEvent, and AnimationTimer are used to handle user interactions and animate the game.
* **Layout Managers**: JavaFX layout managers such as Pane, VBox, HBox, and Scene are used to structure the game’s UI components.
* **Shapes and Transitions**: The Rectangle class and TranslateTransition are used to represent the stick and animate the stick figure, respectively.
* **Styling Classes**: Classes like CornerRadii, BorderStroke, Border, and Background are used to style UI components with borders and backgrounds.

---

## 📚 Design Patterns Used

### Singleton

The Singleton pattern is implemented in the `path_stick` class, which ensures that only one instance of the main path (a `Rectangle` object) is created and shared across the application.

### Factory

The Factory pattern is implemented in the `Factory` class, which provides a method `get_shape` to create shapes based on the provided type. It supports creating `Rectangle` and `Square` shapes and adds them to a given `Pane`.

---

## 📝 Classes and Methods

### Factory Class

* `get_shape(String asd, Pane ma_p)`: Returns a `Shape` object based on the type specified.
* `getRectangle(Pane main_pane)`: Private method to create a `Rectangle` object.
* `getSquare(Pane main_pane)`: Private method to create a `Square` object.
* `get_Cherry(Rectangle rectangle, Pane main_pane)`: Private method to create an `ImageView` object representing a cherry.

### path_stick Class

* `getPathRectangle()`: Static method to get the instance of the main path `Rectangle`.

---

## 📋 Requirements

* Java 8 or higher
* JavaFX SDK

---

## 📥 Installation

To run Stick Hero, you will need to have Java and JavaFX installed on your system.

1.  Install Java JDK from Oracle's website or use OpenJDK.
2.  Download JavaFX SDK from OpenJFX.
3.  Configure your IDE to include the JavaFX library and add VM options to include the JavaFX modules.

---

## 🚀 Running the Application

1.  Compile the source code using your preferred IDE or command line.
2.  Run the `HelloApplication` class to start the application.

---

## 🎯 Assumptions

* When the Player is in moving state, user is advised **`not to click`** at the time as it may cause buggy behaviour sometimes. Although this bug comes rarely.
* Consider a Scenario where a player is dying but can touch/is touching a diamond then it can collect that.
* The hitbox ( the space around an object, that's considered a part of it ) of the diamond is intentionally left big for the ease of the player to play it.
* The paths of all the images are absolute, so to run it, the paths have to refactor.

---

## 👥 Authors

* Amartya Singh
* Adarsh Jha
