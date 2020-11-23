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

  private int evaluateCurrentHealth() throws Exception {
    return evaluateHealth(baseStats.getHealth(), age);
  }

  private static int evaluateHealth(final int baseHealth, final int currentAge) throws Exception {
    validateAge(currentAge);
    return 0;
  }

  private static void validateAge(final int age) throws Exception {
    if (age < 0 || age > 100) {
      throw new PersonException(PersonException.ErrorCode.PERSON_AgeInvalid.getErrorCode(), String.valueOf(age));
    }
  }
}
