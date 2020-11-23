/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

import mockit.*;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import peoplelogic.CurrentStatsLogic;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

  @Test
  public void createPersonTest() throws StatsException {
    final List<Stats> generatedStatAffinities = new ArrayList<>();
    new MockUp<CurrentStatsLogic>() {
      @Mock
      Stats generateStatAffinities(Invocation inv) {
        Assertions.assertEquals(1, inv.getInvocationCount(), "expected one invocation.");
        generatedStatAffinities.add(inv.proceed());
        return generatedStatAffinities.get(inv.getInvocationIndex());
      }

      @Mock
      Stats generateFirstTimeStats(Stats statAffinities) {
        Assertions.assertEquals(generatedStatAffinities.get(0), statAffinities, "Different stat affinities than expected.");
        return null;
      }
    };

    // Code under test
    final Person p = new Person();

    Assertions.assertEquals(0, p.getAge(), "Expected the person's starting age to be 0");
    Assertions.assertTrue(p.isAlive(), "Expected the person to start as alive.");
  }
}
