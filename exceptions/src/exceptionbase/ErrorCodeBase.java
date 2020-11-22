/*
  Copyright Brendan Boyd 2020
 */

package exceptionbase;

public class ErrorCodeBase {

  public ErrorCodeBase(final String errorKeyInPropertiesFile) {
    this.errorKeyInPropertiesFile = errorKeyInPropertiesFile;
  }

  private final String errorKeyInPropertiesFile;

  public String getErrorKeyInPropertiesFile() {
    return errorKeyInPropertiesFile;
  }
}
