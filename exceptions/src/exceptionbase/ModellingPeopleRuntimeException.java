/*
  Copyright Brendan Boyd 2020
 */

package exceptionbase;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ModellingPeopleRuntimeException extends RuntimeException {

  private static final String PROPERTIES_FILE_END = ".properties";

  private final ErrorCodeBase errorCode;
  private final String[] args;

  protected ModellingPeopleRuntimeException(final ErrorCodeBase errorCode, final String... args) {
    super();
    this.errorCode = errorCode;
    this.args = args;
  }

  protected ModellingPeopleRuntimeException(final Throwable cause, final ErrorCodeBase errorCode,
                                            final String... args) {
    super(cause);
    this.errorCode = errorCode;
    this.args = args;
  }

  enum ErrorCode {
    MP_RUNTIME_PropertiesNotFound,
    MP_RUNTIME_ResourceNotFound,
    ;

    private final ErrorCodeBase errorCodeBase;
    ErrorCode() {
      errorCodeBase = new ErrorCodeBase(this.name());
    }

    public ErrorCodeBase getErrorCode() {
      return errorCodeBase;
    }
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
    return getErrorMessage(getClass(), errorCode, args);
  }

  /**
   * Static helper method to get an error from the associated properties file.
   *
   * @param errorClass The class that threw this error. The properties file's name should be the class's name in all
   *                   lower-case.
   * @param errorCode The error code to get out of the properties file.
   * @return The error message.
   */
  static String getErrorMessage(final Class<?> errorClass, final ErrorCodeBase errorCode, final String[] args) {
    // Our properties file should be the name of the class in lowercase.
    final String resourcePropertiesFileName = errorClass.getSimpleName().toLowerCase() + PROPERTIES_FILE_END;

    // Load the properties file.
    InputStream is = errorClass.getClassLoader().getResourceAsStream(resourcePropertiesFileName);
    Properties prop = new Properties();
    try {
      prop.load(is);
    } catch (IOException | NullPointerException e) {
      throw new ModellingPeopleRuntimeException(e, ErrorCode.MP_RUNTIME_PropertiesNotFound.getErrorCode(),
          errorClass.getSimpleName());
    }

    final String unformattedErrorMessage = (String) prop.get(errorCode.getErrorKeyInPropertiesFile());
    if (StringUtils.isEmpty(unformattedErrorMessage)) {
      throw new ModellingPeopleRuntimeException(ErrorCode.MP_RUNTIME_ResourceNotFound.getErrorCode(),
          errorCode.getErrorKeyInPropertiesFile(), errorClass.getSimpleName());
    }

    return String.format(unformattedErrorMessage, (Object[]) args);
  }
}
