/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

public class Stats {
  final int health;
  final int libido;
  final int mettle;
  final int wisdom;

  Stats(final int health, final int libido, final int mettle, final int wisdom) {
    this.health = health;
    this.libido = libido;
    this.mettle = mettle;
    this.wisdom = wisdom;
  }

  // Getters
  public int getHealth() {
    return health;
  }
  public int getLibido() {
    return libido;
  }
  public int getMettle() {
    return mettle;
  }
  public int getWisdom() {
    return wisdom;
  }
}
