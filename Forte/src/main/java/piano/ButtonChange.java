package piano;

public interface ButtonChange {
    /**
     * effects(changes) when click on a button
     * @param x     the current horizontal coordinate of the mouse
     * @return      return whether the change is happens
     */
    public boolean buttonchange(int x);
}