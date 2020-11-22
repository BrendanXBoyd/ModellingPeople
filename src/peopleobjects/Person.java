/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

public class Person {

  // Integer for tracking age. Starts at zero and increments regularly. Stats vary with age. Strength peaks from
  // 15-45, wisdom increases with time (until maybe 85 when dementia hits), odds of sickness increase with time, etc.
  int age = 0;

  // Track a person's base stats.  Their current stats are calculated from this based on their age.
  Stats baseStats;

  public Stats getCurrentStats() {
    return null;
  }
}
