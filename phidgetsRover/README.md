# Rover Control Challenge

This repository contains Java programs to control a Phidgets wireless rover using various methods, including manual control and automated movement with obstacle detection.

## Features

### 1. Move
This class handles the basic movement logic for the rover, allowing it to move forward and backward using motor control.

### 2. Turn
This class is responsible for turning the rover left or right based on the motor control logic. It adjusts the velocities of the left and right motors to create turns.

### 3. AvoidObstacles
This class integrates a distance sensor to prevent the rover from colliding with obstacles. If an obstacle is detected within a predefined safe distance, the rover will stop moving forward.

### 4. Challenge
The `challenge` program combines movement, turning, and obstacle avoidance to make the rover navigate in a square pattern with 90° turns. The rover uses the distance sensor to avoid obstacles during its movement.

### 5. KeyControl
The `keyControl` program allows manual control of the rover using the keyboard. It includes:
- `W` to move forward (with obstacle avoidance).
- `S` to move backward.
- `A` to turn left.
- `D` to turn right.

A distance sensor monitors the environment, preventing forward movement when an obstacle is detected.
