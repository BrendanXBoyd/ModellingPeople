/*
  Copyright Brendan Boyd 2020
 */

package peopleobjects;

import exceptionbase.ErrorCodeBase;
import exceptionbase.ModellingPeopleException;

public class PersonException extends ModellingPeopleException {

  enum ErrorCode {
    PERSON_AgeInvalid,
    ;

    private final ErrorCodeBase errorCodeBase;
    ErrorCode() {
      errorCodeBase = new ErrorCodeBase(this.name());
    }

    public ErrorCodeBase getErrorCode() {
      return errorCodeBase;
    }
  }

  public PersonException(ErrorCodeBase errorCode, String... args) {
    super(errorCode, args);
  }

  public PersonException(Throwable cause, ErrorCodeBase errorCode, String... args) {
    super(cause, errorCode, args);
  }
}
