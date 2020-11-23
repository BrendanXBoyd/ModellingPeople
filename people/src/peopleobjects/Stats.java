/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

public class Stats {
  final int health;
  final int libido;
  final int mettle;
  final int wisdom;

  Stats(final int health, final int libido, final int mettle, final int wisdom) throws StatsException {
    validate(health, libido, mettle, wisdom);
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

  private static void validate(final int health, final int libido, final int mettle, final int wisdom) throws StatsException {
    if (health < 0) {
      throw new StatsException(StatsException.ErrorCode.STATS_EX_HealthBelowMin.getErrorCode());
    }
    if (libido < 0) {
      throw new StatsException(StatsException.ErrorCode.STATS_EX_LibidoBelowMin.getErrorCode());
    }
    if (mettle < 0) {
      throw new StatsException(StatsException.ErrorCode.STATS_EX_MettleBelowMin.getErrorCode());
    }
    if (wisdom < 0) {
      throw new StatsException(StatsException.ErrorCode.STATS_EX_WisdomBelowMin.getErrorCode());
    }
  }
}
