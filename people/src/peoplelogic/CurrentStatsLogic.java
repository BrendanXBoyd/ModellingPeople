/*
  Copyright Brendan Boyd 2020
 */

package peoplelogic;

import peopleobjects.Stats;

/**
 * Helper class which houses the logic for calculating a person's current stats from their age and base stats.
 */
public class CurrentStatsLogic {

  private CurrentStatsLogic() {
    // Don't allow instances.
  }

  /**
   * This helper method calculates a person's new stats assuming that their age was just incremented.
   *
   * @param age - The person's new age. It is assumed that this value was just incremented by 1.
   * @param statAffinities - The person's stat affinities. These are used to calculate the new values.
   * @param oldStats - The person's previous stats. These are used to calculate the new values.
   * @return the person's new stats.
   */
  public static Stats calculateNewStats(final int age, final Stats statAffinities, final Stats oldStats) {
    return null;
  }

  /**
   * This helper method calculates a person's stat affinities at birth (when they're first created).
   * These values are final for the person and are used to calculate their new stats as they age.
   *
   * @return the new person's stat affinities.
   */
  public static Stats generateStatAffinities() {
    // Logic for generating a person's stat affinities.
    return null;
  }

  /**
   * This helper method calculates a person's stats at birth (when they're first created).
   *
   * @param statAffinities - The person's stat affinities.
   * @return the new person's stats.
   */
  public static Stats generateFirstTimeStats(final Stats statAffinities) {
    return null;
  }
}
