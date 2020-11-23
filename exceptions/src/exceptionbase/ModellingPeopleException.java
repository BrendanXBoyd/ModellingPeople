/*
  Copyright Brendan Boyd 2020
 */

package exceptionbase;

public class ModellingPeopleException extends Exception {

  private final ErrorCodeBase errorCode;
  private final String[] args;

  protected ModellingPeopleException(final ErrorCodeBase errorCode, final String... args) {
    super();
    this.errorCode = errorCode;
    this.args = args;
  }

  protected ModellingPeopleException(final Throwable cause, final ErrorCodeBase errorCode, final String... args) {
    super(cause);
    this.errorCode = errorCode;
    this.args = args;
  }

  public ErrorCodeBase getErrorCode() {
    return errorCode;
  }

  @Override
  public String getLocalizedMessage() {
    return getErrorMessage();
  }

  @Override
  public String getMessage() {
    return getLocalizedMessage();
  }

  /**
   * Get the error message associated with this error from the associated properties file.
   * @return The error message.
   */
  String getErrorMessage() {
    return ModellingPeopleRuntimeException.getErrorMessage(getClass(), errorCode, args);
  }
}
