package exceptionbase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ModellingPeopleExceptionTest {

  @Test
  void testGetErrorMessage_failToFindResourcePackage() {
    // When getErrorMessage can't find a resource bundle, it will throw a new ModellingPeopleRuntimeException, which
    // will in-turn call getErrorMessage on a resource that we should guarantee the existence of. This test will help
    // to guarantee that existence. It also simultaneously tests the failure and success cases of this method, since
    // it will have the success case nested within the failure case.

    try {
      ModellingPeopleRuntimeException.getErrorMessage(getClass(), new ErrorCodeBase(""), new String[]{});
      Assertions.fail("Expected an exception to be thrown");
    } catch (ModellingPeopleRuntimeException e) {
      Assertions.assertEquals(ModellingPeopleRuntimeException.ErrorCode.MP_RUNTIME_PropertiesNotFound.getErrorCode(),
          e.getErrorCode(), "Different error code than expected.");
      Assertions.assertTrue(e.getMessage().contains(getClass().getSimpleName()), "Expected our error to contain " +
          "the class that we couldn't find. got: " + e.getMessage());
    }
  }

  @Test
  void testGetErrorMessage_failToFindResourceKey() {
    // When getErrorMessage can't find a key in a resource bundle, it will throw a new ModellingPeopleRuntimeException,
    // which will in-turn call getErrorMessage on a resource that we should guarantee the existence of. This test
    // will help to guarantee that existence. It also simultaneously tests the failure and success cases of this
    // method, since it will have the success case nested within the failure case.

    try {
      ModellingPeopleRuntimeException.getErrorMessage(ModellingPeopleRuntimeException.class,
          new ErrorCodeBase("Bogus Key"),
          new String[]{});
      Assertions.fail("Expected an exception to be thrown");
    } catch (ModellingPeopleRuntimeException e) {
      Assertions.assertEquals(ModellingPeopleRuntimeException.ErrorCode.MP_RUNTIME_ResourceNotFound.getErrorCode(),
          e.getErrorCode(), "Different error code than expected.");
      Assertions.assertTrue(e.getMessage().contains(ModellingPeopleRuntimeException.class.getSimpleName()), "Expected our error to contain the class that we couldn't find. got: " + e.getMessage());
      Assertions.assertTrue(e.getMessage().contains("Bogus Key"), "Expected our error to contain the class that we couldn't find. got: " + e.getMessage());
    }
  }
}