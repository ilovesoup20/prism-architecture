package basic;

import java.util.HashMap;
import java.util.Map;

// From ChatGPT
public class Context {
    private boolean userLoggedIn;
    private double balance;
    private double requiredAmount;
    private Map<String, Object> additionalData;

    public Context() {
    }

    public Context(boolean userLoggedIn, double balance, double requiredAmount) {
        this.userLoggedIn = userLoggedIn;
        this.balance = balance;
        this.requiredAmount = requiredAmount;
        this.additionalData = new HashMap<>();
    }

    public boolean isUserLoggedIn() {
        return userLoggedIn;
    }

    public void setUserLoggedIn(boolean userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(double requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String key, Object value) {
        this.additionalData.put(key, value);
    }

    public Context withUpdatedState() {
        // Return a new context with updated state, for immutability
        Context newContext = new Context(this.userLoggedIn, this.balance, this.requiredAmount);
        newContext.additionalData.putAll(this.additionalData);
        // Perform state updates as needed, e.g., deducting balance
        return newContext;
    }
}
