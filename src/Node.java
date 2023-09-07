import java.io.File;
import java.util.ArrayList;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private  int level;
    private long limit;

    public Node (File folder,long limit) {
        this.folder = folder;
        children = new ArrayList<>();
        this.limit = limit;
    }

    public long getLimit() {
        return limit;
    }

    public File getFolder(){
        return  folder;
    }

    public void addChild(Node node) {
        node.setLevel(level + 1);
        children.add(node);
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
     private void setLevel (int level){
        this.level = level;
     }

    public String toString(){
        String text = SizeRead.getHumanReadableSize(getSize());
        StringBuilder builder = new StringBuilder();
        String space = " ";
        builder.append(folder.getName() + " - " + text + "\n");
        for (Node child : children) {
            if (child.getSize() > limit) {
                builder.append(space.repeat(child.level) + child.toString());
            }
        }
        return builder.toString();
    }
}
