/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

import peoplelogic.CurrentStatsLogic;

public class Person {

  // ========== FIELDS ========== //

  // Integer for tracking age. Starts at zero and increments regularly. Stats vary with age. Strength peaks from
  // 15-45, wisdom increases with time (until maybe 85 when dementia hits), odds of sickness increase with time, etc.
  private int age;

  // Track a person's stat affinities. These are used for incrementing their stats as the years progress. For example,
  // someone with a high affinity for health will maintain their fitness through the years, whereas someone with a low
  // affinity might let themselves go a bit and their health is less likely to stay high.
  private final Stats statAffinities;

  private Stats currentStats;
  private boolean alive;

  // ========== CONSTRUCTORS ========== //

  public Person() throws StatsException {
    age = 0;
    alive = true;
    statAffinities = CurrentStatsLogic.generateStatAffinities();
    currentStats = CurrentStatsLogic.generateFirstTimeStats(statAffinities);
  }

  // ========== METHODS ========== //

  public void incrementAge() throws PersonException {
    validateAge(++age);
    currentStats = CurrentStatsLogic.calculateNewStats(age, statAffinities, currentStats);
  }

  public int getAge() {
    return age;
  }

  private static void validateAge(final int age) throws PersonException {
    if (age < 0 || age > 100) {
      throw new PersonException(PersonException.ErrorCode.PERSON_AgeInvalid.getErrorCode(), String.valueOf(age));
    }
  }

  public Stats getCurrentStats() {
    return currentStats;
  }

  public void died() {
    alive = false;
  }

  public boolean isAlive() {
    return alive;
  }
}
