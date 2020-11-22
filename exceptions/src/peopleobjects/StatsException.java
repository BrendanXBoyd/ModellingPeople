/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

import exceptionbase.ErrorCodeBase;
import exceptionbase.ModellingPeopleException;

public class StatsException extends ModellingPeopleException {

  enum ErrorCode {
    STATS_EX_HealthBelowMin,
    STATS_EX_LibidoBelowMin,
    STATS_EX_MettleBelowMin,
    STATS_EX_WisdomBelowMin,
    ;

    private final ErrorCodeBase errorCodeBase;
    ErrorCode() {
      errorCodeBase = new ErrorCodeBase(this.name());
    }

    public ErrorCodeBase getErrorCode() {
      return errorCodeBase;
    }
  }

  public StatsException(ErrorCodeBase errorCode) {
    super(errorCode);
  }

  public StatsException(Throwable cause, ErrorCodeBase errorCode) {
    super(cause, errorCode);
  }
}
