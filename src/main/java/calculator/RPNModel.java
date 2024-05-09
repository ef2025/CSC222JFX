/**
 * Complete the methods noted below
 **/

package calculator;

public class RPNModel {

    // Instance variables
    MyStack<Integer> stack = new MyStack<>();

    /**
     * TODO: Complete enter handler
     * @param val
     * @return
     */
    public boolean enter(int val)
    {
        if (stack.size() == 8) //checks if max capacity has been reached
            return false;
        else
            stack.push(val); //if capacity isn't max, push the stack up
        return true;
    }

    public int getTop() throws Exception
    {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        }
        throw new Exception("Nothing on the stack to get!");
    }

    /**
     * Drops the top item on the stack if there is one
     * @return true if successful
     */
    public boolean drop()
    {
        if (stack.size() == 0)
            return false;
        else
            stack.pop();
        return true;
    }

    /**
     * TODO: Complete the multiply handler
     * @return
     */
    public boolean multiply()
    {
        if (stack.size() < 2) //checks for two or more operands
            return false;
        stack.push( stack.pop() * stack.pop()); //pushes the multiplied result of the two bottom numbers
        return true;
    }

    /**
     * Divide Handler
     * @return true if successful, false otherwise
     * @throws Exception - in the event of a divide by zero
     * Removes items from stack and places the calculation result on the stack
     */
    public boolean divide() throws Exception
    {
        if (stack.size() < 2)
            return false;
        int v1 = stack.pop();
        if (v1 == 0) throw new Exception("Error: Cannot Divide by 0");
        stack.push( stack.pop() / v1);
        return true;
    }

    /**
     * Add Handler
     * @return true if successful, false otherwise
     * Removes items from stack and places the calculation result on the stack
     */
    public boolean add()
    {
        if (stack.size() < 2)
            return false;
        stack.push( stack.pop() + stack.pop());
        return true;
    }

    /**
     * TODO: Change the sign of the value on the top of the stack
     * @return
     */
    public boolean changeSign() {
        if (stack.isEmpty()) return false;
        else stack.push(stack.pop() * -1); //takes the lowest value in the stack, pops it multiplies it by -1
        // and pushes it back into the stack
        return true;
    }

    /**
     * TODO: Complete the subtract handler
     * @return true if successful
     */
    public boolean subtract()
    {
        if (stack.size() < 2) //checks for two operands or more
            return false;
        int v1 = stack.pop(); //takes the lowest number in the stack and assigns it to v1
        stack.push( stack.pop() - v1); //takes the next number after v1 and subtracts it by v1
        return true;
    }

    /**
     * Returns a formatted string of the stack contents
     * @return string of items on stack separated by carriage returns
     * Note: No modification needed!
     */
    public int[] getValues() throws Exception
    {
        int[] values = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            values[i] = stack.get(i);
        }
        return values;
    }
}
