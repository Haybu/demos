/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package amortizer;

/**
 *
 * @author hmohamed
 */
public class LoanEntryException extends Exception {
     //Parameterless Constructor
      public LoanEntryException() {}

      //Constructor that accepts a message
      public LoanEntryException(String message)
      {
         super(message);
      }
}
