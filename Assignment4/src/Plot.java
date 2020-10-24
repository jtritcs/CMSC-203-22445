/**
 * Manages plots containing various size values.
 * @author Justin Tritinger
 */
public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.depth = 1;
        this.width = 1;
    }

    public Plot(Plot p) {
        this.x = p.getX();
        this.y = p.getY();
        this.width = p.getWidth();
        this.depth = p.getDepth();
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public int getX() { return x; }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }

    public void setWidth(int width) { this.width = width; }

    public int getDepth() { return depth; }

    public void setDepth(int depth) { this.depth = depth; }

    /**
     * Determines if given plot is overlapped by this plot.
     * @param p plot to check against.
     * @return true if plot is being overlapped.
     */
    public boolean overlaps(Plot p) {
        return  ((p.getX() < this.x + this.width)
                && (p.getX() + p.getWidth() > this.x)
                && (p.getY() + depth > this.y)
                && (p.getY() < this.y + this.depth));
    }

    /**
     * Determines if given plot is encompassed by this plot.
     * @param p plot to check against.
     * @return true if plot is being encompassed.
     */
    public boolean encompasses(Plot p) {
        return  ((p.getX() <= this.x)
                && (p.getY() <= this.y)
                && (p.getX() + p.getWidth() >= this.x + this.width)
                && (p.getY() + p.getDepth() >= this.y + this.depth));
    }

    @Override
    public String toString() {
        return "Upper left: ("  + x + "," + y + "); Width: " + width + " Depth: " + depth;
    }
}
