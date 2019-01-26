/**
 * Tree
 */
public class Tree {
    private int value;

    private Tree lhs;

    private Tree rhs;

    public Tree (int value) {
        this.value = value;
    }

    public void insert(int value) {
        if (value > this.value) {
            if (rhs == null) {
                this.rhs = new Tree(value);
            }
            else {
                rhs.insert(value);
            }
        }
        else if (value < this.value) {
            if (lhs == null) {
                this.lhs = new Tree(value);
            }
            else {
                lhs.insert(value);
            }
        }
    }
    
    public int getHeight(){
        int leftChildHeight = 0;
        if (lhs != null) {
            leftChildHeight = this.lhs.getHeight();
        }

        int rightChildHeight = 0;
        if (rhs != null) {
            rightChildHeight = this.rhs.getHeight();    
        }
        return Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    public boolean getValueExists(int value) {
        if (this.value == value) {
            return true;
        }
        boolean childHasValue = false;

        if (lhs != null) {
            childHasValue = lhs.getValueExists(value);
        }
        if (rhs != null && !childHasValue) {
            childHasValue = rhs.getValueExists(value);
        }

        return childHasValue;
    }

    public int getMinValue() {
        if (lhs != null) {
            return lhs.getMinValue();
        }
        return this.value;
    }

    public int getMaxValue() {
        if (rhs != null) {
            return rhs.getMaxValue();
        }
        return this.value;
    }

    public boolean getIsDegenerate() {
        boolean degenerate = false;
        int count = 0;

        if (this.lhs == null) {
            count++;
        }
        if (this.rhs == null) {
            count++;
        }

        if (this.lhs != null) {
            degenerate = this.lhs.getIsDegenerate();
        }
        if (this.rhs != null && !degenerate) {
            degenerate = this.rhs.getIsDegenerate();
        }
        
        return count == 1 ? true : degenerate;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        if (lhs != null) {
            sb.append("(" + lhs.toString() + ") ");
        }

        sb.append(this.value);

        if (rhs != null) {
            sb.append(" (" + rhs.toString() + ")");
        }
        return sb.toString();
    }
}