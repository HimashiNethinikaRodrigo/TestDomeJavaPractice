package test.edu.testdome.java;

import main.edu.testdome.java.Account;
import org.junit.Assert;
import org.junit.Test;


public class AccountTest {

    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositNotAcceptNegativeValues() {
        Account account = new Account(0);

        Assert.assertFalse(account.deposit(-20));
    }

    @Test
    public void withdrawNotAcceptNegativeValues() {
        Account account = new Account(0);

        Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void accountCannotOverstepItsOverdraftLimit() {
        Account account = new Account(20);

        Assert.assertFalse(account.withdraw(21));
    }

    @Test
    public void depositCorrectAmount (){
        Account account = new Account(20);
        account.deposit(10);

        Assert.assertEquals(10,account.getBalance(), epsilon);
    }

    @Test
    public void withdrawCorrectAmount (){
        Account account = new Account(20);
        account.withdraw(5);

        Assert.assertEquals(-5,account.getBalance(), epsilon);
    }

    @Test
    public void deposit (){
        Account account = new Account(20);

        Assert.assertTrue(account.deposit(10));

    }

    @Test
    public void withdraw (){
        Account account = new Account(20);

        Assert.assertTrue(account.withdraw(10));

    }

}
