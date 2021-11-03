package by.tc.task01.dao.impl.exception;

/**
 * DAOException
 */
public class DAOException extends RuntimeException {

   /**
    * constructor
    *
    * @param message message
    * @param cause cause
    */
   public DAOException(final String message, final Throwable cause) {
      super(message, cause);
   }
}
