/*
  Copyright Brendan Boyd 2020
 */

package exceptionbase;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ModellingPeopleException extends Exception {

  private static final String PROPERTIES_FILE_END = ".properties";

  private final ErrorCodeBase errorCode;

  protected ModellingPeopleException(final ErrorCodeBase errorCode) {
    super();
    this.errorCode = errorCode;
  }

  protected ModellingPeopleException(final Throwable cause, final ErrorCodeBase errorCode) {
    super(cause);
    this.errorCode = errorCode;
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
   * Get the error message associated with this error from the associated properies file.
   * @return The error message.
   */
  private String getErrorMessage() {
    // Our properties file should be the name of the class in lowercase.
    final String resourcePropertiesFileName = getClass().getSimpleName().toLowerCase() + PROPERTIES_FILE_END;

    // Load the properties file.
    InputStream is = getClass().getClassLoader().getResourceAsStream(resourcePropertiesFileName);
    Properties prop = new Properties();
    try {
      prop.load(is);
    } catch (IOException e) {
      // Rethrow as a ModellingPeopleException
    }

    return (String) prop.get(errorCode.getErrorKeyInPropertiesFile());
  }
}
